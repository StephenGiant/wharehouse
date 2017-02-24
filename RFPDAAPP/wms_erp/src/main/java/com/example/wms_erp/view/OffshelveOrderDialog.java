package com.example.wms_erp.view;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wms_erp.R;
import com.example.wms_erp.model.response.OffshelveInfo;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 指令下架对话框
 * Created by qianpeng on 2017/1/16.
 */

public class OffshelveOrderDialog extends DialogFragment {
    static OffshelveOrderDialog dialog;
    @Bind(R.id.subtitle)
    TextView subtitle;
    @Bind(R.id.goods_code_dialog)
    TextView goodsCodeDialog;
    @Bind(R.id.ll_reson)
    LinearLayout llReson;
    @Bind(R.id.subtitle2)
    TextView subtitle2;
    @Bind(R.id.content2)
    TextView content2;
    @Bind(R.id.ll_kucun)
    LinearLayout llKucun;
    @Bind(R.id.title_bigunit)
    TextView titleBigunit;
    @Bind(R.id.tv_tuijian)
    TextView tvTuijian;
    @Bind(R.id.title_smallunit)
    TextView titleSmallunit;
    @Bind(R.id.et_actuallyNum)
    ClearEditText etActuallyNum;
    @Bind(R.id.ll_comimtinfo)
    LinearLayout llComimtinfo;
    @Bind(R.id.btn_confirmNum)
    Button btnConfirmNum;
    OffshelveInfo mInfo;
    @Bind(R.id.goods_name_dialog)
    TextView goodsNameDialog;
    private OnDialogDismissListenner listenner;
    Context mContext;

    public static OffshelveOrderDialog instanceDialog(Context context, OffshelveInfo info) {
        OffshelveOrderDialog dialog = new OffshelveOrderDialog();

        dialog.mInfo = info;
        dialog.mContext = context;


        return dialog;
    }


    @Override
    public void setArguments(Bundle args) {
        super.setArguments(args);
    }

//    public  OffshelveOrderDialog (Context context, OffshelveInfo info) {
//
//        mInfo = info;
//        mContext = context;
//
//    }

    @Override
    public void onResume() {
        int height = getResources().getDimensionPixelSize(R.dimen.picker_height);

        Window window = getDialog().getWindow();
        window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, height + 90);//Here!
        window.setGravity(Gravity.BOTTOM);
        etActuallyNum.setText((mInfo.getQTY() > mInfo.getINVQTY() ? mInfo.getINVQTY() : mInfo.getQTY()) + "");
        tvTuijian.setText(mInfo.getINVQTY() + "");
        goodsCodeDialog.setText(mInfo.getGOODSBATCHCODE());
        goodsNameDialog.setText(mInfo.getGOODSNAME());
        super.onResume();
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
//        return super.onCreateDialog(savedInstanceState);
        Dialog dialog = new Dialog(getActivity(), R.style.Dialog_NoTitle);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(initView());
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        return dialog;
    }

    private View initView() {
        View view = LayoutInflater.from(mContext).inflate(R.layout.offshelveorder_dialog, null);
        if (view == null) {
            Log.e("inflate", "error");
        }
        ButterKnife.bind(this, view);

        return view;
    }

    /**
     * 填充数据
     */
    public void setContentInfo(OffshelveInfo info) {
        mInfo = info;
        if (etActuallyNum == null) {
            Log.e("初始化布局", "出错");
        } else {

            etActuallyNum.setText((info.getQTY() > info.getINVQTY() ? info.getINVQTY() : info.getQTY()) + "");
            tvTuijian.setText(info.getINVQTY() + "");
            goodsCodeDialog.setText(info.getGOODSBATCHCODE());
            goodsNameDialog.setText(mInfo.getGOODSNAME());
        }

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }


    @OnClick(R.id.btn_confirmNum)
    public void onClick() {
        if (Double.parseDouble(etActuallyNum.getText().toString()) <= mInfo.getINVQTY()) {
            try {
                mInfo.setQTYEXCE(Double.parseDouble(etActuallyNum.getText().toString()));
                Log.i("看下架数", mInfo.getQTYEXCE() + "");

                listenner.onDialogDismiss(mInfo);
            } catch (NullPointerException e) {
                e.printStackTrace();
                Log.e("出错", "点击监听未实例化");
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }

            dismiss();
        } else {
            Toast.makeText(getActivity(), "不能大于库存", Toast.LENGTH_SHORT).show();
        }
    }

    public void setOnDialogDismissListener(OnDialogDismissListenner listener) {
        this.listenner = listener;

    }



    public interface OnDialogDismissListenner {
        public void onDialogDismiss(OffshelveInfo info);
    }
}
