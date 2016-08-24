package com.example.wms_erp.model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/8/24.
 */
public class test {
private static void test() {
    String jsonStr="{ \"status\":200, \"message\": \"\",\"tel\": \"13146688808\",\"stored\": {\"1\": {\"money\": 199900,\"gift\": 60000}," +
            "\"2\": { \"money\":499900,\"gift\":200000},\"3\": {\"money\":999900,\"gift\":500000} }}";
    Gson gson = new Gson();
    Object fromJson = gson.fromJson(jsonStr,Object.class);
}
}
