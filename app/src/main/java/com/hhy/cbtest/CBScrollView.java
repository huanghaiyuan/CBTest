package com.hhy.cbtest;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;

import java.nio.channels.spi.AbstractSelectableChannel;

/**
 * Created by hhy on 16/12/16.
 */

public class CBScrollView extends ScrollView {
    private ScrollViewListener scrollViewListener = null;

    public CBScrollView(Context context) {
        super(context);
    }

    public CBScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CBScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.onTouchEvent(ev);
    }

    public void setScrollViewListener(ScrollViewListener scrollViewListener) {
        this.scrollViewListener = scrollViewListener;
    }

    @Override
    protected void onScrollChanged(int x, int y, int oldx, int oldy) {
        super.onScrollChanged(x, y, oldx, oldy);
        if (scrollViewListener != null) {
            scrollViewListener.onScrollChanged(this, x, y, oldx, oldy);
        }
    }

    interface  ScrollViewListener{
         void onScrollChanged(CBScrollView scrollView, int x, int y, int oldlX, int oldY);
    }
}
