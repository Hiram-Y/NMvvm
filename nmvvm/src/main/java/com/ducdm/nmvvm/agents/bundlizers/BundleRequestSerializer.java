package com.ducdm.nmvvm.agents.bundlizers;

import com.ducdm.nmvvm.agents.NMvxViewModelWrapper;
import com.ducdm.nmvvm.services.INMvxJsonMapper;
import com.ducdm.nmvvm.services.NMvxJsonMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;

/**
 * Created by DangManhDuc on 12/18/2016.
 */

public class BundleRequestSerializer extends NMvxJsonMapper implements INMvxJsonMapper {

    @Override
    public <T> String writeData(T data) {
        return this.serialize((NMvxViewModelWrapper) data);
    }

    @Override
    public <T> T readData(String content, Class<T> outputType) {
        return this.deserialize(content, outputType);
    }

    private String serialize(NMvxViewModelWrapper viewModelWrapper){
        try {
            return mapper.writeValueAsString(viewModelWrapper);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return null;
    }

    private <T> T deserialize(String content, Class<T> outputType){
        try {
            return mapper.readValue(content, outputType);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}
