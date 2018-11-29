package com.lt.unitreetest.ui.homepage.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.lt.unitreetest.common.BaseFragment;

import java.util.List;




/**
 * Created by zhaowenlong on 2018/7/10.
 */
public class ViewPageAdapter extends FragmentPagerAdapter {
    private List<BaseFragment> fragments;
    private FragmentManager fragmentManager;

    public ViewPageAdapter(FragmentManager fm, List<BaseFragment> fragmentList) {
        super(fm);
        this.fragments = fragmentList;
        this.fragmentManager = fm;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    //No sliding

}

