package cn.wochu.wh.utils;

import java.util.regex.Pattern;

/**
 * project name：Warehouse
 * class describe：
 * create person：dayongxin
 * create time：16/6/16 上午11:04
 * alter person：dayongxin
 * alter time：16/6/16 上午11:04
 * alter remark：
 */
public class CheckCodeUtil {
    public static boolean isWochuGoodsNum(String str) {

        boolean matches = Pattern.compile("^WOC\\d{6,20}").matcher(str).matches();
        if (str.contains("WOC")) {
            return true;
        }
        return matches;
    }

    public static boolean isHuoweiCode(String code){
       return Pattern.compile("^A\\S{1,6}").matcher(code).matches();
    }
}
