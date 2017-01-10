package com.ducdm.app.views;

import android.os.Handler;

import com.ducdm.app.nmvvm.databinding.SplashViewBinding;
import com.ducdm.app.nmvvm.R;
import com.ducdm.nmvvm.views.NMvxSplashView;

/**
 * Created by DangManhDuc on 12/19/2016.
 */

public class SplashView extends NMvxSplashView<SplashViewBinding> {

    public SplashView() {
        super(R.layout.splash_view, com.ducdm.app.nmvvm.BR.NMvxSplashViewModel);
    }

    @Override
    protected void initialize() {
        new Handler().postDelayed(() ->
        {
            super.initialize();
        }, 3000);
    }

}
