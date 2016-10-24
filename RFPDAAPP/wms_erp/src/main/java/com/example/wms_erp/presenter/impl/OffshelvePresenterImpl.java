package com.example.wms_erp.presenter.impl;

import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.View;

import com.bugtags.library.Bugtags;
import com.example.wms_erp.adapter.OffshelveAdapter;
import com.example.wms_erp.adapter.OnshelveInfoAdapter;
import com.example.wms_erp.fragment.OffshelveFragment;
import com.example.wms_erp.model.BaseBean;
import com.example.wms_erp.model.response.OnShelveInfo;
import com.example.wms_erp.retrofit.RetrofitSingle;
import com.example.wms_erp.retrofit.ServiceApi;
import com.example.wms_erp.ui.MainActivity;
import com.example.wms_erp.util.SharePreUtil;
import com.example.wms_erp.view.OffshelveDialog;
import com.example.wms_erp.view.RecyclerItemClickListener;

import java.util.ArrayList;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2016/10/22.
 */

public class OffshelvePresenterImpl extends BasePresenterImpl {
    OffshelveFragment fragment;
    MainActivity activity;
    private final ServiceApi serviceApi;
int userID;
    ArrayList<OnShelveInfo> onShelveInfos;
    private ArrayList<String> unEdits;
    private OffshelveDialog offDialog;
    private  String unEdit = null;
  private OnshelveInfoAdapter adapter;
    int unEditSize = 100;
    public OffshelvePresenterImpl(OffshelveFragment fragment, MainActivity activity) {
        this.fragment = fragment;
        this.activity = activity;
        serviceApi = RetrofitSingle.getInstance();
        userID = SharePreUtil.getInteger(activity, "userID", 0);
        onShelveInfos = new ArrayList<>();
        unEdits = new ArrayList<>();
        initUnEdits();
        fragment.onshelveData.addOnItemTouchListener(new RecyclerItemClickListener(activity) {
            @Override
            protected void onItemClick(View view, int position) {
                showOffshelveDialog(onShelveInfos.get(position));
            }
        });
    }

