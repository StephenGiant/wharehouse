package com.example.wms_erp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.wms_erp.R;
import com.example.wms_erp.presenter.impl.GoodsMovePresenterImpl;
import com.example.wms_erp.ui.MainActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/9/22.
 */

public class GoodsMoveFragment extends BaseFragment {
    @Bind(R.id.et_GoodsCode)
    EditText etGoodsCode;
    @Bind(R.id.et_LocCode)
    EditText etLocCode;
    @Bind(R.id.rv_goodslocs)
    public RecyclerView rvGoodslocs;
    public static final int TAG_MOVELACATION = 0x1007;
    @Bind(R.id.btn_query)
    Button btnQuery;
    private GoodsMovePresenterImpl goodsMovePresenter;

    @Override
    public void dispatchCode(String code) {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.movegoods_layout, null);
        ButterKnife.bind(this, view);
        goodsMovePresenter = new GoodsMovePresenterImpl((MainActivity) getActivity(), this);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick(R.id.btn_query)
    public void onClick() {
        goodsMovePresenter.getGoodsLocInfo(etGoodsCode.getText().toString(),etLocCode.getText().toString());
    }
}
