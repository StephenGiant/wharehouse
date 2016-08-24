package com.example.wms_erp.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.ButterKnife;

/**
 * Created by hasee on 2016/5/23.
 */
public class MyBaseViewHolder extends RecyclerView.ViewHolder {
    public MyBaseViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }
}
