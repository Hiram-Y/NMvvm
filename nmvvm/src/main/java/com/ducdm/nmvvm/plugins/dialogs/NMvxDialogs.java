package com.ducdm.nmvvm.plugins.dialogs;

import android.app.Activity;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.ducdm.nmvvm.agents.finders.INMvxCurrentTopView;
import com.ducdm.nmvvm.mappings.NMvx;

/**
 * Created by DangManhDuc on 1/7/2017.
 */

public class NMvxDialogs implements INMvxDialogs {

    private final int COUNTDOWN_INTERVAL = 1000;

    public NMvxDialogs(){
    }

    @Override
    public void showToast(String title, int duration) {
        this.showToast(new ToastConfigs(title, duration));
    }

    @Override
    public void showToast(ToastConfigs toastConfigs) {
        Activity currentView = NMvx.resolve(INMvxCurrentTopView.class).currentTopView();
        if(currentView != null && (AppCompatActivity) currentView != null){
            Toast toast = Toast.makeText(currentView, toastConfigs.getMessage(), Toast.LENGTH_SHORT);

            if(toastConfigs.getLayoutId() != null){
                View view = LayoutInflater.from(currentView).inflate(toastConfigs.getLayoutId(), null);
                toast.setView(view);
                toast.setGravity(toastConfigs.getGravity(), 0, 0);
            }

            toast.show();
            new CountDownTimer(toastConfigs.getDuration(), COUNTDOWN_INTERVAL){

                @Override
                public void onTick(long millisUntilFinished) {
                    toast.show();
                }

                @Override
                public void onFinish() {
                    cancel();
                }

            }.start();
        }
    }

    @Override
    public void showAlert(String title, String message, String positiveText) {

    }

    @Override
    public void showAlert(AlertConfigs alertConfigs) {

    }

    @Override
    public void showConfirm(String title, String message, String positiveText, String negativeText) {

    }

    @Override
    public void showConfirm(ConfirmConfigs confirmConfigs) {

    }

    @Override
    public void showLoading(String title, MaskType maskType) {

    }

}
