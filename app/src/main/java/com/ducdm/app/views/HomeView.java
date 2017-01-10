package com.ducdm.app.views;

import com.ducdm.app.viewmodels.HomeViewModel;
import com.ducdm.app.nmvvm.R;
import com.ducdm.app.nmvvm.databinding.HomeViewBinding;
import com.ducdm.nmvvm.views.NMvxView;

/**
 * Created by DangManhDuc on 12/11/2016.
 */

public class HomeView extends NMvxView<HomeViewBinding, HomeViewModel> {

    public HomeView() {
        super(R.layout.home_view, com.ducdm.app.nmvvm.BR.HomeViewModel);
    }

    @Override
    protected void initialize() {
        viewModel.setBtnTitle("Add user");
    }

}
