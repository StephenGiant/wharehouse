package com.example.wms_erp.presenter.impl;

import android.widget.ArrayAdapter;

import com.example.wms_erp.fragment.OffshelveOrderFragment;
import com.example.wms_erp.model.BaseBean;
import com.example.wms_erp.model.response.Kuwei;
import com.example.wms_erp.retrofit.RetrofitSingle;
import com.example.wms_erp.retrofit.ServiceApi;
import com.example.wms_erp.ui.MainActivity;
import com.example.wms_erp.util.SharePreUtil;

import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2016/9/29.
 */

public class OffshelveOrderPresenterImpl extends BasePresenterImpl {
    MainActivity activity; OffshelveOrderFragment fragment;
    private ServiceApi serviceApi;

    public OffshelveOrderPresenterImpl(MainActivity activity, OffshelveOrderFragment fragment) {
        this.activity = activity;this.fragment = fragment;
        initData();
    }
    private void initData(){
        serviceApi = RetrofitSingle.getInstance();
        serviceApi.getKuwei(SharePreUtil.getInteger(activity,"userID",0)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Subscriber<BaseBean<List<Kuwei>>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(BaseBean<List<Kuwei>> listBaseBean) {
                activity.ToastCheese(listBaseBean.getMESSAGE());
                if(listBaseBean.getDATA()!=null){
                    //填充spinner
                    String[] kuweis= new String[listBaseBean.getDATA().size()];
                    for(int x=0;x<listBaseBean.getDATA().size();x++){
                        kuweis[x] = listBaseBean.getDATA().get(x).getCELLNO();
                    }
                    ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(activity, android.R.layout.simple_spinner_item, kuweis);
                    fragment.spKuwei.setAdapter(stringArrayAdapter);
                }
            }
        });
    }
}
