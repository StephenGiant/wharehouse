package com.example.wms_erp.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.wms_erp.R;
import com.example.wms_erp.model.response.LocInfo;
import com.example.wms_erp.util.UnitUtils;
import com.example.wms_erp.viewholder.MyBaseViewHolder;

import java.util.List;

import butterknife.Bind;

/**
 * 库存盘点信息显示adapter
 * Created by qianpeng on 2016/9/8.
 */
public class LocCountAdapter extends MyBaseAdapter<LocInfo, LocCountAdapter.LocCountViewHolder> {



    public LocCountAdapter(Activity activity, List<LocInfo> data) {
        super(activity, data);
    }

    @Override
    protected void bindItemData(LocCountViewHolder holder, LocInfo data, int position) {
        holder.goodsCode.setText(data.getGOODSBATCHCODE());
        holder.goodsName.setText(data.getGOODSNAME());
        holder.tvQTY.setText((data.getStoreQty()+data.getBuyQty()*data.getPURUNITQTY())+"");
        holder.countBigunit.setText("大单位:" + data.getBuyQty());//获取大单位数量
        holder.countSmallunit.setText("小单位:" + data.getStoreQty());//获取小单位数量
        holder.huoweiCode.setText(data.getLOCATIONCODE());
    }

    @Override
    public LocCountViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mActivity).inflate(R.layout.item_locinfo, parent, false);

        return new LocCountViewHolder(view);
    }

     class LocCountViewHolder extends MyBaseViewHolder {
        @Bind(R.id.goodsCode)
        TextView goodsCode;
        @Bind(R.id.goodsName)
        TextView goodsName;
        @Bind(R.id.tv_QTY)
        TextView tvQTY;
        @Bind(R.id.count_bigunit)
        TextView countBigunit;
        @Bind(R.id.count_smallunit)
        TextView countSmallunit;
        @Bind(R.id.huowei_code)
        TextView huoweiCode;

        public LocCountViewHolder(final View itemView) {
            super(itemView);
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    LocCountAdapter.this.mData.remove(getLayoutPosition());
                    LocCountAdapter.this.notifyItemRemoved(getLayoutPosition());
                    return false;
                }
            });
        }
    }
}
