package com.ducdm.nmvvm.agents.finders;

import java.util.Collection;

/**
 * Created by DangManhDuc on 12/18/2016.
 */

public class LoaderQuery extends Query<Class<?>> {

    public LoaderQuery() {
    }

    public LoaderQuery(Collection<? extends Class<?>> c) {
        super(c);
    }

}
