package com.baidu.retrofit.model;

import android.content.Context;

import com.baidu.retrofit.RetrofitWrapper;
import com.baidu.retrofit.bean.FamousInfo;
import com.baidu.retrofit.bean.FamousInfoReq;
import com.baidu.retrofit.intf.IFamousInfo;

import retrofit2.Call;

/**
 * Created by lizhixian on 16/5/8.
 */
public class FamousInfoModel {
    private static FamousInfoModel famousInfoModel;
    private IFamousInfo mIFamousInfo;

    public FamousInfoModel(Context context) {
        mIFamousInfo = RetrofitWrapper.getInstance().create(IFamousInfo.class);
    }

    public static FamousInfoModel getInstance(Context context){
        if(famousInfoModel == null) {
            famousInfoModel = new FamousInfoModel(context);
        }
        return famousInfoModel;
    }

    public Call<FamousInfo> queryLookUp(FamousInfoReq famousInfoReq) {
        Call<FamousInfo> infoCall = mIFamousInfo.getFamousResult(famousInfoReq.apiKey, famousInfoReq.keyword, famousInfoReq.page, famousInfoReq.rows);
        return infoCall;
    }
}
