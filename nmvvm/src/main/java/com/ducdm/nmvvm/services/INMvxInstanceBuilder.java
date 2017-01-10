package com.ducdm.nmvvm.services;

import java.lang.reflect.Constructor;

/**
 * Created by DangManhDuc on 12/15/2016.
 */

public interface INMvxInstanceBuilder {

    Object createNewInstance(Constructor constructor, Object [] parameters);

    Object getSingleton(Constructor constructor, Object [] parameters);
    public Object getSingleton(Object object);

}
