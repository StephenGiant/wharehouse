package wochu.com.rfpdaapp.retrofit;

import java.util.Map;

import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Query;
import retrofit.http.QueryMap;
import rx.Observable;
import wochu.com.rfpdaapp.bean.BaseBean;
import wochu.com.rfpdaapp.bean.UserInfo;

/**
 * Created by hasee on 2016/7/19.
 */
public interface RestApi {
    @POST("/ZboxSku/SetRFidSkuRela")
    public Observable<BaseBean<Boolean>> BindZbox_RFID(@Query("UserId")int userID,
    @Query("GoodsCode")String goodsCode,@Query("RFid")String rfID);

    /**
     * 登陆接口
     * @param userName 工号
     * @param password 密码
     * @return
     */
    @GET("/Account/LogOn")
    public Observable<UserInfo> login(@Query("userName") String userName,@Query("password") String password);
}
