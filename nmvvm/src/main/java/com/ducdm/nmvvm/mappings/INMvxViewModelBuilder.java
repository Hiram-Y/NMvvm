package com.ducdm.nmvvm.mappings;

import com.ducdm.nmvvm.viewmodels.NMvxViewModel;

/**
 * Created by DangManhDuc on 12/18/2016.
 */

public interface INMvxViewModelBuilder {

    <T extends NMvxViewModel> T resolveViewModelInstance(Class<?> viewModelType);

}
