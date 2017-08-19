package com.tianxi.recycleviewdemo02.loadmoredemo;

import android.graphics.Color;

import com.marshalchen.ultimaterecyclerview.UltimateRecyclerView;
import com.tianxi.recycleviewdemo02.R;
import com.tianxi.recycleviewdemo02.modules.SampleDataboxset;
import com.tianxi.recycleviewdemo02.rvComponents.sectionZeroAdapter;

import java.util.ArrayList;

public class DebugNoHeaderLoadMoreActivity extends BasicFunctions {


    private sectionZeroAdapter simpleRecyclerViewAdapter = null;


    @Override
    protected void enableEmptyViewPolicy() {
        super.enableEmptyViewPolicy();
        ultimateRecyclerView.setEmptyView(R.layout.empty_view, UltimateRecyclerView.EMPTY_KEEP_HEADER_AND_LOARMORE);



    }

    @Override
    protected void onLoadmore() {

        SampleDataboxset.insertMoreWhole(simpleRecyclerViewAdapter, 2);



    }

    @Override
    protected void onFireRefresh() {

        // simpleRecyclerViewAdapter.insertLast(moreNum++ + "  Refresh things");
        ultimateRecyclerView.setRefreshing(false);
        //   ultimateRecyclerView.scrollBy(0, -50);
        //  linearLayoutManager.scrollToPosition(0);
        ultimateRecyclerView.scrollVerticallyTo(0);
        //ultimateRecyclerView.setAdapter(simpleRecyclerViewAdapter);
        //simpleRecyclerViewAdapter.notifyDataSetChanged();
        simpleRecyclerViewAdapter.removeAll();
        ultimateRecyclerView.disableLoadmore();
        ultimateRecyclerView.showEmptyView();

    }

    @Override
    protected void addButtonTrigger() {
        simpleRecyclerViewAdapter.insertLast("++ new Item");
        ultimateRecyclerView.reenableLoadmore();
    }

    @Override
    protected void removeButtonTrigger() {
        simpleRecyclerViewAdapter.removeLast();

    }

    @Override
    protected void doURV(UltimateRecyclerView ultimateRecyclerView) {

        ultimateRecyclerView.setHasFixedSize(false);
        ArrayList<String> list = new ArrayList<>();
        list.add("o2fn31");
        list.add("of2n32");
        list.add("of3n36");
        simpleRecyclerViewAdapter = new sectionZeroAdapter(list);
        configLinearLayoutManager(ultimateRecyclerView);
        //enableParallaxHeader();
        //设置emptview
        enableEmptyViewPolicy();
        //可以加载更多
        enableLoadMore();
        ultimateRecyclerView.setRecylerViewBackgroundColor(Color.parseColor("#ff4fcccf"));
        enableRefresh();
        // enableScrollControl();
        // enableSwipe();
        // enableItemClick();
        ultimateRecyclerView.setItemViewCacheSize(simpleRecyclerViewAdapter.getAdditionalItems());

        ultimateRecyclerView.setAdapter(simpleRecyclerViewAdapter);
    }
}
