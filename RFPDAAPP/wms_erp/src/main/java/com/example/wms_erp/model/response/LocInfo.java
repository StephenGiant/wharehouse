package com.example.wms_erp.model.response;

import com.example.wms_erp.model.db.LocInfoTable;

import java.util.List;

/**
 * Created by Administrator on 2016/9/5.
 */
public class LocInfo {


    /**
     * GOODSCODE : 0101010022
     * GOODSNAME : 友加白胡椒粉
     * LOCATIONINVENTORYID : 130657
     * LOCATIONID : 8141
     * LOCATIONCODE : CK1B39
     * GOODSBATCHCODE : 010101002260304120
     * GOODSID : 0
     * UNITNAME : 瓶
     * WAREHOUSEID : 0
     * CELLNO : 常温原料
     * PRODUCTIONDATE : 60304
     * STORAGEDATE : 160326
     * EXPIRYDAYS : 120
     * QTY : 0
     * QTYchange : 0
     * INVQTY : 2058
     * PURUNITQTY : 20
     * BuyQty : 102
     * StoreQty : 18
     * PURUNITNAME : 箱
     * CREATER : null
     * STATUS : 1
     * MAXBATCH : null
     * MINBATCH : null
     * QUALITYSTATUS : null
     * GOODS_SN : null
     * CHQTY : 0
     */

    private String GOODSCODE;
    private String GOODSNAME;
    private int LOCATIONINVENTORYID;
    private int LOCATIONID;
    private String LOCATIONCODE;
    private String GOODSBATCHCODE;
    private int GOODSID;
    private String UNITNAME;
    private int WAREHOUSEID;
    private String CELLNO;
    private String PRODUCTIONDATE;
    private String STORAGEDATE;
    private int EXPIRYDAYS;
    private int QTY;
    private int QTYchange;
    private double INVQTY;
    private int PURUNITQTY;
    private int BuyQty;
    private int StoreQty;
    private String PURUNITNAME;
    private String CREATER;
    private int STATUS;
    private String MAXBATCH;
    private String MINBATCH;
    private String QUALITYSTATUS;
    private String GOODS_SN;
    private int CHQTY;

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

    public int getLOCATIONINVENTORYID() {
        return LOCATIONINVENTORYID;
    }

    public void setLOCATIONINVENTORYID(int LOCATIONINVENTORYID) {
        this.LOCATIONINVENTORYID = LOCATIONINVENTORYID;
    }

    public int getLOCATIONID() {
        return LOCATIONID;
    }

    public void setLOCATIONID(int LOCATIONID) {
        this.LOCATIONID = LOCATIONID;
    }

    public String getLOCATIONCODE() {
        return LOCATIONCODE;
    }

    public void setLOCATIONCODE(String LOCATIONCODE) {
        this.LOCATIONCODE = LOCATIONCODE;
    }

    public String getGOODSBATCHCODE() {
        return GOODSBATCHCODE;
    }

    public void setGOODSBATCHCODE(String GOODSBATCHCODE) {
        this.GOODSBATCHCODE = GOODSBATCHCODE;
    }

    public int getGOODSID() {
        return GOODSID;
    }

    public void setGOODSID(int GOODSID) {
        this.GOODSID = GOODSID;
    }

    public String getUNITNAME() {
        return UNITNAME;
    }

    public void setUNITNAME(String UNITNAME) {
        this.UNITNAME = UNITNAME;
    }

    public int getWAREHOUSEID() {
        return WAREHOUSEID;
    }

    public void setWAREHOUSEID(int WAREHOUSEID) {
        this.WAREHOUSEID = WAREHOUSEID;
    }

    public String getCELLNO() {
        return CELLNO;
    }

    public void setCELLNO(String CELLNO) {
        this.CELLNO = CELLNO;
    }

    public String getPRODUCTIONDATE() {
        return PRODUCTIONDATE;
    }

    public void setPRODUCTIONDATE(String PRODUCTIONDATE) {
        this.PRODUCTIONDATE = PRODUCTIONDATE;
    }

    public String getSTORAGEDATE() {
        return STORAGEDATE;
    }

    public void setSTORAGEDATE(String STORAGEDATE) {
        this.STORAGEDATE = STORAGEDATE;
    }

    public int getEXPIRYDAYS() {
        return EXPIRYDAYS;
    }

    public void setEXPIRYDAYS(int EXPIRYDAYS) {
        this.EXPIRYDAYS = EXPIRYDAYS;
    }

    public int getQTY() {
        return QTY;
    }

    public void setQTY(int QTY) {
        this.QTY = QTY;
    }

    public int getQTYchange() {
        return QTYchange;
    }

    public void setQTYchange(int QTYchange) {
        this.QTYchange = QTYchange;
    }

    public double getINVQTY() {
        return INVQTY;
    }

    public void setINVQTY(double INVQTY) {
        this.INVQTY = INVQTY;
    }

    public int getPURUNITQTY() {
        return PURUNITQTY;
    }

    public void setPURUNITQTY(int PURUNITQTY) {
        this.PURUNITQTY = PURUNITQTY;
    }

    public int getBuyQty() {
        return BuyQty;
    }

    public void setBuyQty(int BuyQty) {
        this.BuyQty = BuyQty;
    }

    public int getStoreQty() {
        return StoreQty;
    }

    public void setStoreQty(int StoreQty) {
        this.StoreQty = StoreQty;
    }

    public String getPURUNITNAME() {
        return PURUNITNAME;
    }

    public void setPURUNITNAME(String PURUNITNAME) {
        this.PURUNITNAME = PURUNITNAME;
    }

    public String getCREATER() {
        return CREATER;
    }

    public void setCREATER(String CREATER) {
        this.CREATER = CREATER;
    }

    public int getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(int STATUS) {
        this.STATUS = STATUS;
    }

    public String getMAXBATCH() {
        return MAXBATCH;
    }

    public void setMAXBATCH(String MAXBATCH) {
        this.MAXBATCH = MAXBATCH;
    }

    public String getMINBATCH() {
        return MINBATCH;
    }

    public void setMINBATCH(String MINBATCH) {
        this.MINBATCH = MINBATCH;
    }

    public String getQUALITYSTATUS() {
        return QUALITYSTATUS;
    }

    public void setQUALITYSTATUS(String QUALITYSTATUS) {
        this.QUALITYSTATUS = QUALITYSTATUS;
    }

    public String getGOODS_SN() {
        return GOODS_SN;
    }

    public void setGOODS_SN(String GOODS_SN) {
        this.GOODS_SN = GOODS_SN;
    }

    public int getCHQTY() {
        return CHQTY;
    }

    public void setCHQTY(int CHQTY) {
        this.CHQTY = CHQTY;
    }

    public void setValues(LocInfoTable tableinfo){
      setGOODSCODE(tableinfo.getGOODSCODE());
        setGOODSNAME(tableinfo.getGOODSNAME());
        setPURUNITQTY(tableinfo.getPURUNITQTY());
        setBuyQty(tableinfo.getBuyQty());

    }

    public boolean isNeed(String locCode,String goodsCode){
        return LOCATIONCODE.equals(locCode)&&GOODSCODE.equals(goodsCode);
    }
}
