package com.example.wms_erp.presenter.impl;

import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.View;

import com.example.wms_erp.adapter.OnshelveInfoAdapter;
import com.example.wms_erp.fragment.OffshelveFragment;
import com.example.wms_erp.fragment.OnoffBlindFragment;
import com.example.wms_erp.model.BaseBean;
import com.example.wms_erp.model.response.OnShelveInfo;
import com.example.wms_erp.retrofit.RetrofitSingle;
import com.example.wms_erp.retrofit.ServiceApi;
import com.example.wms_erp.ui.MainActivity;
import com.example.wms_erp.util.SharePreUtil;
import com.example.wms_erp.view.OffshelveDialog;
import com.example.wms_erp.view.OnshelveDialog;
import com.example.wms_erp.view.RecyclerItemClickListener;

import java.util.ArrayList;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2016/8/19.
 */
public class OnOffShelvePresenterImpl extends BasePresenterImpl {
    private MainActivity activity;
    private final ServiceApi serviceApi;
    private final int userID;
    private final ArrayList<OnShelveInfo> onShelveInfos;
    private OnshelveInfoAdapter adapter;
private OnoffBlindFragment fragment;
private OffshelveFragment offshelveFragment;
    private OnshelveDialog dialog;
    private OffshelveDialog offDialog;
    private  String unEdit = null;
    private ArrayList<String> unEdits;
int unEditSize = 1000;
    public OnOffShelvePresenterImpl(final MainActivity activity, OnoffBlindFragment fragment) {
        this.activity = activity;
        this.fragment = fragment;
        serviceApi = RetrofitSingle.getInstance();
        userID = SharePreUtil.getInteger(activity, "userID", 0);
        onShelveInfos = new ArrayList<>();
        unEdits = new ArrayList<>();

        new Thread(){
            @Override
            public void run() {
                super.run();
                int x=0;
                while (x<1000){
                    unEdits.add(x+"");
                    x++;
                }
            }
        }.start();



        fragment.onshelveData.addOnItemTouchListener(new RecyclerItemClickListener(activity) {
            @Override
            protected void onItemClick(View view, int position) {
                    showOnshelveDialog(onShelveInfos.get(position));

            }
        });

    }

    public OnOffShelvePresenterImpl(MainActivity activity, OffshelveFragment fragment){
        serviceApi = RetrofitSingle.getInstance();
        userID = SharePreUtil.getInteger(activity, "userID", 0);
        onShelveInfos = new ArrayList<>();
        offshelveFragment = fragment;
    }



    /**
     *   获取上架信息
     */
    public void getOnShelveInfo(final String barCode){
        String code = barCode;
        serviceApi.getOnShelveInfo(code.substring(0,code.length()-8)).subscribeOn(Schedulers.io())
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
                activity.ToastCheese(e.toString()+"上架");
                activity.hideLoadingDialog();
            }

