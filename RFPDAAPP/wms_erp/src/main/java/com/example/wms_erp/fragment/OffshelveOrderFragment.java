package com.example.wms_erp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wms_erp.R;
import com.example.wms_erp.adapter.OffshelveOrderAdapter;
import com.example.wms_erp.decorator.MySpaceDecration;
import com.example.wms_erp.event.CodeEvent;
import com.example.wms_erp.event.RxBus;
import com.example.wms_erp.listenner.OffShelveOrderListenner;
import com.example.wms_erp.model.response.OffshelveInfo;
import com.example.wms_erp.presenter.impl.OffshelveOrderPresenterImpl;
import com.example.wms_erp.ui.BaseActivity;
import com.example.wms_erp.ui.LoginAct;
import com.example.wms_erp.ui.MainActivity;
import com.example.wms_erp.util.SharePreUtil;
import com.example.wms_erp.view.ClearEditText;
import com.example.wms_erp.view.DatePickWiget;
import com.example.wms_erp.view.OffshelveOrderDialog;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Subscriber;
import rx.Subscription;


/**
 * 指令下架
 * Created by qianpeng on 2016/9/29.
 */

public class OffshelveOrderFragment extends BaseFragment implements OffShelveOrderListenner {
    @Bind(R.id.sp_kuwei)
    public Spinner spKuwei;
    @Bind(R.id.datePicker)
    DatePickWiget datePicker;
    @Bind(R.id.et_batch)
    EditText etBatch;
    @Bind(R.id.iv_query)
    ImageView ivQuery;
    @Bind(R.id.rv_offshelveInfo)
    public RecyclerView rvOffshelveInfo;
    @Bind(R.id.ll_comit_offshelve)
    LinearLayout llComitOffshelve;

    private OffshelveOrderPresenterImpl offshelveOrderPresenter;
    public static final int TAG_OFFSHELVEORDER = 0x1012;
    private MainActivity activity;
    private View dialogContent;
    private TextView tv_batchCode;
    private TextView tv_adviceNum;
    private ClearEditText et_actuallyNum;
    private List<OffshelveInfo> datas;
    private OffshelveOrderAdapter adapter;
    private OffshelveOrderDialog dialog;
    private int userID;

    @Override
    public void dispatchCode(String code) {
        offshelveOrderPresenter.scrollto(code);
//        Toast.makeText(getContext(),code,Toast.LENGTH_SHORT).show();//测试代码
        //到缓存数据中寻找匹配数据
//        offshelveOrderPresenter.signOrder(code);
        offshelveOrderPresenter.getLocationInfo(code);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.offshelve_order_layout, null);
//        dialogContent = inflater.inflate(R.layout.offshelveorder_dialog, null);
//        tv_batchCode = (TextView) dialogContent.findViewById(R.id.goods_code_dialog);
//        tv_adviceNum = (TextView) dialogContent.findViewById(R.id.tv_tuijian);
//        et_actuallyNum = (ClearEditText) dialogContent.findViewById(R.id.et_actuallyNum);
        userID = SharePreUtil.getInteger(getContext(), "userID", 3);
        ButterKnife.bind(this, view);
        rvOffshelveInfo.addItemDecoration(new MySpaceDecration(10, LinearLayoutManager.VERTICAL));
        offshelveOrderPresenter = new OffshelveOrderPresenterImpl((MainActivity) getActivity(), this);
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
                    if (((CodeEvent) o).getTag() == TAG_OFFSHELVEORDER) {
                        dispatchCode(((CodeEvent) o).getCode());
                    }
                }
            }
        });
        activity = (MainActivity) getActivity();
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }


    @OnClick({R.id.iv_query,R.id.ll_comit_offshelve })
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_query:
                offshelveOrderPresenter.getOffshelveOrderInfo((String) spKuwei.getSelectedItem(), userID, etBatch.getText().toString(), datePicker.getDate());
                break;
            case R.id.ll_comit_offshelve:
                Log.i("点击提交","click");
                offshelveOrderPresenter.postOffshelveOrder(3,datas);

                break;
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
                    if(((CodeEvent) o).getTag()==TAG_OFFSHELVEORDER) {
                        dispatchCode(((CodeEvent) o).getCode());
                    }
                }
            }
        });
    }

    @Override
    public void onPause() {
        super.onPause();

    }

    @Override
    public void onCellNoGet() {

    }

    @Override
    public void onCellNoFail() {

    }

    @Override
    public void onItemSign() {

    }

    @Override
    public void onItemSignFail() {

    }

    @Override
    public void onOffshelveOrderGet(List<OffshelveInfo> datas) {
this.datas = datas;

//        if(adapter==null) {
            adapter = new OffshelveOrderAdapter(activity, datas);

            rvOffshelveInfo.setAdapter(adapter);
//        }else{
//            adapter.refreshData(datas);
//        }
    }

    @Override
    public void onOffshelveOderFailed() {
        if(adapter!=null){
            adapter.refreshData(null);
        }

    }

    @Override
    public void onPostOffshelve() {

    }

    @Override
    public void onPostOffshelveFailed() {

    }

    @Override
    public void onGetBatchInfo(OffshelveInfo info) {
        Log.i("getBatchinfo","success");
        if(datas!=null) {
            showDialog(info);
//            Log.i("批次号",info.getGOODSBATCHCODE());
        }else{

        }
    }

    @Override
    public void onGetBatchInfoFailed(String message) {
        activity.ToastCheese(message);
        if(dialog!=null)
            dialog.dismiss();

    }

    private void markItem(String code){
        //标记扫描到的条目
    }

    private void showDialog(final OffshelveInfo info){
        Log.i("dialog","attach");
        //对话框显示数据
        try {
            if(dialog==null) {
                dialog = OffshelveOrderDialog.instanceDialog(activity, info);
            }
            dialog.setContentInfo(info);
            dialog.setOnDialogDismissListener(new OffshelveOrderDialog.OnDialogDismissListenner() {
                @Override
                public void onDialogDismiss(OffshelveInfo info) {
                    for (OffshelveInfo osif:datas
                         ) {
                        if(osif.getGOODSNAME().equals(info.getGOODSNAME())){
                            osif.setQTYEXCE(info.getQTYEXCE());
                            osif.setGOODSBATCHCODE(info.getGOODSBATCHCODE());
                            break;
                        }
                    }
//                    offshelveOrderPresenter.refreshData(datas);
                    adapter.refreshData(datas);
                }
            });
            dialog.show(activity.getFragmentManager(),"offshelveOrder");
        }catch (Exception e){
            e.printStackTrace();
        }

    }


}
