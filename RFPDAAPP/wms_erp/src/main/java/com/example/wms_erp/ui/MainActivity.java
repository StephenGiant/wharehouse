package com.example.wms_erp.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnticipateOvershootInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wms_erp.R;
import com.example.wms_erp.view.FlipCardAnimation;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,View.OnClickListener {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
//    @Bind(R.id.ll_categary)
//    LinearLayout llCategary;
    @Bind(R.id.fab)
    FloatingActionButton fab;
    @Bind(R.id.nav_view)
    NavigationView navView;
    @Bind(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    private ImageView imageView;
    //    @Bind(R.id.tv_title)
//    TextView tvTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        toolbar.setTitle("盲扫上下架");
        setSupportActionBar(toolbar);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();

        navView.setNavigationItemSelectedListener(this);
        View view = navView.getHeaderView(0);
        imageView = (ImageView) view.findViewById(R.id.imageView);
        imageView.setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
            toolbar.setTitle("盲扫上下架");
        } else if (id == R.id.nav_gallery) {
            toolbar.setTitle("指令上下架");
        } else if (id == R.id.nav_slideshow) {
            toolbar.setTitle("库存盘点");
        } else if (id == R.id.nav_manage) {
            toolbar.setTitle("报损");
        } else if (id == R.id.nav_setting) {
            toolbar.setTitle("设置选项");
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(this,"请登陆",Toast.LENGTH_SHORT).show();
    }

    //
//    @OnClick(R.id.ll_categary)
//    public void onClick() {
//        startAnimation(llCategary.getWidth() / 2, llCategary.getHeight() / 2, 180, 1000);
//
//    }
int count = 1;
//    private void startAnimation(int width, int height, int degree, int duration) {
//        FlipCardAnimation animation = new FlipCardAnimation(0, degree, width, height);
//        animation.setInterpolator(new AnticipateOvershootInterpolator()
//        );
//        animation.setDuration(duration);
//        animation.setFillAfter(false);
//        animation.setRepeatCount(0);
//        animation.setAnimationListener(new Animation.AnimationListener() {
//            @Override
//            public void onAnimationStart(Animation animation) {
//            }
//
//            @Override
//            public void onAnimationEnd(Animation animation) {
//            }
//
//            @Override
//            public void onAnimationRepeat(Animation animation) {
//                ((FlipCardAnimation) animation).setCanContentChange();
//            }
//        });
//        animation.setOnContentChangeListener(new FlipCardAnimation.OnContentChangeListener() {
//            @Override
//            public void contentChange() {
////                if (iv_pro == null) {
////                    return;
////                }
////                if (num >= 3) {
////                    num = 0;
////                }
////                iv_pro.setBackgroundResource(DRAWABLE[num]);
////                tv_item.setText("￥" + new Random().nextInt(500));
////
////                if (num == 0) {
////                    tv_price_item.setText("Discount");
////                } else if (num == 1) {
////                    tv_price_item.setText("Price");
////                } else if (num == 2) {
////                    tv_price_item.setText("Cost");
////                }
////                num++;
//                if(count%2==1) {
//                    llCategary.setBackgroundColor(Color.parseColor("#607D8B"));
//                    tvTitle.setText("盲扫下架");
//                }else{
//                    llCategary.setBackgroundColor(Color.parseColor("#00BCD4"));
//                    tvTitle.setText("盲扫上架");
//                }
//                count++;
//            }
//        });
//        llCategary.startAnimation(animation);
//
//    }
}
