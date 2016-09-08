package com.example.wms_erp.fragment;

import android.app.Application;
import android.graphics.Camera;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wms_erp.R;
import com.example.wms_erp.adapter.LocPagerAdapter;
import com.example.wms_erp.application.MyApplication;
import com.example.wms_erp.dao.LocInfoDao;
import com.example.wms_erp.model.BaseBean;
import com.example.wms_erp.model.db.LocInfoTable;
import com.example.wms_erp.model.response.LocInfo;
import com.example.wms_erp.retrofit.RetrofitSingle;
import com.example.wms_erp.retrofit.ServiceApi;
import com.example.wms_erp.ui.MainActivity;
import com.example.wms_erp.view.NoScrollViewPager;
import com.raizlabs.android.dbflow.sql.language.Delete;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2016/9/6.
 */
public class LocCountFragment extends BaseFragment {
    @Bind(R.id.tab_title)
    TabLayout tabTitle;
    @Bind(R.id.vp_content)
    NoScrollViewPager vpContent;
    private MyApplication application;
    private ServiceApi serviceApi;
    private MainActivity activity;
    private LocInfoDao locInfoDao;

    @Override
    public void dispatchCode(String code) {

    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i("LocCountFragment","可见了");

    }

    public void initData(){
        serviceApi.getLocationInventory("").subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<BaseBean<List<LocInfo>>>() {
                    @Override
                    public void onStart() {
                        activity.showLoadingDialog("正在加载数据");
                    }

                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        activity.ToastCheese("加载数据失败，请检查网络！");
                        activity.hideLoadingDialog();
                        Log.e("加载盘点数据失败",e.toString());
                    }

                    @Override
                    public void onNext(final BaseBean<List<LocInfo>> data) {
                        //存入数据库
                        if(data.getDATA()!=null){
                            Delete.table(LocInfoTable.class);
                            Observable.create(new Observable.OnSubscribe<String>() {
                                @Override
                                public void call(Subscriber<? super String> subscriber) {
                                    for(LocInfo info:data.getDATA()){
                                        LocInfoTable infoTable = new LocInfoTable();
                                        infoTable.setBuyQty(info.getBuyQty());
                                        infoTable.setGOODSCODE(info.getGOODSCODE());
                                        infoTable.setGOODSNAME(info.getGOODSNAME());
                                        infoTable.setPURUNITQTY(info.getPURUNITQTY());
                                        infoTable.setCELLNO(info.getCELLNO());
                                        infoTable.setCHQTY(info.getCHQTY());
                                        infoTable.setCREATER(info.getCREATER());
                                        infoTable.setEXPIRYDAYS(info.getEXPIRYDAYS());
                                        infoTable.setGOODS_SN(info.getGOODS_SN());
                                        infoTable.setGOODSBATCHCODE(info.getGOODSBATCHCODE());
                                        infoTable.setGOODSID(info.getGOODSID());
                                        infoTable.setINVQTY(info.getINVQTY());
                                        infoTable.setLOCATIONCODE(info.getLOCATIONCODE());
                                        infoTable.setLOCATIONINVENTORYID(info.getLOCATIONINVENTORYID());
                                        infoTable.setLOCATIONID(info.getLOCATIONID());
                                        infoTable.setPRODUCTIONDATE(info.getPRODUCTIONDATE());
                                        infoTable.setMAXBATCH(info.getMAXBATCH());
                                        infoTable.setMINBATCH(info.getMINBATCH());
                                        infoTable.setQTY(info.getQTY());
                                        infoTable.setQTYchange(info.getQTYchange());
                                        infoTable.setSTATUS(info.getSTATUS());
                                        infoTable.setWAREHOUSEID(info.getWAREHOUSEID());
                                        infoTable.setStoreQty(info.getStoreQty());
                                        infoTable.setSTORAGEDATE(info.getSTORAGEDATE());
                                        infoTable.setUNITNAME(info.getUNITNAME());
                                        infoTable.setPURUNITNAME(info.getPURUNITNAME());
                                        infoTable.save();


                                    }
                                    subscriber.onNext("读取数据完成");
                                }
                            }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<String>() {
                                @Override
                                public void onCompleted() {

                                }

                                @Override
                                public void onError(Throwable e) {

                                }

                                @Override
                                public void onNext(String s) {
                                    activity.hideLoadingDialog();
                                    activity.ToastCheese("加载数据完成");
                                }
                            });

                        }
                    }
                });
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        serviceApi = RetrofitSingle.getInstance();
        activity = (MainActivity) getActivity();
        locInfoDao = new LocInfoDao();

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.loccount_layout, null);

        ButterKnife.bind(this, view);
        application = (MyApplication) getActivity().getApplication();
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new TiaoZhengFragment());
        vpContent.setAdapter(new LocPagerAdapter(getFragmentManager(),fragments));
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
        application.rxManager.clear();//取消掉所有事件
//        Camera camera = new Camera();
//        camera.rotateZ(360);
    }
}
