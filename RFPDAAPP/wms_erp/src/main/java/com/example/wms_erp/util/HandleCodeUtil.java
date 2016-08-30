package com.example.wms_erp.util;

import android.util.Log;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by qianpeng on 2016/8/30.
 */
public class HandleCodeUtil {

    public static boolean checkDate(String code){
        boolean flag = false;
        Log.i("条码",code);
        String dateString = code.substring(code.length() - 8, code.length());
        dateString = "201"+dateString;
        Log.i("条码日期",dateString);
        String keepTime = dateString.substring(dateString.length() - 3, dateString.length());
        dateString = dateString.substring(0,dateString.length()-3);

       Log.i("dateString",dateString);

        Log.i("keepTime",keepTime);
        int keepDays = 0;
        if(keepTime!=null) {
           keepDays = Integer.parseInt(keepTime);
        }
        Calendar calendar = Calendar.getInstance();
        Date curTime = calendar.getTime();
        Log.i("当前日期",curTime.toString());
//        int year = calendar.get(Calendar.YEAR);
//        int month = calendar.get(Calendar.MONTH);
//        month+=1;
//        int day = calendar.get(Calendar.DATE);
//        if(Integer.getInteger(dateString.charAt(0)+"")<=year-2010){
//
//        };
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        dateFormat.setLenient(false);
//        String date = dateFormat.format(dateString);
//        Log.i("生产日期1",date);
        try {
            calendar.setTime(dateFormat.parse(dateString));
            Log.i("生产日期",calendar.getTime().toString());
            Date createDate = calendar.getTime();
            calendar.add(Calendar.DAY_OF_YEAR,keepDays);
            Date time = calendar.getTime();
            Log.i("过期日期",time.toString());
            if(curTime.before(time)&&curTime.after(createDate)){
               flag=true;
            }else{
                Log.i("过期","不能上架");
               flag=false;
            }
            return flag;
        } catch (ParseException e) {
            //日期格式异常
            e.printStackTrace();
            Log.i("异常",e.toString());
            return false;
        }

    }

    public static boolean isGoodsCode(String code){
        return false;
    }

}
