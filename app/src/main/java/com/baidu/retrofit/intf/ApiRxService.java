package com.baidu.retrofit.intf;


import com.baidu.retrofit.bean.HttpResponse;
import com.baidu.retrofit.bean.IpInfo;

import java.util.Map;

import okhttp3.RequestBody;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Query;
import rx.Observable;

public interface ApiRxService {

    @GET("service/getIpInfo.php")
    Observable<IpInfo> getIpinfoResult(@Query("ip") String keyword);

    @Multipart
    @POST("http://api.stay4it.com/v1/public/core/?service=user.updateAvatar")
    Observable<HttpResponse<String>> uploadFile(@Part("data") String des,
                                                      @PartMap Map<String,RequestBody> params);

}
