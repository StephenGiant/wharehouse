package com.example.wms_erp.view;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.wms_erp.R;
import com.example.wms_erp.model.response.GoodsLocInfo;
import com.example.wms_erp.model.response.OnShelveInfo;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 转移货位弹出框
 * Created by qianpeng on 2016/9/22.
 */

public class ChangeLocDialog extends DialogFragment {
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.subtitle)
    TextView subtitle;
    @Bind(R.id.goods_code_dialog)
    TextView goodsCodeDialog;
    @Bind(R.id.ll_reson)
    LinearLayout llReson;
    @Bind(R.id.et_updateLoc)
    EditText etUpdateLoc;
    @Bind(R.id.ll_huoweiupdate)
    LinearLayout llHuoweiupdate;
    @Bind(R.id.btn_comit)
    Button btnComit;
    private static ChangeLocDialog dialog;
    private  OnShelveInfo info;
    public static ChangeLocDialog getInstance(OnShelveInfo info){
        //单例的创建，防止弹多个对话框
        synchronized (ChangeLocDialog.class){
            if(dialog==null){
                dialog = new ChangeLocDialog();

            }
                dialog.setData(info);

        }
        return dialog;
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

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

//        ButterKnife.bind(this, super.onCreateView(inflater, container, savedInstanceState));
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    private View initView() {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.goodsmove_dialog, null);
        ButterKnife.bind(this,view);
        if(tvTitle!=null) {
            tvTitle.setText(info.getGOODSNAME());
            goodsCodeDialog.setText(info.getGOODSCODE());
        }

        return view;
    }
    public void setData(OnShelveInfo info){
        this.info = info;
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
    public String getNewHuowei(){
        return etUpdateLoc.getText().toString();
    }
    @Override
    public void show(FragmentManager manager, String tag) {
        super.show(manager, tag);
    }
    private ChangeLocDialog.OnConfirmLitsenner listenner;

    public void setOnConfirmListenner(ChangeLocDialog.OnConfirmLitsenner listenner) {
        this.listenner = listenner;
    }



    public static interface OnConfirmLitsenner {
        public void onConfirmClick(OnShelveInfo info);
    }
}
