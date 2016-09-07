package com.example.wms_erp.event;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Administrator on 2016/9/7.
 */
public class RxManager {
    //统一取消、订阅事件
    private CompositeSubscription compositeSubscription = new CompositeSubscription();

    public void add(Subscription s) {
        compositeSubscription.add(s);
    }

    public void clear() {
        compositeSubscription.unsubscribe();
    }
}
