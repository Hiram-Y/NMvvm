package com.ducdm.nmvvm;

import android.app.Application;

import com.ducdm.nmvvm.agents.INMvxAppStart;
import com.ducdm.nmvvm.agents.INMvxApplication;
import com.ducdm.nmvvm.agents.INMvxViewDispatcher;
import com.ducdm.nmvvm.agents.INMvxViewPresenter;
import com.ducdm.nmvvm.agents.INMvxViewsPopulator;
import com.ducdm.nmvvm.agents.NMvxAppStart;
import com.ducdm.nmvvm.agents.NMvxViewDispatcher;
import com.ducdm.nmvvm.agents.NMvxViewPresenter;
import com.ducdm.nmvvm.agents.NMvxViewsPopulator;
import com.ducdm.nmvvm.agents.bundlizers.INMvxNavigationSerializer;
import com.ducdm.nmvvm.agents.bundlizers.NMvxNavigationSerializer;
import com.ducdm.nmvvm.agents.finders.INMvxCurrentTopView;
import com.ducdm.nmvvm.agents.finders.INMvxDynamicViewModelViewLoader;
import com.ducdm.nmvvm.agents.finders.NMvxCurrentTopView;
import com.ducdm.nmvvm.agents.finders.NMvxDynamicViewModelViewLoader;
import com.ducdm.nmvvm.dynamicscanner.INMvxDynamicScanner;
import com.ducdm.nmvvm.dynamicscanner.NMvxDynamicScanner;
import com.ducdm.nmvvm.mappings.INMvxViewModelBuilder;
import com.ducdm.nmvvm.mappings.IoCViewModelBuilder;
import com.ducdm.nmvvm.mappings.NMvx;
import com.ducdm.nmvvm.plugins.dialogs.INMvxDialogs;
import com.ducdm.nmvvm.plugins.dialogs.NMvxDialogs;
import com.ducdm.nmvvm.viewmodels.NMvxViewModel;

/**
 * Created by DangManhDuc on 12/17/2016.
 */

public abstract class NMvxApplication extends Application implements INMvxApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        initialize();
    }

    @Override
    public void initialize() {
        // dynamic scanner
        NMvx.registerSingleton(INMvxDynamicScanner.class, new NMvxDynamicScanner(getPackageCodePath()));
        NMvx.registerSingleton(INMvxDynamicViewModelViewLoader.class, new NMvxDynamicViewModelViewLoader(getPackageName()));

        INMvxDynamicViewModelViewLoader loader = NMvx.resolve(INMvxDynamicViewModelViewLoader.class);
        loader.startMapping();

        // running view
        NMvx.registerSingleton(INMvxCurrentTopView.class, new NMvxCurrentTopView());

        // starters
        INMvxViewPresenter presenter = this.createViewPresenter();
        NMvx.registerSingleton(INMvxViewDispatcher.class, new NMvxViewDispatcher(presenter));

        // view populator
        NMvx.registerSingleton(INMvxViewsPopulator.class, new NMvxViewsPopulator(getApplicationContext()));

        // bundlizers
        NMvx.registerSingleton(INMvxNavigationSerializer.class, new NMvxNavigationSerializer());

        // viewmodel resolver
        NMvx.registerSingleton(INMvxViewModelBuilder.class, new IoCViewModelBuilder());

        // dialogs
        NMvx.registerSingleton(INMvxDialogs.class, NMvxDialogs.class);
    }

    protected INMvxViewPresenter createViewPresenter(){
        INMvxViewPresenter presenter = new NMvxViewPresenter();
        NMvx.registerSingleton(INMvxViewPresenter.class, presenter);

        return presenter;
    }

    @Override
    public void registerAppStart(INMvxAppStart nMvxAppStart) {
        NMvx.registerSingleton(INMvxAppStart.class, nMvxAppStart);
    }

    @Override
    public <T extends NMvxViewModel> void registerAppStart(Class<T> viewModel) {
        NMvx.registerSingleton(INMvxAppStart.class, new NMvxAppStart(viewModel));
    }

}
