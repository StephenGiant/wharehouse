package cn.wochu.wh.ui;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.apkfuns.logutils.LogUtils;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.ResponseBody;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.wochu.wh.R;
import cn.wochu.wh.base.BaseActivity;
import cn.wochu.wh.constant.Constants;
import cn.wochu.wh.entity.AccountLogOnEntity;
import cn.wochu.wh.entity.BaseEntity;
import cn.wochu.wh.net.ApiClient;
import cn.wochu.wh.net.OkHttpClientManager;
import cn.wochu.wh.retrofit.DPSRetrofit;
import cn.wochu.wh.retrofit.Rest_API;
import cn.wochu.wh.retrofit.RetrofitSingle;
import cn.wochu.wh.utils.SharePreUtil;
import cn.wochu.wh.utils.VersionUtils;
import pl.droidsonroids.gif.GifImageView;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * project name：Warehouse
 * class describe：
 * create person：dayongxin
 * create time：16/6/12 下午4:57
 * alter person：dayongxin
 * alter time：16/6/12 下午4:57
 * alter remark：
 */
public class LoginAct extends BaseActivity {

    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.tv_control)
    TextView tvControl;
    @Bind(R.id.et_username)
    EditText etUsername;
    @Bind(R.id.et_password)
    EditText etPassword;
    @Bind(R.id.but_login)
    Button butLogin;
    @Bind(R.id.tv_version)
    TextView tvVersion;
    @Bind(R.id.tv_copyright)
    TextView tvCopyright;
    @Bind(R.id.tv_wochu)
    TextView tvWochu;
    @Bind(R.id.progress)
    GifImageView progress;
    private Rest_API restApi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_login_login_layout);
        ButterKnife.bind(this);
        initView();
