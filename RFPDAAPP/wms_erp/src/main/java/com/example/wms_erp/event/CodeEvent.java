package com.example.wms_erp.event;

/**
 * Created by Administrator on 2016/9/7.
 */
public class CodeEvent {
    private String Code;
    private int tag;

    public CodeEvent(String code, int tag) {
        Code = code;
        this.tag = tag;
    }

    public int getTag() {
        return tag;
    }

    public String getCode() {
        return Code;
    }
}
