package com.ducdm.nmvvm.agents.finders;

import com.ducdm.nmvvm.agents.models.NMvxServiceAndImplementationTypePair;

import java.util.Collection;

/**
 * Created by DangManhDuc on 12/17/2016.
 */

public class MapperQuery extends Query<NMvxServiceAndImplementationTypePair> {

    public MapperQuery() {
    }

    public MapperQuery(Collection<? extends NMvxServiceAndImplementationTypePair> c) {
        super(c);
    }

}
