package com.tianxi.rollviewpagerdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jude.rollviewpager.RollPagerView;
import com.tianxi.rollviewpagerdemo.R;
import com.tianxi.rollviewpagerdemo.utils.ScreenUtils;

import java.util.List;

/**
 * Created by admin on 17/4/13.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;

    List<Integer> list;

    enum ItemType {
        Item_TYPE1,
        Item_TYPE2
    }

    public RecyclerViewAdapter(Context context, List<Integer> list) {
        this.context=context;
        this.list=list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == ItemType.Item_TYPE1.ordinal()) {
            View view = LayoutInflater.from(context).inflate(R.layout.item_bunner, parent, false);
            view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                    ScreenUtils.getScreenW()/2));
            view.setVisibility(View.GONE);
            return new ViewHolder1(view);
        } else {
            View view = LayoutInflater.from(context).inflate(R.layout.item_normal, parent, false);
            return new ViewHolder2(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ViewHolder1) {
            ((ViewHolder1) holder).mRollViewPager
                    .setPlayDelay(1000);
            //设置透明度
            ((ViewHolder1) holder).mRollViewPager
                    .setAnimationDurtion(500);
            //设置适配器
            ((ViewHolder1) holder).mRollViewPager
                    .setAdapter(new RollPagerViewAdapter());


            //设置指示器（顺序依次）
            //自定义指示器图片
            //设置圆点指示器颜色
            //设置文字指示器
            //隐藏指示器
            //mRollViewPager.setHintView(new IconHintView(this, R.drawable.point_focus, R.drawable.point_normal));
//            ((ViewHolder1) holder).mRollViewPager
//                    .setHintView(new ColorPointHintView(context, Color.YELLOW, Color.WHITE));
            //mRollViewPager.setHintView(new TextHintView(this));
            //mRollViewPager.setHintView(null);

        } else if (holder instanceof ViewHolder2) {

        }

    }


    @Override
    public int getItemViewType(int position) {
//        return super.getItemViewType(position);
        if (position == 0) {
            return ItemType.Item_TYPE1.ordinal();
        } else {
            return ItemType.Item_TYPE2.ordinal();
        }
    }

    @Override
    public int getItemCount() {
        return list.size()+1;
    }

    class ViewHolder1 extends RecyclerView.ViewHolder {
        RollPagerView mRollViewPager;

        public ViewHolder1(View itemView) {
            super(itemView);
            mRollViewPager = (RollPagerView) itemView.findViewById(R.id.roll_view_pager);
        }
    }

    class ViewHolder2 extends RecyclerView.ViewHolder {

        public ViewHolder2(View itemView) {
            super(itemView);
        }
    }

}
