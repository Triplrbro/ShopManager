package com.example.shopmanager.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.example.shopmanager.R;

public class ChangeBookActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chang_book);
        Intent intent = getIntent();
        String bookInfo = intent.getStringExtra("bookInfo");
    }
}
