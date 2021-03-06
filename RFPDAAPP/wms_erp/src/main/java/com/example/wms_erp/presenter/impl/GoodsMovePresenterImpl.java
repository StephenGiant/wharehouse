package com.example.wms_erp.presenter.impl;

import android.util.Log;
import android.view.View;

import com.example.wms_erp.adapter.GoodsMoveAdapter;
import com.example.wms_erp.adapter.LocDetailAdapter;
//import com.example.wms_erp.adapter.LocMoveInfoAdapter;
import com.example.wms_erp.adapter.OnshelveInfoAdapter;
import com.example.wms_erp.fragment.GoodsMoveFragment;
import com.example.wms_erp.model.BaseBean;
import com.example.wms_erp.model.response.GoodsLocInfo;
import com.example.wms_erp.model.response.OnShelveInfo;
import com.example.wms_erp.retrofit.RetrofitSingle;
import com.example.wms_erp.retrofit.ServiceApi;
import com.example.wms_erp.ui.MainActivity;
import com.example.wms_erp.view.ChangeLocDialog;
import com.example.wms_erp.view.RecyclerItemClickListener;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2016/9/22.
 */

public class GoodsMovePresenterImpl extends BasePresenterImpl {
private MainActivity activity;
    private GoodsMoveFragment fragment;
    private final ServiceApi serviceApi;
    private GoodsMoveAdapter goodsMoveAdapter;
    private final ArrayList<OnShelveInfo> changeLocs;
    private ChangeLocDialog changeLocDialog;
    private List<OnShelveInfo> infos;
    public GoodsMovePresenterImpl(MainActivity activity, GoodsMoveFragment fragment) {
        this.activity = activity;
        this.fragment = fragment;
        serviceApi = RetrofitSingle.getInstance();
        changeLocs = new ArrayList<>();

    }
    boolean flag = false;
    public boolean getGoodsLocInfo(String goodsCode,String locCode){

        serviceApi.getGoodsLocInfo(goodsCode,locCode).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<BaseBean<List<OnShelveInfo>>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
activity.ToastCheese(e.toString());
            }

            @Override
            public void onNext(final BaseBean<List<OnShelveInfo>> listBaseBean) {
                        if(listBaseBean.getDATA()!=null){
//                            new GoodsMoveAd
                            infos = listBaseBean.getDATA();
                            fragment.targetLoc.setEnabled(true);
                            if(goodsMoveAdapter==null) {
//                                flag = true;
                                goodsMoveAdapter = new GoodsMoveAdapter(activity, listBaseBean.getDATA());
                                fragment.rvGoodslocs.setAdapter(goodsMoveAdapter);

                                fragment.rvGoodslocs.addOnItemTouchListener(new RecyclerItemClickListener(activity) {
                                    @Override
                                    protected void onItemClick(View view, int position) {
//showDialog(listBaseBean.getDATA().get(position));
                                    }
                                });
                            }else{
                                goodsMoveAdapter.refreshData(listBaseBean.getDATA());
                            }
                        }else {
                            fragment.targetLoc.setEnabled(false);
                            flag =false;
                            if(goodsMoveAdapter!=null){
                                goodsMoveAdapter.refreshData(null);
                            }
                            activity.ToastCheese(listBaseBean.getMESSAGE());
                        }
            }
        });
        return flag;
    }

    private void showDialog(OnShelveInfo info){
        changeLocDialog = ChangeLocDialog.getInstance(info);
        changeLocDialog.setOnConfirmListenner(new ChangeLocDialog.OnConfirmLitsenner() {
            @Override
            public void onConfirmClick(OnShelveInfo info,String code) {
                //提交转仓
                    changeLocDialog.dismiss();
                Log.i("点击了","对话框确认");
//                postChangeLoc(code);
            }
        });
        changeLocDialog.show(activity.getFragmentManager(),"changeLoc");
    }


    public void postChangeLoc( String locCode){
//        changeLocs.clear();
//        changeLocs.add(info);
        serviceApi.postGoodsLocChange(3,locCode,infos).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<BaseBean<String>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(BaseBean<String> stringBaseBean) {
            activity.ToastCheese(stringBaseBean.getMESSAGE());
                if("请求成功".equals(stringBaseBean.getMESSAGE())){
//                    goodsMoveAdapter.removeUItem(infos.indexOf(info));
                    fragment.etLocCode.setText("");
                    fragment.etGoodsCode.setText("");
                    fragment.targetLoc.setText("");
                    fragment.targetLoc.setEnabled(false);
                    goodsMoveAdapter.refreshData(null);
                }
            }
        });
    }

    /**
     * 检查货位号
     * @param code
     * @return
     */
    public boolean checkLoc(String code){
        if(infos.get(0).getLOCATIONCODE().equals(code)){
            return true;
        }
        return false;
    }
}
