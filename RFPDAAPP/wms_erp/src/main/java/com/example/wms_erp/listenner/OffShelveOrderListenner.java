package com.example.wms_erp.listenner;

import com.example.wms_erp.model.response.OffshelveInfo;

import java.util.List;

/**
 * Created by Administrator on 2017/1/4.
 */

public interface OffShelveOrderListenner {
    public abstract void onCellNoGet();//获取库位成功的回调
    public abstract void onCellNoFail();//获取库位失败的回调
    public abstract void onItemSign();//扫描条目与服务器交互成功
    public abstract void onItemSignFail();//扫描条目与服务器交互失败
    public abstract void onOffshelveOrderGet(List<OffshelveInfo> list);//获取下架指令成功
    public abstract void onOffshelveOderFailed();//获取下架指令失败
    public abstract void onPostOffshelve();//提交下架成功
    public abstract void onPostOffshelveFailed();//提交下架失败
    public abstract void onGetBatchInfo(OffshelveInfo info);
    public abstract void onGetBatchInfoFailed(String message);
}
