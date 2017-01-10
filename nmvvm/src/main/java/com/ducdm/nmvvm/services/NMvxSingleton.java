package com.ducdm.nmvvm.services;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by DangManhDuc on 12/16/2016.
 */

public class NMvxSingleton {

    private static Map<Class<?>, Object> holder = new HashMap<Class<?>, Object>();

    private NMvxSingleton(){
    }

    public static <T> T getInstance(Class<T> clazz){
        try {
            return NestedNMvxSingleton.getInstance(clazz);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

        return null;
    }

    static class NestedNMvxSingleton {

        public static <T> T getInstance(Class<T> clazz) throws IllegalAccessException, InstantiationException {
            if(!holder.containsKey(clazz)){
                T instance = clazz.newInstance();
                holder.put(clazz, instance);
            }

            return (T) holder.get(clazz);
        }

    }

}
