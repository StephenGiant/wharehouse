package com.example.wms_erp.decorator;

import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.view.View;

/**
 * item间距
 * @author Administrator
 *
 */
public class MySpaceDecration extends ItemDecoration {
	private int space;
    private int orentation = LinearLayoutManager.VERTICAL;
    public MySpaceDecration(int space) {
        this.space=space;
    }
    public MySpaceDecration(int space,int orentation){
        this.space = space;
        this.orentation = orentation;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
//        outRect.left=space;
//        outRect.right=space;
        if(orentation==LinearLayoutManager.VERTICAL) {
            outRect.bottom = space;
            if (parent.getChildAdapterPosition(view) == 0) {
                outRect.top = space;
            }
        }else if(orentation ==LinearLayoutManager.HORIZONTAL){
            outRect.right = space;
            if (parent.getChildAdapterPosition(view) == 0) {
                outRect.left = space;
            }
        }
    }
}
