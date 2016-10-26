package com.example.wms_erp.ui;

import android.os.Bundle;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.example.wms_erp.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/10/26.
 */

public class NewHomeAct extends BaseActivity {
    @Bind(R.id.title)
    Toolbar title;
    @Bind(R.id.rv_functions)
    RecyclerView rvFunctions;
    @Bind(R.id.bottom_navigation)
    BottomNavigationBar bottomNavigation;
    @Bind(R.id.nested_scroll_view)
    NestedScrollView nestedScrollView;

    @Override
    protected void handleCode(String str) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_homepage);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        title.setTitle("试试");
        setSupportActionBar(title);
         bottomNavigation.addItem(new BottomNavigationItem(R.drawable.ic_book_white_24dp, "book")).
                 addItem(new BottomNavigationItem(R.drawable.ic_favorite_white_24dp,"zuiai")).setFirstSelectedPosition(0).initialise();
    }
}
