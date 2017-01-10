package com.ducdm.nmvvm.views;

import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Window;
import android.view.WindowManager;

import com.ducdm.nmvvm.agents.INMvxAppStart;
import com.ducdm.nmvvm.mappings.NMvx;
import com.ducdm.nmvvm.viewmodels.NMvxSplashViewModel;

/**
 * Created by DangManhDuc on 12/19/2016.
 */

public abstract class NMvxSplashView<T extends ViewDataBinding> extends NMvxView<T, NMvxSplashViewModel> {

    private INMvxAppStart appStart;

    protected NMvxSplashView(int layoutId, int dataContextId) {
        super(layoutId, dataContextId);
        appStart = NMvx.resolve(INMvxAppStart.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initialize() {
        appStart.start();
    }

}
