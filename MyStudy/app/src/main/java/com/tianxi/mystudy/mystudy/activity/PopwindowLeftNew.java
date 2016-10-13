package com.tianxi.mystudy.mystudy.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;

import com.tianxi.mystudy.mystudy.R;
import com.tianxi.mystudy.mystudy.utils.ScreenUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by admin on 16/10/13.
 */

public class PopwindowLeftNew extends AppCompatActivity{
    @BindView(R.id.toobar)
    Toolbar toolbar;
    private PopupWindow popupWindow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popwindow_leftnew);
//        setActionBar();
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        findViewById(R.id.popBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                // 获取自定义布局文件activity_popupwindow_left.xml的视图
                View popupWindow_view = getLayoutInflater().inflate(R.layout.activity_popupwindow_left, null,false);
                // 创建PopupWindow实例,200,LayoutParams.MATCH_PARENT分别是宽度和高度
                popupWindow = new PopupWindow(popupWindow_view, ViewGroup.LayoutParams.MATCH_PARENT, 200, true);
                // 设置动画效果
                popupWindow.setAnimationStyle(R.style.AnimationFade);
                // 这里是位置显示方式,在屏幕的左侧
                popupWindow.showAtLocation(v, Gravity.TOP, subStatusBarHeight(), subStatusBarHeight());
                // 点击其他地方消失
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
        });

    }

    private int subStatusBarHeight() {
        int statusHeight = ScreenUtils.getStatusBarHeight(this);
        ActionBar ab = (this).getSupportActionBar();
        int abHeight = ab == null ? 0 : ab.getHeight();
            return abHeight+statusHeight;

    }

}
