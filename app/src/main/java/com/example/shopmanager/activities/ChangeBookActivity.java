package com.example.shopmanager.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.alibaba.fastjson.JSON;
import com.example.shopmanager.R;
import com.example.shopmanager.controller.BookInfoController;
import com.example.shopmanager.service.db.bean.BookInfo;

public class ChangeBookActivity extends Activity {

    private BookInfoController bookInfoController;
    private BookInfo bookInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chang_book);
        initView();
        initData();
        setOnClickListener();
    }

    private void initView() {

    }

    private void initData() {
        bookInfoController = new BookInfoController();
        Intent intent = getIntent();
        bookInfo = JSON.parseObject(intent.getStringExtra("bookInfo"), BookInfo.class);
    }

    private void setOnClickListener() {

    }
}
