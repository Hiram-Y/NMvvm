package com.ducdm.nmvvm.mappings;

import com.ducdm.nmvvm.atrributes.Construct;
import com.ducdm.nmvvm.services.NMvxSingleton;
import com.ducdm.nmvvm.viewmodels.NMvxViewModel;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DangManhDuc on 12/18/2016.
 */

public class IoCViewModelBuilder extends IoCContainer implements INMvxViewModelBuilder {

    public IoCViewModelBuilder(){

    }

    @Override
    public <T extends NMvxViewModel> T resolveViewModelInstance(Class<?> viewModelType) {
        Object resolvedObject = null;

        try {
            Constructor pendingResolvedConstructor = null;

            Constructor[] constructors = viewModelType.getDeclaredConstructors();
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
                    resolvedObject = this.createInstance(pendingResolvedConstructor, RegistrationType.INSTANCE, null);
                } else {
                    List<Object> resolvedParameters = new ArrayList<Object>();
                    for(Class<?> parameter : parameters){
                        resolvedParameters.add(NMvxSingleton.getInstance(NMvxIoCContainer.class).resolve(parameter));
                    }
                    resolvedObject = this.createInstance(pendingResolvedConstructor, RegistrationType.INSTANCE, resolvedParameters.toArray(new Object []{}));
                }
            } else {
                resolvedObject = this.createInstance(viewModelType.getConstructor(new Class<?>[0]), RegistrationType.INSTANCE, null);
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        return (T) resolvedObject;
    }

}
