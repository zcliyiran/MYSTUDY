package com.tianxi.recycleviewdemo02;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.marshalchen.ultimaterecyclerview.UltimateRecyclerviewViewHolder;
import com.marshalchen.ultimaterecyclerview.UltimateViewAdapter;

import java.security.SecureRandom;
import java.util.List;

/**
 * Created by admin on 17/5/18.
 */

public class SimpleAdapter extends UltimateViewAdapter{
    private List<String> stringList;
    public SimpleAdapter(List<String> stringList) {
        this.stringList = stringList;
    }



    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (position<getItemCount()&&
                (customHeaderView!=null?position<=stringList.size():position<stringList.size())&&
                (customHeaderView!=null?position>0:true)){
            ((ViewHolder) holder).textViewSample.setText(stringList.get(customHeaderView != null ? position - 1 : position));
            if (mDragStartListener != null) {
//                ((ViewHolder) holder).imageViewSample.setOnTouchListener(new View.OnTouchListener() {
//                    @Override
//                    public boolean onTouch(View view, MotionEvent motionEvent) {
//                        return false;
//                    }
//                });
                ((ViewHolder) holder).item_view.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        Log.d("SimpleAdapter", "motionEvent");
                        return false;
                    }
                });
            }
        }

    }

    @Override
    public int getAdapterItemCount() {
        return stringList.size();
    }


    @Override
    public RecyclerView.ViewHolder newFooterHolder(View view) {

        return new UltimateRecyclerviewViewHolder<>(view);
    }

    @Override
    public RecyclerView.ViewHolder newHeaderHolder(View view) {
        return new UltimateRecyclerviewViewHolder<>(view);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_view_adapter, parent, false);
        return  new ViewHolder(v);
    }


    /**
     * 插入数据
     * @param string
     * @param position
     */
    public void insert(String string, int position) {
        insertInternal(stringList, string, position);
    }

    /**
     * 移除一条数据
     * @param position
     */
    public void remove(int position) {
        removeInternal(stringList, position);
    }


    /**
     * 清除数据
     */
    public void clear() {
        clearInternal(stringList);
    }

    /**
     * 未知方法
     */
    public void swapPositions(int from, int to) {
        swapPositions(stringList, from, to);

    }

    @Override
    public long generateHeaderId(int position) {
        if (getItem(position).length() > 0)
            return getItem(position).charAt(0);
        else return -1;
    }

    @Override
    public RecyclerView.ViewHolder onCreateHeaderViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.stick_header_item, parent, false);
        return new RecyclerView.ViewHolder(view) {
        };
    }

    @Override
    public void onBindHeaderViewHolder(RecyclerView.ViewHolder viewHolder, int position) {

        TextView textView = (TextView) viewHolder.itemView.findViewById(R.id.stick_text);
        textView.setText(String.valueOf(getItem(position).charAt(0)));
//        viewHolder.itemView.setBackgroundColor(Color.parseColor("#AA70DB93"));
        viewHolder.itemView.setBackgroundColor(Color.parseColor("#AAffffff"));
        ImageView imageView = (ImageView) viewHolder.itemView.findViewById(R.id.stick_img);

        SecureRandom imgGen = new SecureRandom();
        switch (imgGen.nextInt(3)) {
            case 0:
                imageView.setImageResource(R.mipmap.jr1);
                break;
            case 1:
                imageView.setImageResource(R.mipmap.jr2);
                break;
            case 2:
                imageView.setImageResource(R.mipmap.jr3);
                break;
        }

    }

    public String getItem(int position) {
        if (customHeaderView != null)
            position--;
        // URLogs.d("position----"+position);
        if (position >= 0 && position < stringList.size())
            return stringList.get(position);
        else return "";
    }

    @Override
    public void onItemMove(int fromPosition, int toPosition) {
        if (fromPosition > 0 && toPosition > 0) {
            swapPositions(fromPosition, toPosition);
//        notifyItemMoved(fromPosition, toPosition);
            super.onItemMove(fromPosition, toPosition);
        }

    }



    @Override
    public void onItemDismiss(int position) {
        if (position > 0) {
            remove(position);
            // notifyItemRemoved(position);
//        notifyDataSetChanged();
            super.onItemDismiss(position);
        }

    }

    public void setOnDragStartListener(OnStartDragListener dragStartListener) {
        mDragStartListener = dragStartListener;

    }

}


class ViewHolder extends UltimateRecyclerviewViewHolder {

    TextView textViewSample;
    ImageView imageViewSample;
    ProgressBar progressBarSample;
    View item_view;

    public ViewHolder(View itemView) {
        super(itemView);
//            itemView.setOnTouchListener(new SwipeDismissTouchListener(itemView, null, new SwipeDismissTouchListener.DismissCallbacks() {
//                @Override
//                public boolean canDismiss(Object token) {
//                    Logs.d("can dismiss");
//                    return true;
//                }
//
//                @Override
//                public void onDismiss(View view, Object token) {
//                   // Logs.d("dismiss");
//                    remove(getPosition());
//
//                }
//            }));
        textViewSample = (TextView) itemView.findViewById(
                R.id.textview);
        imageViewSample = (ImageView) itemView.findViewById(R.id.imageview);
        progressBarSample = (ProgressBar) itemView.findViewById(R.id.progressbar);
        progressBarSample.setVisibility(View.GONE);
        item_view = itemView.findViewById(R.id.itemview);
    }
}