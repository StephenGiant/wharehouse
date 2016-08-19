package com.example.wms_erp.retrofit;

import com.example.wms_erp.model.BaseBean;
import com.example.wms_erp.model.post.OnShelvebean;
import com.example.wms_erp.model.response.OnShelveInfo;

import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Query;
import rx.Observable;

/**
 * api接口 负责访问网络
 * Created by qianpeng on 2016/8/19.
 */
public interface ServiceApi {
    /**
     * 获取上架信息
     * @param barCode
     * @return
     */
    @GET("OnShelves/GetLocationGoodsInfo")
    public Observable<BaseBean<OnShelveInfo>> getOnShelveInfo(@Query("barCode")String barCode);

    /**
     * 提交上架
     * @param userID
     * @param objType
     * @param osb
     * @return
     */
    @POST("OnShelves/SetOnShelves")
    public Observable<String> postOnShelve (@Query("userID") int userID, @Query("objType") String objType, @Body OnShelvebean osb);
}