package com.example.wms_erp.application;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/**
 * Created by Administrator on 2016/8/22.
 */
public class MyApplication extends Application {
    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int userID;
    @Override
    public void onCreate() {
        super.onCreate();
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
            //fuck your selfe
        }
return null;
    }
}
