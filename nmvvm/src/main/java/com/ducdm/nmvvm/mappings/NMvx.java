package com.ducdm.nmvvm.mappings;

import com.ducdm.nmvvm.services.NMvxSingleton;

/**
 * Created by DangManhDuc on 12/15/2016.
 */

public class NMvx {

    public static <T, V extends T> void registerType(Class<T> source, Class<V> destination) {
        NMvxSingleton.getInstance(NMvxIoCContainer.class).registerType(source, destination);
    }

    public static <T> void registerType(Class<T> source, T destination) {
        NMvxSingleton.getInstance(NMvxIoCContainer.class).registerType(source, destination);
    }

    public static <T, V extends T> void registerSingleton(Class<T> source, Class<V> destination) {
        NMvxSingleton.getInstance(NMvxIoCContainer.class).registerSingleton(source, destination);
    }

    public static <T> void registerSingleton(Class<T> source, T destination) {
        NMvxSingleton.getInstance(NMvxIoCContainer.class).registerSingleton(source, destination);
    }

    public static <T> T resolve(Class<T> source) {
        return NMvxSingleton.getInstance(NMvxIoCContainer.class).resolve(source);
    }

}
