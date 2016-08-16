package wochu.com.rfpdaapp.presenter.impl;

import android.view.View;
import android.widget.Toast;

import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import wochu.com.rfpdaapp.bean.BaseBean;
import wochu.com.rfpdaapp.retrofit.RestApi;
import wochu.com.rfpdaapp.retrofit.RetrofitSingle;
import wochu.com.rfpdaapp.ui.ScanActivity;
import wochu.com.rfpdaapp.utils.ScanUtil;
import wochu.com.rfpdaapp.utils.SharePreUtil;

/**
 * Created by hasee on 2016/7/25.
 */
public class BindZboxPresenterImpl extends BaseImpl {
    ScanActivity mActivity;
    private final RestApi restApi;

    public BindZboxPresenterImpl(ScanActivity activity){
        mActivity = activity;
        restApi = RetrofitSingle.getInstance();
    }

    public void bindZbox(String uhf,String barCode){
        int userID = SharePreUtil.getIntSP(mActivity, "userID", "userinfo");
        restApi.BindZbox_RFID(userID, barCode, uhf).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<BaseBean<Boolean>>() {
                    @Override
                    public void onStart() {
mActivity.progress.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mActivity.progress.setVisibility(View.GONE);
                        Toast.makeText(mActivity,e.toString(),Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onNext(BaseBean<Boolean> booleanBaseBean) {
                        mActivity.etGoodsCode.setText("");
                        Toast.makeText(mActivity, booleanBaseBean.getMESSAGE(), Toast.LENGTH_SHORT).show();
                        mActivity.progress.setVisibility(View.GONE);
                        if(!"1".equals(booleanBaseBean.getRESULT())) {

                        }
                    }
                });
    }
}
