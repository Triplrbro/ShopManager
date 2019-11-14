package com.example.shopmanager.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

import com.example.shopmanager.R;
import com.example.shopmanager.controller.UserController;
import com.example.shopmanager.service.BaseService;
import com.example.shopmanager.utils.SharedPreferencesUtil;

public class StartActivity extends Activity {

    private Button bt_login;
    private Button bt_register;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_login);
        initDB();
        UserController userController = new UserController();
        // 如果有本地缓存，直接登录
        if (userController.autoCheckUserAccess()) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }

        bt_login = findViewById(R.id.bt_login);
        bt_register = findViewById(R.id.bt_register);
        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        bt_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initDB() {
        BaseService.DBInit(this);
        SharedPreferencesUtil.init(this);
    }
}
