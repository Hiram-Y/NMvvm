package com.ducdm.nmvvm.viewmodels;

import com.ducdm.nmvvm.agents.models.INMvxBundle;

/**
 * Created by DangManhDuc on 12/17/2016.
 */

public interface INMvxViewModel {

    void onInitialize(INMvxBundle bundle);
    void onStart();
    void onRestoreStates(INMvxBundle bundle);
    void onSaveStates(INMvxBundle bundle);
    void onClose();

}
