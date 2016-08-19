package com.example.wms_erp.retrofit;

import com.example.wms_erp.apiconfig.ApiConfig;
import com.squareup.okhttp.OkHttpClient;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

/**
 * Created by Administrator on 2016/8/19.
 */
public class RetrofitBuilder {
    private  OkHttpClient client = new OkHttpClient();
    private static Retrofit.Builder builder =
            new Retrofit.Builder()
                    .baseUrl(ApiConfig.BaseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create());

    /**
     * 返回apiService 接口的实现类 用于调用方法
     * @param serviceClass
     * @param <S>
     * @return
     */
    public  <S> S createServiceClass(Class<S> serviceClass){
        Retrofit retrofit = builder.client(client).build();
        return retrofit.create(serviceClass);
    }
}
