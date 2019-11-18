package com.example.shopmanager.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.shopmanager.Properties.Properties;
import com.example.shopmanager.R;
import com.example.shopmanager.activities.AddDataActivity;
import com.example.shopmanager.activities.AddShopActivity;
import com.example.shopmanager.adapter.TrendsInfoAdapter;
import com.example.shopmanager.controller.TrendsController;
import com.example.shopmanager.controller.UserController;
import com.example.shopmanager.service.db.bean.TrendsInfo;
import com.example.shopmanager.utils.ChooseImageDialogUtil;

import java.util.List;


public class MyselfFragment extends Fragment implements View.OnClickListener {

    private View fragment_myself;
    private Button bt_set;
    private LinearLayout ll_order;
    private ImageView iv_order;
    private TextView tv_order;
    private RecyclerView rv_my_bbs;
    private ImageView iv_userHead;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        fragment_myself = inflater.inflate(R.layout.fragment_myself, null);

        initView();

        initData();
        return fragment_myself;
    }

    private void initData() {

        List<TrendsInfo> trendsInfos = new TrendsController().queryTrendsInfoById(UserController.getUserId());
        TrendsInfoAdapter trendsInfoAdapter = new TrendsInfoAdapter(trendsInfos, getContext());
        LinearLayoutManager manager = new LinearLayoutManager(getActivity()) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        manager.setOrientation(LinearLayoutManager.VERTICAL);

        rv_my_bbs.setLayoutManager(manager);
        rv_my_bbs.setAdapter(trendsInfoAdapter);
    }

    private void initView() {


        bt_set = fragment_myself.findViewById(R.id.bt_set);
        ll_order = fragment_myself.findViewById(R.id.ll_order);
        iv_order = fragment_myself.findViewById(R.id.iv_order);
        tv_order = fragment_myself.findViewById(R.id.tv_order);
        rv_my_bbs = fragment_myself.findViewById(R.id.rv_my_bbs);
        iv_userHead = fragment_myself.findViewById(R.id.iv_userHead);

        iv_userHead.setOnClickListener(this);
        bt_set.setOnClickListener(this);
        iv_order.setOnClickListener(this);
        ll_order.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_set:
                Intent intent = new Intent(getContext(), AddDataActivity.class);
                startActivity(intent);
                break;
            case R.id.ll_order:
            case R.id.iv_order:
            case R.id.tv_order:
                Intent intent1 = new Intent(getContext(), AddShopActivity.class);
                startActivity(intent1);
                break;
            case R.id.iv_userHead:
                ChooseImageDialogUtil.showSelectSubmitDialog(getActivity());
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case Properties.FROM_GALLERY:
                if (resultCode == -1) {
                    Glide.with(getActivity()).load(data.getData()).into(iv_userHead);
                }
        }
    }

}

