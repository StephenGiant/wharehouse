package com.example.wms_erp.ui;

//                            _ooOoo_
//                           o8888888o
//                           88" . "88
//                           (| -_- |)
//                            O\ = /O
//                        ____/`---'\____
//                      .   ' \\| |// `.
//                       / \\||| : |||// \
//                     / _||||| -:- |||||- \
//                       | | \\\ - /// | |
//                     | \_| ''\---/'' | |
//                      \ .-\__ `-` ___/-. /
//                   ___`. .' /--.--\ `. . __
//                ."" '< `.___\_<|>_/___.' >'"".
//               | | : `- \`.;`\ _ /`;.`/ - ` : | |
//                 \ \ `-. \_ __\ /__ _/ .-` / /
//         ======`-.____`-.___\_____/___.-`____.-'======
//                            `=---='
//
//         .............................................
//                  佛祖镇楼                  BUG辟易
//          佛曰:
//                  写字楼里写字间，写字间里程序员；
//                  程序人员写程序，又拿程序换酒钱。
//                  酒醒只在网上坐，酒醉还来网下眠；
//                  酒醉酒醒日复日，网上网下年复年。
//                  但愿老死电脑间，不愿鞠躬老板前；
//                  奔驰宝马贵者趣，公交自行程序员。
//                  别人笑我忒疯癫，我笑自己命太贱；
//                  不见满街漂亮妹，哪个归得程序员？
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.bugtags.library.Bugtags;
import com.example.wms_erp.R;
import com.example.wms_erp.application.AppManager;
import com.example.wms_erp.receiver.PDAReceiver;
import com.example.wms_erp.retrofit.RetrofitSingle;
import com.example.wms_erp.retrofit.ServiceApi;
import com.example.wms_erp.util.NetUtils;
import com.example.wms_erp.util.ToastUtil;
import com.example.wms_erp.view.MaterialDialog;


/**
 * project name：Warehouse
 * class describe：
 * create person：dayongxin
 * create time：16/6/12 下午4:58
 * alter person：dayongxin
 * alter time：16/6/12 下午4:58
 * alter remark：
 */
public abstract class BaseActivity extends AppCompatActivity {

    private Dialog mProgressDialog;
    private Activity attachActivity;

    /**
     * PDA相关
     */
    protected PDAReceiver receiver;
    private IntentFilter scanDataIntentFilter;
    protected ServiceApi serviceApi;
    private MaterialDialog materialDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppManager.getAppManager().addActivity(this);


