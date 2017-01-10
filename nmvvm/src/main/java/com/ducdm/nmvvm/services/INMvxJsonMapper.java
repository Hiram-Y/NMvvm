package com.ducdm.nmvvm.services;

/**
 * Created by DangManhDuc on 12/17/2016.
 */

public interface INMvxJsonMapper {

    <T> String writeData(T data);
    <T> T readData(String content, Class<T> outputType);

}
