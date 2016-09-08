package com.example.wms_erp.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.wms_erp.R;
import com.example.wms_erp.model.response.LocInfo;
import com.example.wms_erp.viewholder.MyBaseViewHolder;

import java.util.List;

/**
 * 库存盘点信息显示adapter
 * Created by qianpeng on 2016/9/8.
 */
public class LocCountAdapter extends MyBaseAdapter<List<LocInfo>,LocCountAdapter.LocCountViewHolder> {
    public LocCountAdapter(Activity activity, List<List<LocInfo>> data) {
        super(activity, data);
    }

    @Override
    protected void bindItemData(LocCountViewHolder holder, List<LocInfo> data, int position) {

    }

    @Override
    public LocCountViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mActivity).inflate(R.layout.item_locinfo, parent, false);

        return new LocCountViewHolder(view);
    }

    static class LocCountViewHolder extends MyBaseViewHolder{
        public LocCountViewHolder(View itemView) {
            super(itemView);
        }
    }
}
