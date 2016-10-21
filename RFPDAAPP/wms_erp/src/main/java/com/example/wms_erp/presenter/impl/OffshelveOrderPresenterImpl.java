package com.example.wms_erp.presenter.impl;

import android.widget.ArrayAdapter;

import com.example.wms_erp.adapter.OffshelveOrderAdapter;
import com.example.wms_erp.fragment.OffshelveOrderFragment;
import com.example.wms_erp.model.BaseBean;
import com.example.wms_erp.model.response.Kuwei;
import com.example.wms_erp.model.response.OffshelveInfo;
import com.example.wms_erp.retrofit.RetrofitSingle;
import com.example.wms_erp.retrofit.ServiceApi;
import com.example.wms_erp.ui.MainActivity;
import com.example.wms_erp.util.SharePreUtil;

import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2016/9/29.
 */

public class OffshelveOrderPresenterImpl extends BasePresenterImpl {
    MainActivity activity; OffshelveOrderFragment fragment;
    private ServiceApi serviceApi;
    private OffshelveOrderAdapter adapter;

    public OffshelveOrderPresenterImpl(MainActivity activity, OffshelveOrderFragment fragment) {
        this.activity = activity;this.fragment = fragment;
        initData();
    }
    private void initData(){
        serviceApi = RetrofitSingle.getInstance();
        serviceApi.getKuwei(SharePreUtil.getInteger(activity,"userID",0)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Subscriber<BaseBean<List<Kuwei>>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                activity.ToastCheese(e.toString());
            }

            @Override
            public void onNext(BaseBean<List<Kuwei>> listBaseBean) {
                activity.ToastCheese(listBaseBean.getMESSAGE());
                if(listBaseBean.getDATA()!=null){
                    //填充spinner
                    String[] kuweis= new String[listBaseBean.getDATA().size()];
                    for(int x=0;x<listBaseBean.getDATA().size();x++){
                        kuweis[x] = listBaseBean.getDATA().get(x).getCELLNO();
                    }
                    ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(activity, android.R.layout.simple_spinner_item, kuweis);
                    fragment.spKuwei.setAdapter(stringArrayAdapter);

//                    byte[] bytes = "".getBytes();
                }
            }
        });
    }
private List<OffshelveInfo> infoList ;
    /**
     * 获取下架
     */
    public void getOffshelveOrderInfo(String cellNo,int userID,String batchNo,String date){
                serviceApi.getOffshelveOrderInfo(cellNo,batchNo,userID,date).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Subscriber<BaseBean<List<OffshelveInfo>>>() {
                            @Override
                            public void onCompleted() {

                            }

                            @Override
                            public void onError(Throwable e) {

                            }

                            @Override
                            public void onNext(BaseBean<List<OffshelveInfo>> listBaseBean) {
                                if(listBaseBean.getDATA()!=null) {
                                    if(adapter==null) {
                                        adapter = new OffshelveOrderAdapter(activity, listBaseBean.getDATA());
                                        infoList = listBaseBean.getDATA();
                                        fragment.rvOffshelveInfo.setAdapter(adapter);
                                    }else{
                                        adapter.refreshData(listBaseBean.getDATA());
                                    }

                                }
                            }
                        });
    }

    /**
     * 提交下架
     */
    public void postOffshelveOrder(int userID){
            if(adapter!=null){
                serviceApi.postOffshelveOrder(userID,adapter.getPudowninfo()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<BaseBean<String>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(BaseBean<String> stringBaseBean) {
                            activity.ToastCheese(stringBaseBean.getMESSAGE());
                    }
                });
            }
    }

    public void scrollto(String code){
        int position = -1;
        if(infoList!=null){
            for(int x=0;x<infoList.size();x++){
                if(code.equals(infoList.get(x).getGOODSBATCHCODE())){
                    position = x;
                    break;
                }
            }
            if(adapter!=null&&adapter.getItemCount()>0){
                fragment.rvOffshelveInfo.scrollToPosition(position);
            }
        }
    }
}