            @Override
            public void onNext(BaseBean<OnShelveInfo> onShelveInfoBaseBean) {
                activity.hideLoadingDialog();
//                activity.ToastCheese(onShelveInfoBaseBean.getDATA().toString());
                if(onShelveInfoBaseBean.getDATA()!=null) {
                    onShelveInfoBaseBean.getDATA().setGOODSBATCHCODE(barCode);
                    if(OnoffBlindFragment.codes.size()>0&&OnoffBlindFragment.codes.contains(barCode)){
                        //如果已经扫过了 就什么都不做并提示
                        showOnshelveDialog(onShelveInfos.get(OnoffBlindFragment.codes.indexOf(barCode)));
//                        activity.ToastCheese("请勿重复扫描");
                    }else {
                       unEdit=barCode;
                        OnoffBlindFragment.codes.add(barCode);
                        showOnShelveInfo(onShelveInfoBaseBean.getDATA());
                        showOnshelveDialog(onShelveInfoBaseBean.getDATA());
                    }
                }else{
                    activity.ToastCheese(onShelveInfoBaseBean.getMESSAGE());
                }

            }
        });
    }
    private void showOnShelveInfo(OnShelveInfo info){
        Log.i("看数据",info.getMAXQTY()+"");
        onShelveInfos.add(info);
        Log.i("数据个数3",onShelveInfos.size()+"");
        if(adapter==null) {
            adapter = new OnshelveInfoAdapter(activity, onShelveInfos);
            Log.i("数据个数1",onShelveInfos.size()+"");
           fragment.onshelveData.setAdapter(adapter);
        }else{
            Log.i("数据个数2",onShelveInfos.size()+"");

//                adapter.refreshData(onShelveInfos);
            Log.i("看bug",onShelveInfos.get(0).getMAXQTY()+"");
adapter.notifyDataSetChanged();

        }
    }
    public boolean isShowing(){
        return adapter!=null&&adapter.getItemCount()>0;
    }

    private void showOnshelveDialog(OnShelveInfo info){
        if(dialog==null) {
            dialog = OnshelveDialog.instanceDialog(info);
        }else{
            dialog.setInfo(info);
        }
            dialog.setOnConfirmListenner(new OnshelveDialog.OnConfirmLitsenner() {
                @Override
                public void onConfirmClick(OnShelveInfo info) {
                    boolean b = adapter.setCountShow(info, dialog.getCountDetail());
                    if(b) {


//                    unEdit = null;
            unEdits.remove(unEdits.size()-1);
                        dialog.dismiss();
                    }else{
                        activity.ToastCheese("请输入数量");
                    }
                }
            });
        FragmentManager manager = activity.getSupportFragmentManager();
        android.app.FragmentManager activityFragmentManager = activity.getFragmentManager();
        dialog.show(activity.getFragmentManager(),"onshelve");
    }


    /**
     * 提交上架信息
     * @param reason
     */
    public void postOnshelve(final String reason){
//        for(OnShelveInfo info:onShelveInfos ){
//            info.setCELLNO(reason);
//        }
        if(!hasUnEdit()) {
            serviceApi.postOnShelve(userID, reason, onShelveInfos).subscribeOn(Schedulers.io())
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
                        onShelveInfos.clear();
                        adapter.refreshData(onShelveInfos);
                        adapter.clearCountsDetail();
                        unEditSize = unEdits.size();
//                fragment.codes.clear();
                        OnoffBlindFragment.clearCodes();
                    }
                }
            });
        }else{
            activity.ToastCheese("尚有未编辑的条目！");
        }
    }

    private boolean hasUnEdit(){
        if(unEditSize-unEdits.size()<onShelveInfos.size()){
            return true;
        }
        return false;
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
                Log.i("获取下架信息有误",e.toString());
            }

            @Override
            public void onNext(BaseBean<OnShelveInfo> onShelveInfoBaseBean) {
                activity.hideLoadingDialog();

                handleInfo(barCode,onShelveInfoBaseBean,curType);
            }
        });
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

private void handleInfo(String barCode,BaseBean<OnShelveInfo> onShelveInfoBaseBean,String curType){
    if(onShelveInfoBaseBean.getDATA()!=null) {
//        activity.ToastCheese(onShelveInfoBaseBean.getMESSAGE());
        Log.i("下架","有数据");
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
        if (OnoffBlindFragment.codes.size()>0&&OnoffBlindFragment.codes.contains(barCode)) {
            //如果已经扫过了 就什么都不做并提示
            Log.i("已扫描",barCode);
            showOnshelveDialog(onShelveInfos.get(OnoffBlindFragment.codes.indexOf(barCode)));
            Log.i("对象",onShelveInfos.get(OnoffBlindFragment.codes.indexOf(barCode)).toString());
//            activity.ToastCheese("请勿重复扫描");
        } else {
//
            Log.i("对象2",onShelveInfoBaseBean.getDATA().toString());
//            Log.i("看数据",onShelveInfoBaseBean.getDATA().getMAXQTY()+"");
            unEdit = barCode;
            OnoffBlindFragment.codes.add(barCode);
            showOffshelveDialog(onShelveInfoBaseBean.getDATA());
            showOnshelveDialog(onShelveInfoBaseBean.getDATA());
        }
    }

    /**
     * 清除信息列表
     */
    public void clearInfo(){
        if(adapter!=null){
            onShelveInfos.clear();
//            unEdits.clear();
            adapter.refreshData(onShelveInfos);
            OnoffBlindFragment.clearCodes();
            adapter.clearCountsDetail();
        }
    }
private void showOffshelveDialog(OnShelveInfo info){
    if(offDialog==null) {
        offDialog = OffshelveDialog.instanceDialog(info);
    }else{
        offDialog.setInfo(info);
    }
    offDialog.setOnConfirmListenner(new OffshelveDialog.OnConfirmLitsenner() {
        @Override
        public void onConfirmClick(OnShelveInfo info) {
            boolean b = adapter.setCountShow(info, offDialog.getCountDetail());


               if (b && offDialog.compair(offDialog.getOpratorNum()) ) {
                   offDialog.setQty(offDialog.getOpratorNum());

//                    unEdit = null;
                   unEdits.remove(unEdits.size() - 1);
                   dialog.dismiss();
               } else {
                   activity.ToastCheese("请输入正确数量");
               }

        }
    });
    FragmentManager manager = activity.getSupportFragmentManager();
    android.app.FragmentManager activityFragmentManager = activity.getFragmentManager();
    dialog.show(activity.getFragmentManager(),"onshelve");
}

}
