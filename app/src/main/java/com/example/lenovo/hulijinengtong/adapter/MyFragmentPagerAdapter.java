package com.example.lenovo.hulijinengtong.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;


public class MyFragmentPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment>fragments;
    private List<String>titleList;
    public MyFragmentPagerAdapter(FragmentManager fm, List<Fragment>fragments, List<String>titleList) {
        super(fm);
        this.fragments=fragments;
        this.titleList=titleList;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    //获取标题信息

    @Override
    public CharSequence getPageTitle(int position) {
        return titleList.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
