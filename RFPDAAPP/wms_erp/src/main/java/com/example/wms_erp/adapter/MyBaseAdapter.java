package com.example.wms_erp.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hasee on 2016/5/23.
 */
public abstract class MyBaseAdapter<T,VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH>{
    protected Activity mActivity;
    protected List<T> mData = new ArrayList<T>();
    AdapterView.OnItemClickListener mItemClickListener;
    public MyBaseAdapter(Activity activity, List<T> data){
        mActivity = activity;
        mData = data;
    }


    @Override
    public void onBindViewHolder(VH holder, int position) {
        T item = getItem(position);
        bindItemData(holder,item,position);
        setupOnItemClick(holder, position);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

protected abstract void bindItemData(VH holder,T data,int position);
    protected T getItem(int position){
       position= Math.max(0,position);//防止position小于0报错
        return mData.get(position);
    }

    protected void setupOnItemClick(final VH viewHolder, final int position) {
        if (mItemClickListener != null) {
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mItemClickListener.onItemClick(null, viewHolder.itemView, position, position);
                }
            });
        }
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener listener) {
        this.mItemClickListener = listener;
    }

    public void refreshData(List<T> data){
        mData.clear();
        if(data!=null){
            mData.addAll(data);
        }
        notifyDataSetChanged();
    }

    public void removeUItem(int position){
        mData.remove(position);
        notifyItemRemoved(position);
    }
    public void addItem(T item){
        mData.add(item);
        notifyItemInserted(mData.size()-1);
    }
}
