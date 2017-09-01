package com.tianxi.recycleviewdemo02.activity;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.ActionMode;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.marshalchen.ultimaterecyclerview.RecyclerItemClickListener;
import com.marshalchen.ultimaterecyclerview.URLogs;
import com.marshalchen.ultimaterecyclerview.UltimateRecyclerView;
import com.marshalchen.ultimaterecyclerview.itemTouchHelper.SimpleItemTouchHelperCallback;
import com.marshalchen.ultimaterecyclerview.stickyheadersrecyclerview.StickyRecyclerHeadersDecoration;
import com.tianxi.recycleviewdemo02.R;
import com.tianxi.recycleviewdemo02.SimpleAdapter;
import com.tianxi.recycleviewdemo02.modules.FastBinding;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import jp.wasabeef.recyclerview.animators.BaseItemAnimator;
import jp.wasabeef.recyclerview.animators.FadeInAnimator;
import jp.wasabeef.recyclerview.animators.FadeInDownAnimator;
import jp.wasabeef.recyclerview.animators.FadeInLeftAnimator;
import jp.wasabeef.recyclerview.animators.FadeInRightAnimator;
import jp.wasabeef.recyclerview.animators.FadeInUpAnimator;
import jp.wasabeef.recyclerview.animators.FlipInBottomXAnimator;
import jp.wasabeef.recyclerview.animators.FlipInLeftYAnimator;
import jp.wasabeef.recyclerview.animators.FlipInRightYAnimator;
import jp.wasabeef.recyclerview.animators.FlipInTopXAnimator;
import jp.wasabeef.recyclerview.animators.LandingAnimator;
import jp.wasabeef.recyclerview.animators.OvershootInLeftAnimator;
import jp.wasabeef.recyclerview.animators.OvershootInRightAnimator;
import jp.wasabeef.recyclerview.animators.ScaleInAnimator;
import jp.wasabeef.recyclerview.animators.ScaleInBottomAnimator;
import jp.wasabeef.recyclerview.animators.ScaleInLeftAnimator;
import jp.wasabeef.recyclerview.animators.ScaleInRightAnimator;
import jp.wasabeef.recyclerview.animators.ScaleInTopAnimator;
import jp.wasabeef.recyclerview.animators.SlideInDownAnimator;
import jp.wasabeef.recyclerview.animators.SlideInLeftAnimator;
import jp.wasabeef.recyclerview.animators.SlideInRightAnimator;
import jp.wasabeef.recyclerview.animators.SlideInUpAnimator;

public class LauncherActivity extends AppCompatActivity  implements ActionMode.Callback {
    @BindView(R.id.tool_bar)
    Toolbar toolbar;
    @BindView(R.id.ultimate_recycler_view)
    UltimateRecyclerView ultimateRecyclerView;

    SimpleAdapter simpleRecyclerViewAdapter = null;

    LinearLayoutManager linearLayoutManager;

    int moreNum = 2;


    private ActionMode actionMode;

    boolean isDrag = true;

    private ItemTouchHelper mItemTouchHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
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

//        圆图的item header
        StickyRecyclerHeadersDecoration headersDecor = new StickyRecyclerHeadersDecoration(simpleRecyclerViewAdapter);
        ultimateRecyclerView.addItemDecoration(headersDecor);

        //设置加载更多
        ultimateRecyclerView.setLoadMoreView(LayoutInflater.from(this)
                .inflate(R.layout.custom_bottom_progressbar, null));
        //headview
        ultimateRecyclerView.setParallaxHeader(getLayoutInflater().inflate(R.layout.parallax_recyclerview_header, ultimateRecyclerView.mRecyclerView, false));

        //head 的滚动
        ultimateRecyclerView.setOnParallaxScroll(new UltimateRecyclerView.OnParallaxScroll() {
            @Override
            public void onParallaxScroll(float percentage, float offset, View parallax) {
                Drawable c = toolbar.getBackground();
                c.setAlpha(Math.round(127 + percentage * 128));
                toolbar.setBackgroundDrawable(c);
            }
        });



        ultimateRecyclerView.setRecylerViewBackgroundColor(Color.parseColor("#ff00ff"));


