package com.example.wms_erp.presenter.impl;

import com.example.wms_erp.adapter.OnshelveInfoAdapter;
import com.example.wms_erp.fragment.OnoffBlindFragment;
import com.example.wms_erp.model.BaseBean;
import com.example.wms_erp.model.response.OnShelveInfo;
import com.example.wms_erp.retrofit.RetrofitSingle;
import com.example.wms_erp.retrofit.ServiceApi;
import com.example.wms_erp.ui.MainActivity;
import com.example.wms_erp.util.SharePreUtil;

import java.util.ArrayList;
import java.util.Scanner;

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
    public OnOffShelvePresenterImpl(MainActivity activity, OnoffBlindFragment fragment) {
        this.activity = activity;
        this.fragment = fragment;
        serviceApi = RetrofitSingle.getInstance();
        userID = SharePreUtil.getInteger(activity, "userID", 0);
        onShelveInfos = new ArrayList<>();
    }

    /**
     * 上传上架数据
     */
    public void postOnShelve(){
        serviceApi.postOnShelve(userID,null,null).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {


            }
        });
    }

    /**
     *   获取上架信息
     */
    public void getOnShelveInfo(String barCode){
        serviceApi.getOnShelveInfo(barCode).subscribeOn(Schedulers.io())
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
                    showOnShelveInfo(onShelveInfoBaseBean.getDATA());
                }else{
                    activity.ToastCheese(onShelveInfoBaseBean.getMESSAGE());
                }

            }
        });
    }
    private void showOnShelveInfo(OnShelveInfo info){
        onShelveInfos.add(info);
        if(adapter==null) {
            adapter = new OnshelveInfoAdapter(activity, onShelveInfos);
           fragment.onshelveData.setAdapter(adapter);
        }else{
            adapter.refreshData(onShelveInfos);
        }
    }
}
