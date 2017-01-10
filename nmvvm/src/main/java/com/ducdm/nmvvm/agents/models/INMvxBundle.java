package com.ducdm.nmvvm.agents.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.Map;

/**
 * Created by DangManhDuc on 12/17/2016.
 */

@JsonDeserialize(as = NMvxBundle.class)
public interface INMvxBundle {

    Map<String, String> getBundleData();
    <T> void write(T data);
    <T> T read(Class<T> data);

}
