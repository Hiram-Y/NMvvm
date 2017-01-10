package com.ducdm.app.models;

import android.databinding.Bindable;

import com.ducdm.nmvvm.models.NMVxModel;

/**
 * Created by DangManhDuc on 12/11/2016.
 */

public class UserSignInModel extends NMVxModel {

    private String username;

    public UserSignInModel(){

    }

    @Bindable
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
        notifyPropertyChanged(com.ducdm.app.nmvvm.BR.username);
    }

}
