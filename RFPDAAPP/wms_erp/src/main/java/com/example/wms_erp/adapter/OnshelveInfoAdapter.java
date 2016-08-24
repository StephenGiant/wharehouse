package com.example.wms_erp.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.wms_erp.R;
import com.example.wms_erp.model.response.OnShelveInfo;
import com.example.wms_erp.viewholder.MyBaseViewHolder;

import java.util.List;

import butterknife.Bind;

/**
 * Created by Administrator on 2016/8/23.
 */
public class OnshelveInfoAdapter extends MyBaseAdapter<OnShelveInfo, OnshelveInfoAdapter.OnshelveInfoViewHolder> {




    public OnshelveInfoAdapter(Activity activity, List<OnShelveInfo> data) {
        super(activity, data);
    }

    @Override
    protected void bindItemData(OnshelveInfoViewHolder holder, OnShelveInfo data, int position) {
        holder.goodsName.setText(data.getGOODSNAME());
        holder.batchNum.setText(data.getGOODSBATCHCODE());
        holder.goodsLocation.setText(data.getLOCATIONCODE());
        holder.goodsCode.setText(data.getGOODSCODE());
        holder.unit.setText(data.getUNITNAME());
        holder.specifation.setText(data.getGOODSSPEC());
        holder.count.setText(data.getMAXQTY()*data.getPURUNITQTY()+"");

    }

    @Override
    public int getItemCount() {
//        Toast.makeText(mActivity,super.getItemCount()+"",Toast.LENGTH_SHORT).show();
        return super.getItemCount();
    }

    @Override
    public OnshelveInfoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mActivity).inflate(R.layout.item_onshelve, parent, false);
        OnshelveInfoViewHolder viewHolder = new OnshelveInfoViewHolder(view);
        return viewHolder;
    }

    static class OnshelveInfoViewHolder extends MyBaseViewHolder {
        @Bind(R.id.goods_name)
        TextView goodsName;
        @Bind(R.id.goods_location)
        TextView goodsLocation;
        @Bind(R.id.goodsCode)
        TextView goodsCode;
        @Bind(R.id.batchNum)
        TextView batchNum;
        @Bind(R.id.unit)
        TextView unit;
        @Bind(R.id.count)
        TextView count;
        @Bind(R.id.specifation)
        TextView specifation;
        public OnshelveInfoViewHolder(View itemView) {
            super(itemView);
        }
    }
}
