package com.example.shopmanager.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.shopmanager.R;
import com.example.shopmanager.controller.UserController;
import com.example.shopmanager.service.db.bean.UserInfo;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class OrderActivity extends Activity implements View.OnClickListener {

    private LinearLayout ll_change_address;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);
        initView();
        initData();
    }

    private void initData() {
        UserInfo userInfo = UserController.getUserInfo();
        if (userInfo.getAddress()==null||userInfo.getPhone()==null||userInfo.getUserName()==null){
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
        }
    }

    private void initView() {
        ll_change_address = findViewById(R.id.ll_change_address);
    }

    @Override
    public void onClick(View v) {

    }
}
