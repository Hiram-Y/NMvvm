package com.ducdm.app.viewmodels;

import android.databinding.Bindable;
import android.databinding.ObservableArrayList;
import android.util.Log;

import com.ducdm.app.models.UserModel;
import com.ducdm.app.nmvvm.BR;
import com.ducdm.app.nmvvm.R;
import com.ducdm.app.services.IDeviceInfo;
import com.ducdm.nmvvm.atrributes.Construct;
import com.ducdm.nmvvm.mappings.NMvx;
import com.ducdm.nmvvm.plugins.dialogs.INMvxDialogs;
import com.ducdm.nmvvm.viewmodels.NMvxViewModel;

import io.reactivex.functions.Action;
import io.reactivex.functions.Function;

/**
 * Created by DangManhDuc on 12/20/2016.
 */

public class HomeViewModel extends NMvxViewModel {

    private String btnTitle;
    public ObservableArrayList<UserModel> users;
    public int itemTemplate;
    public int itemDataSourceId;
    public Action addUserCommand;
    public Function<UserModel, Void> itemClickCommand;

    private IDeviceInfo deviceInfo;

    @Construct
    public HomeViewModel(IDeviceInfo deviceInfo){
        this.deviceInfo = deviceInfo;

        users = new ObservableArrayList<UserModel>();
        users.add(new UserModel("a"));
        users.add(new UserModel("b"));
        users.add(new UserModel("c"));
        users.add(new UserModel("d"));
        users.add(new UserModel("e"));

        itemTemplate = R.layout.user_item;

        itemDataSourceId = BR.UserModel;

        itemClickCommand = (userModel) -> {
            INMvxDialogs dialogs = NMvx.resolve(INMvxDialogs.class);
            dialogs.showToast("User " + userModel.getName() + " clicked", 6000);

            Log.d("Item Click: ", "User " + userModel.getName() + " clicked");

            return null;
        };

        addUserCommand = () -> {
            users.add(new UserModel("f"));
        };

        Log.d("DEVICE: ", deviceInfo.deviceModel());
    }

    @Bindable
    public String getBtnTitle() {
        return btnTitle;
    }

    public void setBtnTitle(String btnTitle) {
        this.btnTitle = btnTitle;
        notifyPropertyChanged(BR.btnTitle);
    }

}
