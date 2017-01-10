package com.ducdm.app.viewmodels;

import android.databinding.Bindable;

import com.ducdm.app.events.ISignInEvents;
import com.ducdm.app.nmvvm.BR;
import com.ducdm.app.models.UserSignInModel;
import com.ducdm.nmvvm.viewmodels.NMvxViewModel;

/**
 * Created by DangManhDuc on 12/11/2016.
 */

public class SignInViewModel extends NMvxViewModel implements ISignInEvents {

    private UserSignInModel userSignIn;

    public String lblShowHome = "Show Home";

    public SignInViewModel(){
        super();
    }

    @Bindable
    public UserSignInModel getUserSignIn() {
        return userSignIn;
    }

    public void setUserSignIn(UserSignInModel userSignIn) {
        this.userSignIn = userSignIn;
        notifyPropertyChanged(BR.userSignIn);
    }

    @Override
    public void showHome() {
        showViewModel(HomeViewModel.class);
    }

}
