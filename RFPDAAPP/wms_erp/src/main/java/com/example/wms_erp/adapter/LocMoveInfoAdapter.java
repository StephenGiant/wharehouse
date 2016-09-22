package com.example.wms_erp.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.wms_erp.R;
import com.example.wms_erp.model.response.GoodsLocInfo;
import com.example.wms_erp.viewholder.MyBaseViewHolder;

import java.util.List;

import butterknife.Bind;

/**
 * Created by Administrator on 2016/9/22.
 */

public class LocMoveInfoAdapter extends MyBaseAdapter<GoodsLocInfo, LocMoveInfoAdapter.LocMoveViewHolder> {


    public LocMoveInfoAdapter(Activity activity, List<GoodsLocInfo> data) {
        super(activity, data);
    }

    @Override
    protected void bindItemData(LocMoveViewHolder holder, GoodsLocInfo data, int position) {

    }

    @Override
    public LocMoveViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mActivity).inflate(R.layout.item_locdetail, parent, false);

        return new LocMoveViewHolder(view);
    }

    class LocMoveViewHolder extends MyBaseViewHolder {
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
        public LocMoveViewHolder(View itemView) {
            super(itemView);
        }
    }
}
