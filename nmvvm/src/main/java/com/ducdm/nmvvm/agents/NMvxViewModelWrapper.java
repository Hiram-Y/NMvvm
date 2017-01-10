package com.ducdm.nmvvm.agents;

import com.ducdm.nmvvm.agents.models.INMvxBundle;
import com.ducdm.nmvvm.viewmodels.NMvxViewModel;

/**
 * Created by DangManhDuc on 12/17/2016.
 */

public class NMvxViewModelWrapper {

    private Class<? extends NMvxViewModel> viewModelType;
    private INMvxBundle bundleParameters;
    private INMvxBundle savedStatesParameters;

    public NMvxViewModelWrapper(){

    }

    public NMvxViewModelWrapper(Class<? extends NMvxViewModel> viewModelType, INMvxBundle bundleParameters, INMvxBundle savedStatesParameters){
        this.viewModelType = viewModelType;
        this.bundleParameters = bundleParameters;
        this.savedStatesParameters = savedStatesParameters;
    }

    public Class<? extends NMvxViewModel> getViewModelType() {
        return viewModelType;
    }

    public void setViewModelType(Class<? extends NMvxViewModel> viewModelType) {
        this.viewModelType = viewModelType;
    }

    public INMvxBundle getBundleParameters() {
        return bundleParameters;
    }

    public void setBundleParameters(INMvxBundle bundleParameters) {
        this.bundleParameters = bundleParameters;
    }

    public INMvxBundle getSavedStatesParameters() {
        return savedStatesParameters;
    }

    public void setSavedStatesParameters(INMvxBundle savedStatesParameters) {
        this.savedStatesParameters = savedStatesParameters;
    }

}
