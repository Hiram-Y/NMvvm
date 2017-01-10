package com.ducdm.nmvvm.plugins.dialogs;

/**
 * Created by DangManhDuc on 1/7/2017.
 */

public class ToastConfigs {

    public String message;
    public Integer layoutId;
    public int gravity;
    public int duration;

    public ToastConfigs(String message, int duration){
        this.message = message;
        this.duration = duration;
    }

    public ToastConfigs(int layoutId, Integer gravity, int duration){
        this.layoutId = layoutId;
        this.gravity = gravity;
        this.duration = duration;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getLayoutId() {
        return layoutId;
    }

    public void setLayoutId(Integer layoutId) {
        this.layoutId = layoutId;
    }

    public int getGravity() {
        return gravity;
    }

    public void setGravity(int gravity) {
        this.gravity = gravity;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

}
