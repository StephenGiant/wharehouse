package wochu.com.rfpdaapp.utils;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by hasee on 2016/7/27.
 */
public class SharePreUtil {

    private static SharedPreferences sp;

    public static void addIntSP(Context context, String key, int value, String spName){
        sp = context.getSharedPreferences(spName, Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt(key,value);
        editor.commit();

    }

    public static void addStringSP(Context context, String key, String value, String spName){
        sp = context.getSharedPreferences(spName, Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(key,value);
        editor.commit();

    }

    public static int getIntSP(Context context, String key, String spName){
        sp = context.getSharedPreferences(spName,Activity.MODE_PRIVATE);
        return sp.getInt(key,0);

    }

    public static String getStringSP(Context context, String key, String spName){
        sp = context.getSharedPreferences(spName,Activity.MODE_PRIVATE);
        return sp.getString(key,"");
    }

}
