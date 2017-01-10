package com.ducdm.nmvvm.services;

import java.lang.reflect.Constructor;
import java.util.Hashtable;

/**
 * Created by DangManhDuc on 12/15/2016.
 */

public class NMvxInstanceBuilder implements INMvxInstanceBuilder {

    private static NMvxInstanceBuilder objectInstanceHelper = new NMvxInstanceBuilder();
    private static Hashtable<String, Object> objectsPool = new Hashtable<String, Object>();

    private NMvxInstanceBuilder(){
    }

    public static NMvxInstanceBuilder getObjectInstanceHelper(){
        return objectInstanceHelper;
    }

    @Override
    public Object createNewInstance(Constructor constructor, Object[] parameters) {
        Object instance = null;
        try{
            instance = constructor.newInstance(parameters);
        } catch (Exception ex)
        {
            // log here
        }

        return instance;
    }

    @Override
    public Object getSingleton(Constructor constructor, Object[] parameters) {
        Object instance = null;
        try{
            if(!objectsPool.containsKey(constructor.getClass().getName())){
                instance = this.createNewInstance(constructor, parameters);
                objectsPool.put(constructor.getClass().getName(), instance);
            } else {
                instance = objectsPool.get(constructor.getClass().getName());
            }
        } catch (Exception ex) {
            // log here
        }

        return instance;
    }

    @Override
    public Object getSingleton(Object object) {
        Object instance = null;
        try{
            if(!objectsPool.containsKey(object.getClass().getName())){
                instance = object;
                objectsPool.put(object.getClass().getName(), instance);
            } else {
                instance = objectsPool.get(object.getClass().getName());
            }
        } catch (Exception ex) {
            // log here
        }

        return instance;
    }
}
