package com.example.wms_erp.retrofit;

import com.example.wms_erp.model.BaseBean;
import com.example.wms_erp.model.post.OnShelvebean;
import com.example.wms_erp.model.response.LocInfo;
import com.example.wms_erp.model.response.LocInfoResponse;
import com.example.wms_erp.model.response.OnShelveInfo;
import com.example.wms_erp.model.response.UserInfo;

import java.util.List;

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
     * @param onShelveInfos
     * @return
     */
    @POST("OnShelves/SetOnShelves")
    public Observable<BaseBean<String>> postOnShelve (@Query("userID") int userID, @Query("objType") String objType, @Body List<OnShelveInfo> onShelveInfos);

    /**
     * 登陆接口
     * @param userID
     * @param userPswd
     * @return
     */
    @GET("Login/LogonUser")
    public Observable<BaseBean<UserInfo>> login(@Query("userID")String userID,@Query("userPswd")String userPswd);

    /**
     * 获取下架信息
     * @param barCode
     * @return
     */
    @GET("OffShelves/GetLocationGoodsInfo")
    public Observable<BaseBean<OnShelveInfo>> getOffShelveInfo(@Query("gbCode")String barCode);

    /**
     * 提交下架
     * @param userID
     * @param objType
     * @param onShelveInfos
     * @return
     */
    @POST("OffShelves/SetOffShelves")
    public Observable<BaseBean<String>> postOffShelve(@Query("userID") int userID, @Query("objType") String objType, @Body List<OnShelveInfo> onShelveInfos);
    @GET("InventoryAdjustment/GetLocationInventory")
    public Observable<BaseBean<List<LocInfoResponse>>> getLocationInventory(@Query("LocCode")String locCode);
    @POST("InventoryAdjustment/UpdateLocationInventory")
    public Observable<BaseBean<String>> postLocCount(@Query("UserId")int userID,@Body List<LocInfo> locs);
}
