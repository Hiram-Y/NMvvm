package com.ducdm.nmvvm.mappings;

/**
 * Created by DangManhDuc on 12/15/2016.
 */

public class RegisterModelType extends RegisterModel {

    private Class<?> destinationType;

    protected RegisterModelType(Class<?> destinationType, IoCContainer.RegistrationType registrationType) {
        super(registrationType);
        this.destinationType = destinationType;
    }

    protected Class<?> getDestinationType() {
        return destinationType;
    }

}
