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
import com.example.wms_erp.model.response.LocInfoResponse;
//import com.example.wms_erp.model.response.LocInfo_Table;
import com.example.wms_erp.retrofit.RetrofitSingle;
import com.example.wms_erp.retrofit.ServiceApi;
import com.example.wms_erp.ui.BaseActivity;
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
    public ArrayList<LocInfo> doneList = new ArrayList<>();
    private LocPagerAdapter locPagerAdapter;
    private ArrayList<Fragment> fragments;

    @Override
    public void dispatchCode(String code) {

    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i("LocCountFragment","可见了");

//            if(locPagerAdapter==null) {
                locPagerAdapter = new LocPagerAdapter(getChildFragmentManager(), fragments);
                vpContent.setAdapter(locPagerAdapter);
//            }else{
//                locPagerAdapter.notifyDataSetChanged();
//            }
        tabTitle.setupWithViewPager(vpContent);

        tabTitle.getTabAt(0).setText("调整");
        tabTitle.getTabAt(1).setText("清单");
        tabTitle.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()){
                    case 0:
                        tab.setText("调整");

                        break;
                    case 1:
                        tab.setText("清单");
                        break;
                }
                vpContent.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                switch (tab.getPosition()){
                    case 0:
                        break;
                    case 1:
                        break;
                }
            }
        });
        Log.i("库存盘点","onResume");
//        initData();
    }

    public void initData(){
        serviceApi.getLocationInventory("").subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<BaseBean<List<LocInfoResponse>>>() {
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
                    public void onNext(final BaseBean<List<LocInfoResponse>> data) {
                        //存入数据库
                        if(data.getDATA()!=null){
                            Delete.table(LocInfo.class);
                            Observable.create(new Observable.OnSubscribe<String>() {
                                @Override
                                public void call(Subscriber<? super String> subscriber) {
                                    for(LocInfoResponse info:data.getDATA()){
                                        LocInfo infoTable = new LocInfo();
                                       infoTable.setValues(info);
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

                        }else{
                            activity.showMaterialDialog("加载数据失败", "请重新加载数据", new BaseActivity.OncheckListenner() {
                                @Override
                                public void onPositiveClick() {
                                    initData();
                                }

                                @Override
                                public void onNagativeClick() {
                                //do nothing
                                }
                            });
                        }
                    }
                });

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.loccount_layout, null);

        ButterKnife.bind(this, view);
        application = (MyApplication) getActivity().getApplication();
        serviceApi = RetrofitSingle.getInstance();
        activity = (MainActivity) getActivity();
        locInfoDao = new LocInfoDao();
        Log.i("库存盘点","onCreate");
        fragments = new ArrayList<>();
        fragments.add(new TiaoZhengFragment());
        fragments.add(new LocBillFragment());
//        tabTitle.setupWithViewPager(vpContent);
//        tabTitle.setTabMode(TabLayout.MODE_FIXED);

Log.i("库存盘点","oncreateView");

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
//        application.rxManager.clear();//取消掉所有事件
//        vpContent.removeAllViews();
//        vpContent = null;
        Log.i("库存盘点","onDestroyView");
//        Camera camera = new Camera();
//        camera.rotateZ(360);
    }
}
