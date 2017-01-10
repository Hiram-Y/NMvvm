package com.ducdm.nmvvm.agents.finders;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by DangManhDuc on 12/18/2016.
 */

public class Query<T> extends ArrayList<T> {

    public Query() {
    }

    public Query(Collection<? extends T> c) {
        super(c);
    }

}
