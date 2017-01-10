package com.ducdm.app.views;

import com.ducdm.app.nmvvm.R;
import com.ducdm.app.nmvvm.databinding.SignInViewBinding;
import com.ducdm.app.models.UserSignInModel;
import com.ducdm.app.viewmodels.SignInViewModel;
import com.ducdm.nmvvm.views.NMvxView;

/**
 * Created by DangManhDuc on 12/11/2016.
 */

public class SignInView extends NMvxView<SignInViewBinding, SignInViewModel> {

    public SignInView() {
        super(R.layout.sign_in_view, com.ducdm.app.nmvvm.BR.SignInViewModel);
    }

    @Override
    protected void initialize() {
        viewModel.setUserSignIn(new UserSignInModel());
    }

}
