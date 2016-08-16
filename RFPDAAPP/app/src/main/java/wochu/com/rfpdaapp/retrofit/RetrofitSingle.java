package wochu.com.rfpdaapp.retrofit;

/**
 * Created by hasee on 2016/7/19.
 */
public class RetrofitSingle {

    public static RestApi APISingle=null;
    public static RestApi APISingle2=null;
    public static RestApi getInstance() {
        if (APISingle == null) {
            synchronized (RetrofitSingle.class) {
                if (APISingle == null) {
                    APISingle = new RetrofitClient().createService(RestApi.class);
                }
            }
        }
        return APISingle;
    }


    public static RestApi getInstance2() {
        if (APISingle2 == null) {
            synchronized (RetrofitSingle.class) {
                if (APISingle2 == null) {
                    APISingle2 = new RetrofitClient().createService2(RestApi.class);
                }
            }
        }
        return APISingle2;
    }
}
