package com.baidu.retrofit.bean;

/**
 * Created by lizhixian on 16/5/10.
 */
public class IpInfo {
    //{"code":0,"data":{"country":"\u7f8e\u56fd","country_id":"US","area":"","area_id":"","region":"","region_id":"","city":"","city_id":"","county":"","county_id":"","isp":"","isp_id":"","ip":"63.223.108.42"}}
    //变量的名字要与接口中的对应
    public int code;//对于code字段
    public Info data;//对应data字段

    public static class Info {
        public String country;
        public String country_id;
        public String area;
        public String area_id;
        public String ip;
    }
}
