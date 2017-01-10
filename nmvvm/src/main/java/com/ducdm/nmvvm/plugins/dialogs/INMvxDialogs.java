package com.ducdm.nmvvm.plugins.dialogs;

/**
 * Created by DangManhDuc on 1/7/2017.
 */

public interface INMvxDialogs {

    enum MaskType {
        Black
    }

    void showToast(String title, int duration);
    void showToast(ToastConfigs toastConfigs);
    void showAlert(String title, String message, String positiveText);
    void showAlert(AlertConfigs alertConfigs);
    void showConfirm(String title, String message, String positiveText, String negativeText);
    void showConfirm(ConfirmConfigs confirmConfigs);
    void showLoading(String title, MaskType maskType);

}
