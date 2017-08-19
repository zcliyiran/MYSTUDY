package com.tianxi.rollviewpagerdemo;

import android.app.Application;

import com.tianxi.rollviewpagerdemo.utils.ScreenUtils;

/**
 * Created by admin on 17/4/13.
 */

public class MyAPP  extends Application{


    @Override
    public void onCreate() {
        super.onCreate();
        ScreenUtils.initScreen(this);
    }
}
