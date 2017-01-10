package com.ducdm.nmvvm.agents;

import android.app.Activity;
import android.content.Intent;

import com.ducdm.nmvvm.agents.finders.INMvxCurrentTopView;
import com.ducdm.nmvvm.mappings.NMvx;

/**
 * Created by DangManhDuc on 12/17/2016.
 */

public class NMvxViewPresenter implements INMvxViewPresenter {

    public Activity activity;

    public NMvxViewPresenter(){

    }

    @Override
    public void showView(NMvxViewModelWrapper viewModelWrapper) {
        Intent intent = this.buildIntent(viewModelWrapper);
        show(intent);
    }

    @Override
    public void close() {
        activity = NMvx.resolve(INMvxCurrentTopView.class).currentTopView();
        if(activity == null){
            return;
        }

        activity.onBackPressed();
    }

    protected void show(Intent intent){
        if(intent == null){
            return;
        }

        activity = NMvx.resolve(INMvxCurrentTopView.class).currentTopView();
        if(activity == null){
            return;
        }

        activity.startActivity(intent);
    }

    public Intent buildIntent(NMvxViewModelWrapper viewModelWrapper){
        INMvxViewsPopulator viewsPopulator = NMvx.resolve(INMvxViewsPopulator.class);
        Intent intent = viewsPopulator.getIntent(viewModelWrapper);

        // TODO: do some customizations with intent

        return intent;
    }

}
