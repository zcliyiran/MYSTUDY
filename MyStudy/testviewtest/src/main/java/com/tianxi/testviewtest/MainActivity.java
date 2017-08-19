package com.tianxi.testviewtest;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.paradoxie.autoscrolltextview.VerticalTextview;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> a=new ArrayList<>();
    VerticalTextview TextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       TextView= (VerticalTextview) findViewById(R.id.text);

        for (int i = 0; i < 10; i++) {
        a.add("消息SD法国红酒法国红酒发刚回家快了木马木马木马/n密密dklajkljdkljdklajkldjakljdakl麻麻"+i);
        }
        TextView.setTextList(a);//加入显示内容,集合类型
        TextView.setText(16, 5, Color.RED);//设置属性,具体跟踪源码
        TextView.setTextStillTime(3000);//设置停留时长间隔
        TextView.setAnimTime(300);//设置进入和退出的时间间隔
        //对单条文字的点击监听
        TextView.setOnItemClickListener(new VerticalTextview.OnItemClickListener() {
            @Override
            public void onItemClick(int postion) {
                // TO DO

                Toast.makeText(MainActivity.this, a.get(postion).toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    //开始滚动
    @Override
    protected void onResume() {
        super.onResume();
        TextView.startAutoScroll();
    }
    //停止滚动
    @Override
    protected void onPause() {
        super.onPause();
        TextView.stopAutoScroll();
    }
}
