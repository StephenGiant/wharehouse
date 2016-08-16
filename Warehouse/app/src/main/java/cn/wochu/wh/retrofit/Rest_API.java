package cn.wochu.wh.retrofit;


import com.squareup.okhttp.ResponseBody;

import cn.wochu.wh.entity.BaseEntity;
import retrofit.Call;
import retrofit.Response;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Query;
import retrofit.http.Streaming;
import rx.Observable;

/**
 * 提供了各个api接口
 * Created by qianpeng on 2016/4/22.
 */
public interface Rest_API {
@POST("DCShelves/SetDCLocationGoodsRelation")
    public Observable<BaseEntity<Boolean>> postBindWhareHouse(
        @Query("LocationCode") String locationCode, @Query("GoodsCode") String GoodsCode ,@Query("userCode")String userCode,
@Query("WarehouseID") String WarehouseID);

    /**
     * 下载新版本APK
     * @return
     */
    @Streaming
    @GET("UpdateVersion/download")
    public Call<ResponseBody> dowload(@Query("majorId")String majorId,@Query("buildNo") String buildNo);

    /**
     * 下载新版本APK
     * @return
     */
    @Streaming
    @GET("UpdateVersion/downloadDCapp")
    public Observable<ResponseBody> _dowload(@Query("majorId")String majorId,@Query("buildNo") String buildNo);

    @GET("UpdateVersion/CheckDCAppVersion")
    public Observable<BaseEntity<String>> checkVersion(@Query("majorId")String majorId,@Query("buildNo") String buildNo);
}
