package com.ducdm.nmvvm.agents.finders;

import android.app.Activity;

/**
 * Created by DangManhDuc on 12/20/2016.
 */

public class NMvxCurrentTopView implements INMvxCurrentTopView {

    private Activity activity;

    @Override
    public void setCurrentTopView(Activity activity) {
        this.activity = activity;
    }

    @Override
    public Activity currentTopView() {
        return activity;
    }

}
