package com.ducdm.nmvvm.mappings;

/**
 * Created by DangManhDuc on 12/15/2016.
 */

public interface IResolverContainer {

    <T> T resolve(Class<T> source);

}
