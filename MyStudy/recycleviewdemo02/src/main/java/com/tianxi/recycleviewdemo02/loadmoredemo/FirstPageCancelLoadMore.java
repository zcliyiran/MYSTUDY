package com.tianxi.recycleviewdemo02.loadmoredemo;

import android.graphics.Color;
import android.os.Handler;

import com.marshalchen.ultimaterecyclerview.UltimateRecyclerView;
import com.tianxi.recycleviewdemo02.R;
import com.tianxi.recycleviewdemo02.modules.SampleDataboxset;
import com.tianxi.recycleviewdemo02.rvComponents.sectionZeroAdapter;

import java.util.ArrayList;

public class FirstPageCancelLoadMore extends BasicFunctions {

    private sectionZeroAdapter simpleRecyclerViewAdapter = null;
    private Handler time_count = new Handler();

    @Override
    protected void enableEmptyViewPolicy() {
        super.enableEmptyViewPolicy();


        ultimateRecyclerView.setEmptyView(R.layout.empty_view, UltimateRecyclerView.EMPTY_KEEP_HEADER_AND_LOARMORE);

    }

    @Override
    protected void onLoadmore() {
        time_count.postDelayed(new Runnable() {
            @Override
            public void run() {
                SampleDataboxset.insertMoreWhole(simpleRecyclerViewAdapter, 2);
                ultimateRecyclerView.disableLoadmore();
            }
        }, 1000);


    }

    @Override
    protected void onFireRefresh() {
        // simpleRecyclerViewAdapter.insertLast(moreNum++ + "  Refresh things");
        ultimateRecyclerView.setRefreshing(false);
        //   ultimateRecyclerView.scrollBy(0, -50);
        linearLayoutManager.scrollToPosition(0);
        //ultimateRecyclerView.setAdapter(simpleRecyclerViewAdapter);
        //simpleRecyclerViewAdapter.notifyDataSetChanged();
        simpleRecyclerViewAdapter.removeAll();
        ultimateRecyclerView.disableLoadmore();
        ultimateRecyclerView.showEmptyView();
    }

    @Override
    protected void addButtonTrigger() {
        SampleDataboxset.insertMoreWhole(simpleRecyclerViewAdapter, 3);
        ultimateRecyclerView.reenableLoadmore();
    }

    @Override
    protected void removeButtonTrigger() {
        simpleRecyclerViewAdapter.removeAll();
    }

    @Override
    protected void doURV(UltimateRecyclerView ultimateRecyclerView) {

        ultimateRecyclerView.setHasFixedSize(false);
//        simpleRecyclerViewAdapter = new sectionZeroAdapter(new ArrayList<String>());
        ArrayList<String> list = new ArrayList<>();
        list.add("o2fn31");
        list.add("of2n32");
        list.add("of3n36");
        simpleRecyclerViewAdapter = new sectionZeroAdapter(list);
        configLinearLayoutManager(ultimateRecyclerView);
//        enableParallaxHeader();
        enableEmptyViewPolicy();
        enableLoadMore();
        ultimateRecyclerView.setRecylerViewBackgroundColor(Color.parseColor("#ff4fcccf"));
        enableRefresh();


        ultimateRecyclerView.setAdapter(simpleRecyclerViewAdapter);

    }

//    protected void enableLoadMore() {
//        //  load more progressbar
//        ultimateRecyclerView.setLoadMoreView(R.layout.custom_bottom_progressbar);
//        // delay load more
//        ultimateRecyclerView.setOnLoadMoreListener(new UltimateRecyclerView.OnLoadMoreListener() {
//            @Override
//            public void loadMore(int itemsCount, final int maxLastVisiblePosition) {
//                status_progress = true;
//                Handler handler = new Handler();
//                handler.postDelayed(new Runnable() {
//                    public void run() {
//
//                        onLoadmore();
//                        status_progress = false;
//                    }
//                }, 500);
//            }
//        });
//    }
}
