package com.ducdm.app;

import android.content.Intent;

import com.ducdm.app.services.DeviceInfo;
import com.ducdm.app.services.IDeviceInfo;
import com.ducdm.app.viewmodels.SignInViewModel;
import com.ducdm.nmvvm.NMvxApplication;
import com.ducdm.nmvvm.agents.NMvxViewModelWrapper;
import com.ducdm.nmvvm.agents.NMvxViewPresenter;
import com.ducdm.nmvvm.mappings.NMvx;

/**
 * Created by DangManhDuc on 12/11/2016.
 */

public class NMvvmApplication extends NMvxApplication {

    @Override
    public void initialize() {
        super.initialize();

//        new NMvxLoaderExtension.Builder(getPackageName() + ".services")
//                .load()
//                .queryInterfaces()
//                .registerType()
//                .build();

        NMvx.registerType(IDeviceInfo.class, DeviceInfo.class);

        registerAppStart(SignInViewModel.class);
    }

    // TODO: do custom presenter
//    @Override
//    protected INMvxViewPresenter createViewPresenter() {
//        INMvxViewPresenter presenter = new CustomViewPresenter();
//        NMvx.registerSingleton(INMvxViewPresenter.class, presenter);
//
//        return presenter;
//
//        return null;
//    }

    class CustomViewPresenter extends NMvxViewPresenter {

        @Override
        public void showView(NMvxViewModelWrapper viewModelWrapper) {
            Intent intent = this.buildIntent(viewModelWrapper);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);

            // TODO: do some custom with intent

            this.show(intent);
        }

    }

}
