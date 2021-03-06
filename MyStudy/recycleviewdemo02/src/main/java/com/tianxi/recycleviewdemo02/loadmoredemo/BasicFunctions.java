package com.tianxi.recycleviewdemo02.loadmoredemo;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.ActionMode;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.marshalchen.ultimaterecyclerview.DragDropTouchListener;
import com.marshalchen.ultimaterecyclerview.UltimateRecyclerView;
import com.marshalchen.ultimaterecyclerview.layoutmanagers.ClassicSpanGridLayoutManager;
import com.marshalchen.ultimaterecyclerview.layoutmanagers.ScrollSmoothLineaerLayoutManager;
import com.marshalchen.ultimaterecyclerview.quickAdapter.easyRegularAdapter;
import com.tianxi.recycleviewdemo02.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by admin on 17/5/23.
 */

public abstract class BasicFunctions extends AppCompatActivity {
    @BindView(R.id.ultimate_recycler_view)
    UltimateRecyclerView ultimateRecyclerView;
    @BindView(R.id.tool_bar)
    Toolbar toolbar;

    ActionMode actionMode;

    LinearLayoutManager linearLayoutManager;

    private int moreNum = 2;

    protected boolean isDrag = true, isEnableAutoLoadMore = true, status_progress = false;

    private DragDropTouchListener dragDropTouchListener;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loadmore);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        doURV(ultimateRecyclerView);
        bButtons();
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        setupSpinnerSelection((Spinner) findViewById(R.id.spinner), spinnerAdapter);


    }

    /**
     * Can set the parallax header of the recyclerview
     */
    protected void enableParallaxHeader() {
        //设置parallax 的视图
        ultimateRecyclerView.setParallaxHeader(getLayoutInflater().inflate(R.layout.parallax_recyclerview_header, ultimateRecyclerView.mRecyclerView, false));
        //设置parallax 的参数
        ultimateRecyclerView.setOnParallaxScroll(new UltimateRecyclerView.OnParallaxScroll() {
            @Override
            public void onParallaxScroll(float percentage, float offset, View parallax) {
                Drawable c = toolbar.getBackground();
                c.setAlpha(Math.round(127 + percentage * 128));
                toolbar.setBackgroundDrawable(c);
            }
        });
    }

    /**
     * Can  load  more
     */
    protected void enableLoadMore() {
        //  load more progressbar
        ultimateRecyclerView.setLoadMoreView(R.layout.custom_bottom_progressbar);
        // delay load more
        ultimateRecyclerView.setOnLoadMoreListener(new UltimateRecyclerView.OnLoadMoreListener() {
            @Override
            public void loadMore(int itemsCount, final int maxLastVisiblePosition) {
                status_progress = true;
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {

                        onLoadmore();

                        status_progress = false;
                    }
                }, 500);


            }
        });


    }


    /**
     * loading
     */
    protected abstract void onLoadmore();


    /**
     * refreshing
     */
    protected abstract void onFireRefresh();

    /**
     * Can  refresh
     */
    protected void enableRefresh() {
//        ultimateRecyclerView.setDefaultOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
//            @Override
//            public void onRefresh() {
//                new Handler().postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        onFireRefresh();
//                    }
//                }, 1000);
//            }
//        });
//                ultimateRecyclerView.setDefaultSwipeToRefreshColorScheme(getResources().getColor(android.R.color.holo_blue_bright),
//                getResources().getColor(android.R.color.holo_green_light),
//                getResources().getColor(android.R.color.holo_orange_light),
//                getResources().getColor(android.R.color.holo_red_light));

    }
/**
 *   did not use
 */

//    protected final void configStaggerLayoutManager(UltimateRecyclerView rv, easyRegularAdapter ad) {
//        StaggeredGridLayoutManager gaggeredGridLayoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
//        rv.setLayoutManager(gaggeredGridLayoutManager);
//    }
//
    protected final void configGridLayoutManager(UltimateRecyclerView rv, easyRegularAdapter ad) {
        final ClassicSpanGridLayoutManager mgm = new ClassicSpanGridLayoutManager(this, 2, ad);
        rv.setLayoutManager(mgm);
    }

    protected final void configLinearLayoutManager(UltimateRecyclerView rv) {
        final ScrollSmoothLineaerLayoutManager mgm = new ScrollSmoothLineaerLayoutManager(this, LinearLayoutManager.VERTICAL, false, 300);
        rv.setLayoutManager(mgm);
    }
