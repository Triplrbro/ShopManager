package com.example.shopmanager.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shopmanager.R;
import com.example.shopmanager.adapter.OrderInfoAdapter;
import com.example.shopmanager.controller.OrderSettlementController;
import com.example.shopmanager.controller.ShoppingCarController;
import com.example.shopmanager.controller.UserController;
import com.example.shopmanager.service.db.bean.OrderSettlementInfo;
import com.example.shopmanager.service.db.bean.ShoppingCart;
import com.example.shopmanager.service.db.bean.UserInfo;

import java.util.List;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class OrderActivity extends Activity implements View.OnClickListener {

    private LinearLayout ll_change_address;
    private TextView tv_person_name;
    private Button bt_add_shopcar;
    private TextView tv_person_address;
    private TextView tv_person_phone;
    private TextView tv_num_price;
    private RecyclerView rcv_orderList;
    private List<ShoppingCart> shoppingCarts;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);
        initView();
        initData();
    }

    @Override
    protected void onResume() {
        super.onResume();
        initData();
    }

    private void initData() {
        bt_add_shopcar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrderActivity.this,BillActivity.class);
                makeOrder();
                startActivity(intent);
            }
        });
        ll_change_address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrderActivity.this,SetAddressActivity.class);
                startActivity(intent);
            }
        });
        UserInfo userInfo = UserController.getUserInfo();
        if (userInfo.getAddress()==null||userInfo.getPhone()==null||userInfo.getUserName()==null||userInfo.getAddress().isEmpty()||userInfo.getUserName().isEmpty()||userInfo.getPhone().isEmpty()){
            new SweetAlertDialog(this,
                    SweetAlertDialog.CUSTOM_IMAGE_TYPE)
                    .setTitleText("提示")
                    .setContentText("您仍未填写收货人地址")
                    .setCancelText("好的")
                    .setConfirmText("去填写")
                    .showCancelButton(true)
                    .setConfirmClickListener(
                            new SweetAlertDialog.OnSweetClickListener() {
                                @Override
                                public void onClick(SweetAlertDialog sDialog) {
                                    startActivity(new Intent(OrderActivity.this,
                                            SetAddressActivity.class));
                                }
                            })
                    .show();
        }else {
            tv_person_name.setText(tv_person_name.getText().toString()+userInfo.getUserName());
            tv_person_address.setText(tv_person_address.getText().toString()+userInfo.getAddress());
            tv_person_phone.setText(tv_person_phone.getText().toString()+userInfo.getPhone());
        }


        ShoppingCarController shoppingCarController = new ShoppingCarController();
        shoppingCarts = shoppingCarController.queryUserCarList(UserController.getUserId());

        OrderInfoAdapter orderInfoAdapter = new OrderInfoAdapter(shoppingCarts,this);
        orderInfoAdapter.setNumTextView(tv_num_price);
        LinearLayoutManager manager = new LinearLayoutManager(this) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        manager.setOrientation(LinearLayoutManager.VERTICAL);

        rcv_orderList.setLayoutManager(manager);
        rcv_orderList.setAdapter(orderInfoAdapter);
    }


    private void makeOrder(){
        OrderSettlementInfo orderSettlementInfo = new OrderSettlementInfo();
        orderSettlementInfo.resetShoppingCartList();
        orderSettlementInfo.setUserId(UserController.getUserId());
        orderSettlementInfo.setAddress(UserController.getUserInfo().getAddress());
        orderSettlementInfo.setAllPrice(tv_num_price.getText().toString());
        orderSettlementInfo.setName(UserController.getUserInfo().getUserName());
        orderSettlementInfo.setPhone(UserController.getUserInfo().getPhone());
        System.out.println(orderSettlementInfo.toString());
        new OrderSettlementController().makeOrder(orderSettlementInfo,UserController.getUserId());
    }

    private void initView() {
        ll_change_address = findViewById(R.id.ll_change_address);
        bt_add_shopcar = findViewById(R.id.bt_add_shopcar);
        tv_person_name = (TextView) findViewById(R.id.tv_person_name);
        tv_person_address = (TextView) findViewById(R.id.tv_person_address);
        tv_person_phone = (TextView) findViewById(R.id.tv_person_phone);
        tv_num_price = (TextView) findViewById(R.id.tv_num_price);
        rcv_orderList = findViewById(R.id.rcv_orderList);
    }

    @Override
    public void onClick(View v) {

    }
}
