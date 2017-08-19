package com.tianxi.vpsixteenanimation;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by 甘罗 on 17/6/23.
 */

public class VpAdapter extends FragmentPagerAdapter{
    List<Fragment>list;

    public VpAdapter(FragmentManager fm, List<Fragment>list) {
        super(fm);
        this.list=list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }


}
