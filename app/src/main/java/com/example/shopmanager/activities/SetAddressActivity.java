package com.example.shopmanager.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.shopmanager.R;
import com.example.shopmanager.controller.UserController;
import com.example.shopmanager.service.UserService;
import com.example.shopmanager.service.db.bean.UserInfo;

public class SetAddressActivity extends Activity {

    private Button bt_back;
    private Button bt_submit;
    private EditText et_edit_name;
    private EditText et_edit_phone;
    private EditText et_edit_address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_address);
        initView();
        initData();
    }

    private void initData() {

    }

    private void initView() {
        et_edit_name = findViewById(R.id.et_edit_name);
        et_edit_phone = findViewById(R.id.et_edit_phone);
        et_edit_address = findViewById(R.id.et_edit_address);
        bt_back = findViewById(R.id.bt_back);
        bt_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        bt_submit = findViewById(R.id.bt_submit);
        bt_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserInfo userInfo = UserController.getUserInfo();
                userInfo.setAddress(et_edit_address.getText().toString().trim());
                userInfo.setUserName(et_edit_name.getText().toString().trim());
                userInfo.setPhone(et_edit_phone.getText().toString().trim());
                new UserService().insertOrChangeUser(userInfo);
            }
        });

    }
}
