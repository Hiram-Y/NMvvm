package com.ducdm.nmvvm.agents;

import com.ducdm.nmvvm.viewmodels.NMvxViewModel;

/**
 * Created by DangManhDuc on 12/17/2016.
 */

public interface INMvxApplication {

    void initialize();
    void registerAppStart(INMvxAppStart nMvxAppStart);
    <T extends NMvxViewModel> void registerAppStart(Class<T> viewModel);

}
