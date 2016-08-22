package com.example.wms_erp.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.example.wms_erp.R;
import com.example.wms_erp.application.AppManager;
import com.example.wms_erp.model.BaseBean;
import com.example.wms_erp.model.response.UserInfo;
import com.example.wms_erp.util.SharePreUtil;
import com.example.wms_erp.view.ClearEditText;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2016/8/18.
 */
public class LoginAct extends BaseActivity {

    @Bind(R.id.titile_toolbar)
    Toolbar titileToolbar;
    @Bind(R.id.et_userName)
    ClearEditText etUserName;
    @Bind(R.id.et_password)
    ClearEditText etPassword;
    @Bind(R.id.btn_login)
    Button btnLogin;
    @Bind(R.id.btn_quit)
    Button btnQuit;


    @Override
    protected void handleCode(String str) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_login);
        ButterKnife.bind(this);
        titileToolbar.setTitle("登陆界面");
        titileToolbar.setBackgroundResource(R.color.colorPrimary);
        titileToolbar.setTitleTextColor(Color.parseColor("#FFFFFF"));
        setSupportActionBar(titileToolbar);


    }

    private void login(String userName, String password) {
        serviceApi.login(userName, password).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<BaseBean<UserInfo>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
ToastCheese(e.toString());
            }

            @Override
            public void onNext(BaseBean<UserInfo> userInfoBaseBean) {
            if("1".equals(userInfoBaseBean.getRESULT())){
                SharePreUtil.putInteger(LoginAct.this,"userID",userInfoBaseBean.getDATA().getUSERID());
                SharePreUtil.putString(LoginAct.this,"userName",userInfoBaseBean.getDATA().getUSERNAME());
                finish();
            }else{
                ToastCheese(userInfoBaseBean.getMESSAGE());
            }
            }
        });
    }

    @OnClick({R.id.btn_login, R.id.btn_quit})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                login(etUserName.getText().toString(),etPassword.getText().toString());
                break;
            case R.id.btn_quit:
                SharePreUtil.clearSP(this);
                AppManager appManager = AppManager.getAppManager();
                appManager.AppExit(this);
                break;
        }
    }
}
