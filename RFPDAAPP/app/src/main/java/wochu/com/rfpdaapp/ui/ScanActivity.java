package wochu.com.rfpdaapp.ui;

import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.hdhe.uhf.entity.EPC;
import com.android.hdhe.uhf.reader.Tools;
import com.android.hdhe.uhf.reader.UhfReader;
import com.balysv.materialripple.MaterialRippleLayout;
import com.wang.avi.AVLoadingIndicatorView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import wochu.com.rfpdaapp.R;
import wochu.com.rfpdaapp.presenter.impl.BindZboxPresenterImpl;
import wochu.com.rfpdaapp.receiver.ScreenStateReceiver;
import wochu.com.rfpdaapp.utils.ScanUtil;
import wochu.com.rfpdaapp.utils.Util;

/**
 * Created by qianpeng on 2016/7/21.
 */
public class ScanActivity extends AppCompatActivity {
    @Bind(R.id.connect_nfc)
    Button connectNfc;
    @Bind(R.id.et_ufhID)
    EditText etUfhID;
    @Bind(R.id.et_goodsCode)
    public EditText etGoodsCode;
    @Bind(R.id.progress)
   public AVLoadingIndicatorView progress;
    @Bind(R.id.tool_bar)
    Toolbar toolBar;
    private ScanUtil scanUtil;
    private ScreenStateReceiver screenStateReceiver;
    private IntentFilter filter;
    private InventoryThread thread;
    private boolean runFlag = true;
    private boolean startFlag = false;
    private boolean connectFlag = false;
    private ArrayList<EPC> listEPC;
    private ArrayList<Map<String,Object>> listMap;
    private BindZboxPresenterImpl bindZboxPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_bindzbox);
        ButterKnife.bind(this);
        toolBar.setTitle("周转箱绑定");
        getWindow().addFlags(0x80000000);
        setSupportActionBar(toolBar);
        MaterialRippleLayout.on(connectNfc)
                .rippleOverlay(true)
                .rippleAlpha(0.2f)
                .rippleColor(0xFFFF2222)
                .rippleHover(true)
                .create();
        progress.setVisibility(View.GONE);

        bindZboxPresenter = new BindZboxPresenterImpl(this);
        initNFC();
        initData();


    }
    int x = 0;
    private String barCode;
    private void initData() {
        //初始化NFC模块 初始化扫描模块
        scanUtil = new ScanUtil();

        scanUtil.setmOnScanListenner(new ScanUtil.onScanListenner() {
            @Override
            public void onScan(String code) {
                Util.play(1,0);
                //拿到扫描的条码
                barCode = code;
                etGoodsCode.setText(code);
                Toast.makeText(ScanActivity.this,code+(x++),Toast.LENGTH_SHORT).show();
                if(etUfhID.getText().toString()!=null&&! TextUtils.isEmpty(etUfhID.getText().toString())){
                    bindZboxPresenter.bindZbox(etUfhID.getText().toString(),code);
                }
            }
        });

    }
    UhfReader ufhReader;
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
        Util.initSoundPool(this);

    }
    @OnClick(R.id.connect_nfc)
    public void onClick() {
        byte[] versionBytes = ufhReader.getFirmware();
        if(versionBytes!=null){
            connectNfc.setEnabled(false);
            if(!startFlag){
                startFlag = true ;
//                    start_scan.setText(R.string.stop_inventory);
            }else{
                startFlag = false;
//                    start_scan.setText(R.string.inventory);
            }
        }else{
            Toast.makeText(this,"连接NFC失败",Toast.LENGTH_SHORT).show();
        }


    }
long exitSytemTime;
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_HOME) {
//            scanThread.scan();
            scanUtil.scan();
//            Toast.makeText(this,"按下home了",Toast.LENGTH_SHORT).show();
//            return true;
        }

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            //按两次返回键退出
            if (System.currentTimeMillis() - exitSytemTime > 2000) {
                Toast.makeText(getApplicationContext(), "再按一次返回键退出",
                        Toast.LENGTH_SHORT).show();
                exitSytemTime = System.currentTimeMillis();
                return true;
            } else {
                finish();
            }

        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onResume() {
        registerReceiver(screenStateReceiver,filter);
        super.onResume();
    }

    @Override
    protected void onPause() {
        unregisterReceiver(screenStateReceiver);
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        scanUtil.isScanning = false;
        runFlag=false;
        if(ufhReader!=null) {
            ufhReader.close();
            ufhReader=null;

        }
        super.onDestroy();
    }
    //将读取的EPC添加到LISTVIEW
    private void addToList(final List<EPC> list, final String epc){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                etUfhID.setText(epc);
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
                        Thread.sleep(250);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }

            }
        }
    }

}
