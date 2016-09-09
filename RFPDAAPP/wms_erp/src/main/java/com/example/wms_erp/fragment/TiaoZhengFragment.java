package com.example.wms_erp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.wms_erp.R;
import com.example.wms_erp.adapter.LocCountAdapter;
import com.example.wms_erp.dao.LocInfoDao;
import com.example.wms_erp.decorator.MySpaceDecration;
import com.example.wms_erp.event.CodeEvent;
import com.example.wms_erp.event.RxBus;
import com.example.wms_erp.event.RxManager;
import com.example.wms_erp.model.response.LocInfo;
import com.example.wms_erp.ui.MainActivity;
import com.example.wms_erp.view.ClearEditText;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2016/9/6.
 */
public class TiaoZhengFragment extends BaseFragment {
    @Bind(R.id.ce_huowei)
    EditText ceHuowei;
    @Bind(R.id.ce_code)
   EditText ceCode;
    @Bind(R.id.btn_zuofei)
    Button btnZuofei;
    @Bind(R.id.rv_datas)
    RecyclerView rvDatas;
public static final int TAG_TIAOZHENG = 0x1005;
    private LocInfoDao locInfoDao;
    private LocCountAdapter locCountAdapter;
    private LocCountAdapter locCountAdapter1;

    @Override
    public void dispatchCode(final String code) {
        //要异步操作
        Observable.create(new Observable.OnSubscribe<List<LocInfo>>() {
            @Override
            public void call(Subscriber<? super List<LocInfo>> subscriber) {
                List<LocInfo> locInfos = LocInfoDao.getLocInfos("LU4A02", "0101010986");
                Log.i("看集合长度",locInfos.size()+"");
                if(locInfos!=null&&locInfos.size()>0){
                    subscriber.onNext(locInfos);
                }else{
                    Log.i("查询数据库","失败");
                    subscriber.onError(new Exception());
                }
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<List<LocInfo>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                Log.e("出错了","看看");
            }

            @Override
            public void onNext(List<LocInfo> locInfos) {
                    //显示信息
//                Log.i("查询到了",locInfos.get(0).getGOODSBATCHCODE());
                    if (locCountAdapter == null) {
                        locCountAdapter = new LocCountAdapter((MainActivity) getActivity(), locInfos);
                        rvDatas.setAdapter(locCountAdapter);
                    } else {
                        locCountAdapter.refreshData(locInfos);
                    }


            }

        });


    }

    public TiaoZhengFragment() {
        Log.i("创建对象了","调整界面");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.loctable_layout, null);
        ButterKnife.bind(this, view);
        Log.i("加载布局了","调整界面");
        rvDatas.addItemDecoration(new MySpaceDecration(10));
        return view;
    }

    @Override
    public void onResume() {

        super.onResume();
        Subscription subscription = RxBus.getDefault().toObserverable().subscribe(new Subscriber<Object>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Object event) {
                double i = 3.5 % 1.5;
                int j = 9/4;
                Log.i("test",i+"");
                Log.i("test2",j+"");
                if(event instanceof CodeEvent){
                    //发的是条码
                    if(((CodeEvent) event).getTag()==TAG_TIAOZHENG){
                        dispatchCode(((CodeEvent) event).getCode());
                        Log.i("扫描",((CodeEvent) event).getCode());
                    }
//
                }
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick(R.id.btn_zuofei)
    public void onClick() {
        //作废
    }
}
