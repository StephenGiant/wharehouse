package com.example.wms_erp.fragment;

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
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnticipateInterpolator;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.wms_erp.R;
import com.example.wms_erp.application.MyApplication;
import com.example.wms_erp.decorator.MySpaceDecration;
import com.example.wms_erp.event.CodeEvent;
import com.example.wms_erp.event.RxBus;
import com.example.wms_erp.event.RxManager;
import com.example.wms_erp.model.BaseBean;
import com.example.wms_erp.model.response.OnShelveInfo;
import com.example.wms_erp.presenter.impl.OnOffShelvePresenterImpl;
import com.example.wms_erp.ui.BaseActivity;
import com.example.wms_erp.ui.MainActivity;
import com.example.wms_erp.util.HandleCodeUtil;
import com.example.wms_erp.view.FlipCardAnimation;
import com.example.wms_erp.view.SearchEditText;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Subscriber;
import rx.Subscription;

/**
 * Created by Administrator on 2016/8/18.
 */
public class OnoffBlindFragment extends BaseFragment implements View.OnClickListener {

    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.ll_categary)
    LinearLayout llCategary;
    @Bind(R.id.se_barCode)
    SearchEditText seBarCode;
    @Bind(R.id.sp_reson)
    Spinner spReson;
    @Bind(R.id.onshelve_data)
    public RecyclerView onshelveData;
    @Bind(R.id.submit)
    Button submit;
    //    MainActivity mActivity;
    private MainActivity activity;
    private OnOffShelvePresenterImpl onOffShelvePresenter;
    //缓存的条码集合，去除重复扫描
    public static ArrayList<String> codes;
    private ArrayAdapter<CharSequence> adapter;
    private FlipCardAnimation animation;
    private String[] stringArray;
public static final int TAG_ONOFFFRAGMENT = 0x1001;
    private MyApplication application;

    public static void clearCodes() {
        codes.clear();
    }

    public static void removeCode(int index) {
        if (codes.size() > 1) {
            codes.remove(index);
        } else {
            codes.clear();
        }
    }

    public OnoffBlindFragment() {
        codes = new ArrayList<>();
    }

    public static OnoffBlindFragment newInstance(Bundle args) {

        OnoffBlindFragment f = new OnoffBlindFragment();
        f.setArguments(args);
        codes = new ArrayList<>();
        return f;
    }

    String curType;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        stringArray = getActivity().getResources().getStringArray(R.array.onshelve_type);
        activity = (MainActivity) getActivity();
        application = (MyApplication) activity.getApplication();


//        application.rxManager.add(subscription);
        View view = inflater.inflate(R.layout.on_offshelve_layout, null);

