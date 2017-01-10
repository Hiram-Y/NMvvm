package com.ducdm.nmvvm.extensions;

import android.databinding.BindingAdapter;
import android.databinding.ObservableList;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ducdm.nmvvm.customs.NMvxRecyclerAdapter;

import io.reactivex.functions.Function;

/**
 * Created by DangManhDuc on 12/24/2016.
 */

public class NMvxRecyclerBinding {

    @BindingAdapter(value = {"app:items_source", "app:item_template", "app:item_datasource", "app:item_click"}, requireAll = false)
    public static <T> void setAdapter(RecyclerView recyclerView, ObservableList<T> itemsSource, int itemTemplate, int itemDataSourceId, Function<T, Void> itemClickCommand){
        NMvxRecyclerAdapter<T> adapter = (NMvxRecyclerAdapter<T>) recyclerView.getAdapter();

        if(adapter == null){
            adapter = new NMvxRecyclerAdapter<T>();

            adapter.setDataSource(itemsSource);
            adapter.setItemTemplateId(itemTemplate);
            adapter.setItemDataSourceId(itemDataSourceId);
            adapter.setItemClickCommand(itemClickCommand);
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), LinearLayoutManager.VERTICAL, false));
            recyclerView.setAdapter(adapter);
        }
    }

}
