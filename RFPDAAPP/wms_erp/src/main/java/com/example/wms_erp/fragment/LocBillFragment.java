package com.example.wms_erp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.wms_erp.R;
import com.example.wms_erp.adapter.LocCountAdapter;
import com.example.wms_erp.application.MyApplication;
import com.example.wms_erp.dao.LocInfoDao;
import com.example.wms_erp.decorator.MySpaceDecration;
import com.example.wms_erp.event.RxBus;
import com.example.wms_erp.event.UpdateEvent;
import com.example.wms_erp.model.BaseBean;
import com.example.wms_erp.model.response.LocInfo;
import com.example.wms_erp.retrofit.RetrofitSingle;
import com.example.wms_erp.retrofit.ServiceApi;
import com.example.wms_erp.util.SharePreUtil;
import com.example.wms_erp.util.ToastUtil;

import java.lang.annotation.Annotation;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2016/9/13.
 */
public class LocBillFragment extends BaseFragment {
    @Bind(R.id.rv_bills)
    RecyclerView rvBills;
    @Bind(R.id.btn_comit)
    Button btnComit;
    private MyApplication application;
    private ArrayList<LocInfo> doneLocinfos;
    private LocCountAdapter locCountAdapter;
    private ServiceApi serviceApi;

    @Override
    public void dispatchCode(String code) {
//        application = (MyApplication) getActivity().getApplication();

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.locbill_fragment, null);
        Log.i("locBill", "create");
        ButterKnife.bind(this, view);
        rvBills.addItemDecoration(new MySpaceDecration(10));

        doneLocinfos = new ArrayList<>();
        serviceApi = RetrofitSingle.getInstance();
        RxBus.getDefault().toObserverable()
                .subscribe(new Subscriber<Object>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("locbill", e.toString());
                    }

                    @Override
                    public void onNext(Object locInfo) {
                        Log.i("locbill", "收到消息");
                        if (locInfo instanceof LocInfo) {
                            Log.i("locbill", "收到消息2");
                            //确定此消息是否已收到过
                            boolean isScanded=false;
                            for(LocInfo info:doneLocinfos){
                                if(((LocInfo) locInfo).getGOODSBATCHCODE().equals(info.getGOODSBATCHCODE())){
                                    info =(LocInfo) locInfo;
                                    isScanded = true;
                                    break;
                                }
                            }
                            if(!isScanded) {
                                doneLocinfos.add((LocInfo) locInfo);
                            }
                            double invqty = ((LocInfo) locInfo).getINVQTY();
                            Log.i("看数据",invqty+"");
                            if (locCountAdapter == null) {
                                Log.i("locbill", "收到消息3");
                                locCountAdapter = new LocCountAdapter(getActivity(), doneLocinfos);
                                rvBills.setAdapter(locCountAdapter);
                            } else {
                                locCountAdapter.refreshData(doneLocinfos);
                            }

                        }

                    }
                });
//        application.rxManager.add(subscribe);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick(R.id.btn_comit)
    public void onClick() {
        comitData();
    }
    private void comitData(){

        serviceApi.postLocCount(SharePreUtil.getInteger(getContext(),"userID",3),doneLocinfos).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<BaseBean<String>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                ToastUtil.makeText(getContext(),e.toString()).show();
            }

            @Override
            public void onNext(BaseBean<String> stringBaseBean) {

                ToastUtil.makeText(getContext(),stringBaseBean.getMESSAGE()).show();
                RxBus.getDefault().send(new UpdateEvent());
                    new Thread(

                    ){
                        @Override
                        public void run() {
                            super.run();
                            for (LocInfo info:doneLocinfos){
                                info.setINVQTY(info.getBuyQty()*info.getPURUNITQTY()+info.getStoreQty());
                            }
                            LocInfoDao.updateInfos(doneLocinfos);
                        }
                    }.start();

                doneLocinfos.clear();
                if(locCountAdapter!=null){
                    locCountAdapter.refreshData(doneLocinfos);
                }
            }

        });
    }
}
