package com.example.wms_erp.presenter.impl;

import com.example.wms_erp.presenter.BasePresenter;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Administrator on 2016/8/19.
 */
public class BasePresenterImpl implements BasePresenter {
    private CompositeSubscription mCompositeSubscription;
    @Override
    public void unsubcrible() {
        if(mCompositeSubscription!=null)
            mCompositeSubscription.unsubscribe();
    }
    protected void addSubScription(Subscription s){
        if(mCompositeSubscription==null){
            mCompositeSubscription = new CompositeSubscription();
        }
        mCompositeSubscription.add(s);
    }

}
