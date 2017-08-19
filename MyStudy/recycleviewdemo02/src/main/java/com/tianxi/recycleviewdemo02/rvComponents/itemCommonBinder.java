package com.tianxi.recycleviewdemo02.rvComponents;

import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.marshalchen.ultimaterecyclerview.UltimateRecyclerviewViewHolder;
import com.tianxi.recycleviewdemo02.R;

/**
 * Created by admin on 17/5/24.
 */

public class itemCommonBinder extends UltimateRecyclerviewViewHolder {

    public static final int layout = R.layout.rv_item_linear;
    public TextView textViewSample;
    public ImageView imageViewSample;
    public ProgressBar progressBarSample;
    public RelativeLayout item_view;

    public itemCommonBinder(View itemView , boolean isItem ) {
        super(itemView);
        if (isItem) {
            textViewSample = (TextView) itemView.findViewById(R.id.str_textview_holder);
            imageViewSample = (ImageView) itemView.findViewById(R.id.str_image_holder);
            progressBarSample = (ProgressBar) itemView.findViewById(R.id.str_progress_holder);
            item_view = (RelativeLayout) itemView.findViewById(R.id.str_item_view);
        }
    }

    @Override
    public void onItemSelected() {
        itemView.setBackgroundColor(Color.LTGRAY);
    }

    @Override
    public void onItemClear() {
        itemView.setBackgroundColor(0);
    }


}
