package com.example.wms_erp.util;

import android.util.Log;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

/**
 * Created by qianpeng on 2016/8/30.
 */
public class HandleCodeUtil {
        public static final int RIGHTDATE = 101;
    public static final int OVERDATE = 102;
    public static final int ERRORFORMAT=103;


    public static int checkDate(String code){
        boolean flag = false;
        int status = 101;
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
        Log.i("保质期",keepDays+"");
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
                status = RIGHTDATE;
            }else{
                Log.i("过期","不能上架");
                status = OVERDATE;
               flag=false;
            }
            return status;
        } catch (ParseException e) {
            //日期格式异常
            e.printStackTrace();
            Log.i("异常",e.toString());

            return ERRORFORMAT;
        }

    }

//    public static boolean isGoodsCode(String code){
//        return false;
//    }

    /**
     * 判断是否为货位，此正则与发货箱近似
     * @param code
     * @return
     */
    public static boolean isLocCode(String code){
        Pattern compile = Pattern.compile("\\w{6}");
        return compile.matcher(code).matches();

    }

    /**
     * 商品条码，包括批次号
     * @param code
     * @return
     */
    public static boolean isGoodsCode(String code){
        //前三位为字母或者数字
        Pattern compile = Pattern.compile("\\w{3}\\d{6,20}");
        return compile.matcher(code).matches();
    }

}