//        test();
        restApi = RetrofitSingle.getInstance();
        try {
            isLatest();
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void initView() {
        ivBack.setVisibility(View.INVISIBLE);
        tvControl.setVisibility(View.INVISIBLE);
        tvTitle.setText(getString(R.string.tv_title_login));
        tvVersion.setText("当前版本: " + VersionUtils.getVersionName(this));
    }

    @Override
    protected void handleCode(String str) {
        ToastCheese(str);
    }


    @OnClick({R.id.iv_back, R.id.tv_control, R.id.but_login})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.but_login:
                if (baseHasNet()) {
                    handleUserLogin();
                }
                break;
        }
    }

    private void handleUserLogin() {
        String userName = etUsername.getText().toString().trim();
        String password = etPassword.getText().toString().trim();
        if (!TextUtils.isEmpty(userName) && !TextUtils.isEmpty(password)) {
            OkHttpClientManager.getAsyn(ApiClient.getAccountLogOn(userName, password), new OkHttpClientManager.ResultCallback<BaseEntity<AccountLogOnEntity>>() {
                @Override
                public void onBefore(Request request) {
                    super.onBefore(request);
//                    showLoadingDialog(getString(R.string.toast_data_loading));
                    progress.setVisibility(View.VISIBLE);
                }

                @Override
                public void onError(Request request, Exception e) {
                    progress.setVisibility(View.GONE);
                }

                @Override
                public void onResponse(BaseEntity<AccountLogOnEntity> response) {
                    progress.setVisibility(View.GONE);
                    if (response.getRESULT() != null && response.getDATA() != null) {
                        if (response.getRESULT().equals("1")) {
                            if (response.getDATA().getWAREHOUSECODE() != null) {
                                ToastCheese(getString(R.string.toast_login_success));
                                SharePreUtil.putInteger(LoginAct.this, Constants.SP_ACCOUNT_LOGON_USERID, response.getDATA().getUSERID());
                                SharePreUtil.putString(LoginAct.this, Constants.SP_ACCOUNT_LOGON_USERCODE, response.getDATA().getUSERCODE());
                                SharePreUtil.putString(LoginAct.this, Constants.SP_ACCOUNT_LOGON_PASSWORD, response.getDATA().getPASSWORD());
                                SharePreUtil.putString(LoginAct.this, Constants.SP_ACCOUNT_LOGON_USERNAME, response.getDATA().getUSERNAME());
                                SharePreUtil.putInteger(LoginAct.this, Constants.SP_ACCOUNT_LOGON_ENTITYSTATE, response.getDATA().getEntityState());
                                SharePreUtil.putBoolean(LoginAct.this, Constants.SP_ACCOUNT_LOGON_SELECTED, response.getDATA().isSelected());
                                SharePreUtil.putInteger(LoginAct.this, Constants.SP_ACCOUNT_LOGON_WAREHOUSEID, response.getDATA().getWAREHOUSEID());
                                SharePreUtil.putString(LoginAct.this, Constants.SP_ACCOUNT_LOGON_WAREHOUSECODE, response.getDATA().getWAREHOUSECODE());
                                SharePreUtil.putString(LoginAct.this, Constants.SP_ACCOUNT_LOGON_WAREHOUSENAME, response.getDATA().getWAREHOUSENAME());
                                intentTo(LoginAct.this, MainPageAct.class);
                                finish();
                            } else {
                                ToastCheese("无权限登录!");
                            }
                        }
                    } else {
                        ToastCheese(response.getMESSAGE());
                    }
                }

                @Override
                public void onAfter() {
                    super.onAfter();
                    hideLoadingDialog();
                }
            });
        } else {
            ToastCheese(getString(R.string.toast_username_password_error));
        }
    }

    /**
     * 检查是否为最新版本
     * @return
     */
    private void isLatest() throws PackageManager.NameNotFoundException {
        PackageInfo packageInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
        final String versionName = packageInfo.versionName;
        final String[] splits = versionName.split("\\.");

        restApi.checkVersion(splits[0],splits[1]).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<BaseEntity<String>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(BaseEntity<String> booleanBaseEntity) {
                                if("1".equals(booleanBaseEntity.getRESULT())){
                                    dowloadNewVersion(splits[0],splits[1]);
                                }else{
                                    ToastCheese("当前版本"+versionName+"为最新版本");
                                }
                    }
                });

    }
    /**
     * 下载并安装APK
     */
    private void dowloadNewVersion(String main,String build){

        restApi._dowload(main,build).map(new Func1<ResponseBody, String>() {

                @Override
                public String call(ResponseBody responseBody) {
                    if(responseBody!=null){
                        return writeResponseBodyToDisk(responseBody,"update.apk");


                    }
                    return null;
                }
            }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Subscriber<String>() {
                        @Override
                        public void onCompleted() {

                        }

                        @Override
                        public void onError(Throwable e) {

                        }

                        @Override
                        public void onNext(String path) {
                        if(path!=null){
                            install(new File(path));
                        }
                        }
                    });



    }


    /**
     * 将响应序列化为APK
     * @param body
     * @param savaName
     * @return
     */
    private String writeResponseBodyToDisk(ResponseBody body,String savaName) {
        try {


            // todo change the file location/name according to your needs
            File futureStudioIconFile = new File(Environment.getExternalStorageDirectory().getAbsolutePath(),"/"+savaName);

            InputStream inputStream = null;
            OutputStream outputStream = null;

            try {
                byte[] fileReader = new byte[2048];

                long fileSize = body.contentLength();
                long fileSizeDownloaded = 0;

                inputStream = body.byteStream();
                outputStream = new FileOutputStream(futureStudioIconFile);

                while (true) {
                    int read = inputStream.read(fileReader);

                    if (read ==-1) {
                        Log.i("read","end");
                        break;
                    }

                    outputStream.write(fileReader, 0, read);

                    fileSizeDownloaded += read;

                    Log.w("saveFile", "file download: " + fileSizeDownloaded + " of " + fileSize);
                }

                outputStream.flush();
                Log.i("file","done");

                return futureStudioIconFile.getAbsolutePath();
            } catch (IOException e) {
                Log.i("wrong",1+e.toString());
                return null;
            } finally {
                if (inputStream != null) {
                    inputStream.close();
                }

                if (outputStream != null) {
                    outputStream.close();
                }
            }
        } catch (IOException e) {
            Log.i("wrong",2+e.toString());
            return null;
        }
    }

    private void install(File file){
        String absolutePath = file.getAbsolutePath();
        LogUtils.i("路径",absolutePath);
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
        startActivity(intent);
        Log.i("test","end");
    }
}
