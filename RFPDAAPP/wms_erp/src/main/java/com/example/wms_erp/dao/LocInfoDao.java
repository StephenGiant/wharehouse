package com.example.wms_erp.dao;

import android.database.Cursor;
import android.util.Log;


//import com.example.wms_erp.model.db.LocInfoTable_Table;
import com.example.wms_erp.model.response.LocInfo;
import com.example.wms_erp.model.response.LocInfo_Table;
import com.raizlabs.android.dbflow.sql.language.Delete;
import com.raizlabs.android.dbflow.sql.language.From;
import com.raizlabs.android.dbflow.sql.language.Select;
import com.raizlabs.android.dbflow.sql.language.Update;

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
    Delete.table(LocInfo.class);
    for(LocInfo info:datas){
     info.save();
    }

}
    public static void updateInfos(List<LocInfo> datas){
        for(LocInfo info:datas){
            info.update();
        }
    }
    public static void updateByGoodsBatchCode(LocInfo locInfo){
//        LocInfo info = new Select().from(LocInfo.class).where(LocInfo_Table.GOODSBATCHCODE.eq(locInfo.getGOODSBATCHCODE())).querySingle();
//        info = locInfo;
        locInfo.update();

    }

    /**
     * 根据查询条件拿出数据
     * @return
     */
    public static List<LocInfo>  getLocInfos(String locCode,String goodsCode){
//        ArrayList<LocInfo> results = new ArrayList<>();
        List<LocInfo> locInfoTables = new Select().from(LocInfo.class).where(LocInfo_Table.LOCATIONCODE.eq(locCode)).and(LocInfo_Table.GOODSCODE.eq(goodsCode)).queryList();
//        List<LocInfoTable> from = new Select().from(LocInfoTable.class).queryList();
//        if(locInfoTables!=null) {
//            Log.i("看查询结果", locInfoTables.size() + "");
////            Log.i("看查询结果", from.size() + "");
//        }else{
//            Log.i("看查询结果", "未查询到");
//        }
//        for(LocInfoTable infoTable:locInfoTables){
//            long id = infoTable.getId();//获取索引
//
//            LocInfo locInfo = new LocInfo();
//            //设置参数值
//            locInfo.setValues(infoTable);
//            results.add(locInfo);
//        }
        return locInfoTables;
    }
//public static void updateLocInfos(List<LocInfo> datas){
////   for(LocInfo info:datas){
////       LocInfoTable infoTable = new LocInfoTable();
////       infoTable.update();
////   }
//}

}
