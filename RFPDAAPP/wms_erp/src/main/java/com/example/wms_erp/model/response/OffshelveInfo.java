package com.example.wms_erp.model.response;

/**
 * Created by Administrator on 2016/9/28.
 */

public class OffshelveInfo {
    public double QTY;//计划下架数
    public double QTYEXCE;//实际下架数
    public double INVQTY;//库存数
    public String GOODSNAME;//商品名称
    public String GOODSCODE;//商品编号
    public String GOODSBATCHCODE;//商品批次号
    public String LOCATIONCODE;//货位
    public String UNITNAME;//单位
    public String OFFSHELVESID;//下架指令号，提交的时候用
    public boolean Selected;
    public int EntityState;
    public String BARCODE;
    public String REMARK;
    public String EDITOR;
    public String CREATOR;
    public int FLAG;
    public String GOODSID;
    public String WAREHOUSECODE;
    public String WAREHOUSEID;
    public String LOCATIONID;
    public int BATCHNO;
    public String CELLNO;//库位
    private double PURUNITQTY;

    public String getCELLNO() {
        return CELLNO;
    }

    public void setCELLNO(String CELLNO) {
        this.CELLNO = CELLNO;
    }

    public double getPURUNITQTY() {
        return PURUNITQTY;
    }

    public void setPURUNITQTY(double PURUNITQTY) {
        this.PURUNITQTY = PURUNITQTY;
    }

    public double getQTY() {
        return QTY;
    }

    public void setQTY(double QTY) {
        this.QTY = QTY;
    }

    public double getQTYEXCE() {
        return QTYEXCE;
    }

    public void setQTYEXCE(double QTYEXCE) {
        this.QTYEXCE = QTYEXCE;
    }

    public double getINVQTY() {
        return INVQTY;
    }

    public void setINVQTY(double INVQTY) {
        this.INVQTY = INVQTY;
    }

    public String getGOODSNAME() {
        return GOODSNAME;
    }

    public void setGOODSNAME(String GOODSNAME) {
        this.GOODSNAME = GOODSNAME;
    }

    public String getGOODSCODE() {
        return GOODSCODE;
    }

    public void setGOODSCODE(String GOODSCODE) {
        this.GOODSCODE = GOODSCODE;
    }

    public String getGOODSBATCHCODE() {
        return GOODSBATCHCODE;
    }

    public void setGOODSBATCHCODE(String GOODSBATCHCODE) {
        this.GOODSBATCHCODE = GOODSBATCHCODE;
    }

    public String getLOCATIONCODE() {
        return LOCATIONCODE;
    }

    public void setLOCATIONCODE(String LOCATIONCODE) {
        this.LOCATIONCODE = LOCATIONCODE;
    }

    public String getUNITNAME() {
        return UNITNAME;
    }

    public void setUNITNAME(String UNITNAME) {
        this.UNITNAME = UNITNAME;
    }

    public String getOFFSHELVESID() {
        return OFFSHELVESID;
    }

    public void setOFFSHELVESID(String OFFSHELVESID) {
        this.OFFSHELVESID = OFFSHELVESID;
    }

    public boolean isSelected() {
        return Selected;
    }

    public void setSelected(boolean selected) {
        Selected = selected;
    }

    public int getEntityState() {
        return EntityState;
    }

    public void setEntityState(int entityState) {
        EntityState = entityState;
    }

    public String getBARCODE() {
        return BARCODE;
    }

    public void setBARCODE(String BARCODE) {
        this.BARCODE = BARCODE;
    }

    public String getREMARK() {
        return REMARK;
    }

    public void setREMARK(String REMARK) {
        this.REMARK = REMARK;
    }

    public String getEDITOR() {
        return EDITOR;
    }

    public void setEDITOR(String EDITOR) {
        this.EDITOR = EDITOR;
    }

    public String getCREATOR() {
        return CREATOR;
    }

    public void setCREATOR(String CREATOR) {
        this.CREATOR = CREATOR;
    }

    public int getFLAG() {
        return FLAG;
    }

    public void setFLAG(int FLAG) {
        this.FLAG = FLAG;
    }

    public String getGOODSID() {
        return GOODSID;
    }

    public void setGOODSID(String GOODSID) {
        this.GOODSID = GOODSID;
    }

    public String getWAREHOUSECODE() {
        return WAREHOUSECODE;
    }

    public void setWAREHOUSECODE(String WAREHOUSECODE) {
        this.WAREHOUSECODE = WAREHOUSECODE;
    }

    public String getWAREHOUSEID() {
        return WAREHOUSEID;
    }

    public void setWAREHOUSEID(String WAREHOUSEID) {
        this.WAREHOUSEID = WAREHOUSEID;
    }

    public String getLOCATIONID() {
        return LOCATIONID;
    }

    public void setLOCATIONID(String LOCATIONID) {
        this.LOCATIONID = LOCATIONID;
    }

    public int getBATCHNO() {
        return BATCHNO;
    }

    public void setBATCHNO(int BATCHNO) {
        this.BATCHNO = BATCHNO;
    }
}
