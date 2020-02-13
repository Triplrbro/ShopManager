package com.example.shopmanager.activities;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shopmanager.R;
import com.example.shopmanager.adapter.OrderListAdapter;
import com.example.shopmanager.controller.OrderSettlementController;
import com.example.shopmanager.controller.UserController;
import com.example.shopmanager.service.db.bean.OrderSettlementInfo;

import java.util.List;

public class OrderListActivity extends Activity {

    private RecyclerView rv_shopcart;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_list);

        initView();
        initData();

    }

    private void initData() {

        List<OrderSettlementInfo> orderSettlementInfos = new OrderSettlementController().queryOrderList(UserController.getUserId());
        System.out.println(orderSettlementInfos.toString());
        OrderListAdapter orderListAdapter = new OrderListAdapter(orderSettlementInfos,this);
        LinearLayoutManager manager = new LinearLayoutManager(this) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        manager.setOrientation(LinearLayoutManager.VERTICAL);

        rv_shopcart.setLayoutManager(manager);
        rv_shopcart.setAdapter(orderListAdapter);
    }

    private void initView() {
        rv_shopcart = findViewById(R.id.rv_shopcart);
    }
}
