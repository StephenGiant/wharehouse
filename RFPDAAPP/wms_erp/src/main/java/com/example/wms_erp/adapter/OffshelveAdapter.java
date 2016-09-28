package com.example.wms_erp.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.example.wms_erp.R;
import com.example.wms_erp.model.response.OffshelveInfo;
import com.example.wms_erp.viewholder.MyBaseViewHolder;

import java.util.List;

import butterknife.Bind;

/**
 * 下架指令adapter
 * Created by qianpeng on 2016/9/28.
 */

public class OffshelveAdapter extends MyBaseAdapter<OffshelveInfo, OffshelveAdapter.OffshelveViewHolder> {

    public OffshelveAdapter(Activity activity, List<OffshelveInfo> data) {
        super(activity, data);
    }

    @Override
    protected void bindItemData(OffshelveViewHolder holder, OffshelveInfo data, int position) {

    }

    @Override
    public OffshelveViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater.from(mActivity).inflate(R.layout.item_putdown_info, parent, false);
        return null;
    }

    static class OffshelveViewHolder extends MyBaseViewHolder {
        @Bind(R.id.tv_goodscode)
        TextView tvGoodscode;
        @Bind(R.id.tv_goodsname)
        TextView tvGoodsname;
        @Bind(R.id.tv_huowei)
        TextView tvHuowei;
        @Bind(R.id.tv_kucunNum)
        TextView tvKucunNum;
        @Bind(R.id.tv_planNum)
        TextView tvPlanNum;
        @Bind(R.id.et_actuallyNum)
        EditText etActuallyNum;
        @Bind(R.id.tv_unitName)
        TextView tvUnitName;
        @Bind(R.id.cb_comit)
        CheckBox cbComit;

        public OffshelveViewHolder(View itemView) {
            super(itemView);
        }
    }
}
