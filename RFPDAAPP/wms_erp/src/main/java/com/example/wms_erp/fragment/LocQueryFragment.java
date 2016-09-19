package com.example.wms_erp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wms_erp.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/9/19.
 */
public class LocQueryFragment extends BaseFragment {
    @Bind(R.id.rv_locdetails)
    RecyclerView rvLocdetails;

    @Override
    public void dispatchCode(String code) {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.goodsloacate_query_layout, null);
        ButterKnife.bind(this, super.onCreateView(inflater, container, savedInstanceState));
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
