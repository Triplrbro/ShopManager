package com.example.shopmanager.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.shopmanager.R;
import com.example.shopmanager.adapter.AdminOrderAdapter;
import com.example.shopmanager.controller.OrderSettlementController;
import com.example.shopmanager.service.db.bean.OrderSettlementInfo;
import com.example.shopmanager.views.MyListView;

import java.util.List;

public class AdminOrderActivity extends Activity {

    private TextView tv_title;
    private Button bt_back;
    private OrderSettlementController orderSettlementController;
    private List<OrderSettlementInfo> orderSettlementInfos;
    private MyListView lv_admin_order;
    private AdminOrderAdapter adminOrderAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_order);
        initView();
        initData();
        setOnClickListener();
    }

    private void initView() {
        bt_back = (Button) findViewById(R.id.bt_back);
        tv_title = (TextView) findViewById(R.id.tv_title);
        lv_admin_order = (MyListView) findViewById(R.id.lv_admin_order);
    }

    private void initData() {
        Intent intent = getIntent();
        String type = intent.getStringExtra("type");
        orderSettlementController = new OrderSettlementController();
        orderSettlementInfos = orderSettlementController.queryOrderInfoList(type);
        switch (Integer.valueOf(type)) {
            case 0:
                tv_title.setText("订单发货");
                break;
            case 1:
                tv_title.setText("未完成订单");
                break;
            case 2:
                tv_title.setText("已完成订单");
                break;
        }
        adminOrderAdapter = new AdminOrderAdapter(this, orderSettlementInfos, type);
    }

    private void setOnClickListener() {

    }
}
