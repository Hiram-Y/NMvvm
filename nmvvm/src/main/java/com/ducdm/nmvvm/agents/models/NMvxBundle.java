package com.ducdm.nmvvm.agents.models;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by DangManhDuc on 12/17/2016.
 */

public class NMvxBundle implements INMvxBundle { // extends NMvxJsonMapper

    private Map<String, String> bundleData;

    public NMvxBundle(){
        this(new HashMap<String, String>());
    }

    public NMvxBundle(Map<String, String> bundleData){
        this.bundleData = bundleData != null ? bundleData : new HashMap<String, String>();
    }


    @Override
    public Map<String, String> getBundleData() {
        return bundleData;
    }

    @Override
    public <T> void write(T data) {

    }

    @Override
    public <T> T read(Class<T> data) {
        return null;
    }

}
