package com.example.wms_erp.model;

/**
 * Created by Administrator on 2016/8/19.
 */
public class BaseBean<T> {
    private String RESULT;
    private String MESSAGE;
    private T  DATA;

    public String getRESULT() {
        return RESULT;
    }

    public void setRESULT(String RESULT) {
        this.RESULT = RESULT;
    }

    public String getMESSAGE() {
        return MESSAGE;
    }

    public void setMESSAGE(String MESSAGE) {
        this.MESSAGE = MESSAGE;
    }

    public T getDATA() {
        return DATA;
    }

    public void setDATA(T DATA) {
        this.DATA = DATA;
    }
}
