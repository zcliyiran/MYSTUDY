package com.tianxi.mystudy.mystudy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.tianxi.mystudy.mystudy.activity.PopwindowLeftNew;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


    }
    @OnClick(R.id.btn01)
    public void click01(View view){
        Intent intent=new Intent();
        intent.setClass(this,PopwindowLeftNew.class);
        startActivity(intent);

    }

    @OnClick(R.id.btn02)
    public void click02(View view){
//        Intent intent=new Intent();
//        intent.setClass(this,PopwindowDemo01.class);
//        startActivity(intent);

    }
    @OnClick(R.id.btn03)
    public void click03(View view){
//        Intent intent=new Intent();
//        intent.setClass(this,PopwindowDemo01.class);
//        startActivity(intent);

    }
}
