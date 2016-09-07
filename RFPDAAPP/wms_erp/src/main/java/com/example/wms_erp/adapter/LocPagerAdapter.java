package com.example.wms_erp.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Administrator on 2016/9/7.
 */
public class LocPagerAdapter extends FragmentPagerAdapter {
    List<Fragment> data;
    public LocPagerAdapter(FragmentManager fm,List<Fragment> data) {
        super(fm);
        this.data = data;
    }

    @Override
    public Fragment getItem(int position) {
        return data.get(position);
    }



    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Log.i("LocPager","adapter加载数据");
        return super.instantiateItem(container, position);
    }

    @Override
    public int getCount() {
        if(data!=null) {
            return data.size();
        }else {
            return 0;
        }
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeViewAt(position);
        super.destroyItem(container, position, object);
    }
}
