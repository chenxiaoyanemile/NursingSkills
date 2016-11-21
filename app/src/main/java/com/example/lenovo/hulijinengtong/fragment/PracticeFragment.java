package com.example.lenovo.hulijinengtong.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;

import com.example.lenovo.hulijinengtong.R;
import com.example.lenovo.hulijinengtong.activity.PracticeActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;



public class PracticeFragment extends Fragment implements
        AdapterView.OnItemClickListener {

    private String IMAGE_ITEM = "imgage_item";
    private String TEXT_ITEM = "text_item";
    private ImageView image_view_practice;

    private int[] arrImags = new int[] { R.mipmap.sterile_ic, R.mipmap.sterile_ic,
            R.mipmap.sterile_ic, R.mipmap.sterile_ic, R.mipmap.sterile_ic, R.mipmap.sterile_ic,
            R.mipmap.sterile_ic, R.mipmap.sterile_ic, R.mipmap.sterile_ic, R.mipmap.sterile_ic };

    private String[] arrText = new String[]{
            "无菌操作是一门基础", "无菌操作是一门基础", "无菌操作是一门基础",
            "无菌操作是一门基础", "无菌操作是一门基础", "无菌操作是一门基础",
            "无菌操作是一门基础", "无菌操作是一门基础", "无菌操作是一门基础"
    };
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_practice, container, false);
        init(v);
        return v;
    }
    private void init(View v) {
        initView(v);
        initData();
    }
    private void initView(View v){
        GridView mGridView=(GridView)v.findViewById(R.id.gridview);
        image_view_practice=(ImageView)v.findViewById(R.id.image_view_practice);
        SimpleAdapter saImageItems = new SimpleAdapter(getActivity(),
                getGridViewData(),
                R.layout.item_scene,
                new String[] { IMAGE_ITEM, TEXT_ITEM },
                new int[] { R.id.ItemImage, R.id.ItemText });
        // 设置GridView的adapter。GridView继承于AbsListView。
        mGridView.setAdapter(saImageItems);
        mGridView.setOnItemClickListener(this);

    }
    /**
     * 获取GridView的数据
     */
    private List<HashMap<String, Object>> getGridViewData() {
        List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();

        for (int i=0; i<9; i++) {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put(IMAGE_ITEM, arrImags[i]);
            map.put(TEXT_ITEM, arrText[i]);
            list.add(map);
        }

        return list;
    }

    @Override
    public void onItemClick(AdapterView<?> adapter, View view, int position, long rowid) {

        // 根据元素位置获取对应的值
        HashMap<String, Object> item = (HashMap<String, Object>) adapter.getItemAtPosition(position);
        String itemText=(String)item.get(TEXT_ITEM);
        Object object=item.get(IMAGE_ITEM);
        Intent intent=new Intent(getActivity(), PracticeActivity.class);
        PracticeFragment.this.startActivity(intent);
    }
    private void initData(){

    }

}
