package com.tianxi.recycleviewdemo02.griddemo;

import android.view.View;
import android.view.ViewGroup;

import com.marshalchen.ultimaterecyclerview.UltimateGridLayoutAdapter;
import com.marshalchen.ultimaterecyclerview.UltimateRecyclerviewViewHolder;
import com.tianxi.recycleviewdemo02.modules.JRitem;
import com.tianxi.recycleviewdemo02.rvComponents.itemGridCellBinder;

import java.util.List;

/**
 * Created by admin on 17/5/22.
 */

public class GridJRAdapter extends UltimateGridLayoutAdapter <JRitem,itemGridCellBinder> {

    /**
     * 数据传递进来
     * @param items
     */
    public GridJRAdapter(List<JRitem> items) {
        super(items);
    }

    /**
     * 正常的item  布局id
     *
     * @return the ID
     */
    @Override
    protected int getNormalLayoutResId() {

        return itemGridCellBinder.layout;

    }
    /**
     *  正常视图启动
     */
    @Override
    protected itemGridCellBinder newViewHolder(View view) {

        return new itemGridCellBinder(view, true);

    }
    /**
     * 绑定headview的数据
     *
     */
    @Override
    protected void withBindHolder(itemGridCellBinder holder, JRitem data, int position) {






    }

    /**
     *绑定标准视图
     *
     */
    @Override
    protected void bindNormal(itemGridCellBinder b, JRitem jRitem, int position) {
        b.textViewSample.setText(jRitem.train_name);
        b.imageViewSample.setImageResource(jRitem.photo_id);

    }





    /**
     *  正常视图启动
     */
    @Override
    public itemGridCellBinder newHeaderHolder(View view) {

        return new itemGridCellBinder(view, false);
    }


    /**
     *
     *  正常视图启动
     */
    @Override
    public itemGridCellBinder newFooterHolder(View view) {

        return new itemGridCellBinder(view, false);

    }


    /**
     *
     *  正常视图启动
     */
    @Override
    public UltimateRecyclerviewViewHolder onCreateHeaderViewHolder(ViewGroup parent) {

        return new UltimateRecyclerviewViewHolder(parent);
    }
}
