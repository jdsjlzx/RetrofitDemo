package com.baidu.retrofit.model;

import android.content.Context;

import com.baidu.retrofit.Constant;
import com.baidu.retrofit.RetrofitWrapper;
import com.baidu.retrofit.bean.IpInfo;
import com.baidu.retrofit.intf.ApiRxService;

import rx.Observable;

public class IpInfoRxModel {
    private static IpInfoRxModel famousInfoModel;
    private ApiRxService mApiService;

    public IpInfoRxModel(Context context) {
        mApiService = RetrofitWrapper.getInstance(Constant.BASEURL_IP)
                .create(ApiRxService.class);
    }

    public static IpInfoRxModel getInstance(Context context){
        if(famousInfoModel == null) {
            famousInfoModel = new IpInfoRxModel(context);
        }
        return famousInfoModel;
    }

    public Observable<IpInfo> queryIpInfo(String ip) {
        Observable<IpInfo> infoCall = mApiService.getIpinfoResult(ip);
        return infoCall;
    }
}
