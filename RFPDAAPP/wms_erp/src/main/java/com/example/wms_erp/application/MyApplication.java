package com.example.wms_erp.application;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import com.bugtags.library.Bugtags;
import com.bumptech.glide.Glide;
import com.bumptech.glide.integration.okhttp.OkHttpUrlLoader;
import com.bumptech.glide.load.model.GlideUrl;
import com.example.wms_erp.event.RxManager;
import com.example.wms_erp.model.response.UserInfo;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.squareup.okhttp.OkHttpClient;

import java.io.InputStream;

/**
 * Created by Administrator on 2016/8/22.
 */
public class MyApplication extends Application {

    public RxManager rxManager;

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int userID;
    public UserInfo userInfo;
    @Override
    public void onCreate() {

        super.onCreate();
//        Bugtags.start("0fed9c24794039ea2325087e1f4ab1da", this, Bugtags.BTGInvocationEventBubble);
        Bugtags.start("61ece70d72dbf3a8252692c2fcc1602e", this, Bugtags.BTGInvocationEventNone);
        Glide.get(this)
                .register(GlideUrl.class, InputStream.class, new OkHttpUrlLoader.Factory(new OkHttpClient()));
        FlowManager.init(this);
        rxManager = new RxManager();
    }

    public String getVersion(){

        PackageManager packageManager = getApplicationContext().getPackageManager();
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(getApplicationContext().getPackageName(), 0);
            String versionName = packageInfo.versionName;
            return versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }finally {
            //fuck your selve
        }
return null;
    }
}
