package com.example.wms_erp.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.wms_erp.R;
import com.example.wms_erp.model.response.OffshelveInfo;
import com.example.wms_erp.viewholder.MyBaseViewHolder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;

/**
 * Created by Administrator on 2016/10/9.
 */

public class OffshelveOrderAdapter extends MyBaseAdapter<OffshelveInfo, OffshelveOrderAdapter.OffshelveOrderViewHolder> {



    private List<Integer> checkedPosition = new ArrayList<>();
    private Map<Integer, String> offshelveNO_map = new HashMap<Integer, String>();
    //adapter刷新，清空map的控制变量
    private boolean update = false;
    String num = "0";
    private double QTYEXCE;

    public OffshelveOrderAdapter(Activity activity, List<OffshelveInfo> data) {
        super(activity, data);
    }

    @Override
    protected void bindItemData(final OffshelveOrderViewHolder holder, final OffshelveInfo data, final int position) {
//        if (update) {
//            checkedPosition.clear();
//            offshelveNO_map.clear();
//        }
        final int pos = position;
        holder.tvInvQty.setText(data.INVQTY + "");
        holder.tvCode.setText(data.GOODSCODE);
        holder.tvGoodsName.setText(data.GOODSNAME);
        holder.tvPlanQty.setText(data.QTY + "");
        holder.tvGoodsLoc.setText(data.LOCATIONCODE);
        holder.tvUnitName.setText(data.UNITNAME);
        holder.tvInvNum.setText(data.getQTYEXCE()+"");
//        holder.tvPlanQty.setTag(new Integer(position));

//
//        if (!offshelveNO_map.isEmpty()) {
//            holder.tvPlanQty.setText(offshelveNO_map.containsKey(position) ? offshelveNO_map.get(position) : "");
//        }
//        ;
//
//        holder.tvPlanQty.addTextChangedListener(new TextWatcher() {
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
////                LogUtil.i("输入的字符", s.toString());
//
//            }
//
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//
//                Pattern pattern = Pattern.compile("\\d*\\D?\\d*");
//                Pattern pattern2 = Pattern.compile("\\d");
//                Matcher matcher2 = pattern2.matcher(s);
//                Matcher matcher = pattern.matcher(s);
//                if (matcher.matches()) {
//                    if (s.toString().length() > 1) {
//                        num = matcher.group();
////                        LogUtil.i("看看结果", num);
//                    }
//                } else {
//                    if (matcher2.matches()) {
//                        num = matcher2.group();
//                    } else {
//                        ((MainActivity) mActivity).ToastCheese("非法的数据格式！");
//                    }
//                }
//
//                if (num.toString().length() > 0) {
//
////						viewHolder.cb_comit.setChecked(true);
////                    LogUtil.i("看看索引", contentData.size()+"-"+position);
//                    if (!s.toString().equals("")) {
////                        LogUtil.i("看看此时的s", s.toString());
//                        QTYEXCE = Double.parseDouble((num.charAt(0) + "").equals(".") ? "0" : num);
//                    }
//
//                    data.QTYEXCE = QTYEXCE;
////                    LogUtil.i("下架数", contentData.get(position).QTYEXCE+"");
//                } else {
//
//                }
//
//            }
//        });
//
//        holder.tvPlanQty.setOnFocusChangeListener(new View.OnFocusChangeListener() {
//
//            @Override
//            public void onFocusChange(View v, boolean hasFocus) {
//                EditText edittext = (EditText) v;
//                String text = edittext.getText().toString();
//                if (!hasFocus) {
////                    LogUtil.i("事件", "失去焦点");
//                    if (!offshelveNO_map.containsKey((Integer) edittext.getTag())) {
//                        offshelveNO_map.put(position, text);
//                    }
////							if(text.length()>0&&Double.parseDouble(text)>0){
////								viewHolder.cb_comit.setChecked(true);
////							}
//                } else {
//                    if (offshelveNO_map.containsKey((Integer) edittext.getTag())) {
//                        offshelveNO_map.remove((Integer) edittext.getTag());
//                    }
//                }
//
//            }
//        });
//				viewHolder.cb_comit.setChecked(info.get(position).isSelected());


//        update = false;

//        holder.etActuallyNum.setText(data.getQTY()>data.getQTYEXCE()?data.getQTYEXCE()+"":data.getQTY()+"");

    }

    /**
     * 获取选中的list集合
     *
     * @return
     */
    public List<OffshelveInfo> getPudowninfo() {
        ArrayList<OffshelveInfo> comitdata = new ArrayList<OffshelveInfo>();
        for (int x = 0; x < mData.size(); x++) {
            if (checkedPosition.contains(x)) {
                if (mData.get(x).QTYEXCE > 0) {
                    comitdata.add(mData.get(x));
                }

            }
        }
        return comitdata;
    }

    @Override
    public void refreshData(List<OffshelveInfo> data) {
        super.refreshData(data);
//        checkedPosition.clear();
    }

    @Override
    public OffshelveOrderViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mActivity).inflate(R.layout.item_offshelveorder_new, parent, false);
        OffshelveOrderViewHolder offshelveViewHolder = new OffshelveOrderViewHolder(view);
        return offshelveViewHolder;
    }

    public void setCheck(int position) {
        if (!checkedPosition.contains(new Integer(position))) {
            checkedPosition.add(new Integer(position));
        }
        notifyDataSetChanged();
    }

    static class OffshelveOrderViewHolder extends MyBaseViewHolder {

        @Bind(R.id.tv_code)
        TextView tvCode;
        @Bind(R.id.tv_goodsName)
        TextView tvGoodsName;
        @Bind(R.id.tv_goodsLoc)
        TextView tvGoodsLoc;
        @Bind(R.id.tv_planQty)
        TextView tvPlanQty;
        @Bind(R.id.tv_invQty)
        TextView tvInvQty;
        @Bind(R.id.tv_unitName)
        TextView tvUnitName;
        @Bind(R.id.tv_invNum)
        TextView tvInvNum;
        public OffshelveOrderViewHolder(View itemView) {
            super(itemView);
        }
    }
}
