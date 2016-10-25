package com.example.wms_erp.adapter;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.wms_erp.R;
import com.example.wms_erp.fragment.OffshelveFragment;
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

//                                                               ijGEGDGj:.
//                                                            .:GDDEDEEDGGLGj.
//                                                            LDEKEEEDGffDGEGDG
//                                                          tjEKKGfjjjjfDDfDGDGG.
//                                                         ,GEKEt;;;,;itLDGKEGDGG
//                                                         GDKDi,,,,,;;ijLDGKEDLDL
//                                                       ,LGKGi,,,,,;;;itfDDDKEDDGj
//                                                       GDED;,,,,,,;;;itfGEGDEEKDD.
//                                                      tGEKi,::,,,,;;;;ijLDDDEKDDEG
//                                                .... .GEEj,::,,,,,,;;;itfGEDEDKDDG,
//                                             ..:,;;,,fDKEtfL;,,,,,,;;;iijGDDDKEEKDf
//                                          ..::,;ittttLEW;,;it;,,;;,;;;;itLDEEDKEEED:...
//                                          ..::,;ittttLEW;,;it;,,;;,;;;;itLDEEDKEEED:............
//                                       .:::,,;;iittttEKjjtti;,,;iji;;;;iijGEEGKEKKGjii;;;;;,,,,,.
//                                      .,,,;;iiittttttEKif;Et;,;ittfLt;;;ijGEKDEKWEDLjjjjjjjjjjjj,.
//                                      ,;iiiiiiitttttGG,,;itt:,;iii;ijj;;itLEKEEEKKKDjjjjjjjjjjjj:.
//......                               .,iiiiiiii:,:ttG.:,,,,,,,;itLii;ij;itLEKEGEKWKGtjjjjjjjjjjj:.
//tti;;,:.                             .,iiiiiii.:;,;tE.:,,::,,;;tftKjiiiiitLEKKKEEEWGtjjjjjjjjjjj:.
//fjjjjjt,.......                     ..;iiiiii..;ttiED::,,::,,;;;tifKEi;;;ifEKKEDKKKGtttjjjjjjjjj:
//jjjjjjjt;;;,,,,,::::::..............:,tttttt ::,EGjE;:,;;:,,,;,,;iiitj;;;ifEKKKKDEWEttjjjjjjjjjj:.
//jjjjjjjjjjjjttttjjtttttttiiii;;;,,,;itttttt.,,,,,KDK,,,;,;;;,;,,,,,,,,;;;iLKKKKKEGEEjtjjjjjjjjjj:.
//jjjjjjjjjjjjttttjttttjtttttttttttttttttttt ,;;,,,;WK;,;,,,tG;i;,,,,,,,;;;tDKKWWKEGEEjttjjjjjjjjj:.
//jjjjttjttttttttttttttttttttttttttttttttttt;;;;,,,,;K,,,::;;iti;,,,,,,;;;ifKKKKWWKDGDttjjjjjjjjjt:.
//jjjjjjtttjtttttttttttttttttttittttttttttttti;;;,,,,;,,ti;i;;;;;,,,,;;;;;iGKKEKEWWKDftjjtjjjjjjjt:.
//jjjjtjjttttttttttttttttttttttiiitttttttttttt;;;;,,,,;,;i;jj;,;;;;;;;;;iijDEKKKKKWKEfjjjjjjjjjjjt:.
//jjjjjjjtjjjtttttttttttttttttttitttttttttttttt;;;,,,,t,,,i;ijji;;;;;;;iitGGEDDEKKWKEGLtttttjjjjji:.
//fjjjjjjjjjjjjttttjjjttttttttttttttttttttttttGK;;,:,,t,:;iijjLD;;;;;;;itfLfEDDKEEDKKDjtttjtttjjji:.
//jfjjjjjjjjjjjjttjjjjtjjtjjtjtttttttttttttttfEKK,:::,t::;iitii;;;;;;;iitfjffDGEKDEKKEfttttttjjtji:
//jjfjffffjjjjjtttjjjjjjjjjjtttttttttjjtttttjEKEKE.::,t::,,;;;;;;;;;;iitjEjjLEDWWEKEKEGfjtjjjtjjti:.
//ffffjjjjjjjjttttjjjjjjjjjjjjtttttttjjjjjjtLGjEEK:::,t,:,,,,,;;;;iiittjGDKfLEWWKEKEDKGjjjjjjjjjji:.
//jffjjtttjjjjtiiitjjttttjjjjttiiittjjtjttjGDELED.::,;jG,;;;,,;;iiitjjfLfGWWKWWWWKKDDELLfjjjjjjjji:.
//ffjjttttttttii;ittttittttttti;;;itttttiitLDKfEL.::,;jEjiii;iitttjjfffffDW#KWWW#EKEDELLfjjjjjjjj;..
//ffjtiiiiittti;;iiiiii;iiitti;;;;;itttiiiifGDjfL:::,ifKK###LLfLLfffffjjfE##KK##WKWEDEfDjjjjjjjjj;:.
//ffjtiiiiittti;;iiiii;;;;iiti;;;;;iiii;;;;LGDfG ::,,ifKW##WLfffffffjjjjLG#WKWWWWEEEKKDEjjjjjjjjji:.
//ffjttiiiitttiiiiiii;;;;;iiii;;;;;iiii;;;itDLff.:,,,iKW###WEfjjjjjjttjtjLW#W#W#WKKEKEDGfjjjjjjjji,...
//ffjttittttttiiiitiii;;;;itiii;;;;iiii;;ijiDLf.:::,;iKEWW##KfjttttttttjjDWKWW#KEEEKWKGLLjjjjjjjji,:..
//ffjtttttttttttttttii;;;iiitiiiiiiiiiii;;;iLfi.::,,;tKWWWWWEfjttttiiitjfEEKKEKEKKWWEKDLLjjjjjjjji,::.
//ffjtttttttjtjtttttiiiiiiittttiiittiiiii;;iLf :::,,;GWK#WWWKGjttttiiitjGEtfittGWWKWWKEGfjjjjjjjji;:::
//fjjtttttttttjjttttiiiiiiiitttttttttiiiji;if;.:::,,;WKKW#WKfDjjtttiiitLEK;,,,,;iK##WWDjjjjjjjjjji;,:,
//jjjtttttttjjjttjttiiiiiiiitttttttttii;;;;if..::,,,;WKWWW#KEDLjjttiitjGE,,:,,,:,;j#WKDfjjjjjjjjjt;,,,
//jjjjtttttjjjjttjjttiiiiiittttttttttiiiiitt,.:::,,,iKKWWW#KKKGfjjtttjfD,:::,,,,,:,WWWEGtjjjjjjjjti;;;
//jjjjjjjtjjjjjttjjttttttttttttttttttiiiiijj..::,,,;jKKKWWWKWWGffjtttfE,:::,,,,,,::;WKDfjjjjjjjjjjtiii
//jjjjjjjjjjjtttttttttttttttttttittttttittii.::::,,;EEKKWKWWKKDLffjjjL;:::,,,,,,,,::KKDGjjjjjjjjjjtiii
//jjjjjjjjjjtjttttttjttttttttttiiittttiiijt :::::,,;DKEKKKWKKKDLfffffi,::,,,,,,,,,::;KEEjjjjjjjjjjtiii
//jjjjjjjjjjjttttttjtttttttttttiiittttittfi.:::::,,iDKEKKWKKWEGfffffE;:::,,,,,,,,,,::DDLjjjjjjjjjttiii
//jffjjjjjjjjjjtttjjtttttttttttitttttttttt ::::::,;iDEEKEKKEDDGfjffij,::,,,,,,,,,,,::iELjjjjjjjjjtiii;
//ffffjjjjjjjjjttjjjjjttttttttttttttttttii.:::::,,;fGDDEEKKKLLfftjji,:::,,,,,,,;;,,,::DGjjjjjjjjjttiii
//fffffffjjfjjtttjjjjjjjttttttttttttttttt .:::::,,;GKDGEEKEKfjfftftK::::,,,,,,;;;;,,,:iDjjjjjjjjjtiiii
//fffffffffjjjjttjjjjjjjtttttttttttttttti.::::::,,;GDEDDEKGGfjjjjfj,:::,,,,,,,;;;;,,,::DLjjjjjjjjti;;;
//ffLLLLfffffjtttjjjjjttttjttttiittttttt ::::::,,,;GGDDGEKGLffjjfEj::::,,,,,,;;;;;;,,,:,Ljjjjjjjjttiii
//ffLLLLLLLfjtiiitjjjjjtttttttiiiittttt;.:::::,,,,iDGEGEWEGLffjjjfi:::,,,,,,,;;;;;;;,,,:Gjjjjjjjjtii;;
//ffLGLLLGLfjti;iitjjjjttttttii;;;itjtt..:::::,,,;iDGGGEWDLfffjjjf::::,,,,,,;;;;;;;;,,,:Ejjjjjjjjti;;;
//ffffffffffji;;;itjjjttttttti;;,;ittti.::::,,,,,;jLGDfDEGDfffjjGf:::,,,,,,,;;;;;;;;;,,,:jjjjjjjjttii;
//ffjjttttjjti;;;ittjttiitttti;,,;itti.::::::,,,;;ELGLWDWDGfffjjj,:::,,,,,,;;;;;;i;;;,,,Ljjjjjjjjttiii
//fjjtiiiiitttiiiitttiiiiittti;;;;itLi.:::::,,,,;;LLLKLGLDGfjjjjf:::,,,,,,,;;;;;iii;;;,,;Gjjjjjjjttiii