//
//
//    protected final void enableScrollControl() {
//        ultimateRecyclerView.setScrollViewCallbacks(new ObservableScrollViewCallbacks() {
//            @Override
//            public void onScrollChanged(int scrollY, boolean firstScroll, boolean dragging) {
//                URLogs.d("onScrollChanged: " + dragging);
//            }
//
//            @Override
//            public void onDownMotionEvent() {
//
//            }
//
//            @Override
//            public void onUpOrCancelMotionEvent(ObservableScrollState observableScrollState) {
//                URLogs.d("onUpOrCancelMotionEvent");
//                if (observableScrollState == ObservableScrollState.UP) {
//                    ultimateRecyclerView.hideToolbar(toolbar, ultimateRecyclerView, getScreenHeight());
//                    ultimateRecyclerView.hideFloatingActionMenu();
//                } else if (observableScrollState == ObservableScrollState.DOWN) {
//                    ultimateRecyclerView.showToolbar(toolbar, ultimateRecyclerView, getScreenHeight());
//                    ultimateRecyclerView.showFloatingActionMenu();
//                }
//            }
//        });
//
//        ultimateRecyclerView.showFloatingButtonView();
//    }
//
//    public int getScreenHeight() {
//        return findViewById(android.R.id.content).getHeight();
//    }

    /**
     * Can  set  emptyview of the recyclerview
     */
    protected void enableEmptyViewPolicy() {

        //  ultimateRecyclerView.setEmptyView(R.layout.empty_view, UltimateRecyclerView.EMPTY_KEEP_HEADER_AND_LOARMORE);
        //    ultimateRecyclerView.setEmptyView(R.layout.empty_view, UltimateRecyclerView.EMPTY_KEEP_HEADER);
        //  ultimateRecyclerView.setEmptyView(R.layout.empty_view, UltimateRecyclerView.EMPTY_SHOW_LOADMORE_ONLY);
        ultimateRecyclerView.setEmptyView(R.layout.empty_view, UltimateRecyclerView.EMPTY_CLEAR_ALL);
    }


    /**
     * Can  set  refresh of the recyclerview
     */
    protected void enableSwipe() {


    }

    /**
     * did not use
     */
//    protected void enableItemClick() {
//        ItemTouchListenerAdapter itemTouchListenerAdapter = new ItemTouchListenerAdapter(ultimateRecyclerView.mRecyclerView,
//                new ItemTouchListenerAdapter.RecyclerViewOnItemClickListener() {
//                    @Override
//                    public void onItemClick(RecyclerView parent, View clickedView, int position) {
//                    }
//
//                    @Override
//                    public void onItemLongClick(RecyclerView parent, View clickedView, int position) {
//                        URLogs.d("onItemLongClick()" + isDrag);
//                        if (isDrag) {
//                            URLogs.d("onItemLongClick()" + isDrag);
//                            //   dragDropTouchListener.startDrag();
//                            //   ultimateRecyclerView.enableDefaultSwipeRefresh(false);
//                        }
//
//                    }
//                });
//        ultimateRecyclerView.mRecyclerView.addOnItemTouchListener(itemTouchListenerAdapter);
//    }
    protected abstract void addButtonTrigger();

    protected abstract void removeButtonTrigger();

    private void setupSpinnerSelection(Spinner sp, ArrayAdapter<String> adapter) {
        //
        adapter.add("- select -");
        /**
         * a list of selection for other tests
         */
        for (Route type : Route.values()) {
            adapter.add(type.getNameDisplay());
        }

//        sp.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
//
//                if (position > 0) {
//                    Route.values()[position - 1].start(getApplication());
//                }
//            }
//        });

    }

    /**
     * did not use
     */

//    protected void setupSpinnerAnimationSelection(Spinner spinner, ArrayAdapter<String> adapter) {
//        adapter.add("- animator -");
//        for (AnimationType type : AnimationType.values()) {
//            adapter.add(type.name());
//        }
//        spinner.setAdapter(adapter);
//        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                if (position > 0) {
//                    ultimateRecyclerView.setItemAnimator(AnimationType.values()[position - 1].getAnimator());
//                    ultimateRecyclerView.getItemAnimator().setAddDuration(300);
//                    ultimateRecyclerView.getItemAnimator().setRemoveDuration(300);
//                }
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });
//
//    }

    private void bButtons() {
        findViewById(R.id.add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addButtonTrigger();
            }
        });

        findViewById(R.id.del).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeButtonTrigger();
            }
        });
        //作用
        findViewById(R.id.toggle).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleButtonTrigger();
            }
        });
    }

    protected void toggleButtonTrigger() {
        if (!status_progress) {
            isEnableAutoLoadMore = !isEnableAutoLoadMore;
            if (isEnableAutoLoadMore) {
                ultimateRecyclerView.reenableLoadmore();
            }
        }
    }

    protected abstract void doURV(UltimateRecyclerView ultimateRecyclerView);

}
