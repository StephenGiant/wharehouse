package com.example.wms_erp.presenter.impl;

import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.wms_erp.adapter.OffshelveOrderAdapter;
import com.example.wms_erp.fragment.OffshelveOrderFragment;
import com.example.wms_erp.model.BaseBean;
import com.example.wms_erp.model.post.OffshelveOrderRequest_sign;
import com.example.wms_erp.model.response.Kuwei;
import com.example.wms_erp.model.response.OffshelveInfo;
import com.example.wms_erp.retrofit.RetrofitSingle;
import com.example.wms_erp.retrofit.ServiceApi;
import com.example.wms_erp.ui.MainActivity;
import com.example.wms_erp.util.SharePreUtil;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2016/9/29.
 */

public class OffshelveOrderPresenterImpl extends BasePresenterImpl {
    MainActivity activity; OffshelveOrderFragment fragment;
    private ServiceApi serviceApi;
    private OffshelveOrderAdapter adapter;
    List<OffshelveInfo> orders;
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
//                activity.ToastCheese(listBaseBean.getMESSAGE());
                if(listBaseBean.getDATA()!=null){
                    //填充spinner
                    String[] kuweis= new String[listBaseBean.getDATA().size()];
                    for(int x=0;x<listBaseBean.getDATA().size();x++){
                        kuweis[x] = listBaseBean.getDATA().get(x).getCELLNO();
                    }
                    ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(activity, android.R.layout.simple_spinner_item, kuweis);
                    fragment.spKuwei.setAdapter(stringArrayAdapter);

                }
            }
        });


        //新写法
//      final   ArrayList<String>  kuweis= new  ArrayList<String>();
//        serviceApi.getKuwei(SharePreUtil.getInteger(activity,"userID",0)).flatMap(new Func1<BaseBean<List<Kuwei>>, Observable<Kuwei>>() {
//            @Override
//            public Observable<Kuwei> call(BaseBean<List<Kuwei>> listBaseBean) {
//
//                return Observable.from(listBaseBean.getDATA());
//            }
//        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<Kuwei>() {
//            @Override
//            public void onCompleted() {
//
//            }
//
//            @Override
//            public void onError(Throwable e) {
//
//            }
//
//            @Override
//            public void onNext(Kuwei kuwei) {
//                kuweis.add(kuwei.getCELLNO());
//            }
//        });
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
                                e.printStackTrace();
                                Log.e("获取下架指令","失败");
                            }

                            @Override
                            public void onNext(BaseBean<List<OffshelveInfo>> listBaseBean) {
                                if(listBaseBean.getDATA()!=null) {
                                    fragment.onOffshelveOrderGet(listBaseBean.getDATA());

                                    signOrder(listBaseBean.getDATA());

                                }else{
                                    fragment.onOffshelveOderFailed();
                                    Log.i("无数据","下架指令");
                                    Toast.makeText(activity,"未查询到下架指令",Toast.LENGTH_SHORT).show();
                                }
                            }
                        });



    }

    /**
     * 提交下架
     */
    public void postOffshelveOrder(int userID,List<OffshelveInfo> orders){

                serviceApi.postOffshelveOrder(userID,orders).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<BaseBean<String>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        activity.ToastCheese(e.toString());
                    }

                    @Override
                    public void onNext(BaseBean<String> stringBaseBean) {
                            activity.ToastCheese(stringBaseBean.getMESSAGE());
                    }
                });

    }

    /**
     * 将下架指令都标记为进行中
     *
     */

    private void signOrder(List<OffshelveInfo> offshelveOrderRequest_signs){
        //遍历orders 找匹配项



        serviceApi.SetOffShelvesState("执行",offshelveOrderRequest_signs).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<BaseBean<Boolean>>() {
    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {


    }

    @Override
    public void onNext(BaseBean<Boolean> stringBaseBean) {
//        Toast.makeText(fragment.getContext(),stringBaseBean.getMESSAGE()+"sign",Toast.LENGTH_SHORT).show();

//不需要做什么

    }
});
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

    public void getLocationInfo(String code){
        serviceApi.getLocationInventoryOrder(code).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<BaseBean<OffshelveInfo>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                        Toast.makeText(activity,""+e.toString(),Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onNext(BaseBean<OffshelveInfo> stringBaseBean) {
//                        Toast.makeText(fragment.getContext(),stringBaseBean.getMESSAGE(),Toast.LENGTH_SHORT).show();
                        if(stringBaseBean.getDATA()!=null){
                            fragment.onGetBatchInfo(stringBaseBean.getDATA());
                        }else {
                            fragment.onGetBatchInfoFailed(stringBaseBean.getMESSAGE());
                        }

                    }
                });
    }

//    public void setQtyExe(OffshelveInfo info){
//        for(OffshelveInfo osinfo:orders){
//            if(osinfo.getGOODSCODE().equals(info.getBARCODE())){
//                osinfo.setQTYEXCE(info.QTYEXCE);
//                osinfo.setGOODSBATCHCODE(info.GOODSBATCHCODE);
//                if(adapter!=null){
//                    adapter.refreshData(orders);
//                }
//                break;
//            }
//        }
//
//    }
    public void refreshData(List<OffshelveInfo> infos){
        if(adapter!=null)
        adapter.refreshData(infos);
    }
}
