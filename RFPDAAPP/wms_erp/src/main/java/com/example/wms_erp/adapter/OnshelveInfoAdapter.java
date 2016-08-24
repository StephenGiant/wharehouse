package com.example.wms_erp.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wms_erp.R;
import com.example.wms_erp.model.BaseBean;
import com.example.wms_erp.model.response.OnShelveInfo;
import com.example.wms_erp.viewholder.MyBaseViewHolder;

import java.util.List;

/**
 * Created by Administrator on 2016/8/23.
 */
public class OnshelveInfoAdapter extends MyBaseAdapter<BaseBean<OnShelveInfo>,OnshelveInfoAdapter.OnshelveInfoViewHolder> {
    public OnshelveInfoAdapter(Activity activity, List<BaseBean<OnShelveInfo>> data) {
        super(activity, data);
    }

    @Override
    protected void bindItemData(OnshelveInfoViewHolder holder, BaseBean<OnShelveInfo> data, int position) {

    }

    @Override
    public OnshelveInfoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mActivity).inflate(R.layout.item_onshelve, parent, false);
        OnshelveInfoViewHolder viewHolder = new OnshelveInfoViewHolder(view);
        return viewHolder;
    }

    static class OnshelveInfoViewHolder extends MyBaseViewHolder{
        public OnshelveInfoViewHolder(View itemView) {
            super(itemView);
        }
    }
}
