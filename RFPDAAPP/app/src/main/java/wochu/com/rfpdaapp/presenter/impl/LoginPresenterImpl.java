package wochu.com.rfpdaapp.presenter.impl;

import android.content.Intent;
import android.view.View;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import wochu.com.rfpdaapp.bean.UserInfo;
import wochu.com.rfpdaapp.retrofit.RestApi;
import wochu.com.rfpdaapp.retrofit.RetrofitSingle;
import wochu.com.rfpdaapp.ui.LoginActivity;
import wochu.com.rfpdaapp.ui.ScanActivity;
import wochu.com.rfpdaapp.utils.SharePreUtil;
import wochu.com.rfpdaapp.utils.ToastUtil;

/**
 * 处理登陆的业务逻辑类
 * Created by qianpeng on 2016/7/27.
 */
public class LoginPresenterImpl extends BaseImpl {
    private LoginActivity mActivity;
    private final RestApi restApi;

    public LoginPresenterImpl(LoginActivity activity) {
        mActivity = activity;
        restApi = RetrofitSingle.getInstance();
    }

    /**
     * 登陆方法
     */
    public void login(final String userName, String password){
      restApi.login(userName, password).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
      .subscribe(new Subscriber<UserInfo>() {
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
            ToastUtil.makeText(mActivity,e.toString()).show();
          }

          @Override
          public void onNext(UserInfo userInfo) {
              mActivity.progress.setVisibility(View.GONE);
              ToastUtil.makeText(mActivity,userInfo.MESSAGE).show();
                if("1".equals(userInfo.RESULT)){
                    SharePreUtil.addIntSP(mActivity,"userID",userInfo.DATA.USERID,"userinfo");
                    toMain();

                }
          }
      });

    }
    private void toMain(){
        Intent intent = new Intent(mActivity, ScanActivity.class);
//        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        mActivity.startActivity(intent);
        mActivity.finish();
    }
}
