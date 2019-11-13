package com.example.shopmanager.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shopmanager.R;

public class ShopCarActivity extends Activity {

    private RecyclerView rv_shop_will_buy;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopcar);


        rv_shop_will_buy = findViewById(R.id.rv_shop_will_buy);

    }
}
