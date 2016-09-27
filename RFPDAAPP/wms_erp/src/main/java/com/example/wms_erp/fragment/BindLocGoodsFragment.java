package com.example.wms_erp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.wms_erp.R;
import com.example.wms_erp.presenter.impl.BindLocGoodsPresenter;
import com.example.wms_erp.ui.MainActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

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
    private BindLocGoodsPresenter bindLocGoodsPresenter;

    @Override
    public void dispatchCode(String code) {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bindlocgoods_layout, container, false);
        ButterKnife.bind(this, view);
        bindLocGoodsPresenter = new BindLocGoodsPresenter((MainActivity) getActivity(), this);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick(R.id.button)
    public void onClick() {
        bindLocGoodsPresenter.postBindLocGoods(etGoodsCode.getText().toString(),etLocCode.getText().toString());
    }
}
