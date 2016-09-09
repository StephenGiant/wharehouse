package com.example.wms_erp.util;

/**
 * Created by Administrator on 2016/9/9.
 */
public class UnitUtils {

public static double getSmallUinitNum(double num,double xishu){
    return num%xishu;
}
    public static double getBigUnitNum(double num,double xishu){
        return num/xishu;
    }
}
