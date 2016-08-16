package cn.wochu.wh.entity.search;

import java.util.List;

/**
 * project name：Warehouse
 * class describe：
 * create person：dayongxin
 * create time：16/6/21 下午4:10
 * alter person：dayongxin
 * alter time：16/6/21 下午4:10
 * alter remark：
 */
public class ThridOrderSearchEntity {
    @Override
    public String toString() {
        return "ThridOrderSearchEntity{" +
                "ORDERID=" + ORDERID +
                ", ORDERCODE='" + ORDERCODE + '\'' +
                ", SUMPRICE=" + SUMPRICE +
                ", GOODSNUMBER=" + GOODSNUMBER +
                ", STATUS='" + STATUS + '\'' +
                ", OPRNO='" + OPRNO + '\'' +
                ", ORDERSOURCE='" + ORDERSOURCE + '\'' +
                ", CREATEDATE='" + CREATEDATE + '\'' +
                ", DCJDORDERDETAILItem=" + DCJDORDERDETAILItem +
                '}';
    }

    /**
     * ORDERID : 112
     * ORDERCODE : 101004347265448619
     * SUMPRICE : 24.5
     * GOODSNUMBER : 4
     * STATUS : 0
     * OPRNO : 3a2f22f30
     * ORDERSOURCE : ELE
     * CREATEDATE : 2016-08-04T15:46:08
     * DCJDORDERDETAILItem : [{"ORDERDETAILID":528,"ORDERID":0,"GOODSCODE":"WOC000000936","GOODSNAME":"西红柿（650g以上）","GOODSNUMBER":1,"PRICE":4.9,"STATUS":"1","OPRNO":"3a2f22f30","LOCATIONCODE":"SBB02","CREATEDATE":"2016-08-04T15:46:09"},{"ORDERDETAILID":527,"ORDERID":0,"GOODSCODE":"WOC000004240","GOODSNAME":"带壳鲜毛豆2斤装","GOODSNUMBER":1,"PRICE":6.9,"STATUS":"1","OPRNO":"3a2f22f30","LOCATIONCODE":"X-123","CREATEDATE":"2016-08-04T15:46:09"},{"ORDERDETAILID":529,"ORDERID":0,"GOODSCODE":"WOC000001836","GOODSNAME":"黄瓜600g以上","GOODSNUMBER":1,"PRICE":2.9,"STATUS":"1","OPRNO":"3a2f22f30","LOCATIONCODE":"B0123","CREATEDATE":"2016-08-04T15:46:09"},{"ORDERDETAILID":530,"ORDERID":0,"GOODSCODE":"WOC000004027","GOODSNAME":"马陆夏黑葡萄800g","GOODSNUMBER":1,"PRICE":25.9,"STATUS":"1","OPRNO":"3a2f22f30","LOCATIONCODE":"空","CREATEDATE":"2016-08-04T15:46:09"}]
     */

    private int ORDERID;
    private String ORDERCODE;
    private double SUMPRICE;
    private int GOODSNUMBER;
    private String STATUS;
    private String OPRNO;
    private String ORDERSOURCE;
    private String CREATEDATE;
    /**
     * ORDERDETAILID : 528
     * ORDERID : 0
     * GOODSCODE : WOC000000936
     * GOODSNAME : 西红柿（650g以上）
     * GOODSNUMBER : 1
     * PRICE : 4.9
     * STATUS : 1
     * OPRNO : 3a2f22f30
     * LOCATIONCODE : SBB02
     * CREATEDATE : 2016-08-04T15:46:09
     */

    private List<DCJDORDERDETAILItemBean> DCJDORDERDETAILItem;

    public int getORDERID() {
        return ORDERID;
    }

    public void setORDERID(int ORDERID) {
        this.ORDERID = ORDERID;
    }

    public String getORDERCODE() {
        return ORDERCODE;
    }

    public void setORDERCODE(String ORDERCODE) {
        this.ORDERCODE = ORDERCODE;
    }

    public double getSUMPRICE() {
        return SUMPRICE;
    }

    public void setSUMPRICE(double SUMPRICE) {
        this.SUMPRICE = SUMPRICE;
    }

    public int getGOODSNUMBER() {
        return GOODSNUMBER;
    }

    public void setGOODSNUMBER(int GOODSNUMBER) {
        this.GOODSNUMBER = GOODSNUMBER;
    }

    public String getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS;
    }

    public String getOPRNO() {
        return OPRNO;
    }

    public void setOPRNO(String OPRNO) {
        this.OPRNO = OPRNO;
    }

    public String getORDERSOURCE() {
        return ORDERSOURCE;
    }

    public void setORDERSOURCE(String ORDERSOURCE) {
        this.ORDERSOURCE = ORDERSOURCE;
    }

    public String getCREATEDATE() {
        return CREATEDATE;
    }

    public void setCREATEDATE(String CREATEDATE) {
        this.CREATEDATE = CREATEDATE;
    }

    public List<DCJDORDERDETAILItemBean> getDCJDORDERDETAILItem() {
        return DCJDORDERDETAILItem;
    }

    public void setDCJDORDERDETAILItem(List<DCJDORDERDETAILItemBean> DCJDORDERDETAILItem) {
        this.DCJDORDERDETAILItem = DCJDORDERDETAILItem;
    }

    public static class DCJDORDERDETAILItemBean {
        private int ORDERDETAILID;
        private int ORDERID;
        private String GOODSCODE;
        private String GOODSNAME;
        private int GOODSNUMBER;
        private double PRICE;
        private String STATUS;
        private String OPRNO;
        private String LOCATIONCODE;
        private String CREATEDATE;

        public int getORDERDETAILID() {
            return ORDERDETAILID;
        }

        public void setORDERDETAILID(int ORDERDETAILID) {
            this.ORDERDETAILID = ORDERDETAILID;
        }

        public int getORDERID() {
            return ORDERID;
        }

        public void setORDERID(int ORDERID) {
            this.ORDERID = ORDERID;
        }

        public String getGOODSCODE() {
            return GOODSCODE;
        }

        public void setGOODSCODE(String GOODSCODE) {
            this.GOODSCODE = GOODSCODE;
        }

        public String getGOODSNAME() {
            return GOODSNAME;
        }

        public void setGOODSNAME(String GOODSNAME) {
            this.GOODSNAME = GOODSNAME;
        }

        public int getGOODSNUMBER() {
            return GOODSNUMBER;
        }

        public void setGOODSNUMBER(int GOODSNUMBER) {
            this.GOODSNUMBER = GOODSNUMBER;
        }

        public double getPRICE() {
            return PRICE;
        }

        public void setPRICE(double PRICE) {
            this.PRICE = PRICE;
        }

        public String getSTATUS() {
            return STATUS;
        }

        public void setSTATUS(String STATUS) {
            this.STATUS = STATUS;
        }

        public String getOPRNO() {
            return OPRNO;
        }

        public void setOPRNO(String OPRNO) {
            this.OPRNO = OPRNO;
        }

        public String getLOCATIONCODE() {
            return LOCATIONCODE;
        }

        public void setLOCATIONCODE(String LOCATIONCODE) {
            this.LOCATIONCODE = LOCATIONCODE;
        }

        public String getCREATEDATE() {
            return CREATEDATE;
        }

        public void setCREATEDATE(String CREATEDATE) {
            this.CREATEDATE = CREATEDATE;
        }
    }
}
