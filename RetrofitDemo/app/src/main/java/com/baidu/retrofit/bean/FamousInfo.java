package com.baidu.retrofit.bean;

import java.util.List;

/**
 * Created by lizhixian on 16/5/8.
 */
public class FamousInfo {

    private int total;
    private int error_code;
    private String reason;
    private List<ResultEntity> result;


    public static class ResultEntity {
        private String famous_name;
        private String famous_saying;

        public void setFamous_name(String famous_name) {
            this.famous_name = famous_name;
        }

        public void setFamous_saying(String famous_saying) {
            this.famous_saying = famous_saying;
        }

        public String getFamous_name() {
            return famous_name;
        }

        public String getFamous_saying() {
            return famous_saying;
        }
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public List<ResultEntity> getResult() {
        return result;
    }

    public void setResult(List<ResultEntity> result) {
        this.result = result;
    }
}
