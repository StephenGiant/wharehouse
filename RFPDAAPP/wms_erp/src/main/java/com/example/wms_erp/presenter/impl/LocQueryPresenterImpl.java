package com.example.wms_erp.presenter.impl;

import com.example.wms_erp.retrofit.RetrofitSingle;
import com.example.wms_erp.retrofit.ServiceApi;

/**
 * Created by Administrator on 2016/9/19.
 */
public class LocQueryPresenterImpl extends BasePresenterImpl {

    private final ServiceApi serviceApi;

    public LocQueryPresenterImpl() {
        serviceApi = RetrofitSingle.getInstance();
    }
    public void showLocDetail(){

    }
}
