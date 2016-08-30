package com.example.wms_erp.adapter;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.wms_erp.R;
import com.example.wms_erp.fragment.OnoffBlindFragment;
import com.example.wms_erp.model.response.OnShelveInfo;
import com.example.wms_erp.view.MaterialDialog;
import com.example.wms_erp.view.OnshelveDialog;
import com.example.wms_erp.viewholder.MyBaseViewHolder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;

/**
 * Created by Administrator on 2016/8/23.
 */
public class OnshelveInfoAdapter extends MyBaseAdapter<OnShelveInfo, OnshelveInfoAdapter.OnshelveInfoViewHolder> {


private HashMap<Integer,String> countsDetail;
    private ArrayList<Integer> edits;//标记已修改的条目

    public OnshelveInfoAdapter(Activity activity, List<OnShelveInfo> data) {
        super(activity, data);
        countsDetail = new HashMap<>();
        edits = new ArrayList<>();
    }



    @Override
    protected void bindItemData(OnshelveInfoViewHolder holder, OnShelveInfo data, int position) {
        holder.goodsName.setText(data.getGOODSNAME());
        holder.batchNum.setText(data.getGOODSBATCHCODE());
        holder.goodsLocation.setText(data.getLOCATIONCODE());
        holder.goodsCode.setText(data.getGOODSCODE());

        holder.specifation.setText(data.getGOODSSPEC());
            if(edits.contains(position)){
                if(countsDetail.size()>0) {
                    holder.count.setText(countsDetail.get(position));

                }
            }

    }

    public boolean setCountShow(OnShelveInfo info,String countDetail){
        if(countDetail!=null) {
            Log.i("索引", mData.indexOf(info) + "");
            if (!edits.contains(mData.indexOf(info))) {
                edits.add(mData.indexOf(info));
            }
            countsDetail.put(mData.indexOf(info), countDetail);
            Log.i("改数据", countsDetail.get(mData.indexOf(info)));
            notifyDataSetChanged();
            return true;
        }else {
            return false;
        }
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

     class OnshelveInfoViewHolder extends MyBaseViewHolder implements View.OnLongClickListener{
        @Bind(R.id.goods_name)
        TextView goodsName;
        @Bind(R.id.goods_location)
        TextView goodsLocation;
        @Bind(R.id.goodsCode)
        TextView goodsCode;
        @Bind(R.id.batchNum)
        TextView batchNum;

        @Bind(R.id.count)
        TextView count;
        @Bind(R.id.specifation)
        TextView specifation;
        public OnshelveInfoViewHolder(View itemView) {
            super(itemView);
            itemView.setOnLongClickListener(this);
        }

        @Override
        public boolean onLongClick(View v) {
            removeUItem(getLayoutPosition());
            OnoffBlindFragment.removeCode(getLayoutPosition());
            return false;
        }
    }

    @Override
    public void addItem(OnShelveInfo item) {

        super.addItem(item);
    }
    public void clearCountsDetail(){
        countsDetail.clear();
    }
}
