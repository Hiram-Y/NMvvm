package com.ducdm.nmvvm.customs;

import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import io.reactivex.functions.Function;

/**
 * Created by LapTop on 12/24/2016.
 */

public class NMvxRecyclerAdapter<T> extends RecyclerView.Adapter<NMvxRecyclerViewHolder> {

    private ObservableList<T> dataSource;
    private int itemTemplateId;
    private int itemDataSourceId;
    private Function<T, Void> itemClickCommand;
    private DataSourceChangeEvents dataSourceChangeEvents;

    public NMvxRecyclerAdapter(){
        this.dataSourceChangeEvents = new DataSourceChangeEvents();
    }

    public void setDataSource(ObservableList<T> dataSource) {
        this.dataSource = dataSource != null ? dataSource : new ObservableArrayList<T>();
        if(dataSourceChangeEvents != null){
            this.dataSource.removeOnListChangedCallback(dataSourceChangeEvents);
        }
        this.dataSource.addOnListChangedCallback(dataSourceChangeEvents);
    }

    public ObservableList<T> getDataSource() {
        return this.dataSource;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return getDataSource().size();
    }

    @Override
    public NMvxRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(itemTemplateId, parent, false);

        return new NMvxRecyclerViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(NMvxRecyclerViewHolder holder, int position) {
        holder.getItemBinding().setVariable(itemDataSourceId, getDataSource().get(position));
        holder.getItemBinding().getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    itemClickCommand.apply(getDataSource().get(position));
                } catch (Exception e) {
                    Log.e("Item Click: ", "Can not excecute item click command");
                }
            }
        });
    }

    public void setItemTemplateId(int itemTemplateId) {
        this.itemTemplateId = itemTemplateId;
    }

    public void setItemDataSourceId(int itemDataSourceId) {
        this.itemDataSourceId = itemDataSourceId;
    }

    public void setItemClickCommand(Function<T, Void> itemClickCommand) {
        this.itemClickCommand = itemClickCommand;
    }

    private class DataSourceChangeEvents extends ObservableList.OnListChangedCallback {

        @Override
        public void onChanged(ObservableList observableList) {
            notifyDataSetChanged();
        }

        @Override
        public void onItemRangeChanged(ObservableList observableList, int i, int i1) {
            notifyItemRangeChanged(i, i1);
        }

        @Override
        public void onItemRangeInserted(ObservableList observableList, int i, int i1) {
            notifyItemRangeInserted(i, i1);
        }

        @Override
        public void onItemRangeMoved(ObservableList observableList, int i, int i1, int i2) {
            notifyItemRangeRemoved(i, i2);
            notifyItemRangeInserted(i1, i2);
        }

        @Override
        public void onItemRangeRemoved(ObservableList observableList, int i, int i1) {
            notifyItemRangeRemoved(i, i1);
        }

    }

}
