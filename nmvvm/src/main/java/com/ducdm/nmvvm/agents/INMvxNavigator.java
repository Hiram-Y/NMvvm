package com.ducdm.nmvvm.agents;

import com.ducdm.nmvvm.agents.models.INMvxBundle;
import com.ducdm.nmvvm.viewmodels.NMvxViewModel;

import java.util.Map;

/**
 * Created by DangManhDuc on 12/17/2016.
 */

public interface INMvxNavigator {

    <T extends NMvxViewModel> boolean showViewModel(Class<T> viewModel);
    <T extends NMvxViewModel> boolean showViewModel(Class<T> viewModel, Map<String, String> bundleParameters, Map<String, String> statesSavedParameters);
    <T extends NMvxViewModel> boolean showViewModel(Class<T> viewModel, INMvxBundle bundleParameters, INMvxBundle statesSavedParameters);

}