        receiver = new PDAReceiver() {
            @Override
            protected void dispathCode(String str) {
                handleCode(str);
            }
        };
        setStatusBar();
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.KITKAT&&Build.VERSION.SDK_INT <= Build.VERSION_CODES.LOLLIPOP) {
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //透明导航栏 一些手机如果有虚拟键盘的话,虚拟键盘就会变成透明的,挡住底部按钮点击事件所以,最后不要用
            //getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            int barColor = getWindow().getStatusBarColor();
            Log.i("barcolor",barColor+"");
        }



        scanDataIntentFilter = new IntentFilter();
        //前台输出
        //scanDataIntentFilter.addAction("com.android.scancontext");
        //后台输出
        scanDataIntentFilter.addAction("com.android.scanservice.scancontext");
        serviceApi = RetrofitSingle.getInstance();



    }
    @TargetApi(23)
    private void setStatusBar() {
//        getWindow().setStatusBarColor(444444);
    }

    protected abstract void handleCode(String str);

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(receiver, scanDataIntentFilter);
        Bugtags.onResume(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(receiver);
        Bugtags.onPause(this);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Bugtags.onDispatchTouchEvent(this, ev);

        return super.dispatchTouchEvent(ev);
    }

    @Override
    protected void onStop() {
        super.onStop();
        hideLoadingDialog();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        hideLoadingDialog();
        AppManager.getAppManager().finishActivity(this);
    }

    public void showLoadingDialog(String message) {
        if (mProgressDialog == null || attachActivity == null) {
            attachActivity = this;
            while (attachActivity.getParent() != null) {
                attachActivity = attachActivity.getParent();
            }
            if (attachActivity == null) {
                return;
            }
            mProgressDialog = new Dialog(attachActivity, R.style.dialog_tran);
            View view = LayoutInflater.from(attachActivity).inflate(R.layout.progress_dialog, null);
            WindowManager.LayoutParams params = attachActivity.getWindow().getAttributes();
            params.height = ViewGroup.LayoutParams.MATCH_PARENT;
            params.width = ViewGroup.LayoutParams.MATCH_PARENT;
            //getWindow().setAttributes((android.view.WindowManager.LayoutParams) params);
            mProgressDialog.setCanceledOnTouchOutside(true);
            mProgressDialog.setCancelable(false);
            mProgressDialog.addContentView(view, params);
        }
        if (attachActivity != null && !mProgressDialog.isShowing()) {
            mProgressDialog.show();
        }
    }

    public boolean isDialogShowing() {
        return mProgressDialog != null && mProgressDialog.isShowing();
    }

    public void hideLoadingDialog() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
        mProgressDialog = null;
    }

    /**
     * 公用跳转方法
     */
    public void intentTo(Context packageContext, Class<?> cls) {
        Intent i = new Intent();
        i.setClass(packageContext, cls);
        startActivity(i);
    }

    /**
     * 公共toast
     */
    public void ToastCheese(String msg) {
        ToastUtil.makeText(this, msg).show();
    }

    public OncheckListenner mListenner;
    /**
     * 自定义对话框
     *
     * @param title
     * @param message
     */
    public void showMaterialDialog(String title, String message) {
        if (materialDialog == null) {
            materialDialog = new MaterialDialog(this);
        }
        materialDialog.setTitle(title).setMessage(message).setPositiveButton("确定", new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                materialDialog.dismiss();
                if (mListenner != null) {
                    mListenner.onPositiveClick();
                }

            }
        }).setNegativeButton("取消", new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                materialDialog.dismiss();
                if (mListenner != null) {
                    mListenner.onNagativeClick();
                }
            }
        }).setCanceledOnTouchOutside(false).show();

    }

    /**
     * 带点击事件的普通对话框
     *
     * @param title
     * @param message
     * @param listenner
     */
    public void showMaterialDialog(String title, String message, OncheckListenner listenner) {
        mListenner = listenner;
        if(materialDialog==null) {
            materialDialog = new MaterialDialog(this);
        }

        materialDialog.setTitle(title).setMessage(message).setPositiveButton("确定", new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                materialDialog.dismiss();
                if (mListenner != null) {
                    mListenner.onPositiveClick();
                }

            }
        }).setNegativeButton("取消", new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                materialDialog.dismiss();
                if (mListenner != null) {
                    mListenner.onNagativeClick();
                }
            }
        }).setCanceledOnTouchOutside(false).show();

    }

    /**
     * 自定义布局的dialog
     *
     * @param title
     * @param view
     * @param listenner
     */
    public void showMaterialDialog(String title, View view, OncheckListenner listenner) {
        mListenner = listenner;
        if(materialDialog==null) {
            materialDialog = new MaterialDialog(this);
        }
        if(materialDialog!=null) {
            materialDialog.setTitle(title).setContentView(view).setPositiveButton("确定", new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    if (mListenner != null) {
                        mListenner.onPositiveClick();
                    }
                    materialDialog.dismiss();
                    materialDialog = null;
                }
            }).setNegativeButton("取消", new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    if (mListenner != null) {
                        mListenner.onNagativeClick();
                    }
                    materialDialog.dismiss();
                    materialDialog = null;

                }
            }).setCanceledOnTouchOutside(false).show();
        }
        ;
    }
    public void setOncheckListenner(OncheckListenner listenner) {
        mListenner = listenner;
    }

    public interface OncheckListenner {
        public void onPositiveClick();

        public void onNagativeClick();
    }

    /**
     * 判断网络是否连接
     */
    public boolean baseHasNet() {
        if (!NetUtils.isConnected(this)) {
            ToastCheese(getString(R.string.base_act_network_no));
            return false;
        }
        return true;
    }

    /**
     * 给子类需要强制注销的时候使用
     */
    public void unRegist() {
        unregisterReceiver(receiver);
    }

    /**
     * 给子类需要强制注册广播的时候使用
     */
    public void regist() {
        registerReceiver(receiver, scanDataIntentFilter);
    }
}
