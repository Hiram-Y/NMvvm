package com.ducdm.app.services;

import android.os.Build;
import android.util.Log;

/**
 * Created by LapTop on 12/26/2016.
 */

public class DeviceInfo implements IDeviceInfo {

    @Override
    public String deviceModel() {
        String deviceModel = "";
        try {
            deviceModel = Build.MANUFACTURER + " " + Build.MODEL;
        } catch (Exception ex) {
            Log.e("DEVICE INFO: ", ex.getMessage());
        }

        return deviceModel;
    }

}
