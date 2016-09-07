package com.example.wms_erp.fragment;

import android.graphics.Camera;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wms_erp.R;
import com.example.wms_erp.adapter.LocPagerAdapter;
import com.example.wms_erp.view.NoScrollViewPager;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/9/6.
 */
public class LocCountFragment extends BaseFragment {
    @Bind(R.id.tab_title)
    TabLayout tabTitle;
    @Bind(R.id.vp_content)
    NoScrollViewPager vpContent;

    @Override
    public void dispatchCode(String code) {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.loccount_layout, null);

        ButterKnife.bind(this, view);
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new TiaoZhengFragment());
        vpContent.setAdapter(new LocPagerAdapter(getFragmentManager(),fragments));
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
//        Camera camera = new Camera();
//        camera.rotateZ(360);
    }
}
