package com.example.wms_erp.presenter.impl;

import com.example.wms_erp.adapter.LocDetailAdapter;
import com.example.wms_erp.fragment.LocQueryFragment;
import com.example.wms_erp.model.BaseBean;
import com.example.wms_erp.model.response.LocDetail;
import com.example.wms_erp.retrofit.RetrofitSingle;
import com.example.wms_erp.retrofit.ServiceApi;
import com.example.wms_erp.ui.MainActivity;
import com.example.wms_erp.util.HandleCodeUtil;

import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2016/9/19.
 */
public class LocQueryPresenterImpl extends BasePresenterImpl {

    private final ServiceApi serviceApi;
MainActivity activity;
    LocQueryFragment fragment;
    private LocDetailAdapter locDetailAdapter;

    public LocQueryPresenterImpl(MainActivity activity, LocQueryFragment fragment) {
        this.activity = activity;
        this.fragment = fragment;
        serviceApi = RetrofitSingle.getInstance();
    }
    public void showLocDetail(String code){
       if( HandleCodeUtil.isLocCode(code)) {
           serviceApi.getLocDetailByLocCode(code).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                   .subscribe(new Subscriber<BaseBean<List<LocDetail>>>() {
                       @Override
                       public void onStart() {
                           activity.showLoadingDialog("查询中");
                       }

                       @Override
                       public void onCompleted() {

                       }

                       @Override
                       public void onError(Throwable e) {
activity.hideLoadingDialog();
                           activity.ToastCheese(e.toString());
                       }

                       @Override
                       public void onNext(BaseBean<List<LocDetail>> listBaseBean) {
                           activity.hideLoadingDialog();
                                if(listBaseBean.getDATA()!=null){
                                    //有数据
                                    if(locDetailAdapter==null) {
                                        locDetailAdapter = new LocDetailAdapter(activity, listBaseBean.getDATA());

                                        fragment.rvLocdetails.setAdapter(locDetailAdapter);
                                    }else{
                                        locDetailAdapter.refreshData(listBaseBean.getDATA());
                                    }
                                }else{
                                    activity.ToastCheese(listBaseBean.getMESSAGE());
                                }
                       }
                   });
       }else{
           //商品批次号的时候
           if(code.length()>8) {
               code = code.substring(0, code.length() - 8);
               serviceApi.getLocDetailByGoodsCode(code).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                       .subscribe(new Subscriber<BaseBean<List<LocDetail>>>() {
                           @Override
                           public void onStart() {
                               activity.showLoadingDialog("查询中");
                           }

                           @Override
                           public void onCompleted() {

                           }

                           @Override
                           public void onError(Throwable e) {
                               activity.hideLoadingDialog();
                               activity.ToastCheese(e.toString());
                           }

                           @Override
                           public void onNext(BaseBean<List<LocDetail>> listBaseBean) {
                               activity.hideLoadingDialog();
                               if (listBaseBean.getDATA() != null) {
                                   //有数据
                                   if (locDetailAdapter == null) {
                                       locDetailAdapter = new LocDetailAdapter(activity, listBaseBean.getDATA());

                                       fragment.rvLocdetails.setAdapter(locDetailAdapter);
                                   } else {
                                       locDetailAdapter.refreshData(listBaseBean.getDATA());
                                   }
                               } else {
                                   if(locDetailAdapter!=null){
                                       locDetailAdapter.refreshData(null);
                                   }
                                   activity.ToastCheese(listBaseBean.getMESSAGE());
                               }
                           }
                       });
           }
       }
    }
}