    /**
     * 获取下架信息
     * 实体类和上架信息一样
     */
    public void getOffShelveInfo(final String barCode, final String curType){
        //不需要去掉后8位
        serviceApi.getOffShelveInfo(barCode).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<BaseBean<OnShelveInfo>>() {
            @Override
            public void onStart() {
                activity.showLoadingDialog("");
            }

            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                activity.hideLoadingDialog();
                activity.ToastCheese(e.toString()+"下架");
                Bugtags.sendException(e);
                Log.i("获取下架信息有误",e.toString());
            }

            @Override
            public void onNext(BaseBean<OnShelveInfo> onShelveInfoBaseBean) {
                activity.hideLoadingDialog();

                handleInfo(barCode,onShelveInfoBaseBean,curType);
            }
        });
    }

    private void handleInfo(String barCode,BaseBean<OnShelveInfo> onShelveInfoBaseBean,String curType){
        if(onShelveInfoBaseBean.getDATA()!=null) {
//        activity.ToastCheese(onShelveInfoBaseBean.getMESSAGE());
            Log.i("下架","有数据");
            Log.i("网络数据库存",onShelveInfoBaseBean.getDATA().getINVQTY()+"");
//            onShelveInfos.clear();

            if("报损".equals(curType)) {
                onShelveInfoBaseBean.getDATA().setGOODSBATCHCODE(barCode);
                showCodeInfo(barCode,onShelveInfoBaseBean);
            }else{
                Log.i("非报损",curType);
                //商品过期不能非报损下架
                if(onShelveInfoBaseBean.getDATA().getQUALITYSTATUS()>0){
//                if(adapter!=null){
                    clearInfo();
                    activity.ToastCheese("此商品已临保或已过保!");
//                }
                }else{
                    //正常品且当前为正常品下架
                    showCodeInfo(barCode,onShelveInfoBaseBean);
                }
            }
        }else{
            activity.ToastCheese(onShelveInfoBaseBean.getMESSAGE());
        }
    }

    private void showCodeInfo(String barCode,BaseBean<OnShelveInfo> onShelveInfoBaseBean){
        if (OffshelveFragment.codes.size()>0&&OffshelveFragment.codes.contains(barCode)) {
            //如果已经扫过了 就什么都不做并提示

            Log.i("已扫描",barCode);
            Log.i("codes长度",fragment.codes.size()+"");
            if(onShelveInfos.size()>=OffshelveFragment.codes.indexOf(barCode)){
                showOffshelveDialog(onShelveInfos.get(OffshelveFragment.codes.indexOf(barCode)));
            }
//            Log.i("对象",onShelveInfos.get(OffshelveFragment.codes.indexOf(barCode)).toString());
//            activity.ToastCheese("请勿重复扫描");
        } else {
 onShelveInfos.add(onShelveInfoBaseBean.getDATA());
            fragment.codes.add(barCode);
            if(adapter==null){
                adapter = new OnshelveInfoAdapter(activity,onShelveInfos,1);
                fragment.onshelveData.setAdapter(adapter);
            }else{
                adapter.refreshData(onShelveInfos);
            }
            Log.i("对象2",onShelveInfoBaseBean.getDATA().toString());
//            Log.i("看数据",onShelveInfoBaseBean.getDATA().getMAXQTY()+"");
            unEdit = barCode;
//            OffshelveFragment.codes.add(barCode);
            showOffshelveDialog(onShelveInfoBaseBean.getDATA());
//            showOnshelveDialog(onShelveInfoBaseBean.getDATA());
        }
    }

    /**
     * 清除信息列表
     */
    public void clearInfo(){
        if(adapter!=null){
            onShelveInfos.clear();
            unEdits.clear();
            initUnEdits();
            adapter.refreshData(onShelveInfos);
            OffshelveFragment.clearCodes();
            adapter.clearCountsDetail();
        }
    }
    private void showOffshelveDialog(OnShelveInfo info){
        Log.i("看长度",onShelveInfos.size()+"");
        if(offDialog==null) {
            offDialog = OffshelveDialog.instanceDialog(info);
//            offDialog.setCancelable(false);
        }else if(!offDialog.isVisible()){
            offDialog.setInfo(info);
        }else if(offDialog.isVisible()){
            offDialog.dismiss();
            offDialog.setInfo(info);
        }
        offDialog.setOnConfirmListenner(new OffshelveDialog.OnConfirmLitsenner() {
            @Override
            public void onConfirmClick(OnShelveInfo info) {
                boolean b = adapter.setCountShow(info, offDialog.getCountDetail());
                Log.i("看数据",offDialog.getOpratorNum()+"");
                Log.i("看qty",info.getQTY()+"");

                if (b && offDialog.compair(offDialog.getOpratorNum()) ) {
                    offDialog.setQty(offDialog.getOpratorNum());

//                    unEdit = null;
                    if(unEdits.size()>=1) {
                        unEdits.remove(unEdits.size() - 1);
                    }
                    offDialog.dismiss();
                } else {
                    activity.ToastCheese("请输入正确数量");
                }

            }
        });
        FragmentManager manager = activity.getSupportFragmentManager();
        android.app.FragmentManager activityFragmentManager = activity.getFragmentManager();

            offDialog.show(activity.getFragmentManager(), "onshelve");

    }
    private boolean hasUnEdit(){
        if(unEditSize-unEdits.size()<onShelveInfos.size()){
            return true;
        }
        return false;
    }
    /**
     * 提交下架
     * @param reason
     */
    public void postOffshelve(String reason){
        if(!hasUnEdit()) {
            serviceApi.postOffShelve(userID, reason, onShelveInfos).subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<BaseBean<String>>() {
                @Override
                public void onCompleted() {

                }

                @Override
                public void onError(Throwable e) {
                    activity.ToastCheese(e.toString());
                }

                @Override
                public void onNext(BaseBean<String> response) {
                    activity.ToastCheese(response.getMESSAGE());
                    if("1".equals(response.getRESULT())) {
                        clearInfo();
                    }
                }
            });
        }else{
            activity.ToastCheese("尚有未编辑的条目！");
        }
    }

    private void initUnEdits(){
        new Thread(){
            @Override
            public void run() {
                super.run();
                int x=0;
                while (x<100){
                    unEdits.add(x+"");
                    x++;
                }
            }
        }.start();
    }
}
