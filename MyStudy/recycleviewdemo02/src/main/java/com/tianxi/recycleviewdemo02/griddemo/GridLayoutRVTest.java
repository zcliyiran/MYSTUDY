package com.tianxi.recycleviewdemo02.griddemo;


import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.ActionMode;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;

import com.marshalchen.ultimaterecyclerview.UltimateRecyclerView;
import com.marshalchen.ultimaterecyclerview.grid.BasicGridLayoutManager;
import com.tianxi.recycleviewdemo02.R;
import com.tianxi.recycleviewdemo02.modules.JRitem;
import com.tianxi.recycleviewdemo02.modules.SampleDataboxset;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * recyclerview 的Grid样式
 */
public class GridLayoutRVTest extends AppCompatActivity {
    @BindView(R.id.ultimate_recycler_view)
    UltimateRecyclerView listuv;

    @BindView(R.id.tool_bar)
    Toolbar mToolbar;


    GridJRAdapter mGridAdapter = null;

    private BasicGridLayoutManager mGridLayoutManager;

    private int moreNum = 2, columns = 2;

    private ActionMode actionMode;

    boolean isDrag = true;

    private ItemTouchHelper mItemTouchHelper;

    public static final String TAG = "GLV";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_layout_rvtest);
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        //初始化适配器
        mGridAdapter = new GridJRAdapter(getJRList());
        //设置多少列
        mGridAdapter.setSpanColumns(columns);
        //布局管理器
        mGridLayoutManager=new BasicGridLayoutManager(this,columns,mGridAdapter);

        listuv.setLayoutManager(mGridLayoutManager);

        listuv.setAdapter(mGridAdapter);
        // 确保尺寸是通过用户输入从而确保RecyclerView的尺寸是一个常数
        listuv.setHasFixedSize(true);
        //
        listuv.setSaveEnabled(true);
        //可以在padding中绘制
        listuv.setClipToPadding(false);
        //设置headview
        listuv.setNormalHeader(setupHeaderView());


        final Handler f = new Handler();
        listuv.setOnLoadMoreListener(new UltimateRecyclerView.OnLoadMoreListener() {
            @Override
            public void loadMore(int itemsCount, int maxLastVisiblePosition) {
                //   Log.d(TAG, itemsCount + " :: " + itemsCount);
                f.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mGridAdapter.insert(SampleDataboxset.genJRList(5));
                        mGridAdapter.notifyDataSetChanged();
//                        afterAdd();
                    }
                }, 2000);
            }
        });

        // listuv.enableLoadmore();
        //    listuv.disableLoadmore();
        listuv.setLoadMoreView(R.layout.custom_bottom_progressbar);

        listuv.setAdapter(mGridAdapter);
        listuv.setItemAnimator(new DefaultItemAnimator());
        // 设置点击事件
        harness_control();





    }
//    protected void afterAdd() {
//
//    }

    /**
     *  设置headview
     *
     * @return
     */
    private View setupHeaderView() {

        View custom_header = LayoutInflater.from(this).inflate(R.layout.header_love, null, false);


        return custom_header;
    }




    private List<JRitem> getJRList() {
        List<JRitem> team = new ArrayList<>();
        //you can make your own test for starting-zero-data
        //   team = SampleDataboxset.genJRList(2);
        return team;
    }
    private void harness_control() {
        findViewById(R.id.add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mGridAdapter.insert(SampleDataboxset.genJRList(4));
            }
        });

        findViewById(R.id.del).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mGridAdapter.removeLast();
            }
        });

        findViewById(R.id.delall).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mGridAdapter.removeAll();
            }
        });
        findViewById(R.id.add_one).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mGridAdapter.insertFirst(SampleDataboxset.genJRSingle());
            }
        });

        findViewById(R.id.refresh).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listuv.reenableLoadmore();
            }
        });


    }
}
