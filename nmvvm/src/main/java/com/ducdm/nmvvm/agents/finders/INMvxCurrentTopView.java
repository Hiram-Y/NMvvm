package com.ducdm.nmvvm.agents.finders;

import android.app.Activity;

/**
 * Created by DangManhDuc on 12/20/2016.
 */

public interface INMvxCurrentTopView {

    void setCurrentTopView(Activity activity);
    Activity currentTopView();

}
