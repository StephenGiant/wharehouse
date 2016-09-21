package com.example.wms_erp.view;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.example.wms_erp.R;
import com.example.wms_erp.model.response.LocInfo;
import com.example.wms_erp.model.response.OnShelveInfo;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 模仿datepickerdialog
 * Created by qianpeng on 2016/8/25.
 */
public class OnshelveDialog extends DialogFragment {


    @Bind(R.id.et_bigunit)
    ClearEditText etBigunit;
    @Bind(R.id.et_smalluint)
    ClearEditText etSmalluint;
    @Bind(R.id.btn_comit)
    Button btnComit;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.goods_code_dialog)
    TextView goodsCodeDialog;
    private Activity activity;
    private OnShelveInfo info;
    private LocInfo locInfo;
    public static OnshelveDialog instanceDialog(Object info) {
        OnshelveDialog dialog = new OnshelveDialog();
        if(info instanceof OnShelveInfo) {
            dialog.info = (OnShelveInfo) info;
        }else{

        }

        return dialog;
    }

    public void setInfo(OnShelveInfo info) {
        this.info = info;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = getActivity();
        //隐藏输入法
//        activity.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        Dialog dialog = new Dialog(getActivity(), R.style.Dialog_NoTitle);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(initView());
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        return dialog;
    }

    @Override
    public void onResume() {
        int height = getResources().getDimensionPixelSize(R.dimen.picker_height);

        Window window = getDialog().getWindow();
        window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, height + 90);//Here!
        window.setGravity(Gravity.BOTTOM);
        super.onResume();
        try {
            tvTitle.setText(info.getGOODSNAME());
            etSmalluint.setFocusable(true);
            if (info.getPURUNITNAME().equals(info.getUNITNAME())) {
                etSmalluint.setFocusable(false);
            }
            goodsCodeDialog.setText(info.getGOODSCODE());
        }catch (NullPointerException e){
            e.printStackTrace();
            tvTitle.setText("异常");
            goodsCodeDialog.setText("异常，请检查批次");
        }

    }

    private View initView() {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.onshelve_dialog, null);
        ButterKnife.bind(this, view);
//        setInfo(info);
        try {
            tvTitle.setText(info.getGOODSNAME());
            etSmalluint.setFocusable(true);
            if (info.getPURUNITNAME().equals(info.getUNITNAME())) {
                etSmalluint.setFocusable(false);
            }
            goodsCodeDialog.setText(info.getGOODSCODE());
        }catch (NullPointerException e){
            e.printStackTrace();
            tvTitle.setText("异常");
            goodsCodeDialog.setText("异常，请检查批次");
        }

        return view;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    String test;


    @OnClick(R.id.btn_comit)
    public void onClick() {
        double bigUnit = 0;
        double smallunit=0;

            test = etBigunit.getText().toString();
            Log.i("大单位", etBigunit.getText().toString());

            if (!TextUtils.isEmpty(etBigunit.getText().toString())) {
                bigUnit = Double.parseDouble(etBigunit.getText().toString());
            } else {
                bigUnit = 0;
            }
            info.setMAXQTY(bigUnit);
            Log.i("大单位", info.getMAXQTY() + "");

            if (!TextUtils.isEmpty(etSmalluint.getText().toString())) {
                smallunit = Double.parseDouble(etSmalluint.getText().toString());
            } else {
                smallunit = 0;
            }
        if(!info.getUNITNAME().equals(info.getPURUNITNAME())) {
            info.setQTY(bigUnit * info.getPURUNITQTY() + smallunit);
        }else{
            info.setQTY(bigUnit+smallunit);
        }
        if (listenner != null) {
            listenner.onConfirmClick(info);
        }
//        dismiss();
    }

    private OnConfirmLitsenner listenner;

    public void setOnConfirmListenner(OnConfirmLitsenner listenner) {
        this.listenner = listenner;
    }



    public static interface OnConfirmLitsenner {
        public void onConfirmClick(OnShelveInfo info);
    }

    public static class Builder {

        OnshelveDialog dialog;
        View contentView;

        public Builder setContentView(View view) {
            contentView = view;
            return this;
        }

        public OnshelveDialog build() {
                dialog.setCancelable(false);
            return dialog;
        }
    }

    public String getCountDetail() {
        String small = etSmalluint.getText().toString();
        String big = etBigunit.getText().toString();
        if(TextUtils.isEmpty(small)&&TextUtils.isEmpty(big)){
            return null;
        }
        StringBuilder sb = new StringBuilder();
        if(!info.getUNITNAME().equals(info.getPURUNITNAME())) {
            sb.append(etBigunit.getText().toString());
            sb.append(info.getPURUNITNAME());
            sb.append(etSmalluint.getText().toString());
            sb.append(info.getUNITNAME());
        }else{
            sb.append((Double.parseDouble(TextUtils.isEmpty(big)?"0":big)+Double.parseDouble(TextUtils.isEmpty(small)?"0":small))+info.getPURUNITNAME());
        }
        Log.i("看返回", sb.toString());
        return sb.toString();

    }

}
