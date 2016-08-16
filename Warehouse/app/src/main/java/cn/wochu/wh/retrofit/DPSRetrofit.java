package cn.wochu.wh.retrofit;

import com.squareup.okhttp.OkHttpClient;


import cn.wochu.wh.constant.ApiConstants;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

/**
 * Created by hasee on 2016/4/22.
 */
public class DPSRetrofit {
    private static OkHttpClient httpClient = new OkHttpClient();

    private static Retrofit.Builder builder =
            new Retrofit.Builder()
                    .baseUrl(ApiConstants.APP_HOST)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create());

    private static Retrofit.Builder builder2 =
            new Retrofit.Builder()
                    .baseUrl(ApiConstants.APP_HOST)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create());

    public <S> S createService(Class<S> serviceClass) {
        Retrofit retrofit = builder.client(httpClient).build();
        return retrofit.create(serviceClass);
    }

    public <S> S createService2(Class<S> serviceClass) {
        Retrofit retrofit = builder2.client(httpClient).build();
        return retrofit.create(serviceClass);
    }
}
