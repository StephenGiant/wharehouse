package com.example.wms_erp.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.wms_erp.R;
import com.example.wms_erp.model.response.LocDetail;
import com.example.wms_erp.viewholder.MyBaseViewHolder;

import java.util.List;

import butterknife.Bind;

/**
 * 货位查询adapter
 * Created by qianpeng on 2016/9/19.
 */
public class LocDetailAdapter extends MyBaseAdapter<LocDetail, LocDetailAdapter.LocDetailViewHolder> {


    public LocDetailAdapter(Activity activity, List<LocDetail> data) {
        super(activity, data);
    }

    @Override
    protected void bindItemData(LocDetailViewHolder holder, LocDetail data, int position) {
        holder.goodsName.setText(data.getINVGOODSNAME());
        holder.goodsCode.setText(data.getINVGOODSCODE());
        holder.goodsCount.setText("数量:"+data.getQTY()+data.getINVUNITNAME());
        holder.locCode.setText(data.getLOCATIONCODE());
        holder.firstDate.setText(data.getFIRSTDATE());
        holder.lastDate.setText(data.getLASTDATE());

    }

    @Override
    public LocDetailViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mActivity).inflate(R.layout.item_locdetail, parent, false);
        LocDetailViewHolder locDetailViewHolder = new LocDetailViewHolder(view);
        return locDetailViewHolder;
    }

    class LocDetailViewHolder extends MyBaseViewHolder {
        @Bind(R.id.goodsName)
        TextView goodsName;
        @Bind(R.id.goods_code)
        TextView goodsCode;
        @Bind(R.id.locCode)
        TextView locCode;
        @Bind(R.id.goods_count)
        TextView goodsCount;
        @Bind(R.id.firstDate)
        TextView firstDate;
        @Bind(R.id.lastDate)
        TextView lastDate;
        public LocDetailViewHolder(View itemView) {
            super(itemView);
        }
    }
}