        ultimateRecyclerView.setDefaultOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        simpleRecyclerViewAdapter.insert(moreNum++ + "  Refresh things", 0);
                        ultimateRecyclerView.setRefreshing(false);
                        //   ultimateRecyclerView.scrollBy(0, -50);
                        linearLayoutManager.scrollToPosition(0);
//                        ultimateRecyclerView.setAdapter(simpleRecyclerViewAdapter);
//                        simpleRecyclerViewAdapter.notifyDataSetChanged();
                    }
                }, 1000);
            }
        });
        /**
         * item的滑动监听
         */
        ItemTouchHelper.Callback callback = new SimpleItemTouchHelperCallback(simpleRecyclerViewAdapter);
        mItemTouchHelper = new ItemTouchHelper(callback);
        mItemTouchHelper.attachToRecyclerView(ultimateRecyclerView.mRecyclerView);
        simpleRecyclerViewAdapter.setOnDragStartListener(new SimpleAdapter.OnStartDragListener() {
            @Override
            public void onStartDrag(RecyclerView.ViewHolder viewHolder) {

                Log.d("MyRecyclerView", "viewHolder");
                mItemTouchHelper.startDrag(viewHolder);
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
                        StickyRecyclerHeadersDecoration headersDecor = new StickyRecyclerHeadersDecoration(simpleRecyclerViewAdapter);
                        ultimateRecyclerView.addItemDecoration(headersDecor);
                        simpleRecyclerViewAdapter.insert("More " + moreNum++, simpleRecyclerViewAdapter.getAdapterItemCount());
                        simpleRecyclerViewAdapter.insert("More " + moreNum++, simpleRecyclerViewAdapter.getAdapterItemCount());
                        simpleRecyclerViewAdapter.insert("More " + moreNum++, simpleRecyclerViewAdapter.getAdapterItemCount());
                        // linearLayoutManager.scrollToPositionWithOffset(maxLastVisiblePosition,-1);
                        //   linearLayoutManager.scrollToPosition(maxLastVisiblePosition);

                    }
                }, 1000);
            }
        });


        ultimateRecyclerView.showFloatingButtonView();

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> spinnerAdapter =
                new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        for (Type type : Type.values()) {
            spinnerAdapter.add(type.name());
        }
        spinner.setAdapter(spinnerAdapter);
        /**
         * 设置  增加  删除动画
         */
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ultimateRecyclerView.setItemAnimator(Type.values()[position].getAnimator());
                ultimateRecyclerView.getItemAnimator().setAddDuration(500);
                ultimateRecyclerView.getItemAnimator().setRemoveDuration(500);
            }

            @Override public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        findViewById(R.id.add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                simpleRecyclerViewAdapter.insert("newly added item", 1);
            }
        });

        findViewById(R.id.del).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                simpleRecyclerViewAdapter.remove(1);
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

    }


    /**
     *目前无用
     * @param position
     */

    private void toggleSelection(int position) {
        simpleRecyclerViewAdapter.toggleSelection(position);
        actionMode.setTitle("Selected " + "1");
    }

    /**
     * 目前无用
     * @return
     */

    public int getScreenHeight() {
        return findViewById(android.R.id.content).getHeight();
    }




    //菜单
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    //菜单操作
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        FastBinding.startactivity(this, item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    /**
     * Called to refresh an action mode's action menu whenever it is invalidated.
     *
     * @param mode ActionMode being prepared
     * @param menu Menu used to populate action buttons
     * @return true if the menu or action mode was updated, false otherwise.
     */
    @Override
    public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
        this.actionMode = mode;
        return false;

    }
    @Override
    public boolean onCreateActionMode(ActionMode mode, Menu menu) {
        URLogs.d("actionmode---" + (mode == null));
        mode.getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
        //  return false;
    }



    @Override
    public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
        return false;
    }

    @Override
    public void onDestroyActionMode(ActionMode mode) {
        this.actionMode=null;

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();


    }

    //动画类型
    enum Type {
        FadeIn(new FadeInAnimator(new OvershootInterpolator(1f))),
        FadeInDown(new FadeInDownAnimator(new OvershootInterpolator(1f))),
        FadeInUp(new FadeInUpAnimator(new OvershootInterpolator(1f))),
        FadeInLeft(new FadeInLeftAnimator(new OvershootInterpolator(1f))),
        FadeInRight(new FadeInRightAnimator(new OvershootInterpolator(1f))),
        Landing(new LandingAnimator(new OvershootInterpolator(1f))),
        ScaleIn(new ScaleInAnimator(new OvershootInterpolator(1f))),
        ScaleInTop(new ScaleInTopAnimator(new OvershootInterpolator(1f))),
        ScaleInBottom(new ScaleInBottomAnimator(new OvershootInterpolator(1f))),
        ScaleInLeft(new ScaleInLeftAnimator(new OvershootInterpolator(1f))),
        ScaleInRight(new ScaleInRightAnimator(new OvershootInterpolator(1f))),
        FlipInTopX(new FlipInTopXAnimator(new OvershootInterpolator(1f))),
        FlipInBottomX(new FlipInBottomXAnimator(new OvershootInterpolator(1f))),
        FlipInLeftY(new FlipInLeftYAnimator(new OvershootInterpolator(1f))),
        FlipInRightY(new FlipInRightYAnimator(new OvershootInterpolator(1f))),
        SlideInLeft(new SlideInLeftAnimator(new OvershootInterpolator(1f))),
        SlideInRight(new SlideInRightAnimator(new OvershootInterpolator(1f))),
        SlideInDown(new SlideInDownAnimator(new OvershootInterpolator(1f))),
        SlideInUp(new SlideInUpAnimator(new OvershootInterpolator(1f))),
        OvershootInRight(new OvershootInRightAnimator(1.0f)),
        OvershootInLeft(new OvershootInLeftAnimator(1.0f));

        private BaseItemAnimator mAnimator;

        Type(BaseItemAnimator animator) {
            mAnimator = animator;
        }

        public BaseItemAnimator getAnimator() {
            return mAnimator;
        }


    }
}
