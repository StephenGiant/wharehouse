package com.example.wms_erp.ui;
//                                      LWKKKKKKKWKKEGGDEEGGDfLEEKDLDKEEKDEGGEKKEDKG:
//                                     i##W######EEKKW######LEKLLD#fGKKK#EEEKDGE#WK#K
//                                     E#####WWEDK###########K#KfGDGf#EEKEKDLDDKK###KD:
//                                    jW#####EDW#########W######K#fLLW#LGLDG#DGGDKWW#Kt
//                                 .####K###DG######KEKW###KKKKE##LtDEKffLD##KDEGEKKW#Wj
//                                ,#;DG####DK####DDLGGGGED###GEDD#WtDDDLftD###KLLGGKDDEWG
//                                G.,KK###EK###KtiLKKW##KKDD##GDD##tDKL#;D#K#EGffLKK#####f
//                               ;f; E###KW###DfLK#########KLDKLE##DG#f#tD###Kf;G#########
//                               ;D  K##KE###DLjD######W#W##KfLEtK##E#DDGWE##EtE#KE#######t
//                               ;L :W#WK##KDKLKK#######KW##EDDfDt##K#DEE#K##Df#DK#########
//                                ffDKDK##WfKLKW############KffEftL#K#KKK#E##G#Gf#EK#######;
//                                 D###KKKDKEKW###############fjDGtD##K#W#DK#K#t#DEK#W###W#D
//                               G######WW############KK#####KEffGjGW#KK#EGW##KK#LLW####W###
//                              t#########################KWWGfKEDKfK##K#Gj#W####GfLK####W#K
//                               Lf#K###################WKDDWKWKEGfLGGGGEDDtfD##EEKEDW##WW##
//                              :#########################DtGLfLi;ii;;itGLGtjGW#KLt;fK#####E
//                             ;W############W###########EjGtii,:,: .::,iGGtitGW#WKWDGK#K##t
//                             :E####WW#################KGLi,,:,:   ..:,iiLi:;iGKDiL##KW###
//                              L##W############W######KGfti;,:.     ...:,;,::,ifEKDGW#E###
//                             f####WW#######KWW#WW##EKGjti,::.       ..:,,:::::,LW#EGDf##L
//                             ##EW#KWKW###WK##KEEDLGGj;,::...       . ..::...::,;G#DDEEW#;
//                             ##ijfDEW###EE##f,,,,,;i,:::....         .......::,,tKELWW##i
//                           j#####DGGGD#EK#Wt:::,,,,::::......      .........:::,tGELK###;
//                          D#E#DG######WW#G,.::::,:...........  .     ........:::tDDfE###.
//                        :#Ei##EKt:jDtEWD,.:::::,,;i;,.    ..    .  ..........:::tKKDL#KWf
//                       t#t ###ftWtLLDEf,:,::::::,:;itL;,.  ..     .........:.::,jK#DK#KEt
//                     D#f ,W###E .,:,:ii::::.::::,,,::.;tj;. .. . ............::;L##KK#WW;
//                    Lf :iW##K##. .:.:i;,,::::..::,,::...:tf, ...............::;tE###E##K
//                   ;L jL###K####.   :ii;,:::....:,iii;,:. iLi  .......:....::,ijW###K##G
//                    i#####DW##K##Lij:it;,:,:.....:ijEEWGGt,ift:....:..:....:,;tf####W#W;
//                     .f############W;it;,,,::.....:;ffEK#WEfitt,:::::::.::::,;iD######W.
//                        ,#########Kjiiii;,,:::.....,,:tff;tEfiii::::::::::.::;;W#####WD:
//                      :;;#W#######E;tii;;,,::......:,,,;. .fLi;;,::::::::,;fGEK#KW###GE:
//                     ::.#K########E;tii;;,,,:.... ..:,,;;,iit,i::::,::ijLGGGLLE#KWW#KDj
//                     .t;##########E;ti;;;,,,::...  ..:,;iitt,.,,..::jKE##ELtiiW#DW##LLi
//                     :t###KW######E;t;;,;;,,::..   . .:::,::. ,, .:GEEKKff#KjW#KD#W#tLi
//                     . ##D##W#####tit;;,;;,,::...   ....:....::: .iEi,tt :WWK###f#GKL;.
//                      tKL#WDKKK##E;tt;;,;;,,,:...   .::......::: :j:,:,::tKtL#WEG#GfL::
//                      DGWKL##E##D;;tt;,,;;,,,::.........   ...:. ,t::,iitGj;LfWLWDtG,..
//                     ;GKWDWEjK#W,i;tt;,,,;,,:::.........  ....:  ;i:::,ifj,tL;ffEjEj;
//                    .EEGtfEfKE#t,;;tt,,,,,,,,:::........  ..... .ii,::::,,,i;t;EjtL:
//                    D#jGGfE#W#K,;;,tt,,,,,,,,,:::.............  .i;,:::,,,;:;.tEiEi
//                   jKf;#tK#DK#;,,;;it,,,,,,,,,:::.....:.::::..  :i;:::::,,it,:GfDj.
//                  :LK:GKKKE##L:,,,;it;,,,:,,:,,:::.:::::.::::   ,i;::::,,ii. GGLL;
//                   EE:#EGW###,,,,,,it;,,:,::::::::::::..:,..:  .,i,::,,:;, jGGLLi
//                   GGEKWK###t,,:,,,iti,,::::::::::::.   ,:...  .,i:::::,;iDEjffi:
//                    j######ti,:,,,,;ti,:,::::::::::...  :i;..  .,;:::,,ifEE;;tt::
//                     DjG##t:,,::,,,,it,,,:::::..:. .....  it,. .i;::,,i,;; .:t:::
//                       ##f:,,,::,,,,;j;,,,::::..:it   ...  ,i.:fj,:,,it   .  i: ,
//                      .#L:,,,::::,,,,tt,,,::::.:: iL,     ..ifLft,,;i: .i:   t  i
//                       j:,,,,::::,,,,;f;,,::::::.  iLji,:... ,;;;;i,f:  .    i  t.
//                     ,i,:::,::::::,,,,tj,,::::::.. ,;iLj;;,:,;,;;i,t#,  t    ;  :;
//                   ,ii,::::,::::::,:,,;ft,,::::.....tt iDDjtttLit,t#f. .:    ,. :;
//                :,ii,:::::,,:..::::::,,ifi,,:::.:...:ji::tjLLGji,t##E  :      : .,
//            .:;;;,,:::::.,::.....:::::,,tf;,,::......:jt;,,iLf;;:f##f  :      .  ,
//         .,i;;,::::::::.::::..:::::::::,;tj;,:::......,tLjjft;iG K#W:  :         ;
//      :,;;;:::::....::::..::.::::::.::::,;tt;,::.......:,itti G ;KKG:         . .:
//.:,,;;;;,:::::...........::.:.....::.::::,itf,::::.....:::;iiE .DWLG.          ::,
//,;;;,,,,::::.............:.........::.:::,;tjf;:::...:::,,,fWiGLWttE           ;t .
//:,,,,,,,,,,::.::..:......:..........:..::,,iijLi:::::::,,,t#WEfGt jL           ,i
//::...:::,,;,,::::........:.............::,:,ittLj,::::::,f .  ;f iD:           ::
//..:.....::,,;,,::......................::,,:,itjLGfi,,,tD#LG:jD.Lj,            j: .
//.........:::,,i,,::.....:................:::,;ifLLKWKEDEDfDLGKGDtj      .     :t
//
//
//                                         美女镇楼！！！

