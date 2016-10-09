package com.example.wms_erp.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/**
 * 感谢张涛同志的分享
 * Created by ZhangTao on 7/6/16.
 */
public abstract class RecyclerItemClickListener implements RecyclerView.OnItemTouchListener {

    protected abstract void onItemClick(View view, int position);
    public void onLongClick(View view,int position){}

    private GestureDetector mGestureDetector;
    boolean isLongClick = false;

    public RecyclerItemClickListener(Context context) {

        mGestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return true;
            }

            @Override
            public void onLongPress(MotionEvent e) {
                isLongClick = true;
                super.onLongPress(e);
            }
        });
    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView view, MotionEvent e) {
        View childView = view.findChildViewUnder(e.getX(), e.getY());
        if (childView != null && mGestureDetector.onTouchEvent(e)&&!isLongClick) {
            onItemClick(childView, view.getChildAdapterPosition(childView));
            return true;
        }else if(childView != null && mGestureDetector.onTouchEvent(e)&&isLongClick){
            onLongClick(childView,view.getChildAdapterPosition(childView));
                isLongClick = false;
            return true;
        }
        //获取item的viewholder
//        view.getChildViewHolder(view.getChildAt(0));
        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView view, MotionEvent motionEvent) {

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
    }
}