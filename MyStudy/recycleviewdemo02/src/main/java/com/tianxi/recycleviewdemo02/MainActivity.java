package com.tianxi.recycleviewdemo02;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.tianxi.recycleviewdemo02.activity.LauncherActivity;
import com.tianxi.recycleviewdemo02.griddemo.GridLayoutRVTest;
import com.tianxi.recycleviewdemo02.loadmoredemo.DebugLoadMoreActivity;
import com.tianxi.recycleviewdemo02.loadmoredemo.DebugNoHeaderLoadMoreActivity;
import com.tianxi.recycleviewdemo02.loadmoredemo.FinalEmptyViewDisplayActivity;
import com.tianxi.recycleviewdemo02.loadmoredemo.FirstPageCancelLoadMore;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    @BindView(android.R.id.list)
    ListView mList;
    LinkedHashMap<String, Class> data = new LinkedHashMap<>();
    ArrayList<Class> o = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        ArrayList<String> items = new ArrayList<>();
        initList();
        for (Map.Entry<String, Class> entry : data.entrySet()) {
            String key = entry.getKey();
            items.add(key);
            o.add(entry.getValue());
        }
        mList.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items));
        mList.setOnItemClickListener(this);

    }

    private void initList() {

        data.put("LauncherActivity", LauncherActivity.class);
        data.put("Debug Grid Test", GridLayoutRVTest.class);
//        data.put("Issue #374, #363 enabled and disable load more off screen", GridTestOnlyOnePage.class);
        data.put("Debug load more", DebugLoadMoreActivity.class);
        data.put("Debug no header", DebugNoHeaderLoadMoreActivity.class);
        data.put("Debug Final Empty", FinalEmptyViewDisplayActivity.class);
        data.put("Debug First Page Cancel Load More", FirstPageCancelLoadMore.class);
//        data.put("Debug Line Node", LineNodeActivity.class);
//        data.put("Debug Pull to refresh", PullToRefreshActivity.class);
//        data.put("Debug Admob classic", TestAdMobClassicActivity.class);
//        data.put("Debug Admob advanced", TestAdvancedAdmobActivity.class);
//        data.put("Debug Slider Header", SliderHeader.class);
//        data.put("Debug Stagger Load More", StaggerLoadMoreActivity.class);
//        data.put("Debug Swipe List", SwipeListViewExampleActivity.class);
//        data.put("Debug expandable", TestExpandableRV.class);
//        data.put("Debug multi view types", MultiViewTypesActivity.class);



    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


        Intent intent = new Intent(this, o.get(i));
        startActivity(intent);


    }
}
