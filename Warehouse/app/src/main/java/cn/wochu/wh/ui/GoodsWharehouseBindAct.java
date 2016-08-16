package cn.wochu.wh.ui;

import android.os.Bundle;
import android.provider.SyncStateContract;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.squareup.okhttp.Request;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.wochu.wh.R;
import cn.wochu.wh.adapter.MainActAdapter;
import cn.wochu.wh.adapter.on.OnShelvesRvAdapter;
import cn.wochu.wh.base.BaseActivity;
import cn.wochu.wh.constant.Constants;
import cn.wochu.wh.entity.BaseEntity;
import cn.wochu.wh.entity.GetDCWarehouseGoodsInfoEntity;
import cn.wochu.wh.entity.on.OnShelvesRvEntity;
import cn.wochu.wh.net.ApiClient;
import cn.wochu.wh.net.OkHttpClientManager;
import cn.wochu.wh.retrofit.Rest_API;
import cn.wochu.wh.retrofit.RetrofitSingle;
import cn.wochu.wh.utils.CheckCodeUtil;
import cn.wochu.wh.utils.SharePreUtil;
import cn.wochu.wh.view.SearchEditText;
import cn.wochu.wh.view.WarehouseDialog;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by hasee on 2016/8/3.
 */
public class GoodsWharehouseBindAct extends BaseActivity {

    @Bind(R.id.title_toolbar)
    Toolbar titleToolbar;
    @Bind(R.id.goodsCode)
    SearchEditText goodsCode;
    @Bind(R.id.goodsName)
    TextView goodsName;
    @Bind(R.id.huowei_id)
    EditText huoweiId;
    @Bind(R.id.btn_submit)
    Button btnSubmit;
    private GetDCWarehouseGoodsInfoEntity mGetDCWarehouseGoodsInfoEntity;
    private Rest_API rest_api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_goods_warehouse_bind);
        ButterKnife.bind(this);
        rest_api = RetrofitSingle.getInstance();
        goodsCode.setOnConfirmListenner(new SearchEditText.OnConfirmListenner() {
            @Override
            public void onConfirm(String str) {
                handleCode(str);
            }
        });
        titleToolbar.setTitle("绑定货位");
        String string = SharePreUtil.getString(this, Constants.SP_ACCOUNT_LOGON_WAREHOUSENAME, "");
        titleToolbar.setSubtitle(string);
        setSupportActionBar(titleToolbar);
        titleToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("toolbar", "点击返回");
                finish();
            }
        });

    }

    @Override
    protected void handleCode(String code) {
        if(CheckCodeUtil.isWochuGoodsNum(code)){
            goodsCode.setText(code);
            OkHttpClientManager.getAsyn(ApiClient.getDCOnWarehouseGoodsInfo(code), new OkHttpClientManager.ResultCallback<BaseEntity<GetDCWarehouseGoodsInfoEntity>>() {

                @Override
                public void onBefore(Request request) {
                    super.onBefore(request);
                    showLoadingDialog("");
                }

                @Override
                public void onError(Request request, Exception e) {
                    ToastCheese(e.toString());

                }

                @Override
                public void onResponse(BaseEntity<GetDCWarehouseGoodsInfoEntity> response) {
                    if (response.getRESULT().equals("1")) {
                        if (response.getDATA() != null) {
                            mGetDCWarehouseGoodsInfoEntity = response.getDATA();
                            Log.i("商品名称",response.getDATA().getGOODSNAME());
//                            ToastCheese("数据"+response.getDATA().getGOODSNAME());
                            goodsName.setText(response.getDATA().getGOODSNAME());




                                }
                            }else{
                        goodsCode.setText("");
                        goodsName.setText("");
                    }
                        }




                @Override
                public void onAfter() {
                    super.onAfter();
                    hideLoadingDialog();
                }
            });
        }else {
            huoweiId.setText(code);
        }
    }


    @OnClick(R.id.btn_submit)
    public void onClick() {
        bindWhareHouse(goodsCode.getText().toString(),huoweiId.getText().toString());
//        OkHttpClientManager.postAsyn("", new OkHttpClientManager.ResultCallback<String>() {
//            @Override
//            public void onError(Request request, Exception e) {
//
//            }
//
//            @Override
//            public void onResponse(String response) {
//
//            }
//        });

    }

    private void bindWhareHouse(String goodsCode,String huowei){
        String userCode = SharePreUtil.getString(this, Constants.SP_ACCOUNT_LOGON_USERCODE, "");
        String WAREHOUSEID = SharePreUtil.getInteger(this, Constants.SP_ACCOUNT_LOGON_WAREHOUSEID, 0)+"";

        rest_api.postBindWhareHouse(huowei,goodsCode,userCode,WAREHOUSEID).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<BaseEntity<Boolean>>() {
            @Override
            public void onCompleted() {
clearInfo();
            }

            @Override
            public void onError(Throwable e) {
                ToastCheese(e.toString()+"访问失败");
//clearInfo();
            }

            @Override
            public void onNext(BaseEntity<Boolean> response) {
                clearInfo();
//                if("1".equals(response.getRESULT())&&response.getDATA()){
                    ToastCheese(response.getMESSAGE());
//                }
            }
        });
    }

    private void clearInfo(){
        goodsName.setText("");
        goodsCode.setText("");
        huoweiId.setText("");
    }
}
