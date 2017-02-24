package com.example.wms_erp.model.response;

/**
 * Created by Administrator on 2017/1/4.
 */

public class BatchCheckResult {


    /**
     * LOCATIONGOODSID : 0
     * LOCATIONID : 0
     * LOCATIONCODE : null
     * GOODSBATCHCODE : 010136003060912540
     * GOODSID : 0
     * GOODSCODE : null
     * GOODSNAME : 毛豆仁
     * WAREHOUSEID : 0
     * WAREHOUSECODE : null
     * CELLNO : null
     * QTY : 0.0
     * CREATER : null
     * UNITNAME : 包
     * INVQTY : 1555.0
     * INVSTATUS : 0
     * TIPNUMBER : 0
     * PURUNITQTY : 0.0
     * PURUNITNAME : null
     * QUALITYSTATUS : 0
     * ISPURUNITNAME : null
     * GOODSSPEC : null
     * MAXQTY : 0.0
     * EntityState : 3
     * Selected : false
     */

    private int LOCATIONGOODSID;
    private int LOCATIONID;
    private String LOCATIONCODE;
    private String GOODSBATCHCODE;
    private int GOODSID;
    private String GOODSCODE;
    private String GOODSNAME;
    private int WAREHOUSEID;
    private String WAREHOUSECODE;
    private String CELLNO;
    private double QTY;
    private String CREATER;
    private String UNITNAME;
    private double INVQTY;
    private int INVSTATUS;
    private int TIPNUMBER;
    private double PURUNITQTY;
    private String PURUNITNAME;
    private String QUALITYSTATUS;
    private String ISPURUNITNAME;
    private String GOODSSPEC;
    private double MAXQTY;
    private int EntityState;
    private boolean Selected;

    public int getLOCATIONGOODSID() {
        return LOCATIONGOODSID;
    }

    public void setLOCATIONGOODSID(int LOCATIONGOODSID) {
        this.LOCATIONGOODSID = LOCATIONGOODSID;
    }

    public int getLOCATIONID() {
        return LOCATIONID;
    }

    public void setLOCATIONID(int LOCATIONID) {
        this.LOCATIONID = LOCATIONID;
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



    public String getGOODSNAME() {
        return GOODSNAME;
    }

    public void setGOODSNAME(String GOODSNAME) {
        this.GOODSNAME = GOODSNAME;
    }

    public int getWAREHOUSEID() {
        return WAREHOUSEID;
    }

    public void setWAREHOUSEID(int WAREHOUSEID) {
        this.WAREHOUSEID = WAREHOUSEID;
    }


    public double getQTY() {
        return QTY;
    }

    public void setQTY(double QTY) {
        this.QTY = QTY;
    }



    public void setUNITNAME(String UNITNAME) {
        this.UNITNAME = UNITNAME;
    }

    public double getINVQTY() {
        return INVQTY;
    }

    public void setINVQTY(double INVQTY) {
        this.INVQTY = INVQTY;
    }

    public int getINVSTATUS() {
        return INVSTATUS;
    }

    public void setINVSTATUS(int INVSTATUS) {
        this.INVSTATUS = INVSTATUS;
    }

    public int getTIPNUMBER() {
        return TIPNUMBER;
    }

    public void setTIPNUMBER(int TIPNUMBER) {
        this.TIPNUMBER = TIPNUMBER;
    }

    public double getPURUNITQTY() {
        return PURUNITQTY;
    }

    public void setPURUNITQTY(double PURUNITQTY) {
        this.PURUNITQTY = PURUNITQTY;
    }



    public void setQUALITYSTATUS(String QUALITYSTATUS) {
        this.QUALITYSTATUS = QUALITYSTATUS;
    }

    public Object getISPURUNITNAME() {
        return ISPURUNITNAME;
    }

    public String getLOCATIONCODE() {
        return LOCATIONCODE;
    }

    public void setLOCATIONCODE(String LOCATIONCODE) {
        this.LOCATIONCODE = LOCATIONCODE;
    }

    public String getGOODSCODE() {
        return GOODSCODE;
    }

    public void setGOODSCODE(String GOODSCODE) {
        this.GOODSCODE = GOODSCODE;
    }

    public String getCELLNO() {
        return CELLNO;
    }

    public void setCELLNO(String CELLNO) {
        this.CELLNO = CELLNO;
    }

    public String getWAREHOUSECODE() {
        return WAREHOUSECODE;
    }

    public void setWAREHOUSECODE(String WAREHOUSECODE) {
        this.WAREHOUSECODE = WAREHOUSECODE;
    }

    public String getCREATER() {
        return CREATER;
    }

    public void setCREATER(String CREATER) {
        this.CREATER = CREATER;
    }

    public String getUNITNAME() {
        return UNITNAME;
    }

    public String getPURUNITNAME() {
        return PURUNITNAME;
    }

    public void setPURUNITNAME(String PURUNITNAME) {
        this.PURUNITNAME = PURUNITNAME;
    }

    public String getQUALITYSTATUS() {
        return QUALITYSTATUS;
    }

    public String getGOODSSPEC() {
        return GOODSSPEC;
    }

    public void setGOODSSPEC(String GOODSSPEC) {
        this.GOODSSPEC = GOODSSPEC;
    }

    public void setISPURUNITNAME(String ISPURUNITNAME) {
        this.ISPURUNITNAME = ISPURUNITNAME;
    }

    public double getMAXQTY() {
        return MAXQTY;
    }

    public void setMAXQTY(double MAXQTY) {
        this.MAXQTY = MAXQTY;
    }

    public int getEntityState() {
        return EntityState;
    }

    public void setEntityState(int EntityState) {
        this.EntityState = EntityState;
    }

    public boolean isSelected() {
        return Selected;
    }

    public void setSelected(boolean Selected) {
        this.Selected = Selected;
    }
}
