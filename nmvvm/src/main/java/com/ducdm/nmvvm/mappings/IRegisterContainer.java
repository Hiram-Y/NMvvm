package com.ducdm.nmvvm.mappings;

/**
 * Created by DangManhDuc on 12/15/2016.
 */

public interface IRegisterContainer {

    <T, V extends T> void registerType(Class<T> source, Class<V> destination);
    <T> void registerType(Class<T> source, T destination);
    <T, V extends T> void registerSingleton(Class<T> source, Class<V> destination);
    <T> void registerSingleton(Class<T> source, T destination);

}
