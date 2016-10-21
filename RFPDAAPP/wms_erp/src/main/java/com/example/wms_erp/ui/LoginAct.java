package com.example.wms_erp.ui;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.wms_erp.R;
import com.example.wms_erp.application.AppManager;
import com.example.wms_erp.application.MyApplication;
import com.example.wms_erp.model.BaseBean;
import com.example.wms_erp.model.response.UserInfo;
import com.example.wms_erp.util.HttpUtils;
import com.example.wms_erp.util.SharePreUtil;
import com.example.wms_erp.view.ClearEditText;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.zhy.http.okhttp.https.HttpsUtils;

import java.io.IOException;
import java.io.InputStream;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;

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
    @Bind(R.id.ll_login)
    LinearLayout llLogin;
    @Bind(R.id.ll_userInfo)
    LinearLayout llUserInfo;
    @Bind(R.id.tv_userName)
    TextView tvUserName;
    private MyApplication application;
    private int userID;


    @Override
    protected void handleCode(String str) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_login);
        ButterKnife.bind(this);
        titileToolbar.setTitle("登陆界面");
        userID = getIntent().getIntExtra("userID", -1);
        titileToolbar.setBackgroundResource(R.color.colorPrimary);
        titileToolbar.setTitleTextColor(Color.parseColor("#FFFFFF"));
        setSupportActionBar(titileToolbar);
        application = (MyApplication) getApplication();
        if (userID != -1) {
            llUserInfo.setVisibility(View.VISIBLE);
        }
        String userName = SharePreUtil.getString(this, "userName", null);
        if (userName != null) {
            tvUserName.setText("用户名: " + userName);
        }

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
                if ("1".equals(userInfoBaseBean.getRESULT())) {
                    SharePreUtil.putInteger(LoginAct.this, "userID", userInfoBaseBean.getDATA().getUSERID());
                    SharePreUtil.putString(LoginAct.this, "userName", userInfoBaseBean.getDATA().getUSERNAME());
                    application.userInfo = userInfoBaseBean.getDATA();
                    finish();
                } else {
                    ToastCheese(userInfoBaseBean.getMESSAGE());
                }
            }
        });
    }

    @OnClick({R.id.btn_login, R.id.btn_quit})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                login(etUserName.getText().toString(), etPassword.getText().toString());
                break;
            case R.id.btn_quit:
                SharePreUtil.clearSP(this);
                AppManager appManager = AppManager.getAppManager();
                appManager.AppExit(this);

                break;
        }
    }

    private void practice(InputStream... certificates) {
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());

            keyStore.load(null);
            int index = 0;
            for (InputStream certificate : certificates) {
                String certificateAlias = Integer.toString(index++);
                keyStore.setCertificateEntry(certificateAlias, certificateFactory.generateCertificate(certificate));

                try {
                    if (certificate != null)
                        certificate.close();
                } catch (IOException e) {
                }

            }

            SSLContext sslContext = SSLContext.getInstance("TLS");
            TrustManagerFactory trustManagerFactory =
                    TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init(keyStore);
            sslContext.init(
                    null,
                    trustManagerFactory.getTrustManagers(),
                    new SecureRandom()
            );

        } catch (CertificateException e) {
            e.printStackTrace();
        } catch (KeyStoreException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        }

    }

    /**
     * 添加自签名证书，此证书为12306的证书
     */
    private void test2() {
        int[] certificates = {R.raw.srca};
        SSLSocketFactory sslSocketFactory = HttpUtils.getSSLSocketFactory(this, certificates);
        OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.setSocketFactory(sslSocketFactory);
    }



    }
