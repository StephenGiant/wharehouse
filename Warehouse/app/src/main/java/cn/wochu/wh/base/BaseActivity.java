package cn.wochu.wh.base;

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
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import cn.wochu.wh.R;
import cn.wochu.wh.app.AppManager;
import cn.wochu.wh.receiver.PDAReceiver;
import cn.wochu.wh.utils.NetUtils;
import cn.wochu.wh.utils.ToastUtil;

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
    private PDAReceiver receiver;
    private IntentFilter scanDataIntentFilter;


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

        scanDataIntentFilter = new IntentFilter();
        //前台输出
        //scanDataIntentFilter.addAction("com.android.scancontext");
        //后台输出
        scanDataIntentFilter.addAction("com.android.scanservice.scancontext");
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
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(receiver);
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
