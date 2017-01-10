package com.ducdm.nmvvm.extensions;

import android.databinding.BindingAdapter;
import android.view.View;

import io.reactivex.functions.Action;

/**
 * Created by DangManhDuc on 1/7/2017.
 */

public class NMvxViewBinding {

    @BindingAdapter(value = {"app:click", "app:long_click"}, requireAll = false)
    public static void setAdapter(View view, Action clickCommand, Action longClickCommand){
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    clickCommand.run();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
