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
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnticipateOvershootInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wms_erp.R;
import com.example.wms_erp.application.MyApplication;
import com.example.wms_erp.model.BaseBean;
import com.example.wms_erp.model.response.UserInfo;
import com.example.wms_erp.retrofit.RetrofitSingle;
import com.example.wms_erp.retrofit.ServiceApi;
import com.example.wms_erp.util.SharePreUtil;
import com.example.wms_erp.view.FlipCardAnimation;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener,View.OnClickListener {

    private ServiceApi serviceApi;
    private TextView account_name;
    private TextView versionName;
    private MyApplication application;

    @Override
    protected void handleCode(String str) {
        //将code传给当前的fragment处理
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
        if(userID==-1) {
            Intent intent = new Intent(this, LoginAct.class);
            startActivity(intent);
            ToastCheese(userID+"");
        }
//        serviceApi.login("sa","8").subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Subscriber<BaseBean<UserInfo>>() {
//                    @Override
//                    public void onCompleted() {
//
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        ToastCheese(e.toString());
//                    }
//
//                    @Override
//                    public void onNext(BaseBean<UserInfo> userInfoBaseBean) {
//                        if(userInfoBaseBean .getDATA()!=null){
//                            account_name.setText(userInfoBaseBean.getDATA().getUSERNAME());
//                        }
//                    }
//                });

    }

    //
//    @OnClick(R.id.ll_categary)
//    public void onClick() {
//        startAnimation(llCategary.getWidth() / 2, llCategary.getHeight() / 2, 180, 1000);
//
//    }
int count = 1;
//    private void startAnimation(int width, int height, int degree, int duration) {
//        FlipCardAnimation animation = new FlipCardAnimation(0, degree, width, height);
//        animation.setInterpolator(new AnticipateOvershootInterpolator()
//        );
//        animation.setDuration(duration);
//        animation.setFillAfter(false);
//        animation.setRepeatCount(0);
//        animation.setAnimationListener(new Animation.AnimationListener() {
//            @Override
//            public void onAnimationStart(Animation animation) {
//            }
//
//            @Override
//            public void onAnimationEnd(Animation animation) {
//            }
//
//            @Override
//            public void onAnimationRepeat(Animation animation) {
//                ((FlipCardAnimation) animation).setCanContentChange();
//            }
//        });
//        animation.setOnContentChangeListener(new FlipCardAnimation.OnContentChangeListener() {
//            @Override
//            public void contentChange() {
////                if (iv_pro == null) {
////                    return;
////                }
////                if (num >= 3) {
////                    num = 0;
////                }
////                iv_pro.setBackgroundResource(DRAWABLE[num]);
////                tv_item.setText("￥" + new Random().nextInt(500));
////
////                if (num == 0) {
////                    tv_price_item.setText("Discount");
////                } else if (num == 1) {
////                    tv_price_item.setText("Price");
////                } else if (num == 2) {
////                    tv_price_item.setText("Cost");
////                }
////                num++;
//                if(count%2==1) {
//                    llCategary.setBackgroundColor(Color.parseColor("#607D8B"));
//                    tvTitle.setText("盲扫下架");
//                }else{
//                    llCategary.setBackgroundColor(Color.parseColor("#00BCD4"));
//                    tvTitle.setText("盲扫上架");
//                }
//                count++;
//            }
//        });
//        llCategary.startAnimation(animation);
//
//    }


    @Override
    protected void onResume() {
        super.onResume();
        userID = SharePreUtil.getInteger(this,"userID",-1);
        if(userID!=-1){
            account_name.setText(SharePreUtil.getString(this,"userName",""));
        }
    }
}
