package com.baidu.retrofit;

import android.content.Context;

import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;

/**
 * Created by lizhixian on 16/5/8.
 */
public class RetrofitWrapper {
    private static RetrofitWrapper instance;
    private Context mContext;
    private Retrofit mRetrofit;

    public RetrofitWrapper() {
        mRetrofit = new Retrofit.Builder().baseUrl(Constant.BASEURL)
                .addConverterFactory(GsonConverterFactory.create()).build();
    }

    public  static RetrofitWrapper getInstance(){

        if(null == instance){
            synchronized (RetrofitWrapper.class){
                instance = new RetrofitWrapper();
            }
        }
        return instance;
    }

    public <T> T create(final Class<T> service) {
        return mRetrofit.create(service);
    }
}
