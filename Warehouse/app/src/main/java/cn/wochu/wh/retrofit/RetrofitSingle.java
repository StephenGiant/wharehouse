package cn.wochu.wh.retrofit;

/**
 * 实例化网络访问对象
 * Created by qianpeng on 2016/4/22.
 */
public class RetrofitSingle {
    public static Rest_API APISingle=null;
    public static Rest_API APISingle2=null;
    public static Rest_API getInstance() {
        if (APISingle == null) {
            synchronized (RetrofitSingle.class) {
                if (APISingle == null) {
                    APISingle = new DPSRetrofit().createService(Rest_API.class);
                }
            }
        }
        return APISingle;
    }


    public static Rest_API getInstance2() {
        if (APISingle2 == null) {
            synchronized (RetrofitSingle.class) {
                if (APISingle2 == null) {
                    APISingle2 = new DPSRetrofit().createService2(Rest_API.class);
                }
            }
        }
        return APISingle2;
    }
}
