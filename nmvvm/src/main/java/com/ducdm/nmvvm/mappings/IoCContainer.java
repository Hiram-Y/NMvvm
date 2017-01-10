package com.ducdm.nmvvm.mappings;

import com.ducdm.nmvvm.services.NMvxInstanceBuilder;

import java.lang.reflect.Constructor;

/**
 * Created by DangManhDuc on 12/15/2016.
 */

public class IoCContainer {

    public enum RegistrationType {
        INSTANCE,
        SINGLETON
    }

    protected IoCContainer(){
    }

    protected Object createInstance(Constructor constructor, RegistrationType registrationType, Object [] parameters){
        Object result = null;
        if(registrationType == RegistrationType.INSTANCE){
            result = NMvxInstanceBuilder.getObjectInstanceHelper().createNewInstance(constructor, parameters);
        } else if(registrationType == RegistrationType.SINGLETON) {
            result = NMvxInstanceBuilder.getObjectInstanceHelper().getSingleton(constructor, parameters);
        }

        return result;
    }

    protected Object createInstance(Object instance, RegistrationType registrationType){
        Object result = null;
        if(registrationType == RegistrationType.INSTANCE){
            result = instance;
        } else if(registrationType == RegistrationType.SINGLETON) {
            result = NMvxInstanceBuilder.getObjectInstanceHelper().getSingleton(instance);
        }

        return result;
    }

}
