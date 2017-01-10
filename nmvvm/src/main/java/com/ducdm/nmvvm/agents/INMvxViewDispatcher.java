package com.ducdm.nmvvm.agents;

/**
 * Created by DangManhDuc on 12/17/2016.
 */

public interface INMvxViewDispatcher {

    boolean showViewModel(NMvxViewModelWrapper viewModelWrapper);
    void closeViewModel();

}
