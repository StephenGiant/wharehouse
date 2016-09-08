package com.example.wms_erp.model.db;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

/**
 * Created by Administrator on 2016/9/5.
 */
@Table(database = LocInfoDB.class)
public class LocInfoTable extends BaseModel{
    @PrimaryKey(autoincrement = true)
    long id;
    @Column
    private String GOODSCODE;
    @Column
    private String GOODSNAME;
    @Column
    private int LOCATIONINVENTORYID;
    @Column
    private int LOCATIONID;
    @Column
    private String LOCATIONCODE;
    @Column
    private String GOODSBATCHCODE;
    @Column
    private int GOODSID;
    @Column
    private String UNITNAME;
    @Column
    private int WAREHOUSEID;
    @Column
    private String CELLNO;
    @Column
    private String PRODUCTIONDATE;
    @Column
    private String STORAGEDATE;
    @Column
    private int EXPIRYDAYS;
    @Column
    private double QTY;
    @Column
    private int QTYchange;
    @Column
    private double INVQTY;
    @Column
    private int PURUNITQTY;
    @Column
    private double BuyQty;
    @Column
    private double StoreQty;
    @Column
    private String PURUNITNAME;
    @Column
    private String CREATER;
    @Column
    private int STATUS;
    @Column
    private String MAXBATCH;
    @Column
    private String MINBATCH;
    @Column
    private String QUALITYSTATUS;
    @Column
    private String GOODS_SN;
    @Column
    private double CHQTY;

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

    public int getGOODSID() {
        return GOODSID;
    }

    public void setGOODSID(int GOODSID) {
        this.GOODSID = GOODSID;
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

    public double getQTY() {
        return QTY;
    }

    public void setQTY(double QTY) {
        this.QTY = QTY;
    }

    public int getQTYchange() {
        return QTYchange;
    }

    public void setQTYchange(int QTYchange) {
        this.QTYchange = QTYchange;
    }

    public double getStoreQty() {
        return StoreQty;
    }

    public void setStoreQty(double storeQty) {
        StoreQty = storeQty;
    }

    public double getBuyQty() {
        return BuyQty;
    }

    public void setBuyQty(double buyQty) {
        BuyQty = buyQty;
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

    public double getCHQTY() {
        return CHQTY;
    }

    public void setCHQTY(double CHQTY) {
        this.CHQTY = CHQTY;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPURUNITNAME() {
        return PURUNITNAME;
    }

    public void setPURUNITNAME(String PURUNITNAME) {
        this.PURUNITNAME = PURUNITNAME;
    }

    public int getPURUNITQTY() {
        return PURUNITQTY;
    }

    public void setPURUNITQTY(int PURUNITQTY) {
        this.PURUNITQTY = PURUNITQTY;
    }

    public double getINVQTY() {
        return INVQTY;
    }

    public void setINVQTY(double INVQTY) {
        this.INVQTY = INVQTY;
    }

    public int getWAREHOUSEID() {
        return WAREHOUSEID;
    }

    public void setWAREHOUSEID(int WAREHOUSEID) {
        this.WAREHOUSEID = WAREHOUSEID;
    }

    public String getUNITNAME() {
        return UNITNAME;
    }

    public void setUNITNAME(String UNITNAME) {
        this.UNITNAME = UNITNAME;
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







    @Override
    public void save() {
        super.save();
    }
}
