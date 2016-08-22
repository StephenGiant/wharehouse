package com.example.wms_erp.model.response;

/**
 * Created by Administrator on 2016/8/22.
 */
public class UserInfo {

    /**
     * USERID : 3
     * USERCODE : sa
     * PASSWORD : 8
     * USERNAME : 开发者
     * WAREHOUSEID : 0
     * WAREHOUSECODE : null
     * WAREHOUSENAME : null
     * EntityState : 3
     * Selected : false
     */

    private int USERID;
    private String USERCODE;
    private String PASSWORD;
    private String USERNAME;
    private int WAREHOUSEID;
    private Object WAREHOUSECODE;
    private Object WAREHOUSENAME;
    private int EntityState;
    private boolean Selected;

    public int getUSERID() {
        return USERID;
    }

    public void setUSERID(int USERID) {
        this.USERID = USERID;
    }

    public String getUSERCODE() {
        return USERCODE;
    }

    public void setUSERCODE(String USERCODE) {
        this.USERCODE = USERCODE;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }

    public String getUSERNAME() {
        return USERNAME;
    }

    public void setUSERNAME(String USERNAME) {
        this.USERNAME = USERNAME;
    }

    public int getWAREHOUSEID() {
        return WAREHOUSEID;
    }

    public void setWAREHOUSEID(int WAREHOUSEID) {
        this.WAREHOUSEID = WAREHOUSEID;
    }

    public Object getWAREHOUSECODE() {
        return WAREHOUSECODE;
    }

    public void setWAREHOUSECODE(Object WAREHOUSECODE) {
        this.WAREHOUSECODE = WAREHOUSECODE;
    }

    public Object getWAREHOUSENAME() {
        return WAREHOUSENAME;
    }

    public void setWAREHOUSENAME(Object WAREHOUSENAME) {
        this.WAREHOUSENAME = WAREHOUSENAME;
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
