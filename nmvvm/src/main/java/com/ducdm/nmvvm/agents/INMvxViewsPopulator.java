package com.ducdm.nmvvm.agents;

import android.content.Intent;

import com.ducdm.nmvvm.agents.models.INMvxBundle;
import com.ducdm.nmvvm.viewmodels.INMvxViewModel;

/**
 * Created by DangManhDuc on 12/17/2016.
 */

public interface INMvxViewsPopulator {

    Intent getIntent(NMvxViewModelWrapper viewModelWrapper);
    INMvxViewModel lookupViewModel(Intent intent, INMvxBundle bundle);

}
