package com.example.wms_erp.model;

import java.util.List;

/**
 * Created by Administrator on 2016/10/26.
 */

public class TiangouBase<T> {

    /**
     * status : true
     * tngou : [{"description":"\u2026\u2026","id":1,"keywords":"\u2026\u2026","name":"性感美女","seq":1,"title":"\u2026\u2026"},{"description":"\u2026\u2026","id":2,"keywords":"\u2026\u2026","name":"韩日美女","seq":2,"title":"\u2026\u2026"},{"description":"\u2026\u2026","id":3,"keywords":"\u2026\u2026","name":"丝袜美腿","seq":3,"title":"\u2026\u2026"},{"description":"\u2026\u2026","id":4,"keywords":"\u2026\u2026","name":"美女照片","seq":4,"title":"\u2026\u2026"},{"description":"\u2026\u2026","id":5,"keywords":"\u2026\u2026","name":"美女写真","seq":5,"title":"\u2026\u2026"},{"description":"\u2026\u2026","id":6,"keywords":"\u2026\u2026","name":"清纯美女","seq":6,"title":"\u2026\u2026"},{"description":"\u2026\u2026","id":2,"keywords":"\u2026\u2026","name":"性感车模","seq":7,"title":"\u2026\u2026"}]
     */

    private boolean status;
    /**
     * description : ……
     * id : 1
     * keywords : ……
     * name : 性感美女
     * seq : 1
     * title : ……
     */

    private T tngou;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public T getTngou() {
        return tngou;
    }

    public void setTngou(T tngou) {
        this.tngou = tngou;
    }
}
