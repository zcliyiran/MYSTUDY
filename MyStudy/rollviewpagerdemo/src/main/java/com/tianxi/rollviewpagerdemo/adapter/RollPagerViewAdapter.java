package com.tianxi.rollviewpagerdemo.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.jude.rollviewpager.adapter.StaticPagerAdapter;
import com.tianxi.rollviewpagerdemo.R;
import com.tianxi.rollviewpagerdemo.utils.ScreenUtils;

/**
 * Created by admin on 17/4/13.
 */

public class RollPagerViewAdapter extends StaticPagerAdapter {
    private int[] imgs = {
            R.drawable.im1,
            R.drawable.im2,
            R.drawable.im3
    };


    @Override
    public View getView(ViewGroup container, int position) {
        ImageView view = new ImageView(container.getContext());
        view.setImageResource(imgs[position]);
        view.setScaleType(ImageView.ScaleType.CENTER_CROP);
        view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ScreenUtils.getScreenW()/2));
        return view;
    }


    @Override
    public int getCount() {
        return imgs.length;
    }
}
