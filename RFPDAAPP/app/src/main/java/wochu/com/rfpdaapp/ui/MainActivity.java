package wochu.com.rfpdaapp.ui;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.hdhe.uhf.entity.EPC;
import com.android.hdhe.uhf.reader.Tools;
import com.android.hdhe.uhf.reader.UhfReader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import wochu.com.rfpdaapp.R;
import wochu.com.rfpdaapp.receiver.ScreenStateReceiver;
import wochu.com.rfpdaapp.thread.ScanThread;
import wochu.com.rfpdaapp.utils.ScanUtil;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private UhfReader ufhReader;
    private ScreenStateReceiver screenStateReceiver;
    private IntentFilter filter;
    private Button btn_connect;
    private Button start_scan;
    private Thread thread;
    private EditText et_zBox;
    private ScanThread scanThread;

    private Handler mHandler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            if (msg.what == ScanThread.SCAN) {
                //data就是扫到的条码
                String data = msg.getData().getString("data");
//				Toast.makeText(getApplicationContext(), data, 0).show();
//                sortAndadd(listBarcode, data);
//                addListView();
//                eidtBarCount.setText(listBarcode.size() + "");
            }
        };
    };
    private Button btn_scanBarcode;
    private ScanUtil scanUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(0x80000000);
        setContentView(R.layout.activity_main);


        btn_connect = (Button) findViewById(R.id.btn_connect);
        start_scan = (Button) findViewById(R.id.btn_scan);
        et_zBox = (EditText) findViewById(R.id.et_zBox);
        btn_scanBarcode = (Button) findViewById(R.id.btn_scanBarcode);
        btn_connect.setOnClickListener(this);
        start_scan.setOnClickListener(this);
        try {
            scanThread = new ScanThread(mHandler);
        } catch (Exception e) {
            // 出现异常
            Toast.makeText(getApplicationContext(), "打开扫描头失败", Toast.LENGTH_SHORT)
                    .show();
            return;
            // e.printStackTrace();
        }
//        scanThread.start();


        scanUtil = new ScanUtil();
        scanUtil.setmOnScanListenner(new ScanUtil.onScanListenner() {
            @Override
            public void onScan(String code) {
                Toast.makeText(MainActivity.this,code,Toast.LENGTH_SHORT).show();
            }
        });
        initNFC();

    }

    private void initNFC() {
        //实例化uhf对象
        ufhReader = UhfReader.getInstance();
            if(ufhReader !=null) {
                ufhReader.setOutputPower(20);
            }else{
                Log.i("异常","ufhReader为null");
            }
        listEPC = new ArrayList<>();
        //监听屏幕亮灭的广播,达到省电的效果
        screenStateReceiver = new ScreenStateReceiver();
        filter = new IntentFilter();
        filter.addAction(Intent.ACTION_SCREEN_ON);
        filter.addAction(Intent.ACTION_SCREEN_OFF);

        thread = new InventoryThread();
        thread.start();

    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(screenStateReceiver,filter);
        if(ufhReader!=null){
           btn_connect.setEnabled(true);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(screenStateReceiver);
    }

    private boolean runFlag = true;
    private boolean startFlag = false;
    private boolean connectFlag = false;
    private ArrayList<EPC> listEPC;
    private ArrayList<Map<String, Object>> listMap;
    class InventoryThread extends Thread{
        private List<byte[]> epcList;

        @Override
        public void run() {
            super.run();
            Log.i("线程启动","run调用");
            //用循环来维护，防止退出
            while(runFlag){
                if(startFlag){
//					reader.stopInventoryMulti()
                    epcList = ufhReader.inventoryRealTime(); //实时盘存
                    Log.i("看扫描集合",epcList.size()+"");
                    if(epcList != null && !epcList.isEmpty()){
                        //播放提示音
//                        Util.play(1, 0);
                        for(byte[] epc:epcList){
                            String epcStr = Tools.Bytes2HexString(epc, epc.length);
                            addToList(listEPC, epcStr);
                        }
                    }
                    epcList = null ;
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }

            }
        }
    }

    //将读取的EPC添加到LISTVIEW
    private void addToList(final List<EPC> list, final String epc){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                et_zBox.setText(epc);
            Log.i("看条码",epc);
                //第一次读入数据
                if(list.isEmpty()){
                    EPC epcTag = new EPC();
                    epcTag.setEpc(epc);
                    epcTag.setCount(1);
                    list.add(epcTag);
                }else{
                    for(int i = 0; i < list.size(); i++){
                        EPC mEPC = list.get(i);
                        //list中有此EPC
                        if(epc.equals(mEPC.getEpc())){
                            mEPC.setCount(mEPC.getCount() + 1);
                            list.set(i, mEPC);
                            break;
                        }else if(i == (list.size() - 1)){
                            //list中没有此epc
                            EPC newEPC = new EPC();
                            newEPC.setEpc(epc);
                            newEPC.setCount(1);
                            list.add(newEPC);
                        }
                    }
                }
                //将数据添加到ListView
                listMap = new ArrayList<Map<String,Object>>();
                int idcount = 1;
                for(EPC epcdata:list){
                    Map<String, Object> map = new HashMap<String, Object>();
                    map.put("ID", idcount);
                    map.put("EPC", epcdata.getEpc());
                    Log.i("EPC",epcdata.getEpc());
                    map.put("COUNT", epcdata.getCount());
                    idcount++;
                    listMap.add(map);
                }
//                listViewData.setAdapter(new SimpleAdapter(MainActivity.this,
//                        listMap, R.layout.listview_item,
//                        new String[]{"ID", "EPC", "COUNT"},
//                        new int[]{R.id.textView_id, R.id.textView_epc, R.id.textView_count}));
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_connect:
                byte[] versionBytes = ufhReader.getFirmware();
                if(versionBytes!=null){
                    btn_connect.setEnabled(false);
                }
                break;
            case R.id.btn_scan:
                if(!startFlag){
                    startFlag = true ;
//                    start_scan.setText(R.string.stop_inventory);
                }else{
                    startFlag = false;
//                    start_scan.setText(R.string.inventory);
                }
        }

    }

    @Override
    protected void onDestroy() {

        super.onDestroy();
     runFlag=false;
        if(ufhReader!=null) {
            ufhReader.close();
            ufhReader=null;

        }

    }

long exitSytemTime;
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_HOME) {
            //按下home键扫描
//            scanThread.scan();
            scanUtil.scan();
        }

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            //按两次返回键退出
            if (System.currentTimeMillis() - exitSytemTime > 2000) {
                Toast.makeText(getApplicationContext(), "再按一次退出",
                        Toast.LENGTH_SHORT).show();
                exitSytemTime = System.currentTimeMillis();
                return true;
            } else {
                finish();
            }

        }

        return super.onKeyDown(keyCode, event);
    }
}
