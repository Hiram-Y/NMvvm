package com.ducdm.nmvvm.agents.bundlizers;

import com.ducdm.nmvvm.services.INMvxJsonMapper;

/**
 * Created by DangManhDuc on 12/18/2016.
 */

public class NMvxNavigationSerializer implements INMvxNavigationSerializer {

    private INMvxJsonMapper serializer;

    public NMvxNavigationSerializer(){
        this.serializer = new BundleRequestSerializer();
    }

    @Override
    public INMvxJsonMapper getSerializer() {
        return serializer;
    }

}
