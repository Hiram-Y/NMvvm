package com.ducdm.nmvvm.views;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.ducdm.nmvvm.agents.NMvxViewModelWrapper;
import com.ducdm.nmvvm.agents.bundlizers.INMvxNavigationSerializer;
import com.ducdm.nmvvm.agents.finders.INMvxCurrentTopView;
import com.ducdm.nmvvm.commons.Constants;
import com.ducdm.nmvvm.mappings.INMvxViewModelBuilder;
import com.ducdm.nmvvm.mappings.NMvx;
import com.ducdm.nmvvm.viewmodels.NMvxViewModel;
import com.ducdm.nmvvm.viewmodels.NMvxSplashViewModel;

/**
 * Created by DangManhDuc on 12/17/2016.
 */

public abstract class NMvxView<T extends ViewDataBinding, V extends NMvxViewModel> extends AppCompatActivity implements INMvxView {

    private int layoutId;
    private int dataContextId;

    private T binding;
    protected V viewModel;

    private INMvxViewModelBuilder viewModelBuilder;
    private INMvxCurrentTopView currentTopView;

    public NMvxView(int layoutId, int dataContextId){
        this.layoutId = layoutId;
        this.dataContextId = dataContextId;
        viewModelBuilder = NMvx.resolve(INMvxViewModelBuilder.class);
        currentTopView = NMvx.resolve(INMvxCurrentTopView.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        currentTopView.setCurrentTopView(this);

        parseBundleData(getIntent().getStringExtra(Constants.NAVIGATION_KEY));
    }

    private void parseBundleData(String extra){
        NMvxViewModelWrapper bundle = null;
        if(extra != null && !extra.isEmpty()){
            bundle = NMvx.resolve(INMvxNavigationSerializer.class).getSerializer().readData(extra, NMvxViewModelWrapper.class);
            if(bundle != null){
                viewModel = viewModelBuilder.resolveViewModelInstance(bundle.getViewModelType());
            }
        } else {
            viewModel = (V) new NMvxSplashViewModel();
        }

        binding = (T) DataBindingUtil.setContentView(this, layoutId);
        binding.setVariable(dataContextId, viewModel);
        viewModel.onInitialize(bundle != null ? bundle.getBundleParameters() : null);

        viewModel.onStart();
        viewModel.onRestoreStates(bundle != null ? bundle.getSavedStatesParameters() : null);

        initialize();
    }

    protected abstract void initialize();

    protected T binding() {
        return binding;
    }

}
