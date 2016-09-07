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

import android.content.Intent;
import android.os.Bundle;
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
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wms_erp.R;
import com.example.wms_erp.adapter.FunctionsAdapter;
import com.example.wms_erp.application.MyApplication;
import com.example.wms_erp.event.CodeEvent;
import com.example.wms_erp.event.RxBus;
import com.example.wms_erp.fragment.OnoffBlindFragment;
import com.example.wms_erp.fragment.TiaoZhengFragment;
import com.example.wms_erp.retrofit.RetrofitSingle;
import com.example.wms_erp.retrofit.ServiceApi;
import com.example.wms_erp.util.SharePreUtil;
import com.example.wms_erp.view.NoScrollViewPager;
import com.example.wms_erp.view.OnshelveDialog;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

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
        serviceApi = RetrofitSingle.getInstance();
        application = (MyApplication) getApplication();
        toolbar.setTitle("盲扫上下架");
        setSupportActionBar(toolbar);
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
        versionName.setText(application.getVersion());
        imageView.setOnClickListener(this);
        initViewPager();

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

        if (id == R.id.nav_camera) {

            // Handle the camera action
            toolbar.setTitle("盲扫上下架");
        } else if (id == R.id.nav_gallery) {
            toolbar.setTitle("指令上下架");
        } else if (id == R.id.nav_slideshow) {
            toolbar.setTitle("库存盘点");
        } else if (id == R.id.nav_manage) {
            toolbar.setTitle("报损");
        } else if (id == R.id.nav_setting) {
            toolbar.setTitle("设置选项");
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View v) {
//        Toast.makeText(this,"请登陆",Toast.LENGTH_SHORT).show();
        if (userID == -1) {
            Intent intent = new Intent(this, LoginAct.class);
            startActivity(intent);
            ToastCheese(userID + "");
        }


    }


    int count = 1;

    private void initViewPager() {
        vpFunctions.setNoScroll(true);
        ArrayList<Fragment> fragments = new ArrayList<>();
    fragments.add(onoffBlindFragment);
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
    }
}