//                                              哥哥的注释强大吧？？？
/**
 * Created by Administrator on 2016/8/23.
 */
public class OnshelveInfoAdapter extends MyBaseAdapter<OnShelveInfo, OnshelveInfoAdapter.OnshelveInfoViewHolder> {


private HashMap<Integer,String> countsDetail;
    private ArrayList<Integer> edits;//标记已修改的条目
private int type=0;
    public OnshelveInfoAdapter(Activity activity, List<OnShelveInfo> data,int type) {
        super(activity, data);
        countsDetail = new HashMap<>();
        edits = new ArrayList<>();
        this.type = type;
    }



    @Override
    protected void bindItemData(OnshelveInfoViewHolder holder, OnShelveInfo data, int position) {

        holder.goodsName.setText(data.getGOODSNAME());
        holder.batchNum.setText(data.getGOODSBATCHCODE());
        holder.goodsLocation.setText(data.getLOCATIONCODE());
        holder.goodsCode.setText(data.getGOODSCODE());

        holder.specifation.setText(data.getGOODSSPEC());
        holder.count.setText("0.0");
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
//            OnoffBlindFragment.removeCode(getLayoutPosition());
            switch (type){
                case 0:
                    OnoffBlindFragment.removeCode(getLayoutPosition());
                    break;
                case 1:
                    OffshelveFragment.removeCode(getLayoutPosition());
                    break;
            }
            countsDetail.clear();
            if(edits.size()>0&&edits.size()>(getLayoutPosition()-1)) {
                edits.remove(getLayoutPosition());
            }
            Log.i("codes长度",OnoffBlindFragment.codes.size()+"");
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
