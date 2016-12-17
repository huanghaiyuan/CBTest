package com.hhy.cbtest;

import android.app.Activity;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends Activity implements CBScrollView.ScrollViewListener {
    TextView green;
    CBScrollView scrollView;
    int[] gp = new int[2];
    int[] sp = new int[2];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        green = (TextView) findViewById(R.id.green);
        scrollView = (CBScrollView) findViewById(R.id.scrollView);
        scrollView.setScrollViewListener(this);
    }

    int position = 0;

    @Override
    public void onScrollChanged(CBScrollView scrollView, int x, int y, int oldlX, int oldY) {
        green.getLocationInWindow(gp);
        scrollView.getLocationInWindow(sp);
        Log.e("hhy", gp[1] + "---" + sp[1] + "---" + (sp[1] + scrollView.getHeight()) + "---" + y);
        if (gp[1] < sp[1]|| gp[1] > sp[1] + scrollView.getHeight()) {
            scrollView.smoothScrollTo(0, position);
            Log.e("hhy", "停止");
        }
        else {
            position = y;
//  scrollView.smoothScrollTo(0,position);
        }
//        else
//        if(gp[1] > sp[1] + scrollView.getHeight()){
//            scrollView.smoothScrollTo(0,green.getTop());
//        }
    }
}
