package com.ducdm.nmvvm.mappings;

import com.ducdm.nmvvm.atrributes.Construct;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

/**
 * Created by DangManhDuc on 12/15/2016.
 */

public class NMvxIoCContainer extends IoCContainer implements INMvxIoCContainer {

    private Hashtable<Class<?>, RegisterModel> container;

    public NMvxIoCContainer(){
        super();
        container = new Hashtable<Class<?>, RegisterModel>();
    }

    @Override
    public <T, V extends T> void registerType(Class<T> source, Class<V> destination) {
        this.register(source, destination, RegistrationType.INSTANCE);
    }

    @Override
    public <T> void registerType(Class<T> source, T destination) {
        this.register(source, destination, RegistrationType.INSTANCE);
    }

    @Override
    public <T, V extends T> void registerSingleton(Class<T> source, Class<V> destination) {
        this.register(source, destination, RegistrationType.SINGLETON);
    }

    @Override
    public <T> void registerSingleton(Class<T> source, T destination) {
        this.register(source, destination, RegistrationType.SINGLETON);
    }

    private <T> void register(Class<T> source, T destination, RegistrationType type){
        if(container.containsKey(source)){
            container.remove(source);
        }

        container.put(source, new RegisterModelInstance(destination, type));
    }

    private <T, V extends T> void register(Class<T> source, Class<V> destination, RegistrationType type){
        if(container.containsKey(source)){
            container.remove(source);
        }

        container.put(source, new RegisterModelType(destination, type));
    }

    @Override
    public <T> T resolve(Class<T> source) {
        return (T) resolveInstance(source);
    }

    private Object resolveInstance(Class<?> source){
        Object resolvedObject = null;
        try{
            if(container.containsKey(source)){
                RegisterModel registerModel = container.get(source);
                if(registerModel != null){
                    RegistrationType registrationType = registerModel.getRegistrationType();
                    if(registerModel instanceof RegisterModelType){
                        Class<?> destinationType = ((RegisterModelType) registerModel).getDestinationType();

                        Constructor pendingResolvedConstructor = null;

                        Constructor[] constructors = destinationType.getDeclaredConstructors();
                        for(Constructor constructor : constructors){
                            boolean isAnnotationPresent = constructor.isAnnotationPresent(Construct.class);
                            if(isAnnotationPresent){
                                pendingResolvedConstructor = constructor;
                                break;
                            }
                        }

                        if(pendingResolvedConstructor != null){
                            pendingResolvedConstructor.setAccessible(true);
                            Class<?> [] parameters = pendingResolvedConstructor.getParameterTypes();
                            if(parameters.length == 0){
                                resolvedObject = this.createInstance(pendingResolvedConstructor, registrationType, null);
                            } else {
                                List<Object> resolvedParameters = new ArrayList<Object>();
                                for(Class<?> parameter : parameters){
                                    resolvedParameters.add(this.resolveInstance(parameter));
                                }
                                resolvedObject = this.createInstance(pendingResolvedConstructor, registrationType, resolvedParameters.toArray(new Object []{}));
                            }
                        } else {
                            resolvedObject = this.createInstance(destinationType.getConstructor(new Class<?>[0]), registrationType, null);
                        }
                    } else {
                        resolvedObject = this.createInstance(((RegisterModelInstance) registerModel).getDestinationInstance(), registrationType);
                    }
                }
            }
        } catch (NoSuchMethodException ex) {
            // log here
        }

        return resolvedObject;
    }

    @Override
    public void clearStack() {

    }

}
