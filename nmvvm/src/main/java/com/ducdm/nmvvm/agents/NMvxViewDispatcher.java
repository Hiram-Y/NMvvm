package com.ducdm.nmvvm.agents;

import com.ducdm.nmvvm.atrributes.Construct;

/**
 * Created by DangManhDuc on 12/17/2016.
 */

public class NMvxViewDispatcher implements INMvxViewDispatcher {

    private INMvxViewPresenter viewPresenter;

    @Construct
    public NMvxViewDispatcher(INMvxViewPresenter viewPresenter){
        this.viewPresenter = viewPresenter;
    }

    @Override
    public boolean showViewModel(NMvxViewModelWrapper viewModelWrapper) {
        viewPresenter.showView(viewModelWrapper);

        return true;
    }

    @Override
    public void closeViewModel() {
        viewPresenter.close();
    }

}
