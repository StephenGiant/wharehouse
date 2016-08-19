package com.example.wms_erp.retrofit;

/**
 * Created by qianpeng on 2016/8/19.
 */
public class RetrofitSingle  {

    private RetrofitSingle(){
        //do nothing
    }
    private static ServiceApi serviceApi;

    /**
     * 加了同步锁的单例模式
     * @return
     */
    public static ServiceApi getInstance(){
            if(serviceApi==null){
                synchronized (RetrofitSingle.class){
                    serviceApi = new RetrofitBuilder().createServiceClass(ServiceApi.class);
                }
            }
        return serviceApi;
    }
}
