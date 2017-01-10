package com.ducdm.nmvvm.agents.bundlizers;

import com.ducdm.nmvvm.services.INMvxJsonMapper;
import com.ducdm.nmvvm.services.NMvxJsonMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;

/**
 * Created by DangManhDuc on 12/17/2016.
 */

public class NMvxTextMapper extends NMvxJsonMapper implements INMvxJsonMapper {

    @Override
    public <T> String writeData(T data) {
        try {
            return mapper.writeValueAsString(data);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public <T> T readData(String content, Class<T> outputType) {
        try {
            return mapper.readValue(content, outputType);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}
