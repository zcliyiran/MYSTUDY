package com.tianxi.recycleviewdemo01;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.tianxi.recycleviewdemo01.adapter.MyAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义recycleview
 */
public class MainActivity extends AppCompatActivity {
    private RecyclerView recycler;
    private MyAdapter adapter;
    private SwipeRefreshLayout refreshLayout;
    private List<String> list;

    private int mpage = 1;
    private boolean isLoading = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();


        requestNet(mpage);


    }


    private void initView() {
        recycler = (RecyclerView) findViewById(R.id.recycler);
        refreshLayout = (SwipeRefreshLayout) findViewById(R.id.srl);
        list = new ArrayList<>();
        final LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(mLinearLayoutManager);
        adapter = new MyAdapter(list, this);
        recycler.setAdapter(adapter);

        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mpage = 1;
                list.clear();
                adapter.notifyDataSetChanged();
                requestNet(mpage);
            }
        });
        recycler.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                int visible = mLinearLayoutManager.getChildCount();
                int total = mLinearLayoutManager.getItemCount();
                int past = mLinearLayoutManager.findFirstCompletelyVisibleItemPosition();
                if ((visible + past) >= total) {
                    if (!isLoading) {
                        isLoading = true;
                        mpage++;
//                        requestNet(mpage);

                    }
                }

            }
        });
    }


    private void requestNet(final int page) {
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
        for (int i = (page - 1) * 10; i < page * 10; i++) {

            list.add("第" + i + "条信息");

        }

        adapter.notifyDataSetChanged();

        refreshLayout.setRefreshing(false);
        isLoading = false;
//            }
//        }).start();
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//            adapter.notifyDataSetChanged();
//            }
//        },3000);


    }

}