import android.app.Application;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wms_erp.BuildConfig;
import com.example.wms_erp.R;
import com.example.wms_erp.adapter.FunctionsAdapter;
import com.example.wms_erp.apiconfig.ApiConfig;
import com.example.wms_erp.application.MyApplication;
import com.example.wms_erp.event.CodeEvent;
import com.example.wms_erp.event.RxBus;
import com.example.wms_erp.event.UpdateEvent;
import com.example.wms_erp.fragment.BindLocGoodsFragment;
import com.example.wms_erp.fragment.GoodsMoveFragment;
import com.example.wms_erp.fragment.LocCountFragment;
import com.example.wms_erp.fragment.LocQueryFragment;
import com.example.wms_erp.fragment.OffshelveFragment;
import com.example.wms_erp.fragment.OffshelveOrderFragment;
import com.example.wms_erp.fragment.OnoffBlindFragment;
import com.example.wms_erp.fragment.TiaoZhengFragment;
import com.example.wms_erp.model.VersionInfo;
import com.example.wms_erp.retrofit.RetrofitSingle;
import com.example.wms_erp.retrofit.ServiceApi;
import com.example.wms_erp.util.HandleCodeUtil;
import com.example.wms_erp.util.OkHttpClientManager;
import com.example.wms_erp.util.SharePreUtil;
import com.example.wms_erp.view.NoScrollViewPager;
import com.example.wms_erp.view.OnshelveDialog;
import com.google.gson.Gson;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import im.fir.sdk.FIR;
import im.fir.sdk.VersionCheckCallback;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    @Bind(R.id.vp_functions)
    NoScrollViewPager vpFunctions;
    private ServiceApi serviceApi;
    private TextView account_name;
    private TextView versionName;
    private MyApplication application;
    private OnoffBlindFragment onoffBlindFragment;
    private int curTag = 0x1001;
    private MyApplication application1;
    private LocCountFragment countFragment;
    private LocQueryFragment locQueryFragment;
    private GoodsMoveFragment goodsMoveFragment;
    private BindLocGoodsFragment bindLocGoodsFragment;
    private OffshelveOrderFragment orderFragment;
    private OffshelveFragment offshelveFragment;
    private View view;

    @Override
    protected void handleCode(String str) {
        //将code传给当前的fragment处理
//    diapatchCode(str,curTag);
        RxBus.getDefault().send(new CodeEvent(str,curTag));

    }
    private void diapatchCode(String code,int tag){
        switch (tag){
            case OnoffBlindFragment.TAG_ONOFFFRAGMENT:
                onoffBlindFragment.dispatchCode(code);
                break;
            case TiaoZhengFragment.TAG_TIAOZHENG:

                break;
        }
    }

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    //    @Bind(R.id.ll_categary)
//    LinearLayout llCategary;
    @Bind(R.id.fab)
    FloatingActionButton fab;
    @Bind(R.id.nav_view)
    NavigationView navView;
    @Bind(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    private ImageView imageView;
    //    @Bind(R.id.tv_title)
//    TextView tvTitle;
    int userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
//        MyApplication application1 =  (MyApplication) getApplication();
        serviceApi = RetrofitSingle.getInstance();
        this.application = (MyApplication) getApplication();
        toolbar.setTitle("盲扫上下架");
        setSupportActionBar(toolbar);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
//        int checkDate = HandleCodeUtil.checkDate("011601020160414720");
//        if(checkDate==HandleCodeUtil.OVERDATE){
//            ToastCheese("过期了");
//        }

//        Log.i("testConfig",BuildConfig.URL);
//        RxBus.getDefault().toObserverable().subscribe(new Subscriber<Object>() {
//            @Override
//            public void onCompleted() {
//
//            }
//
//            @Override
//            public void onError(Throwable e) {
//
//            }
//
//            @Override
//            public void onNext(Object o) {
//                if(o instanceof UpdateEvent){
////                    countFragment.initData();
//                }
//            }
//        });
        onoffBlindFragment = new OnoffBlindFragment();
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();

        navView.setNavigationItemSelectedListener(this);
        View view = navView.getHeaderView(0);
        imageView = (ImageView) view.findViewById(R.id.imageView);
        account_name = (TextView) view.findViewById(R.id.account_name);
        versionName = (TextView) view.findViewById(R.id.version_name);
        versionName.setText(this.application.getVersion());
        imageView.setOnClickListener(this);
        showVersion();
        initViewPager();
//        if(application.userInfo==null) {
//            showMaterialDialog("当前未登陆", "请先登录!", new OncheckListenner() {
//                @Override
//                public void onPositiveClick() {
//                    drawerLayout.openDrawer(GravityCompat.START);
//                }
//
//                @Override
//                public void onNagativeClick() {
//                    drawerLayout.openDrawer(GravityCompat.START);
//                }
//            });
//        }
//        showToast();
//        checkUpdate();

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onPause() {
//        showToast();
        super.onPause();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        application.rxManager.clear();
        if (id == R.id.nav_camera) {

            // Handle the camera action

            toolbar.setTitle("盲扫上架");
            curTag=OnoffBlindFragment.TAG_ONOFFFRAGMENT;
            Log.i("当前页面",curTag+"");
            vpFunctions.setCurrentItem(0);

        } else if (id == R.id.nav_gallery) {
            toolbar.setTitle("指令下架");
                curTag = OffshelveOrderFragment.TAG_OFFSHELVEORDER;
            vpFunctions.setCurrentItem(6);
        } else if (id == R.id.nav_slideshow) {
            toolbar.setTitle("库存调整");
            try {
                curTag = TiaoZhengFragment.TAG_TIAOZHENG;
                vpFunctions.setCurrentItem(2);
                countFragment.initData();
            }
            catch (NullPointerException e){
                e.printStackTrace();
                Log.i("切换失败","库存盘点");
            }


        } else if (id == R.id.nav_manage) {
            toolbar.setTitle("库存查询");
            curTag = LocQueryFragment.TAG_LOCQUERY;
            vpFunctions.setCurrentItem(3);
        } else if (id == R.id.nav_setting) {
            toolbar.setTitle("设置选项");
        }else if(id==R.id.move_location){
            toolbar.setTitle("货位搬移");
            curTag = GoodsMoveFragment.TAG_MOVELACATION;
            vpFunctions.setCurrentItem(4);
        }else if(id == R.id.nav_bindloc){
            toolbar.setTitle("货位关联");
            curTag = BindLocGoodsFragment.TAG_BINDLOCGOODS;
            vpFunctions.setCurrentItem(5);
        }else if(id ==R.id.nav_offshelve){
            toolbar.setTitle("盲扫下架");
            curTag = OffshelveFragment.TAG_OFFSHELVE;
            vpFunctions.setCurrentItem(1);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View v) {
//        Toast.makeText(this,"请登陆",Toast.LENGTH_SHORT).show();
//        if (userID == -1) {
            Intent intent = new Intent(this, LoginAct.class);
            intent.putExtra("userID",userID);
            startActivity(intent);
//            ToastCheese(userID + "");
//        }


    }


    int count = 1;

    private void initViewPager() {
        vpFunctions.setNoScroll(true);
        ArrayList<Fragment> fragments = new ArrayList<>();
    fragments.add(onoffBlindFragment);
        offshelveFragment = new OffshelveFragment();
        fragments.add(offshelveFragment);
        countFragment = new LocCountFragment();
        fragments.add(countFragment);
        locQueryFragment = new LocQueryFragment();
        fragments.add(locQueryFragment);
        goodsMoveFragment = new GoodsMoveFragment();
        fragments.add(goodsMoveFragment);
        bindLocGoodsFragment = new BindLocGoodsFragment();
        fragments.add(bindLocGoodsFragment);
        orderFragment = new OffshelveOrderFragment();
        fragments.add(orderFragment);
        FunctionsAdapter functionsAdapter = new FunctionsAdapter(getSupportFragmentManager(), this, fragments);
        vpFunctions.setAdapter(functionsAdapter);
    }


    @Override
    protected void onResume() {
        super.onResume();
        userID = SharePreUtil.getInteger(this, "userID", -1);
        if (userID != -1) {
            account_name.setText(SharePreUtil.getString(this, "userName", ""));
        }
//        if(view!=null){
//            WindowManager windowManager = (WindowManager) getApplication().getSystemService(getApplication().WINDOW_SERVICE);
//            windowManager.removeView(view);
//        }
    }

    @Override
    protected void onDestroy() {
//        application.rxManager.clear();
        if(view!=null){
            WindowManager windowManager = (WindowManager) getApplication().getSystemService(getApplication().WINDOW_SERVICE);
            windowManager.removeView(view);
        }
        super.onDestroy();

    }

    private void showVersion(){

        PackageInfo packageInfo = null;
        try {
            packageInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
            String versionName = packageInfo.versionName;
            ToastCheese("当前版本号:"+versionName);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

    }
//不消失的悬浮窗
//    private void showToast(){
//        view = LayoutInflater.from(this).inflate(R.layout.toastlayout, null);
//        WindowManager.LayoutParams params = new WindowManager.LayoutParams(WindowManager.LayoutParams.TYPE_TOAST);
//        params.flags = WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;
//        params.width = WindowManager.LayoutParams.WRAP_CONTENT;
//        params.height = WindowManager.LayoutParams.WRAP_CONTENT;
//        WindowManager windowManager = (WindowManager) getApplication().getSystemService(getApplication().WINDOW_SERVICE);
//        windowManager.addView(view, params);
//
//    }

    private void checkUpdate(){
        if(BuildConfig.DEBUG) {

            FIR.checkForUpdateInFIR(ApiConfig.FIRTOKEN, new VersionCheckCallback() {
                @Override
                public void onSuccess(String versionJson) {
                    Log.i("fir", "check from fir.im success! " + "\n" + versionJson);
                    Gson gson = new Gson();
                    VersionInfo versionInfo = gson.fromJson(versionJson, VersionInfo.class);
                    String versionShort = versionInfo.getVersionShort();


//                    ToastCheese(versionInfo.getInstallUrl());
//                serviceApi.getNewVersion(versionInfo.getInstallUrl()).subscribeOn(Schedulers.io())
//                        .observeOn(AndroidSchedulers.mainThread())
//                        .subscribe(new Subscriber<Response>() {
//                            @Override
//                            public void onCompleted() {
//
//                            }
//
//                            @Override
//                            public void onError(Throwable e) {
//                                ToastCheese(e.toString());
//                            }
//
//                            @Override
//                            public void onNext(final Response body) {
////                                ToastCheese("下载成功");
//                        new Thread(new Runnable() {
//                            @Override
//                            public void run() {
//                                updateVersion(body);
//                            }
//                        }).start();
//
//
//                            }
//                        });
                    OkHttpClientManager.downloadAsyn(versionInfo.getInstallUrl(), Environment.getExternalStorageDirectory().getAbsolutePath(), "wms.apk"
                            , new OkHttpClientManager.ResultCallback<String>() {
                                @Override
                                public void onError(Request request, Exception e) {

                                }

                                @Override
                                public void onResponse(String response) {
                                    ToastCheese(response + "okhttp!!!");
                                    Intent intent = new Intent(Intent.ACTION_VIEW);
                                    intent.setDataAndType(Uri.fromFile(new File(response)), "application/vnd.android.package-archive");
                                    startActivity(intent);
                                    installNewVersion();
                                }
                            });

                }

                @Override
                public void onFail(Exception exception) {
                    Log.i("fir", "check fir.im fail! " + "\n" + exception.getMessage());
                }

                @Override
                public void onStart() {
//                Toast.makeText(getApplicationContext(), "正在获取", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFinish() {
//                Toast.makeText(getApplicationContext(), "获取完成", Toast.LENGTH_SHORT).show();
                }
            });
        }

        NetworkInterface iface = null;
        try {
            iface = NetworkInterface.getByName("https://www.baidu.com");
        } catch (SocketException e) {
            e.printStackTrace();
        }
        if (iface != null) {

            for (InterfaceAddress address : iface.getInterfaceAddresses()) {
                String ip = address.getAddress().getHostAddress();
                if (ip.length() <= 15) {
                    Log.i("ip", "ip:" + ip);
                }
            }
        }else{
            Log.i("ip地址","获取失败");
        }
    }


    private void updateVersion(Response body){

        InputStream is = null;
        byte[] buf = new byte[2048];
        int len = 0;
        FileOutputStream fos = null;

        try {
            is = body.body().byteStream();

            File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath(), "wms.apk");
            fos = new FileOutputStream(file);
            while ((len = is.read(buf)) != -1) {
                fos.write(buf, 0, len);
                Log.i("下载","完成"+len);
            }
            Log.i("下载",file.getAbsolutePath()+"完成");
            fos.flush();
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    installNewVersion();
                }
            });

        }
        catch (IOException e) {
            e.printStackTrace();
            Log.e("IO","出错");
        }
    }

    private void installNewVersion(){
        String dir = Environment.getExternalStorageDirectory() + "wms.apk";
//        ToastCheese(dir+"试试");
//        Intent intent = new Intent(Intent.ACTION_VIEW);
//        intent.setDataAndType(Uri.fromFile(new File(dir)), "application/vnd.android.package-archive");
//        startActivity(intent);
    }
    long curTime = 0;
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        switch (keyCode){
            case KeyEvent.KEYCODE_BACK:
                //返回键
                if(curTime!=0) {
                    if(System.currentTimeMillis()-curTime<1000){
                        //视为双击
                        finish();
                        return false;
                    }else{
                        curTime = System.currentTimeMillis();
                        ToastCheese("再点击一次返回键退出");
                        return false;
                    }
                }else{
                    curTime = System.currentTimeMillis();
                    ToastCheese("再点击一次返回键退出");
                    return false;
                }



            default:
                return super.onKeyDown(keyCode, event);
        }

    }
}
