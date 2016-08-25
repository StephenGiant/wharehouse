package com.example.wms_erp.view;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.wms_erp.R;
import com.example.wms_erp.model.response.OnShelveInfo;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 模仿datepickerdialog
 * Created by qianpeng on 2016/8/25.
 */
public class OnshelveDialog extends DialogFragment {

    @Bind(R.id.sp_reason)
    Spinner spReason;
    @Bind(R.id.et_bigunit)
    ClearEditText etBigunit;
    @Bind(R.id.et_smalluint)
    ClearEditText etSmalluint;
    @Bind(R.id.btn_comit)
    Button btnComit;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    private Activity activity;
    private OnShelveInfo info;

    public static OnshelveDialog instanceDialog(OnShelveInfo info) {
        OnshelveDialog dialog = new OnshelveDialog();
        dialog.info = info;

        return dialog;
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
        return dialog;
    }

    @Override
    public void onResume() {
        int height = getResources().getDimensionPixelSize(R.dimen.picker_height);

        Window window = getDialog().getWindow();
        window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, height + 90);//Here!
        window.setGravity(Gravity.BOTTOM);
        super.onResume();

    }

    private View initView() {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.onshelve_dialog, null);
        ButterKnife.bind(this, view);
tvTitle.setText(info.getGOODSNAME());
        return view;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick(R.id.btn_comit)
    public void onClick() {
        dismiss();
    }

    public static class Builder {

        OnshelveDialog dialog;
        View contentView;

        public Builder setContentView(View view) {
            contentView = view;
            return this;
        }

        public OnshelveDialog build() {

            return dialog;
        }
    }


}
