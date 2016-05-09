package com.baidu.retrofit.intf;

import com.baidu.retrofit.bean.FamousInfo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

/**
 * Created by lizhixian on 16/5/8.
 */
public interface IFamousInfo {

    @GET("/avatardata/mingrenmingyan/lookup")
    Call<FamousInfo> getFamousResult(@Header("apiKey") String apiKey,
                                     @Query("keyword") String keyword,
                                     @Query("page") int page,
                                     @Query("rows") int rows);
}
