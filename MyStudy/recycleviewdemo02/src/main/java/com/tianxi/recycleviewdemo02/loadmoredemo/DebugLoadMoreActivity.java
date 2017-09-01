package com.tianxi.recycleviewdemo02.loadmoredemo;


import android.graphics.Color;

import com.marshalchen.ultimaterecyclerview.UltimateRecyclerView;
import com.marshalchen.ultimaterecyclerview.ui.swipe.SwipeableRecyclerViewTouchListener;
import com.marshalchen.ultimaterecyclerview.ui.swipe.defaultRegularSwipe;
import com.tianxi.recycleviewdemo02.R;
import com.tianxi.recycleviewdemo02.modules.SampleDataboxset;
import com.tianxi.recycleviewdemo02.rvComponents.sectionZeroAdapter;

import java.util.ArrayList;

public class DebugLoadMoreActivity extends BasicFunctions {

    private sectionZeroAdapter simpleRecyclerViewAdapter = null;

    /**
     * set  emptyview
     */
    @Override
    protected void enableEmptyViewPolicy() {
//        super.enableEmptyViewPolicy();
        /**
         * Need to see the effect
         */

//          ultimateRecyclerView.setEmptyView(R.layout.empty_view, UltimateRecyclerView.EMPTY_KEEP_HEADER_AND_LOARMORE);
//            ultimateRecyclerView.setEmptyView(R.layout.empty_view, UltimateRecyclerView.EMPTY_KEEP_HEADER);
        ultimateRecyclerView.setEmptyView(R.layout.empty_view, UltimateRecyclerView.EMPTY_SHOW_LOADMORE_ONLY);

    }

    /**
     * load more
     */
    @Override
    protected void onLoadmore() {

        SampleDataboxset.insertMoreWhole(simpleRecyclerViewAdapter, 2);
        /**
         * this is the example for making the function test for loading more and disable loading more
         *
         *  进行加载和禁用加载更多
         *
         */
//                         if (isEnableAutoLoadMore) {
////                            ultimateRecyclerView.enableLoadmore();
//                             ultimateRecyclerView.isLoadMoreEnabled();
////                             enableLoadMore();
//                        } else {
//                            ultimateRecyclerView.disableLoadmore();
//
//                        }

    }

    /**
     *
     */
    @Override
    protected void enableSwipe() {
        super.enableSwipe();
        ultimateRecyclerView.addOnItemTouchListener(new SwipeableRecyclerViewTouchListener(ultimateRecyclerView.mRecyclerView, new defaultRegularSwipe<>(simpleRecyclerViewAdapter)));

    }

    /**
     *
     */
    @Override
    protected void addButtonTrigger() {
        simpleRecyclerViewAdapter.insertFirst("rand added item");
        ultimateRecyclerView.reenableLoadmore();
    }

    /**
     *  romove  last  item
     */
    @Override
    protected void removeButtonTrigger() {
        simpleRecyclerViewAdapter.removeLast();
    }

    /**
     *
     */
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
        //ultimateRecyclerView.showEmptyView();

    }

    /**
     *
     */
    @Override
    protected void doURV(UltimateRecyclerView ultimateRecyclerView) {
        ultimateRecyclerView.setHasFixedSize(false);
        simpleRecyclerViewAdapter = new sectionZeroAdapter(new ArrayList<String>());
        configLinearLayoutManager(ultimateRecyclerView);
//        configGridLayoutManager(ultimateRecyclerView,simpleRecyclerViewAdapter);
        enableParallaxHeader();
        enableEmptyViewPolicy();
        enableLoadMore();

        ultimateRecyclerView.setRecylerViewBackgroundColor(Color.parseColor("#ffff66ff"));
        enableRefresh();
        // enableScrollControl();
        // enableSwipe();
        // enableItemClick();
        //ultimateRecyclerView.setItemViewCacheSize(simpleRecyclerViewAdapter.getAdditionalItems());
        ultimateRecyclerView.setAdapter(simpleRecyclerViewAdapter);
    }


    private void toggleSelection(int position) {
//        simpleRecyclerViewAdapter.toggleSelection(position);
//        actionMode.setTitle("Selected " + "1");
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();


    }


}
