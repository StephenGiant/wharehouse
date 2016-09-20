package com.example.wms_erp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wms_erp.R;
import com.example.wms_erp.event.CodeEvent;
import com.example.wms_erp.event.RxBus;
import com.example.wms_erp.presenter.impl.LocQueryPresenterImpl;
import com.example.wms_erp.ui.MainActivity;
import com.example.wms_erp.view.ClearEditText;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.Subscriber;

/**
 * Created by Administrator on 2016/9/19.
 */
public class LocQueryFragment extends BaseFragment {
    @Bind(R.id.rv_locdetails)
    public RecyclerView rvLocdetails;
    @Bind(R.id.ce_code)
    ClearEditText ceCode;
    private LocQueryPresenterImpl presenter;
    public static final int TAG_LOCQUERY = 0x1006;

    @Override
    public void dispatchCode(String code) {
ceCode.setText(code);
        presenter.showLocDetail(code);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.goodsloacate_query_layout, null);
        ButterKnife.bind(this, view);
        presenter = new LocQueryPresenterImpl((MainActivity) getActivity(), this);
        RxBus.getDefault().toObserverable().subscribe(new Subscriber<Object>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Object o) {
                if (o instanceof CodeEvent) {
                    if (((CodeEvent) o).getTag() == TAG_LOCQUERY) {
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
}
