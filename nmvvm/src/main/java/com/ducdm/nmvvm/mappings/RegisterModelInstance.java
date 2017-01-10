package com.ducdm.nmvvm.mappings;

/**
 * Created by DangManhDuc on 12/15/2016.
 */

public class RegisterModelInstance extends RegisterModel {

    private Object destinationInstance;

    protected RegisterModelInstance(Object destinationInstance, IoCContainer.RegistrationType registrationType) {
        super(registrationType);
        this.destinationInstance = destinationInstance;
    }

    protected Object getDestinationInstance() {
        return destinationInstance;
    }

}
