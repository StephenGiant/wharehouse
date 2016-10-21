package com.example.wms_erp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import com.example.wms_erp.R;
import com.example.wms_erp.event.CodeEvent;
import com.example.wms_erp.event.RxBus;
import com.example.wms_erp.presenter.impl.OffshelveOrderPresenterImpl;
import com.example.wms_erp.ui.MainActivity;
import com.example.wms_erp.view.DatePickWiget;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Subscriber;

/**
 * Created by Administrator on 2016/9/29.
 */

public class OffshelveOrderFragment extends BaseFragment {
    @Bind(R.id.sp_kuwei)
    public Spinner spKuwei;
    @Bind(R.id.datePicker)
    DatePickWiget datePicker;
    @Bind(R.id.et_batch)
    EditText etBatch;
    @Bind(R.id.iv_query)
    ImageView ivQuery;
    @Bind(R.id.rv_offshelveInfo)
    public RecyclerView rvOffshelveInfo;
    @Bind(R.id.iv_putdown)
    ImageView ivPutdown;
    private OffshelveOrderPresenterImpl offshelveOrderPresenter;
    public static final int TAG_OFFSHELVEORDER = 0x1012;

    @Override
    public void dispatchCode(String code) {
            offshelveOrderPresenter.scrollto(code);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.offshelve_order_layout, null);
        ButterKnife.bind(this, view);
        offshelveOrderPresenter = new OffshelveOrderPresenterImpl((MainActivity) getActivity(), this);
        RxBus.getDefault().toObserverable().subscribe(new Subscriber<Object>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Object o) {
                    if(o instanceof CodeEvent){
                        if(((CodeEvent) o).getTag()==TAG_OFFSHELVEORDER){
                            dispatchCode(((CodeEvent) o).getCode());
                        }
                    }
            }
        });
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }


    @OnClick({R.id.iv_query, R.id.iv_putdown})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_query:
                offshelveOrderPresenter.getOffshelveOrderInfo((String) spKuwei.getSelectedItem(),3,etBatch.getText().toString(),datePicker.getDate());
                break;
            case R.id.iv_putdown:
                offshelveOrderPresenter.postOffshelveOrder(3);
                break;
        }
    }
}
