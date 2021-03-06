package com.example.wms_erp.retrofit;

import com.example.wms_erp.model.BaseBean;
import com.example.wms_erp.model.post.OffshelveOrderRequest_sign;
import com.example.wms_erp.model.post.OnShelvebean;
import com.example.wms_erp.model.response.GoodsLocInfo;
import com.example.wms_erp.model.response.Kuwei;
import com.example.wms_erp.model.response.LocDetail;
import com.example.wms_erp.model.response.LocInfo;
import com.example.wms_erp.model.response.LocInfoResponse;
import com.example.wms_erp.model.response.OffshelveInfo;
import com.example.wms_erp.model.response.OnShelveInfo;
import com.example.wms_erp.model.response.UserInfo;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;

import java.util.List;

import retrofit.http.Body;
import retrofit.http.Field;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;
import retrofit.http.Query;
import retrofit.http.Streaming;
import retrofit.http.Url;
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
    @GET("LocationGoods/GetLocationGoodsByCode")
    public Observable<BaseBean<List<LocDetail>>> getLocDetailByGoodsCode(@Query("code")String code);
    @GET("LocationGoods/GetLocationGoods")
    public Observable<BaseBean<List<LocDetail>>> getLocDetailByLocCode(@Query("code")String code);

    /**
     * 获取商品货位信息
     * @param goodsCode
     * @param loacationCode
     * @return
     */
    @GET("LocationGoodsMove/GetLocationALLGoods")
    public Observable<BaseBean<List<OnShelveInfo>>> getGoodsLocInfo(@Query("goodsCode")String goodsCode,@Query("locationCode")String loacationCode);

    /**
     *  提交转移货位
     * @param userID
     * @param destinLocationCode
     * @return
     */
    @POST("LocationGoodsMove/LocationGoodsMove")
    public Observable<BaseBean<String>> postGoodsLocChange(@Query("UserID") int userID,@Query("DestinLocationCode")String destinLocationCode,@Body List<OnShelveInfo> requestbody);

    /**
     * 绑定商品货位
     * @param userID
     * @param locCode
     * @param goodsCode
     * @param status
     * @return
     */
    @POST("LocationGoods/SetLocationGoods")
    public Observable<BaseBean<String>> postBindLocGoods(
            @Query("userID") int userID,@Query("LocationCode")String locCode,@Query("GoodsCode")String goodsCode,@Query("status") int status);
    @POST("OffShelvesOrder/SetOffShelves")
    public Observable<BaseBean<String>> offshelveOrder();

    //----------------------------------------------------------------------------
    //以下是指令下架
    /**
     * 获取库位，填充sp
     * @param userID
     * @return
     */
    @GET("OffShelvesOrder/GetOffCellNo")
    public Observable<BaseBean<List<Kuwei>>> getKuwei(@Query("userID")int userID);

    /**
     * 获取下架指令信息
     * @param cellNO
     * @param batchNo
     * @param userID
     * @param date
     * @return
     */
    @GET("OffShelvesOrder/GetOffShelvesInfo")
    public Observable<BaseBean<List<OffshelveInfo>>> getOffshelveOrderInfo(@Query("cellNo") String cellNO,@Query("batchNo")String batchNo,@Query("userID") int userID
    ,@Query("offShelvesDate")String date);

    /**
     * 提交下架
     * @param userID
     * @param body
     * @return
     */
    @POST("OffShelvesOrder/SetOffShelves")
    public Observable<BaseBean<String>> postOffshelveOrder(@Query("userID") int userID, @Body List<OffshelveInfo> body);

    /**
     * 检查扫描批次
     * @param goodsBatchCode
     * @return
     */
    @GET("OffShelvesOrder/CheckLocationInventory")
    public Observable<BaseBean<OffshelveInfo>> getLocationInventoryOrder(@Query("GoodsBatchCode")String goodsBatchCode);

    /**
     * 将指令标记为进行中
     * @param setType
     * @param requestList
     * @return
     */
    @POST("OffShelvesOrder/SetOffShelvesState")
    public Observable<BaseBean<Boolean>> SetOffShelvesState(@Query("setType")String setType,@Body List<OffshelveInfo> requestList);

    //------------------------------------------------------------------------------
    //获取新版本
    @Streaming
    @GET
    public Observable<Response> getNewVersion(@Url String url);
}
