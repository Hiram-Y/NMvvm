package com.ducdm.nmvvm.viewmodels;

import android.databinding.BaseObservable;

import com.ducdm.nmvvm.agents.NMvxViewModelWrapper;
import com.ducdm.nmvvm.agents.models.INMvxBundle;
import com.ducdm.nmvvm.agents.models.NMvxBundle;
import com.ducdm.nmvvm.agents.INMvxNavigator;
import com.ducdm.nmvvm.agents.INMvxViewDispatcher;
import com.ducdm.nmvvm.mappings.NMvx;

import java.util.Map;

/**
 * Created by DangManhDuc on 12/17/2016.
 */

public abstract class NMvxViewModel extends BaseObservable implements INMvxViewModel, INMvxNavigator {

    private INMvxViewDispatcher viewDispatcher;

    public NMvxViewModel(){
        this.viewDispatcher = NMvx.resolve(INMvxViewDispatcher.class);
    }

    @Override
    public void onInitialize(INMvxBundle bundle) {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onRestoreStates(INMvxBundle bundle) {

    }

    @Override
    public void onSaveStates(INMvxBundle bundle) {

    }

    @Override
    public void onClose() {
        if(viewDispatcher == null){
            return;
        }

        viewDispatcher.closeViewModel();
    }

    @Override
    public <T extends NMvxViewModel> boolean showViewModel(Class<T> viewModel) {
        return show(viewModel, null, null);
    }

    @Override
    public <T extends NMvxViewModel> boolean showViewModel(Class<T> viewModel, Map<String, String> bundleParameters, Map<String, String> statesSavedParameters) {
        return show(viewModel, new NMvxBundle(bundleParameters), new NMvxBundle(statesSavedParameters));
    }

    @Override
    public <T extends NMvxViewModel> boolean showViewModel(Class<T> viewModel, INMvxBundle bundleParameters, INMvxBundle statesSavedParameters) {
        return show(viewModel, bundleParameters, statesSavedParameters);
    }

    private <T extends NMvxViewModel> boolean show(Class<T> viewModel, INMvxBundle bundleParameter, INMvxBundle statesSavedParameters){
        if(viewDispatcher == null){
            return false;
        }

        return viewDispatcher.showViewModel(new NMvxViewModelWrapper(viewModel, bundleParameter, statesSavedParameters));
    }

}
