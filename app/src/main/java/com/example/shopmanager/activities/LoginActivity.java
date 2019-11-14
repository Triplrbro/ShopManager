package com.example.shopmanager.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.shopmanager.R;
import com.example.shopmanager.controller.UserController;

public class LoginActivity extends Activity {

    private EditText et_password;
    private EditText et_userNumber;
    private Button bt_login;
    private UserController userController;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        userController = new UserController();
        setContentView(R.layout.activity_login);
        initView();
    }

    private void initView() {
        et_password = findViewById(R.id.et_password);
        et_userNumber = findViewById(R.id.et_userNumber);
        bt_login = findViewById(R.id.bt_login);
        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!et_userNumber.getText().toString().trim().isEmpty() && !et_userNumber.getText().toString().trim().isEmpty()) {
                    if (userController.checkUserAccess(et_userNumber.getText().toString().trim(), et_userNumber.getText().toString().trim())) {
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);

                    } else {
                        Toast.makeText(LoginActivity.this, "用户名或密码错误", Toast.LENGTH_SHORT).show();

                    }
                }
                if (et_userNumber.getText().toString().trim().isEmpty()) {
                    Toast.makeText(LoginActivity.this, "用户名为空", Toast.LENGTH_SHORT).show();
                }
                if (et_password.getText().toString().trim().isEmpty()) {
                    Toast.makeText(LoginActivity.this, "密码为空", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
