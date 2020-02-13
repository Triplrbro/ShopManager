package com.example.shopmanager.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shopmanager.R;
import com.example.shopmanager.activities.SendBBSActivity;
import com.example.shopmanager.adapter.TrendsInfoAdapter;
import com.example.shopmanager.controller.TrendsController;
import com.example.shopmanager.service.db.bean.TrendsInfo;

import org.jetbrains.annotations.Nullable;

import java.util.List;

public class BBSFragment extends Fragment {

    private View fragment_brand;
    private Button bt_send;
    private List<TrendsInfo> trendsInfos;
    private RecyclerView rv_bbs;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        fragment_brand = inflater.inflate(R.layout.fragment_bbs, null);
        trendsInfos = new TrendsController().queryAllTrendsInfo();

        initView();
        //TODO:RecyclerView布局渲染方法
        initData();


        return fragment_brand;
    }

    @Override
    public void onResume() {
        initData();
        super.onResume();
    }

    private void initData() {
        List<TrendsInfo> trendsInfos = new TrendsController().queryAllTrendsInfo();
        TrendsInfoAdapter trendsInfoAdapter = new TrendsInfoAdapter(trendsInfos,getActivity());
        LinearLayoutManager manager = new LinearLayoutManager(getActivity()) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        manager.setOrientation(LinearLayoutManager.VERTICAL);

        rv_bbs.setLayoutManager(manager);
        rv_bbs.setAdapter(trendsInfoAdapter);
    }

    private void initView() {
        bt_send = fragment_brand.findViewById(R.id.bt_send);
        bt_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), SendBBSActivity.class);
                startActivity(intent);
            }
        });
        System.out.println("======"+trendsInfos);
        rv_bbs = fragment_brand.findViewById(R.id.rv_bbs);
    }
}
