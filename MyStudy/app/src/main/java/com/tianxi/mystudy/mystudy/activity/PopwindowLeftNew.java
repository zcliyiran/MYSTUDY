package com.tianxi.mystudy.mystudy.activity;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.tianxi.mystudy.mystudy.R;
import com.tianxi.mystudy.mystudy.utils.ScreenUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Created by admin on 16/10/13.
 */

public class PopwindowLeftNew extends AppCompatActivity {
    @BindView(R.id.toobar)
    Toolbar toolbar;
    @BindView(R.id.popBtn)
    TextView btn;
    private PopupWindow popupWindow;

    TextView open;
    TextView close;
    TextView save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popwindow_leftnew);
//        setActionBar();
        ButterKnife.bind(this);
        setTitle("");
        setSupportActionBar(toolbar);




    }


    @OnClick(R.id.popBtn)
    public void popupWindow(View view) {

        View popupWindow_view = initPopuwindow();
        popupWindow = new PopupWindow(popupWindow_view, ViewGroup.LayoutParams.MATCH_PARENT, 200, true);
        popupWindow.setFocusable(true);
        // 设置动画效果
        popupWindow.setAnimationStyle(R.style.AnimationFade);
//        ColorDrawable dw = new ColorDrawable(0x00000000);
        ColorDrawable dw=new ColorDrawable();
        popupWindow.setBackgroundDrawable(dw);

        // 这里是位置显示方式,在屏幕的左侧
        popupWindow.showAtLocation(view, Gravity.TOP, subStatusBarHeight(), subStatusBarHeight());


        popupWindow_view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // TODO Auto-generated method stub
                if (popupWindow != null && popupWindow.isShowing()) {
                    popupWindow.dismiss();
                    popupWindow = null;
                }
                return false;
            }
        });


    }

    private View initPopuwindow() {
        // 获取自定义布局文件activity_popupwindow_left.xml的视图
        View popupWindow_view = getLayoutInflater().inflate(R.layout.activity_popupwindow_left, null, false);
//        ButterKnife.bind(this, popupWindow_view);
        // 创建PopupWindow实例,200,LayoutParams.MATCH_PARENT分别是宽度和高度

        open = (TextView) popupWindow_view.findViewById(R.id.open);
        close = (TextView) popupWindow_view.findViewById(R.id.close);
        save = (TextView) popupWindow_view.findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(PopwindowLeftNew.this, "save", Toast.LENGTH_SHORT).show();
                btn.setText("近30天");

            }
        });
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(PopwindowLeftNew.this, "close", Toast.LENGTH_SHORT).show();
                btn.setText("今日");

            }
        });
        open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(PopwindowLeftNew.this, "open", Toast.LENGTH_SHORT).show();
                btn.setText("近7天");

            }
        });
//        // 点击其他地方消失

        return popupWindow_view;
    }

    //    @OnClick(R.id.save)
//    public void save(View v){
//        Toast.makeText(this, "save", Toast.LENGTH_SHORT).show();
//
//    }
//    @OnClick(R.id.open)
//    public void open(View v){
//        Toast.makeText(this, "save", Toast.LENGTH_SHORT).show();
//
//    }
//    @OnClick(R.id.close)
//    public void close(View v){
//
//
//    }
    private int subStatusBarHeight() {
        int statusHeight = ScreenUtils.getStatusBarHeight(this);
        ActionBar ab = (this).getSupportActionBar();
        int abHeight = ab == null ? 0 : ab.getHeight();
        return abHeight + statusHeight;

    }


    private  int add(int a){
        int b=a+1;
        return b;
    }
}
