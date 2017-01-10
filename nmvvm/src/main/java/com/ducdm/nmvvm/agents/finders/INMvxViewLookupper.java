package com.ducdm.nmvvm.agents.finders;

import com.ducdm.nmvvm.viewmodels.NMvxViewModel;
import com.ducdm.nmvvm.views.NMvxView;

/**
 * Created by DangManhDuc on 12/17/2016.
 */

public interface INMvxViewLookupper {

    Class<? extends NMvxView> lookupViewType(Class<? extends NMvxViewModel> viewModelType);

}
