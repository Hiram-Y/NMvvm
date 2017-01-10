package com.ducdm.nmvvm.customs;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by LapTop on 12/24/2016.
 */

public class NMvxRecyclerViewHolder extends RecyclerView.ViewHolder {

    private ViewDataBinding itemBinding;

    public NMvxRecyclerViewHolder(View itemView) {
        super(itemView);
        this.itemBinding = DataBindingUtil.bind(itemView);
    }

    public ViewDataBinding getItemBinding() {
        return this.itemBinding;
    }

}
