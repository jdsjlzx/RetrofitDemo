package com.baidu.retrofit.model;

import android.content.Context;

import com.baidu.retrofit.Constant;
import com.baidu.retrofit.RetrofitWrapper;
import com.baidu.retrofit.bean.IpInfo;
import com.baidu.retrofit.intf.ApiService;

import retrofit2.Call;

public class IpInfoModel {
    private static IpInfoModel famousInfoModel;
    private ApiService mApiService;

    public IpInfoModel(Context context) {
        mApiService = RetrofitWrapper.getInstance(Constant.BASEURL_IP).create(ApiService.class);
    }

    public static IpInfoModel getInstance(Context context){
        if(famousInfoModel == null) {
            famousInfoModel = new IpInfoModel(context);
        }
        return famousInfoModel;
    }

    public Call<IpInfo> queryIpInfo(String ip) {
        Call<IpInfo> infoCall = mApiService.getIpinfoResult(ip);
        return infoCall;
    }
}
