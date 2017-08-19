package com.tianxi.recycleviewdemo01.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.tianxi.recycleviewdemo01.R;

import java.util.List;

/**
 * Created by admin on 17/5/17.
 */

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<String> list;

    private Context context;

    enum ItemType{

        nomarl,
        last

    }

    public MyAdapter(List<String> list, Context context) {
        this.list = list;
        this.context = context;


    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType==ItemType.nomarl.ordinal()){
            View inflate = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
            return new MyAdapterViewHolder(inflate);

        }else if (viewType==ItemType.last.ordinal()){
            View inflate1= LayoutInflater.from(context).inflate(R.layout.item_footer, parent, false);

            return new MyAdapterViewHolder2(inflate1);
        }
        return null;

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MyAdapterViewHolder2) {

            Log.d("MyAdapter", "----------");
        }
        if (holder instanceof MyAdapterViewHolder) {
            if (position<list.size())
            ((MyAdapterViewHolder) holder).tv.setText(list.get(position));

        }


//        else if (holder instanceof MyAdapterViewHolder2) {
//
//
//        }

    }

    @Override
    public int getItemViewType(int position) {
        if (position==list.size()){

            return ItemType.last.ordinal();
        }else {
            return ItemType.nomarl.ordinal();

        }
    }

    @Override
    public int getItemCount() {
        return list.size()+1;
    }


}

class MyAdapterViewHolder extends RecyclerView.ViewHolder {
    TextView tv;

    public MyAdapterViewHolder(View itemView) {
        super(itemView);
        tv = (TextView) itemView.findViewById(R.id.tv);
    }
}

class MyAdapterViewHolder2 extends RecyclerView.ViewHolder {

    private final ProgressBar pb;

    public MyAdapterViewHolder2(View itemView) {
        super(itemView);
        pb = (ProgressBar) itemView.findViewById(R.id.pb);
    }

}