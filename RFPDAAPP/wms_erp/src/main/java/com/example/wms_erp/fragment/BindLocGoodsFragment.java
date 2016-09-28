package com.example.wms_erp.fragment;

import android.app.Application;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.wms_erp.R;
import com.example.wms_erp.application.MyApplication;
import com.example.wms_erp.event.CodeEvent;
import com.example.wms_erp.event.RxBus;
import com.example.wms_erp.presenter.impl.BindLocGoodsPresenter;
import com.example.wms_erp.ui.MainActivity;
import com.example.wms_erp.util.HandleCodeUtil;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Subscriber;
import rx.Subscription;

/**
 * Created by Administrator on 2016/9/27.
 */

public class BindLocGoodsFragment extends BaseFragment {
    @Bind(R.id.et_goodsCode)
    EditText etGoodsCode;
    @Bind(R.id.et_locCode)
    EditText etLocCode;
    @Bind(R.id.button)
    Button button;
    public static final int TAG_BINDLOCGOODS = 0x1010;
    private BindLocGoodsPresenter bindLocGoodsPresenter;
    private MyApplication application;

    @Override
    public void dispatchCode(String code) {
       if(HandleCodeUtil.isLocCode(code)){
            etLocCode.setText(code);
        }else if(code.length()>8){
           code = code.substring(0,code.length()-8);
           etGoodsCode.setText(code);
       }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bindlocgoods_layout, container, false);
        ButterKnife.bind(this, view);
        bindLocGoodsPresenter = new BindLocGoodsPresenter((MainActivity) getActivity(), this);
        application = (MyApplication) getActivity().getApplication();
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void onResume() {
        Subscription subscribe = RxBus.getDefault().toObserverable().subscribe(new Subscriber<Object>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Object o) {
                if (o instanceof CodeEvent) {
                    if (((CodeEvent) o).getTag() == TAG_BINDLOCGOODS) {
                        dispatchCode(((CodeEvent) o).getCode());
                    }
                }
            }
        });
        application.rxManager.add(subscribe);

        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
//        application.rxManager.clear();
    }

    @OnClick(R.id.button)
    public void onClick() {
        bindLocGoodsPresenter.postBindLocGoods(etGoodsCode.getText().toString(),etLocCode.getText().toString());
    }
}
