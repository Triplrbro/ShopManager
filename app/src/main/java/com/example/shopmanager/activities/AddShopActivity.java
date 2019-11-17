package com.example.shopmanager.activities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.shopmanager.R;

public class AddShopActivity extends Activity {

    private TextView et_add_book_code;
    private TextView et_add_book_bookName;
    private TextView et_add_book_price;
    private TextView et_add_book_oldPrice;
    private TextView et_add_book_author;
    private TextView et_add_book_press;
    private TextView et_add_book_code;
    private TextView et_add_book_code;
    private TextView et_add_book_code;
    private TextView et_add_book_code;
    private TextView et_add_book_code;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_shop);

        initView();
    }

    private void initView() {
        et_add_book_code = (TextView) findViewById(R.id.et_add_book_code);
        et_add_book_bookName = (TextView) findViewById(R.id.et_add_book_bookName);
        et_add_book_price = (TextView) findViewById(R.id.et_add_book_price);
        et_add_book_oldPrice = (TextView) findViewById(R.id.et_add_book_oldPrice);
        et_add_book_author = (TextView) findViewById(R.id.et_add_book_author);
        et_add_book_press = (TextView) findViewById(R.id.et_add_book_press);
        et_add_book_code = (TextView) findViewById(R.id.et_add_book_code);
        et_add_book_code = (TextView) findViewById(R.id.et_add_book_code);
        et_add_book_code = (TextView) findViewById(R.id.et_add_book_code);
        et_add_book_code = (TextView) findViewById(R.id.et_add_book_code);
        et_add_book_code = (TextView) findViewById(R.id.et_add_book_code);
    }
}
