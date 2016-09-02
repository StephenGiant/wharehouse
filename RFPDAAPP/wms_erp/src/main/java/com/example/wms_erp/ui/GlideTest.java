package com.example.wms_erp.ui;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.wms_erp.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/9/2.
 */
public class GlideTest extends BaseActivity {
    @Bind(R.id.test_beauty)
    ImageView testBeauty;

    @Override
    protected void handleCode(String str) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.glide_test);
        ButterKnife.bind(this);
        String url = "http://i1.umei.cc/uploads/tu/201608/82/seej3h3cqdh.jpg";
        testBeauty.setImageResource(R.mipmap.bigmm);
        Glide.with(this).load(url).error(R.mipmap.bigmm).centerCrop().into(testBeauty);
    }
}
