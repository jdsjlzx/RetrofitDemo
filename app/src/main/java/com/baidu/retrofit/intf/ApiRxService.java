package com.baidu.retrofit.intf;


import com.baidu.retrofit.bean.IpInfo;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface ApiRxService {
    /*@GET("service/getIpInfo.php")
    Call<IpInfo> getIpinfoResult(@Query("ip") String keyword);*/

    @GET("service/getIpInfo.php")
    Observable<IpInfo> getIpinfoResult(@Query("ip") String keyword);

}
