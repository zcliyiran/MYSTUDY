package com.tianxi.mystudy.rxandroid;

/**
 * Created by admin on 16/10/14.
 */

public class G1 implements Guannchazhe{


    @Override
    public void change() {
        System.out.println(this.getClass().toString()+"改变了");
//        Log.e("MainActivity", this.getClass().toString()+"改变了");
    }
}
