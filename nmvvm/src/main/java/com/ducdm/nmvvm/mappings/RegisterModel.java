package com.ducdm.nmvvm.mappings;

/**
 * Created by DangManhDuc on 12/15/2016.
 */

public class RegisterModel {

    private IoCContainer.RegistrationType registrationType;

    protected RegisterModel(IoCContainer.RegistrationType registrationType){
        this.registrationType = registrationType;
    }

    protected IoCContainer.RegistrationType getRegistrationType() {
        return registrationType;
    }

}
