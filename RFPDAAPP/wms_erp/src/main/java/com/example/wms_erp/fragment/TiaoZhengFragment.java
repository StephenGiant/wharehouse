package com.example.wms_erp.fragment;

import android.app.Application;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;

import com.example.wms_erp.R;
import com.example.wms_erp.adapter.LocCountAdapter;
import com.example.wms_erp.application.MyApplication;
import com.example.wms_erp.dao.LocInfoDao;
import com.example.wms_erp.decorator.MySpaceDecration;
import com.example.wms_erp.event.CodeEvent;
import com.example.wms_erp.event.RxBus;
import com.example.wms_erp.event.RxManager;
import com.example.wms_erp.event.UpdateEvent;
import com.example.wms_erp.model.response.LocInfo;
import com.example.wms_erp.model.response.OnShelveInfo;
import com.example.wms_erp.ui.MainActivity;
import com.example.wms_erp.util.HandleCodeUtil;
import com.example.wms_erp.util.ToastUtil;
import com.example.wms_erp.view.ClearEditText;
import com.example.wms_erp.view.LocCountDialog;
import com.example.wms_erp.view.OnshelveDialog;

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
 * Created by qianpeng on 2016/9/6.
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
    private List<LocInfo> locInfos;
//    private final MyApplication application;

    @Override
    public void dispatchCode(final String code) {
        if(HandleCodeUtil.isLocCode(code)){
            ceHuowei.setText(code);
        }else if(HandleCodeUtil.isGoodsCode(code)){
            ceCode.setText(code);
        }

    }

    public TiaoZhengFragment() {
        Log.i("创建对象了","调整界面");
//        application = (MyApplication) getActivity().getApplication();
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
        RxBus.getDefault().toObserverable().subscribe(new Subscriber<Object>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Object o) {
        if(o instanceof UpdateEvent){
            onClick();
        }
            }
        });
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
        locInfos = null;
        if(locCountAdapter!=null){
            Log.i("生命周期","保存了信息");
        }
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
Log.i("调整界面","销毁了");
        locCountAdapter=null;
//        application.rxManager.clear();
    }

    @OnClick(R.id.btn_zuofei)
    public void onClick() {
        String barCode = ceCode.getText().toString();
        if(barCode.length()>8)
        {
            final String goodsCode = barCode.substring(0, barCode.length() - 8);
            Log.i("goodsCode", goodsCode);
            final String huowei = ceHuowei.getText().toString();
            if (TextUtils.isEmpty(barCode) || TextUtils.isEmpty(huowei)) {
                ToastUtil.makeText(getContext(), "请确保两个条码都已输入").show();
            } else {
                //要异步操作
                Subscription subscribe = Observable.create(new Observable.OnSubscribe<List<LocInfo>>() {
                    @Override

                    public void call(Subscriber<? super List<LocInfo>> subscriber) {
                        locInfos = LocInfoDao.getLocInfos(huowei, goodsCode);
                        Log.i("看集合长度", locInfos.size() + "");
                        if (locInfos != null && locInfos.size() > 0) {
                            subscriber.onNext(locInfos);
                        } else {
                            Log.i("查询数据库", "失败");
                            subscriber.onError(new Exception());
                        }
                    }
                }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<List<LocInfo>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("出错了", "看看");
                        if (locCountAdapter != null) {
                            locCountAdapter.refreshData(null);
                        }
                    }

                    @Override
                    public void onNext(final List<LocInfo> locInfos) {
                        //显示信息
//                Log.i("查询到了",locInfos.get(0).getGOODSBATCHCODE());
                        Log.i("查询库存",locInfos.toString());
                        if (locCountAdapter == null) {
                            locCountAdapter = new LocCountAdapter((MainActivity) getActivity(), locInfos);
                            locCountAdapter.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                    showCountDialog(position);
                                }
                            });
                            rvDatas.setAdapter(locCountAdapter);
                        } else {
                            Log.i("库存盘点","刷新数据");
                            Log.i("看数据",locInfos.get(0).getGOODSNAME());
                            locCountAdapter.refreshData(locInfos);
                           if(View.VISIBLE!= rvDatas.getVisibility()){
                               Log.i("rv对象",rvDatas.toString());
                           }
//                        TiaoZhengFragment.this.locInfos = locInfos;
//                            locCountAdapter.notifyDataSetChanged();
                        }


                    }

                });
//            application.rxManager.add(subscribe);
            }
        }else{
            ToastUtil.makeText(getContext(),"条码必须为8位以上").show();
        }
    }


    LocCountDialog dialog;
    private void showCountDialog(final int position){
        if(dialog==null) {
            dialog = LocCountDialog.instanceDialog(locInfos.get(position));
        }else{
            dialog.setInfo(locInfos.get(position));
        }
  dialog.setOnConfirmListenner(new LocCountDialog.OnConfirmLitsenner() {
      @Override
      public void onConfirmClick(LocInfo info) {
          dialog.dismiss();

         locCountAdapter.notifyItemChanged(position);
          RxBus.getDefault().send(info);


      }
  });
//        FragmentManager manager = activity.getSupportFragmentManager();
//        android.app.FragmentManager activityFragmentManager = activity.getFragmentManager();
        dialog.show(getActivity().getFragmentManager(),"pickcount");
    }


}
