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
import com.example.wms_erp.event.RxBus;
import com.example.wms_erp.view.ClearEditText;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action1;

/**
 * Created by Administrator on 2016/9/6.
 */
public class TiaoZhengFragment extends BaseFragment {
    @Bind(R.id.ce_huowei)
    EditText ceHuowei;
    @Bind(R.id.ce_bigunit)
    EditText ceBigunit;
    @Bind(R.id.ce_smallunit)
    EditText ceSmallunit;
    @Bind(R.id.ce_code)
   EditText ceCode;
    @Bind(R.id.btn_zuofei)
    Button btnZuofei;
    @Bind(R.id.rv_datas)
    RecyclerView rvDatas;
public static final int TAG_TIAOZHENG = 0x1005;
    @Override
    public void dispatchCode(String code) {

    }

    public TiaoZhengFragment() {
        Log.i("创建对象了","调整界面");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.loctable_layout, null);
        ButterKnife.bind(this, view);
        Log.i("加载布局了","调整界面");
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
                if(event instanceof String){
                    //发的是条码
                    dispatchCode((String)event);
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
