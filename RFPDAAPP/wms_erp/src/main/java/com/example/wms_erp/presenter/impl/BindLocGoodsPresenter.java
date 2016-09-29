package com.example.wms_erp.presenter.impl;

import com.example.wms_erp.fragment.BindLocGoodsFragment;
import com.example.wms_erp.model.BaseBean;
import com.example.wms_erp.retrofit.RetrofitSingle;
import com.example.wms_erp.retrofit.ServiceApi;
import com.example.wms_erp.ui.MainActivity;
import com.example.wms_erp.util.SharePreUtil;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2016/9/27.
 */

public class BindLocGoodsPresenter extends BasePresenterImpl {

    private final ServiceApi serviceApi;
    private final int userID;
    MainActivity activity;
    BindLocGoodsFragment fragment;
    public BindLocGoodsPresenter(MainActivity activity, BindLocGoodsFragment fragment) {
this.activity = activity;
        this.fragment = fragment;
        serviceApi = RetrofitSingle.getInstance();
        userID = SharePreUtil.getInteger(activity, "userID", 0);
    }

    public void postBindLocGoods(String goodsCode,String locCode){
        serviceApi.postBindLocGoods(userID,locCode,goodsCode,1).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(
                new Subscriber<BaseBean<String>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        activity.ToastCheese(e.toString());

                    }

                    @Override
                    public void onNext(BaseBean<String> stringBaseBean) {
                        //提交数据
                        activity.ToastCheese(stringBaseBean.getMESSAGE());

                    }
                }
        );
    }
}
