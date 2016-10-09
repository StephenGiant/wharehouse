package com.example.wms_erp.adapter;

import android.app.Activity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import com.example.wms_erp.R;
import com.example.wms_erp.model.response.OffshelveInfo;
import com.example.wms_erp.ui.MainActivity;
import com.example.wms_erp.viewholder.MyBaseViewHolder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.Bind;

/**
 * Created by Administrator on 2016/10/9.
 */

public class OffshelveOrderAdapter extends MyBaseAdapter<OffshelveInfo, OffshelveAdapter.OffshelveViewHolder> {

    private List<Integer> checkedPosition;
    private Map<Integer,String> offshelveNO_map = new HashMap<Integer,String>();
    //adapter刷新，清空map的控制变量
    private boolean update = false;
    String num = "0";
    private double QTYEXCE;
    public OffshelveOrderAdapter(Activity activity, List<OffshelveInfo> data) {
        super(activity, data);
    }

    @Override
    protected void bindItemData(final OffshelveAdapter.OffshelveViewHolder holder, final OffshelveInfo data, final int position) {
        if(update){
            checkedPosition.clear();
            offshelveNO_map.clear();
        }
        final int pos = position;
        holder.tvKucunNum.setText(data.INVQTY+"");
        holder.tvGoodscode.setText(data.GOODSCODE);
        holder.tvGoodsname.setText(data.GOODSNAME);
        holder.tvPlanNum.setText(data.QTY+"");
        holder.tvHuowei.setText(data.LOCATIONCODE);
        holder.tvUnitName.setText(data.UNITNAME);
        holder.etActuallyNum.setTag(new Integer(position));

        if(!offshelveNO_map.isEmpty()){
            holder.etActuallyNum.setText(offshelveNO_map.containsKey(position)?offshelveNO_map.get(position):"");
        }
        ;

        holder.etActuallyNum.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                LogUtil.i("输入的字符", s.toString());

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {


            }

            @Override
            public void afterTextChanged(Editable s) {

                Pattern pattern = Pattern.compile("\\d*\\D?\\d*");
                Pattern pattern2 = Pattern.compile("\\d");
                Matcher matcher2 = pattern2.matcher(s);
                Matcher matcher = pattern.matcher(s);
                if(matcher.matches()){
                    if(s.toString().length()>1){
                        num = matcher.group();
//                        LogUtil.i("看看结果", num);
                    }
                }else{
                    if(matcher2.matches()){
                        num = matcher2.group();
                    }else{
                        ( (MainActivity) mActivity).ToastCheese( "非法的数据格式！");
                    }
                }

                if(num.toString().length()>0){

//						viewHolder.cb_comit.setChecked(true);
//                    LogUtil.i("看看索引", contentData.size()+"-"+position);
                    if(!s.toString().equals("")){
//                        LogUtil.i("看看此时的s", s.toString());
                        QTYEXCE = Double.parseDouble((num.charAt(0)+"").equals(".")?"0":num);
                    }

                    data.QTYEXCE = QTYEXCE;
//                    LogUtil.i("下架数", contentData.get(position).QTYEXCE+"");
                }else{

                }

            }
        });
        holder.etActuallyNum.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                EditText edittext = (EditText)v;
                String text = edittext.getText().toString();
                if(!hasFocus){
//                    LogUtil.i("事件", "失去焦点");
                    if(!offshelveNO_map.containsKey((Integer)edittext.getTag())){
                        offshelveNO_map.put(position, text);
                    }
//							if(text.length()>0&&Double.parseDouble(text)>0){
//								viewHolder.cb_comit.setChecked(true);
//							}
                }else{
                    if(offshelveNO_map.containsKey((Integer)edittext.getTag())){
                        offshelveNO_map.remove((Integer)edittext.getTag());
                    }
                }

            }
        });
//				viewHolder.cb_comit.setChecked(info.get(position).isSelected());

        holder.cbComit.setTag(new Integer(position));

        if(checkedPosition!=null){
            holder.cbComit.setChecked(checkedPosition.contains(new Integer(position))?true:false);
        }else{
            holder.cbComit.setChecked(false);
        }

        holder.cbComit.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                OffshelveInfo putdownInfo = data;

                if(isChecked){
                    holder.etActuallyNum.clearFocus();
                    if(!checkedPosition.contains(buttonView.getTag())){
                        checkedPosition.add(new Integer(position));
//					ArrayList<PutdownInfo> temp = new ArrayList<PutdownInfo>();
//					for(int x=0;x<contentData.size();x++){
//						if(x>=position&&x<(contentData.size()-1)){
//							//往前移一个位置
//							temp.add(contentData.get(x+1));
////							contentData.get(x) =
//						}else if(x<position){
//							temp.add(contentData.get(x));
//						}else if(x==(contentData.size()-1)){
//							temp.add(contentData.get(position));
//						}
//					}
////					MyPutDownAdapter.this.notifyItemMoved(position, contentData.size()-1);
////				rv_info.scrollToPosition(0);
//					contentData.clear();
//					contentData.addAll(temp);
//					MyPutDownAdapter.this.notifyItemMoved(position, contentData.size()-1);

                    }
                }else{
                    if(checkedPosition.contains(buttonView.getTag())){
                        checkedPosition.remove(new Integer(position));
                    }
                }

            }
        });

        update = false;

    }
    /**
     * 获取选中的list集合
     * @return
     */
    public List<OffshelveInfo> getPudowninfo() {
        ArrayList<OffshelveInfo> comitdata = new ArrayList<OffshelveInfo>();
        for(int x=0;x<mData.size();x++){
            if(checkedPosition.contains(x)){
                if(mData.get(x).QTYEXCE>0){
                    comitdata.add(mData.get(x));
                }

            }
        }
        return comitdata;
    }

    @Override
    public OffshelveAdapter.OffshelveViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mActivity).inflate(R.layout.item_putdown_info, parent, false);
        OffshelveAdapter.OffshelveViewHolder offshelveViewHolder = new OffshelveAdapter.OffshelveViewHolder(view);
        return offshelveViewHolder;
    }

    static class OffshelveOrderViewHolder extends MyBaseViewHolder {
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
        public OffshelveOrderViewHolder(View itemView) {
            super(itemView);
        }
    }
}
