package wochu.com.rfpdaapp.presenter.impl;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;
import wochu.com.rfpdaapp.presenter.BasePresenter;

/**
 * Created by hasee on 2016/7/25.
 */
public class BaseImpl implements BasePresenter {
    private CompositeSubscription mCompositeSubscription;

    protected void addSubscription(Subscription s) {
        //因为unsubcribe后 compositeSubscription不可用了所以要再创建一次
        if (this.mCompositeSubscription == null||this.mCompositeSubscription.isUnsubscribed()) {
            this.mCompositeSubscription = new CompositeSubscription();
        }
        this.mCompositeSubscription.add(s);
    }

    @Override
    public void unsubcrible() {
        if (this.mCompositeSubscription != null) {
            this.mCompositeSubscription.unsubscribe();
        }
    }
}
