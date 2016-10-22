package com.example.wms_erp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.wms_erp.R;
import com.example.wms_erp.event.CodeEvent;
import com.example.wms_erp.event.RxBus;
import com.example.wms_erp.presenter.impl.OffshelvePresenterImpl;
import com.example.wms_erp.presenter.impl.OnOffShelvePresenterImpl;
import com.example.wms_erp.ui.BaseActivity;
import com.example.wms_erp.ui.MainActivity;
import com.example.wms_erp.util.HandleCodeUtil;
import com.example.wms_erp.view.SearchEditText;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Subscriber;
import rx.Subscription;

/**
 * Created by Administrator on 2016/10/21.
 */

public class OffshelveFragment extends BaseFragment {

    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.ll_categary)
    LinearLayout llCategary;
    @Bind(R.id.se_barCode)
    SearchEditText seBarCode;
    @Bind(R.id.sp_reson)
    Spinner spReson;
    @Bind(R.id.onshelve_data)
   public RecyclerView onshelveData;
    @Bind(R.id.submit)
    Button submit;
    private OnOffShelvePresenterImpl onOffShelvePresenter;
    private String[] stringArray;
    private OffshelvePresenterImpl offshelvePresenter;
    private MainActivity activity;
    //缓存的条码集合，去除重复扫描
    public static ArrayList<String> codes;
public static final int TAG_OFFSHELVE = 0x1024;

    public OffshelveFragment() {
        codes = new ArrayList<>();
    }

    public static void clearCodes() {
        codes.clear();
    }

    public static void removeCode(int index) {
        if (codes.size() > 1) {
            codes.remove(index);
        } else {
            codes.clear();
        }
    }

    @Override
    public void dispatchCode(final String code) {
        if (HandleCodeUtil.checkDate(code)) {
            seBarCode.setText(code);

                    offshelvePresenter.getOffShelveInfo(code,curType);

//            if (onOffShelvePresenter.isShowing()) {
//
//            }
        } else {
            if(!"报损".equals(curType)){
                //报损下架
                activity.showMaterialDialog("此商品已过期", "点确认将选报损下架", new BaseActivity.OncheckListenner() {
                    @Override
                    public void onPositiveClick() {
                        seBarCode.setText(code);
                        spReson.setSelection(3);
                        curType = "报损";
                        offshelvePresenter.getOffShelveInfo(code,curType);
                    }

                    @Override
                    public void onNagativeClick() {
                        seBarCode.setText("");
                    }
                });
            }else {
                seBarCode.setText(code);

                offshelvePresenter.getOffShelveInfo(code,curType);
            }
        }
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
            public void onNext(Object o) {
                if (o instanceof CodeEvent) {
                    Log.i("RxBus", ((CodeEvent) o).getCode());
                    if(((CodeEvent) o).getTag()==TAG_OFFSHELVE) {
                        dispatchCode(((CodeEvent) o).getCode());
                    }
                }
            }
        });
    }

    private String curType = "门店出货" ;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        onOffShelvePresenter = new OnOffShelvePresenterImpl((MainActivity) getActivity(), null);
        View view = inflater.inflate(R.layout.offshelve_layout, null);
        ButterKnife.bind(this, view);
        activity = (MainActivity) getActivity();
        stringArray = getActivity().getResources().getStringArray(R.array.offshelve_type);
        spReson.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                curType = stringArray[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        offshelvePresenter = new OffshelvePresenterImpl(this, (MainActivity) getActivity());
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick(R.id.submit)
    public void onClick() {
        offshelvePresenter.postOffshelve(curType);
    }
}
