package com.ducdm.nmvvm.agents.models;

import java.util.List;

/**
 * Created by DangManhDuc on 12/18/2016.
 */

public class NMvxServiceAndImplementationTypePair<T, V extends T> {

    private List<Class<T>> serviceTypes;
    private Class<V> implementationType;

    public NMvxServiceAndImplementationTypePair(List<Class<T>> serviceTypes, Class<V> implementationType){
        this.serviceTypes = serviceTypes;
        this.implementationType = implementationType;
    }

    public List<Class<T>> getServiceTypes() {
        return serviceTypes;
    }

    public void setServiceTypes(List<Class<T>> serviceTypes) {
        this.serviceTypes = serviceTypes;
    }

    public Class<V> getImplementationType() {
        return implementationType;
    }

    public void setImplementationType(Class<V> implementationType) {
        this.implementationType = implementationType;
    }

}
