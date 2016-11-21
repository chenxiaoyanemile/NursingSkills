package com.example.lenovo.hulijinengtong.activity;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.lenovo.hulijinengtong.R;
import com.example.lenovo.hulijinengtong.fragment.CheckFragment;
import com.example.lenovo.hulijinengtong.fragment.MyFragment;
import com.example.lenovo.hulijinengtong.fragment.PKFragment;
import com.example.lenovo.hulijinengtong.fragment.PracticeFragment;

public class MainPageActivity extends AppCompatActivity implements
        RadioGroup.OnCheckedChangeListener{

    private Fragment practiceFragment,checkFragment,
            pkFragment,meFragment,currentFragment;
    private RadioGroup tab_main;
    private RadioButton btn_main_practice,btn_main_check,
            btn_main_pk,btn_main_me;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        init();

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().add(R.id.fragment_main_content,practiceFragment).commit();
        currentFragment = practiceFragment;
    }
    private void init(){
        initView();
    }
    private void initView(){

        btn_main_practice=(RadioButton)findViewById(R.id.btn_main_practice);
        btn_main_check=(RadioButton)findViewById(R.id.btn_main_check);
        btn_main_pk=(RadioButton)findViewById(R.id.btn_main_pk);
        btn_main_me=(RadioButton)findViewById(R.id.btn_main_me);
        tab_main=(RadioGroup)findViewById(R.id.tab_main);
        tab_main.setOnCheckedChangeListener(this);

        practiceFragment=new PracticeFragment();
        checkFragment=new CheckFragment();
        pkFragment=new PKFragment();
        meFragment=new MyFragment();

    }
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId){
        switch (checkedId){
            case R.id.btn_main_practice:
                btn_main_practice.setChecked(true);
                btn_main_check.setChecked(false);
                btn_main_pk.setChecked(false);
                btn_main_me.setChecked(false);
                switchFragment(practiceFragment);
                break;
            case R.id.btn_main_check:
                btn_main_practice.setChecked(false);
                btn_main_check.setChecked(true);
                btn_main_pk.setChecked(false);
                btn_main_me.setChecked(false);
                switchFragment(checkFragment);
                break;
            case R.id.btn_main_pk:
                btn_main_practice.setChecked(false);
                btn_main_check.setChecked(false);
                btn_main_pk.setChecked(true);
                btn_main_me.setChecked(false);
                switchFragment(pkFragment);
                break;
            case R.id.btn_main_me:
                btn_main_practice.setChecked(false);
                btn_main_check.setChecked(false);
                btn_main_pk.setChecked(false);
                btn_main_me.setChecked(true);
                switchFragment(meFragment);
                break;
        }

    }

    private void switchFragment(Fragment fragment) {
        //判断当前显示的Fragment是不是切换的Fragment
        if(currentFragment != fragment) {
            //判断切换的Fragment是否已经添加过
            if (!fragment.isAdded()) {
                //如果没有，则先把当前的Fragment隐藏，把切换的Fragment添加上
                getSupportFragmentManager().beginTransaction().hide(currentFragment)
                        .add(R.id.fragment_main_content,fragment).commit();
            } else {
                //如果已经添加过，则先把当前的Fragment隐藏，把切换的Fragment显示出来
                getSupportFragmentManager().beginTransaction().hide(currentFragment).show(fragment).commit();
            }
            currentFragment = fragment;
        }
    }
}