//        return super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, view);

        llCategary.setOnClickListener(this);

        curType = stringArray[0];
        spReson.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                final String choose = stringArray[position];
                if(num==1&&"报损".equals(curType)){
                    activity.showMaterialDialog("当前为报损下架", "确定更换为" + stringArray[position] + "下架吗？", new BaseActivity.OncheckListenner() {
                        @Override
                        public void onPositiveClick() {
                            onOffShelvePresenter.clearInfo();
                            curType = choose;
                        }

                        @Override
                        public void onNagativeClick() {
                                spReson.setSelection(3);
                        }
                    });
                }
                curType = stringArray[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ArrayList<BaseBean<OnShelveInfo>> data = new ArrayList<>();
        for (int x = 0; x < 3; x++) {
            data.add(null);
        }
        onshelveData.addItemDecoration(new MySpaceDecration(10));

//changeToOffShelve();


        return view;
    }

    @Override
    public void dispatchCode(final String code) {
        if (HandleCodeUtil.checkDate(code)) {
            seBarCode.setText(code);
            switch (num){
                case 0:
                    onOffShelvePresenter.getOnShelveInfo(code);
                    break;
                case 1:
                    onOffShelvePresenter.getOffShelveInfo(code,curType);
                    break;
            }

//            if (onOffShelvePresenter.isShowing()) {
//
//            }
        } else {
            if(num==0) {
                activity.ToastCheese("请检查条码!");
            }else if(!"报损".equals(curType)){
                //报损下架
           activity.showMaterialDialog("此商品已过期", "点确认将选报损下架", new BaseActivity.OncheckListenner() {
               @Override
               public void onPositiveClick() {
                   seBarCode.setText(code);
                    spReson.setSelection(3);
                   curType = "报损";
                   onOffShelvePresenter.getOffShelveInfo(code,curType);
               }

               @Override
               public void onNagativeClick() {
                        seBarCode.setText("");
               }
           });
            }else{
                seBarCode.setText(code);
                onOffShelvePresenter.getOnShelveInfo(code);
            }
        }

    }

    @Override
    public void onDestroyView() {
//        application.rxManager.clear();//结束订阅的事件，防止ANR
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void onResume() {
        onOffShelvePresenter = new OnOffShelvePresenterImpl(activity, this);
        Subscription subscription = RxBus.getDefault().toObserverable().subscribe(new Subscriber<Object>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Object o) {
                if (o instanceof CodeEvent) {
                    Log.i("RxBus", ((CodeEvent) o).getCode());
                    if(((CodeEvent) o).getTag()==TAG_ONOFFFRAGMENT) {
                        dispatchCode(((CodeEvent) o).getCode());
                    }
                }
            }
        });
        super.onResume();
    }

//    @Override
//    public void onClick(View v) {
////        Toast.makeText(getContext(),"点击了",Toast.LENGTH_SHORT).show();
////        onOffShelvePresenter.postOnshelve(curType);
//
//
//    }

    private void changeToOffShelve() {
        stringArray = getActivity().getResources().getStringArray(R.array.offshelve_type);
        adapter = ArrayAdapter.createFromResource(getContext(), R.array.offshelve_type, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spReson.setAdapter(adapter);
        onOffShelvePresenter.clearInfo();
    }

    private void changeToOnshelve() {
        stringArray = getActivity().getResources().getStringArray(R.array.onshelve_type);
        adapter = ArrayAdapter.createFromResource(getContext(), R.array.onshelve_type, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spReson.setAdapter(adapter);
        onOffShelvePresenter.clearInfo();
    }

    int num = 0;

    private void startFlipAnimation() {
        onOffShelvePresenter.clearInfo();
        if (animation == null) {
            int width = llCategary.getWidth() / 2;
            int height = llCategary.getHeight() / 2;
            animation = new FlipCardAnimation(0, 180, width, height);
            animation.setInterpolator(new AnticipateInterpolator());
            animation.setDuration(2000);
            animation.setFillAfter(false);
            animation.setRepeatCount(0);
            animation.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {

                }

                @Override
                public void onAnimationEnd(Animation animation) {

                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });
            animation.setOnContentChangeListener(new FlipCardAnimation.OnContentChangeListener() {
                @Override
                public void contentChange() {
                    Log.i("oncontentChange","getIn");
                    if (num > 0) {
                        num = 0;
                        Log.i("进来","变上架");
                        tvTitle.setText("盲扫上架");
                        changeToOnshelve();
                    } else {
                        Log.i("进来","变下架num="+num);
                        tvTitle.setText("盲扫下架");
                        changeToOffShelve();
                        num++;
                    }

                }
            });
        }
        animation.setCanContentChange();
        llCategary.startAnimation(animation);

    }

    @OnClick({R.id.ll_categary, R.id.submit})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_categary:
                startFlipAnimation();
                break;
            case R.id.submit:
                switch (num){
                    case 0:
                        onOffShelvePresenter.postOnshelve(curType);
                        break;
                    case 1:
                        onOffShelvePresenter.postOffshelve(curType);
                        break;
                }
                break;
        }
    }

    @Override
    public void onPause() {
        super.onPause();
//        activity.unRegist();
//        application.rxManager.clear();
        onOffShelvePresenter.clearInfo();
        Log.i("pause","盲扫");

    }
}

//
//
//
//
//
//
//
//
//
//
//