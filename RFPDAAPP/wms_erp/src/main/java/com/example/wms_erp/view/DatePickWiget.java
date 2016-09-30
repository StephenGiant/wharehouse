package com.example.wms_erp.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.example.wms_erp.R;

import java.util.Calendar;



/**
 * 日期选择自定义控件
 *
 * @author Administrator
 */
public class DatePickWiget extends LinearLayout implements OnClickListener {

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public DatePickWiget(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        // TODO Auto-generated constructor stub
        initView(context);
    }

    public DatePickWiget(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    public DatePickWiget(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public DatePickWiget(Context context) {
        super(context);
        initView(context);
    }


    private void initView(Context context) {
        itemView = LayoutInflater.from(context).inflate(R.layout.date_choose_layout, this, true);
        et_date = (EditText) itemView.findViewById(R.id.et_date);
        et_date.setOnClickListener(this);
        getDataPick();
        et_date.setText(curTime);
    }

    String curTime;
    WheelView year;
    WheelView month;
    WheelView day;

    private View getDataPick() {
        Calendar c = Calendar.getInstance();
        int curYear = c.get(Calendar.YEAR);
        int curMonth = c.get(Calendar.MONTH) + 1;//通过Calendar算出的月数要+1
        int curDate = c.get(Calendar.DATE);
        String month_str = "";
        String date_str = "";
        if (curMonth < 10) {
            month_str = "0" + curMonth;
        } else {
            month_str += curMonth;
        }
        if (curDate < 10) {
            date_str = "0" + curDate;
        } else {
            date_str += curDate;
        }
        curTime = curYear + "-" + month_str + "-" + date_str;

//        final View view = View.inflate(getContext(), R.layout.datapick, null);
        final View view = LayoutInflater.from(getContext()).inflate(R.layout.datapick, null);
        year = (WheelView) view.findViewById(R.id.year);
        year.setAdapter(new NumericWheelAdapter(1950, curYear));
        year.setLabel("年");
        year.setCyclic(true);
        year.addScrollingListener(scrollListener);

        month = (WheelView) view.findViewById(R.id.month);
        month.setAdapter(new NumericWheelAdapter(1, 12));
        month.setLabel("月");
        month.setCyclic(true);
        month.addScrollingListener(scrollListener);

        day = (WheelView) view.findViewById(R.id.day);
        initDay(curYear, curMonth);
        day.setLabel("日");
        day.setCyclic(true);

        year.setCurrentItem(curYear - 1950);
        month.setCurrentItem(curMonth - 1);
        day.setCurrentItem(curDate - 1);

        Button bt = (Button) view.findViewById(R.id.set);
        bt.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = null;
                if ((month.getCurrentItem()) + 1 < 10 && (day.getCurrentItem() + 1) < 10) {

                    str = (year.getCurrentItem() + 1950) + "-0" + (month.getCurrentItem() + 1) + "-0" + (day.getCurrentItem() + 1);
                } else if ((month.getCurrentItem()) + 1 >= 10 && (day.getCurrentItem() + 1) < 10) {
                    str = (year.getCurrentItem() + 1950) + "-" + (month.getCurrentItem() + 1) + "-0" + (day.getCurrentItem() + 1);
                } else if ((month.getCurrentItem()) + 1 < 10 && (day.getCurrentItem() + 1) >= 10) {
                    str = (year.getCurrentItem() + 1950) + "-0" + (month.getCurrentItem() + 1) + "-" + (day.getCurrentItem() + 1);
                } else if ((month.getCurrentItem()) + 1 >= 10 && (day.getCurrentItem() + 1) >= 10) {
                    str = (year.getCurrentItem() + 1950) + "-" + (month.getCurrentItem() + 1) + "-" + (day.getCurrentItem() + 1);
                }
                Toast.makeText(getContext(), str, Toast.LENGTH_LONG).show();
                et_date.setText(str);
                if (confirm_listenner != null) {
                    confirm_listenner.onConfirmClick();
                }
                datePopupWindow.dismiss();
            }
        });
        Button cancel = (Button) view.findViewById(R.id.cancel);
        cancel.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                datePopupWindow.dismiss();
            }
        });
        return view;
    }

    private int getDay(int year, int month) {
        int day = 30;
        boolean flag = false;
        switch (year % 4) {
            case 0:
                flag = true;
                break;
            default:
                flag = false;
                break;
        }
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                day = 31;
                break;
            case 2:
                day = flag ? 29 : 28;
                break;
            default:
                day = 30;

                break;
        }
        return day;
    }

    //
//	/**
//	 */
    private void initDay(int arg1, int arg2) {
        day.setAdapter(new NumericWheelAdapter(1, getDay(arg1, arg2), "%02d"));
    }

    //
    OnWheelScrollListener scrollListener = new OnWheelScrollListener() {

        @Override
        public void onScrollingStarted(WheelView wheel) {

        }

        @Override
        public void onScrollingFinished(WheelView wheel) {
            // TODO Auto-generated method stub
            int n_year = year.getCurrentItem() + 1950;//
            int n_month = month.getCurrentItem() + 1;//
            initDay(n_year, n_month);
        }
    };

    PopupWindow datePopupWindow;
    private View itemView;
    private EditText et_date;

    private void showDatePopuwindow() {
        View view = getDataPick();
        datePopupWindow = new PopupWindow(view, LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        datePopupWindow.setFocusable(true);
        datePopupWindow.setBackgroundDrawable(new BitmapDrawable());
        datePopupWindow.showAtLocation(view, Gravity.CENTER_HORIZONTAL, 0, 0);


    }

    /**
     * 获取当前日期
     *
     * @return
     */
    public String getDate() {
        return et_date.getText().toString();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.et_date:
//                LogUtil.i("点击了", "日期控件");
                showDatePopuwindow();
                break;

            default:
                break;
        }


    }

    public onConfirmListenner confirm_listenner;

    public interface onConfirmListenner {
        public void onConfirmClick();
    }

    /**
     * 设置日期选择监听
     *
     * @param listenner
     */
    public void setOnConfirmListenner(onConfirmListenner listenner) {
        this.confirm_listenner = listenner;
    }


}
