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

public class RegisterActivity extends Activity {

    private EditText et_password;
    private EditText et_userNumber;
    private Button bt_register;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_register);
        initView();
    }

    private void initView() {
        et_password = findViewById(R.id.et_password);
        et_userNumber = findViewById(R.id.et_userNumber);
        bt_register = findViewById(R.id.bt_register);
        final UserController userController = new UserController();
        bt_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (userController.checkUserAccess(et_userNumber.getText().toString().trim(),et_userNumber.getText().toString().trim())){
                    Toast.makeText(RegisterActivity.this, "已存在用户，自动登录", Toast.LENGTH_SHORT).show();
                }
                if (!et_userNumber.getText().toString().trim().isEmpty()&&!et_userNumber.getText().toString().trim().isEmpty()){
                    userController.setUserNameAndPassWord(et_userNumber.getText().toString().trim(),et_userNumber.getText().toString().trim());
                    Toast.makeText(RegisterActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                    userController.checkUserAccess(et_userNumber.getText().toString().trim(),et_userNumber.getText().toString().trim());
                    Intent intent = new Intent(RegisterActivity.this,MainActivity.class);
                    startActivity(intent);
                }if (et_userNumber.getText().toString().trim().isEmpty()){
                    Toast.makeText(RegisterActivity.this, "用户名为空", Toast.LENGTH_SHORT).show();
                }if (et_password.getText().toString().trim().isEmpty()){
                    Toast.makeText(RegisterActivity.this, "密码为空", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
