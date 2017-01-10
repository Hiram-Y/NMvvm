package com.ducdm.app.models;

import android.databinding.Bindable;

import com.ducdm.nmvvm.models.NMVxModel;

/**
 * Created by LapTop on 12/24/2016.
 */

public class UserModel extends NMVxModel {

    private String name;

    public UserModel(String name){
        this.name = name;
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(com.ducdm.app.nmvvm.BR.name);
    }

}
