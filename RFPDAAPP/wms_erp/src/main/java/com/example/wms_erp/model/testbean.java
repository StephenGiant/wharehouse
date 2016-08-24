package com.example.wms_erp.model;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Administrator on 2016/8/24.
 */
public class testbean {

    /**
     * 2 : {"xxx":1000}
     * 3 : {"xxx":2000}
     */

    private AaaBean aaa;

    public static testbean objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), testbean.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }


    public static class AaaBean{

    }
}
