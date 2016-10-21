package com.example.wms_erp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wms_erp.presenter.impl.OnOffShelvePresenterImpl;
import com.example.wms_erp.ui.MainActivity;

/**
 * Created by Administrator on 2016/10/21.
 */

public class OffshelveFragment extends BaseFragment {

    private OnOffShelvePresenterImpl onOffShelvePresenter;

    @Override
    public void dispatchCode(String code) {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        onOffShelvePresenter = new OnOffShelvePresenterImpl((MainActivity) getActivity(), null);
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
