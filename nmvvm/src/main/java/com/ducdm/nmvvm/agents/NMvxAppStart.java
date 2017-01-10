package com.ducdm.nmvvm.agents;

import com.ducdm.nmvvm.viewmodels.NMvxViewModel;

/**
 * Created by DangManhDuc on 12/17/2016.
 */

public class NMvxAppStart<TViewModel extends NMvxViewModel> extends NMvxNavigator implements INMvxAppStart {

    private Class<TViewModel> viewModel;

    public NMvxAppStart(Class<TViewModel> viewModel){
        this.viewModel = viewModel;
    }

    @Override
    public void start() {
        this.showViewModel(viewModel);
    }

}
