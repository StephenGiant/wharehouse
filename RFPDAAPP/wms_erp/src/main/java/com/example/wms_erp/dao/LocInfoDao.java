package com.example.wms_erp.dao;

import com.example.wms_erp.model.db.LocInfoTable;
import com.example.wms_erp.model.db.LocInfoTable_Table;
import com.example.wms_erp.model.response.LocInfo;
import com.raizlabs.android.dbflow.sql.language.Delete;
import com.raizlabs.android.dbflow.sql.language.Select;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/9/5.
 */
public class LocInfoDao {
    /**
     * 将网络数据写入数据库中
     * @param datas
     */
    public static void addLocInfos(List<LocInfo> datas){
    Delete.table(LocInfoTable.class);
    for(LocInfo info:datas){
        LocInfoTable locInfoTable = new LocInfoTable();
        locInfoTable.setGOODSBATCHCODE(info.getGOODSBATCHCODE());
        locInfoTable.setINVQTY(info.getINVQTY());
        locInfoTable.setLOCATIONCODE(info.getLOCATIONCODE());
        locInfoTable.setPURUNITNAME(info.getPURUNITNAME());
        locInfoTable.setUNITNAME(info.getUNITNAME());
        locInfoTable.setPURUNITQTY(info.getPURUNITQTY());
        locInfoTable.setGOODSNAME(info.getGOODSNAME());
        locInfoTable.setGOODSCODE(info.getGOODSCODE());
        locInfoTable.save();
    }

}

    /**
     * 根据查询条件拿出数据
     * @return
     */
    public static List<LocInfo>  getLocInfos(String locCode,String goodsCode){
        ArrayList<LocInfo> results = new ArrayList<>();

        List<LocInfoTable> locInfoTables = new Select().from(LocInfoTable.class).where(LocInfoTable_Table.LOCATIONCODE.eq("")).and(LocInfoTable_Table.GOODSBATCHCODE.eq("")).queryList();
        for(LocInfoTable infoTable:locInfoTables){
            long id = infoTable.getId();//获取索引

            LocInfo locInfo = new LocInfo();
            //设置参数值
            locInfo.setValues(infoTable);
            results.add(locInfo);
        }
        return results;
    }


}
