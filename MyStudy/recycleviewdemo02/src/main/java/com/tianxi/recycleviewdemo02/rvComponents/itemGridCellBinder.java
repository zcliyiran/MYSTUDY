package com.tianxi.recycleviewdemo02.rvComponents;

import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.marshalchen.ultimaterecyclerview.UltimateRecyclerviewViewHolder;
import com.tianxi.recycleviewdemo02.R;

/**
 * Created by admin on 17/5/23.
 */

public class itemGridCellBinder extends UltimateRecyclerviewViewHolder {

    public static final int layout = R.layout.grid_item;
    public TextView textViewSample;

    public ImageView imageViewSample;

    public View item_view;

    public itemGridCellBinder(View itemView, boolean isItem) {
        super(itemView);

        if (isItem) {
            textViewSample = (TextView) itemView.findViewById(R.id.example_row_tv_title);

            imageViewSample = (ImageView) itemView.findViewById(R.id.example_row_iv_image);

            itemView=itemView.findViewById(R.id.planview);



        }
    }



    @Override
    public void onItemClear() {

        super.onItemClear();

        itemView.setBackgroundColor(Color.LTGRAY);

    }


    @Override
    public void onItemSelected() {
        super.onItemSelected();

        itemView.setBackgroundColor(0);

    }


}
