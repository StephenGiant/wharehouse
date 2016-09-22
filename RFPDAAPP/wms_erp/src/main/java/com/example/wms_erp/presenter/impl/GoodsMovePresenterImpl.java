package com.example.wms_erp.presenter.impl;

import com.example.wms_erp.adapter.LocDetailAdapter;
import com.example.wms_erp.fragment.GoodsMoveFragment;
import com.example.wms_erp.model.BaseBean;
import com.example.wms_erp.model.response.GoodsLocInfo;
import com.example.wms_erp.retrofit.RetrofitSingle;
import com.example.wms_erp.retrofit.ServiceApi;
import com.example.wms_erp.ui.MainActivity;

import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2016/9/22.
 */

public class GoodsMovePresenterImpl extends BasePresenterImpl {
private MainActivity activity;
    private GoodsMoveFragment fragment;
    private final ServiceApi serviceApi;

    public GoodsMovePresenterImpl(MainActivity activity, GoodsMoveFragment fragment) {
        this.activity = activity;
        this.fragment = fragment;
        serviceApi = RetrofitSingle.getInstance();
    }
    public void getGoodsLocInfo(String goodsCode,String locCode){
        serviceApi.getGoodsLocInfo(goodsCode,locCode).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<BaseBean<List<GoodsLocInfo>>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(BaseBean<List<GoodsLocInfo>> listBaseBean) {
                        if(listBaseBean.getDATA()!=null){

                        }
            }
        });
    }
}
