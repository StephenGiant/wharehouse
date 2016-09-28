package com.example.wms_erp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.wms_erp.R;
import com.example.wms_erp.event.CodeEvent;
import com.example.wms_erp.event.RxBus;
import com.example.wms_erp.presenter.impl.GoodsMovePresenterImpl;
import com.example.wms_erp.ui.MainActivity;
import com.example.wms_erp.util.HandleCodeUtil;
import com.example.wms_erp.util.ToastUtil;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Subscriber;

/**
 * Created by Administrator on 2016/9/22.
 */

public class GoodsMoveFragment extends BaseFragment {
    @Bind(R.id.et_GoodsCode)
   public EditText etGoodsCode;
    @Bind(R.id.et_LocCode)
   public EditText etLocCode;
    @Bind(R.id.rv_goodslocs)
    public RecyclerView rvGoodslocs;
    public static final int TAG_MOVELACATION = 0x1007;
    @Bind(R.id.btn_query)
    Button btnQuery;
    @Bind(R.id.target_loc)
   public EditText targetLoc;
    private GoodsMovePresenterImpl goodsMovePresenter;
    boolean getInfo = false;

    @Override
    public void dispatchCode(String code) {
        if (code != null) {
            if (code.length() == 6) {

                   if(!targetLoc.isEnabled()) {
                  etLocCode.setText(code);
                   }else{
                       targetLoc.setText(code);
                   }

            } else {
                etGoodsCode.setText(code);
                if(goodsMovePresenter.getGoodsLocInfo(code, "")){
                    getInfo= true;
                }else {
                    getInfo = false;
                }
            }
        }
        if(!TextUtils.isEmpty(etGoodsCode.getText().toString())&&!TextUtils.isEmpty(etLocCode.getText().toString())){
            goodsMovePresenter.getGoodsLocInfo(etGoodsCode.getText().toString(), etLocCode.getText().toString());

        }
    }
private void checkLoc(String code){
if(goodsMovePresenter.checkLoc(code)){
    //货位正确的时候
    etLocCode.setText(code);
    targetLoc.setEnabled(true);
}
}
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.movegoods_layout, null);
        ButterKnife.bind(this, view);
        goodsMovePresenter = new GoodsMovePresenterImpl((MainActivity) getActivity(), this);
        RxBus.getDefault().toObserverable().subscribe(new Subscriber<Object>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Object o) {
                String code = null;
                if (o instanceof CodeEvent) {
                    if(((CodeEvent) o).getTag()==TAG_MOVELACATION) {
                        if (HandleCodeUtil.isLocCode(((CodeEvent) o).getCode())) {
                            code = ((CodeEvent) o).getCode();
                        } else {
                            code = ((CodeEvent) o).getCode().substring(0, ((CodeEvent) o).getCode().length() - 8);
                        }
                        dispatchCode(code);
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

    @OnClick(R.id.btn_query)
    public void onClick() {
      //提交转仓
        if(targetLoc.isEnabled()) {
            goodsMovePresenter.postChangeLoc(targetLoc.getText().toString());

        }else{
            ToastUtil.makeText(getContext(),"非法操作！").show();
        }
    }
}
