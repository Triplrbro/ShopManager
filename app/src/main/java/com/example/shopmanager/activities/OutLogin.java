package com.example.shopmanager.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

import com.example.shopmanager.R;
import com.example.shopmanager.controller.UserController;

public class OutLogin extends Activity {


    private Button bt_back;
    private Button bt_out_login;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_out_login);
        bt_back = findViewById(R.id.bt_back);
        bt_out_login= findViewById(R.id.bt_out_login);

        bt_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        bt_out_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserController userController = new UserController();
                userController.clearUserId();
                Intent intent = new Intent(OutLogin.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
