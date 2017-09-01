package com.tianxi.recycleviewdemo02.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import com.marshalchen.ultimaterecyclerview.RecyclerItemClickListener;
import com.marshalchen.ultimaterecyclerview.UltimateRecyclerView;
import com.tianxi.recycleviewdemo02.R;
import com.tianxi.recycleviewdemo02.SimpleAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 结合项目需求
 * 自己测试使用demo01
 */
public class MyNeedActivity extends AppCompatActivity {



    @BindView(R.id.tool_bar)
    Toolbar toolbar;
    @BindView(R.id.ultimate_recycler_view)
    UltimateRecyclerView ultimateRecyclerView;

    SimpleAdapter simpleRecyclerViewAdapter = null;

    LinearLayoutManager linearLayoutManager;

    int moreNum = 2;



    boolean isDrag = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_need);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().
                setDisplayShowTitleEnabled(false);
        // 确保尺寸是通过用户输入从而确保RecyclerView的尺寸是一个常数
//        ultimateRecyclerView.setHasFixedSize(false);
        ultimateRecyclerView.setHasFixedSize(false);
        final List<String> stringList = new ArrayList<>();

        stringList.add("111");
        stringList.add("aaa");
        stringList.add("222");
        stringList.add("333");
        stringList.add("444");
        stringList.add("555");
        stringList.add("666");
        stringList.add("11771");

        simpleRecyclerViewAdapter = new SimpleAdapter(stringList);
        linearLayoutManager = new LinearLayoutManager(this);
        ultimateRecyclerView.setLayoutManager(linearLayoutManager);


        //设置加载更多
        ultimateRecyclerView.setLoadMoreView(LayoutInflater.from(this)
                .inflate(R.layout.custom_bottom_progressbar, null));





        ultimateRecyclerView.setRecylerViewBackgroundColor(Color.parseColor("#ffffff"));


        ultimateRecyclerView.setDefaultOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
//                        simpleRecyclerViewAdapter.insert(moreNum++ + "  Refresh things", 0);
                        ultimateRecyclerView.setRefreshing(false);
                        //   ultimateRecyclerView.scrollBy(0, -50);
                        linearLayoutManager.scrollToPosition(0);
//                        ultimateRecyclerView.setAdapter(simpleRecyclerViewAdapter);
//                        simpleRecyclerViewAdapter.notifyDataSetChanged();
                    }
                }, 1000);
            }
        });



        //
        ultimateRecyclerView.reenableLoadmore();
        //设置适配器
        ultimateRecyclerView.setAdapter(simpleRecyclerViewAdapter);

        ultimateRecyclerView.setOnLoadMoreListener(new UltimateRecyclerView.OnLoadMoreListener() {
            @Override
            public void loadMore(int itemsCount, final int maxLastVisiblePosition) {
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        simpleRecyclerViewAdapter.insert("More " + moreNum++, simpleRecyclerViewAdapter.getAdapterItemCount());
                        simpleRecyclerViewAdapter.insert("More " + moreNum++, simpleRecyclerViewAdapter.getAdapterItemCount());
                        simpleRecyclerViewAdapter.insert("More " + moreNum++, simpleRecyclerViewAdapter.getAdapterItemCount());

                        linearLayoutManager.scrollToPositionWithOffset(maxLastVisiblePosition,-1);

                           linearLayoutManager.scrollToPosition(maxLastVisiblePosition);

                    }
                }, 1000);
            }
        });


        ultimateRecyclerView.showFloatingButtonView();
        /**
         * 悬浮按钮的点击
         */
        findViewById(R.id.btn2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("LauncherActivity", "合并点击了");

            }
        });

        /**
         * item的点击事件
         */
        ultimateRecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Log.d("LauncherActivity", "点击了");
            }
        }));

//        ultimateRecyclerView.getCustomFloatingActionView();



        /**
         * item的点击事件
         */
        ultimateRecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Log.d("LauncherActivity", "点击了");
            }
        }));

    }










    @Override
    protected void onDestroy() {
        super.onDestroy();


    }
//
//    //动画类型
//    enum Type {
//        FadeIn(new FadeInAnimator(new OvershootInterpolator(1f))),
//        FadeInDown(new FadeInDownAnimator(new OvershootInterpolator(1f))),
//        FadeInUp(new FadeInUpAnimator(new OvershootInterpolator(1f))),
//        FadeInLeft(new FadeInLeftAnimator(new OvershootInterpolator(1f))),
//        FadeInRight(new FadeInRightAnimator(new OvershootInterpolator(1f))),
//        Landing(new LandingAnimator(new OvershootInterpolator(1f))),
//        ScaleIn(new ScaleInAnimator(new OvershootInterpolator(1f))),
//        ScaleInTop(new ScaleInTopAnimator(new OvershootInterpolator(1f))),
//        ScaleInBottom(new ScaleInBottomAnimator(new OvershootInterpolator(1f))),
//        ScaleInLeft(new ScaleInLeftAnimator(new OvershootInterpolator(1f))),
//        ScaleInRight(new ScaleInRightAnimator(new OvershootInterpolator(1f))),
//        FlipInTopX(new FlipInTopXAnimator(new OvershootInterpolator(1f))),
//        FlipInBottomX(new FlipInBottomXAnimator(new OvershootInterpolator(1f))),
//        FlipInLeftY(new FlipInLeftYAnimator(new OvershootInterpolator(1f))),
//        FlipInRightY(new FlipInRightYAnimator(new OvershootInterpolator(1f))),
//        SlideInLeft(new SlideInLeftAnimator(new OvershootInterpolator(1f))),
//        SlideInRight(new SlideInRightAnimator(new OvershootInterpolator(1f))),
//        SlideInDown(new SlideInDownAnimator(new OvershootInterpolator(1f))),
//        SlideInUp(new SlideInUpAnimator(new OvershootInterpolator(1f))),
//        OvershootInRight(new OvershootInRightAnimator(1.0f)),
//        OvershootInLeft(new OvershootInLeftAnimator(1.0f));
//
//        private BaseItemAnimator mAnimator;
//
//        Type(BaseItemAnimator animator) {
//            mAnimator = animator;
//        }
//
//        public BaseItemAnimator getAnimator() {
//            return mAnimator;
//        }
//    }
}
