package com.example.lenovo.hulijinengtong.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.example.lenovo.hulijinengtong.R;
import com.example.lenovo.hulijinengtong.adapter.MyFragmentPagerAdapter;
import com.example.lenovo.hulijinengtong.fragment.PracticeHighFragment;
import com.example.lenovo.hulijinengtong.fragment.PracticeMiddleFragment;
import com.example.lenovo.hulijinengtong.fragment.PracticePrimaryFragment;

import java.util.ArrayList;
import java.util.List;

public class PracticeActivity extends FragmentActivity implements AdapterView.OnItemClickListener{

    List<Fragment> fragmentList;
    //标题栏以及其中的数据
    private PagerTabStrip tab;
    List<String> titlelist;

    private ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice);

        pager=(ViewPager)findViewById(R.id.pager);
        tab=(PagerTabStrip)findViewById(R.id.tab);

        fragmentList=new ArrayList<Fragment>();
        fragmentList.add(new PracticePrimaryFragment());
        fragmentList.add(new PracticeMiddleFragment());
        fragmentList.add(new PracticeHighFragment());
        //为页卡设置标题
        titlelist=new ArrayList<String>();
        titlelist.add("初级场");
        titlelist.add("中级场");
        titlelist.add("高级场");

        MyFragmentPagerAdapter pagerAdapter=new MyFragmentPagerAdapter(getSupportFragmentManager(),fragmentList,titlelist);
        pager.setAdapter(pagerAdapter);

    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
