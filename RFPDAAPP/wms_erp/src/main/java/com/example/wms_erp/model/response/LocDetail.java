package com.example.wms_erp.model.response;

/**
 * 货位查询实体类
 * Created by qianpeng on 2016/9/18.
 */
public class LocDetail {

    /**
     * LOCATIONINVENTORYID : 0
     * GOODSBATCHCODE : null
     * INVGOODSBATCHCODE : null
     * INVSTATUS : 1
     * QTY : 77
     * GOODSCODE : null
     * GOODSNAME : null
     * INVGOODSCODE : 0156010594
     * INVGOODSNAME : 桂冠虾味球
     * INVUNITNAME : 包
     * LOCATIONCODE : LK5C30
     * GOODSID : 7030
     */

    private int LOCATIONINVENTORYID;
    private String GOODSBATCHCODE;
    private String INVGOODSBATCHCODE;
    private String INVSTATUS;
    private int QTY;
    private String GOODSCODE;
    private String GOODSNAME;
    private String INVGOODSCODE;
    private String INVGOODSNAME;
    private String INVUNITNAME;
    private String LOCATIONCODE;
    private String GOODSID;
    private String FIRSTDATE;
    private String LASTDATE;

    public String getFIRSTDATE() {
        return FIRSTDATE;
    }

    public void setFIRSTDATE(String FIRSTDATE) {
        this.FIRSTDATE = FIRSTDATE;
    }

    public String getLASTDATE() {
        return LASTDATE;
    }

    public void setLASTDATE(String LASTDATE) {
        this.LASTDATE = LASTDATE;
    }

    public int getLOCATIONINVENTORYID() {
        return LOCATIONINVENTORYID;
    }

    public void setLOCATIONINVENTORYID(int LOCATIONINVENTORYID) {
        this.LOCATIONINVENTORYID = LOCATIONINVENTORYID;
    }

    public String getGOODSBATCHCODE() {
        return GOODSBATCHCODE;
    }

    public void setGOODSBATCHCODE(String GOODSBATCHCODE) {
        this.GOODSBATCHCODE = GOODSBATCHCODE;
    }

    public String getINVGOODSBATCHCODE() {
        return INVGOODSBATCHCODE;
    }

    public void setINVGOODSBATCHCODE(String INVGOODSBATCHCODE) {
        this.INVGOODSBATCHCODE = INVGOODSBATCHCODE;
    }

    public String getINVSTATUS() {
        return INVSTATUS;
    }

    public void setINVSTATUS(String INVSTATUS) {
        this.INVSTATUS = INVSTATUS;
    }

    public int getQTY() {
        return QTY;
    }

    public void setQTY(int QTY) {
        this.QTY = QTY;
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

    public String getINVGOODSCODE() {
        return INVGOODSCODE;
    }

    public void setINVGOODSCODE(String INVGOODSCODE) {
        this.INVGOODSCODE = INVGOODSCODE;
    }

    public String getINVGOODSNAME() {
        return INVGOODSNAME;
    }

    public void setINVGOODSNAME(String INVGOODSNAME) {
        this.INVGOODSNAME = INVGOODSNAME;
    }

    public String getINVUNITNAME() {
        return INVUNITNAME;
    }

    public void setINVUNITNAME(String INVUNITNAME) {
        this.INVUNITNAME = INVUNITNAME;
    }

    public String getLOCATIONCODE() {
        return LOCATIONCODE;
    }

    public void setLOCATIONCODE(String LOCATIONCODE) {
        this.LOCATIONCODE = LOCATIONCODE;
    }

    public String getGOODSID() {
        return GOODSID;
    }

    public void setGOODSID(String GOODSID) {
        this.GOODSID = GOODSID;
    }
}
