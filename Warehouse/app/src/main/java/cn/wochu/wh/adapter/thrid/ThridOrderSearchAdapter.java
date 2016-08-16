package cn.wochu.wh.adapter.thrid;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import cn.wochu.wh.R;
import cn.wochu.wh.entity.search.DCJDORDERDETAILItem;
import cn.wochu.wh.entity.search.ThridOrderSearchEntity;

/**
 * project name：Warehouse
 * class describe：
 * create person：dayongxin
 * create time：16/6/21 下午4:27
 * alter person：dayongxin
 * alter time：16/6/21 下午4:27
 * alter remark：
 */
public class ThridOrderSearchAdapter extends RecyclerView.Adapter<ThridOrderSearchAdapter.ThridOrderSearchAdapterVH> {
    private Context mContext;
    private List<ThridOrderSearchEntity.DCJDORDERDETAILItemBean> mList;
    private LayoutInflater mLayoutInflater;

    public ThridOrderSearchAdapter(Context mContext, List<ThridOrderSearchEntity.DCJDORDERDETAILItemBean> mList) {
        this.mContext = mContext;
        this.mList = mList;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public ThridOrderSearchAdapterVH onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ThridOrderSearchAdapterVH(mLayoutInflater.inflate(R.layout.rv_item_thrid_order_search_layout, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(ThridOrderSearchAdapterVH holder, int i) {
        holder.mTv_goods_code.setText(mList.get(i).getGOODSCODE() + "");
        holder.mTv_goods_name.setText(mList.get(i).getGOODSNAME() + "");
        holder.mTv_goods_num.setText(mList.get(i).getGOODSNUMBER() + "");
        holder.mTv_location_code.setText(mList.get(i).getLOCATIONCODE()+"");
//        if(mList.get(i).getLOCATIONCODE()!=null) {
//            Toast.makeText(mContext, mList.get(i).getLOCATIONCODE(), Toast.LENGTH_SHORT).show();
//        }
    }

    @Override
    public int getItemCount() {
        if(mList!=null){
            return mList.size();
        }
        return 0;
    }

    public static class ThridOrderSearchAdapterVH extends RecyclerView.ViewHolder {
        TextView mTv_goods_code;
        TextView mTv_goods_name;
        TextView mTv_goods_num;
        TextView mTv_location_code;

        public ThridOrderSearchAdapterVH(View itemView) {



            
            super(itemView);

            mTv_goods_code = (TextView) itemView.findViewById(R.id.tv_goods_code);
            mTv_goods_name = (TextView) itemView.findViewById(R.id.tv_goods_name);
            mTv_goods_num = (TextView) itemView.findViewById(R.id.tv_goods_num);
            mTv_location_code = (TextView)itemView.findViewById(R.id.tv_locationCode);
        }
    }
}
