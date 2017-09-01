package com.tianxi.recycleviewdemo02.rvComponents;

import android.graphics.Color;
import android.view.View;

import com.marshalchen.ultimaterecyclerview.quickAdapter.easyRegularAdapter;
import com.tianxi.recycleviewdemo02.R;

import java.security.SecureRandom;
import java.util.List;

/**
 * Created by admin on 17/5/24.
 */

public class sectionZeroAdapter extends easyRegularAdapter<String, itemCommonBinder> {


    public sectionZeroAdapter(List<String> stringList) {
        super(stringList);
        //  this.stringList = stringList;
    }
    /**
     * the layout id for the normal data
     *
     * @return the ID
     */
    @Override
    protected int getNormalLayoutResId() {
        return itemCommonBinder.layout;
    }

    /**
     *
     */
    @Override
    protected itemCommonBinder newViewHolder(View view) {
        return new itemCommonBinder(view, true);
    }

    /**
     * footview
     */
    @Override
    public itemCommonBinder newFooterHolder(View view) {
        return  new itemCommonBinder(view, true);
    }


    /**
     *  headview
     */
    @Override
    public itemCommonBinder newHeaderHolder(View view) {
        return new itemCommonBinder(view, false);
    }

    /**
     * insert view
     */
    public final void insertOne(String e) {
        insertLast(e);
    }

    /**
     * remove last  view
     */
    public final void removeLastOne() {
        removeLast();
    }

    /**
     * bind  data
     */
    @Override
    protected void withBindHolder(itemCommonBinder holder, String data, int position) {
        holder.textViewSample.setText(data + "just the sample data");
        holder.item_view.setBackgroundColor(Color.parseColor("#AAffffff"));
        SecureRandom imgGen = new SecureRandom();
        switch (imgGen.nextInt(3)) {
            case 0:
                holder.imageViewSample.setImageResource(R.mipmap.scn1);
                break;
            case 1:
                holder.imageViewSample.setImageResource(R.mipmap.jr13);
                break;
            case 2:
                holder.imageViewSample.setImageResource(R.mipmap.jr16);
                break;
        }

    }

    /**
     * 条目移动
     */
    @Override
    public void onItemMove(int fromPosition, int toPosition) {
        swapPositions(fromPosition, toPosition);
//        notifyItemMoved(fromPosition, toPosition);
//        super.onItemMove(fromPosition, toPosition);
    }

    /**
     * 条目消失
     */
    @Override
    public void onItemDismiss(int position) {
        if (position > 0)
            removeAt(position);
        // notifyItemRemoved(position);
        //        notifyDataSetChanged();
        super.onItemDismiss(position);
    }



  /* public String getItem(int position) {
        if (customHeaderView != null)
            position--;
        if (position < stringList.size())
            return stringList.get(position);
        else
            return "";
    }*/
//
//    private int getRandomColor() {
//        SecureRandom rgen = new SecureRandom();
//        return Color.HSVToColor(150, new float[]{
//                rgen.nextInt(359), 1, 1
//        });
//    }





    public void setOnDragStartListener(OnStartDragListener dragStartListener) {
        mDragStartListener = dragStartListener;

    }



}
