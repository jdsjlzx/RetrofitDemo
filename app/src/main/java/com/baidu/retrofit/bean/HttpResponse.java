package com.baidu.retrofit.bean;

/**
 * Created by Lzx on 2016/8/17.
 */

public class HttpResponse<T> {

    //{"ret":200,"data":["uploads\/avatar\/e3e61c7bc6a2c815720ca9bb18229424.png"],"msg":""}
    public T data;
    public int ret;
    public String msg;

}
