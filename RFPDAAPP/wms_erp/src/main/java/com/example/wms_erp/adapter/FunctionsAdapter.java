package com.example.wms_erp.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/8/23.
 */
public class FunctionsAdapter extends FragmentPagerAdapter {
    private Context context;
    private ArrayList<Fragment> data;
    public FunctionsAdapter(FragmentManager fm, Context context,List<Fragment> data) {
        super(fm);
        this.data= (ArrayList<Fragment>) data;
        this.context = context;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        return super.instantiateItem(container, position);
    }

    @Override
    public Fragment getItem(int position) {
        return data.get(position);
    }

    @Override
    public int getCount() {
        if(data!=null) {
            return data.size();
        }
        return 0;
    }



    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeViewAt(position);
        super.destroyItem(container, position, object);
    }
}
