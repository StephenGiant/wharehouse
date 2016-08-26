package com.example.wms_erp.presenter.impl;

import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.View;

import com.example.wms_erp.adapter.OnshelveInfoAdapter;
import com.example.wms_erp.fragment.OnoffBlindFragment;
import com.example.wms_erp.model.BaseBean;
import com.example.wms_erp.model.response.OnShelveInfo;
import com.example.wms_erp.retrofit.RetrofitSingle;
import com.example.wms_erp.retrofit.ServiceApi;
import com.example.wms_erp.ui.MainActivity;
import com.example.wms_erp.util.SharePreUtil;
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

    private OnshelveDialog dialog;

    public OnOffShelvePresenterImpl(final MainActivity activity, OnoffBlindFragment fragment) {
        this.activity = activity;
        this.fragment = fragment;
        serviceApi = RetrofitSingle.getInstance();
        userID = SharePreUtil.getInteger(activity, "userID", 0);
        onShelveInfos = new ArrayList<>();

        fragment.onshelveData.addOnItemTouchListener(new RecyclerItemClickListener(activity) {
            @Override
            protected void onItemClick(View view, int position) {


            }
        });

    }



    /**
     *   获取上架信息
     */
    public void getOnShelveInfo(final String barCode){
        String code = barCode;
        serviceApi.getOnShelveInfo(code.substring(0,code.length()-8)).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<BaseBean<OnShelveInfo>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                activity.ToastCheese(e.toString());

            }

            @Override
            public void onNext(BaseBean<OnShelveInfo> onShelveInfoBaseBean) {
//                activity.ToastCheese(onShelveInfoBaseBean.getDATA().toString());
                if(onShelveInfoBaseBean.getDATA()!=null) {
                    onShelveInfoBaseBean.getDATA().setGOODSBATCHCODE(barCode);
                    if(fragment.codes.contains(barCode)){
                        //如果已经扫过了 就什么都不做并提示
                        showOnshelveDialog(onShelveInfoBaseBean.getDATA());
//                        activity.ToastCheese("请勿重复扫描");
                    }else {
                        fragment.codes.add(barCode);
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

        onShelveInfos.add(info);
        Log.i("数据个数3",onShelveInfos.size()+"");
        if(adapter==null) {
            adapter = new OnshelveInfoAdapter(activity, onShelveInfos);
            Log.i("数据个数1",onShelveInfos.size()+"");
           fragment.onshelveData.setAdapter(adapter);
        }else{
            Log.i("数据个数2",onShelveInfos.size()+"");

                adapter.refreshData(onShelveInfos);


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
                   adapter.setCountShow(info,dialog.getCountDetail());
                }
            });
        FragmentManager manager = activity.getSupportFragmentManager();
        android.app.FragmentManager activityFragmentManager = activity.getFragmentManager();
        dialog.show(activity.getFragmentManager(),"onshelve");
    }


    public void postOnshelve(final String reason){
//        for(OnShelveInfo info:onShelveInfos ){
//            info.setCELLNO(reason);
//        }
        serviceApi.postOnShelve(userID,reason,onShelveInfos).subscribeOn(Schedulers.io())
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
            }
        });
    }
}
