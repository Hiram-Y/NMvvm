package com.ducdm.nmvvm.dynamicscanner;

import com.ducdm.nmvvm.agents.finders.LoaderQuery;

/**
 * Created by DangManhDuc on 12/18/2016.
 */

public interface INMvxDynamicScanner {

    LoaderQuery scan(String scannedPackage);

}
