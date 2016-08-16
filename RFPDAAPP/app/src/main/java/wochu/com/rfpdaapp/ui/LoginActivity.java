package wochu.com.rfpdaapp.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.balysv.materialripple.MaterialRippleLayout;
import com.wang.avi.AVLoadingIndicatorView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Observable;
import rx.Subscriber;
import wochu.com.rfpdaapp.R;
import wochu.com.rfpdaapp.bean.UserInfo;
import wochu.com.rfpdaapp.presenter.impl.LoginPresenterImpl;
import wochu.com.rfpdaapp.utils.SharePreUtil;
import wochu.com.rfpdaapp.utils.ToastUtil;
import wochu.com.rfpdaapp.wiget.ClearEditText;

/**
 * Created by hasee on 2016/7/27.
 */
public class LoginActivity extends AppCompatActivity {

    @Bind(R.id.et_userName)
    ClearEditText etUserName;
    @Bind(R.id.et_password)
    ClearEditText etPassword;
    @Bind(R.id.btn_login)
    Button btnLogin;
    @Bind(R.id.progress)
    public AVLoadingIndicatorView progress;
    private LoginPresenterImpl loginPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    private void initView() {
        setContentView(R.layout.act_login);
        ButterKnife.bind(this);
        MaterialRippleLayout.on(btnLogin)
                .rippleOverlay(true)
                .rippleAlpha(0.2f)
                .rippleColor(0xFFFF2222)
                .rippleHover(true)
                .create();
        progress.setVisibility(View.GONE);
        loginPresenter = new LoginPresenterImpl(this);

    }

    @OnClick(R.id.btn_login)
    public void onClick() {
        loginPresenter.login(etUserName.getText().toString(), etPassword.getText().toString());

    }


}
