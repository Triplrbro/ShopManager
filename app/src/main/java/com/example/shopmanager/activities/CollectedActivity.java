package com.example.shopmanager.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shopmanager.R;
import com.example.shopmanager.adapter.CollectedInfoAdapter;
import com.example.shopmanager.controller.CollectController;
import com.example.shopmanager.controller.UserController;
import com.example.shopmanager.interfaces.OnItemClickListener;
import com.example.shopmanager.service.db.bean.CollectInfo;

import java.util.List;

public class CollectedActivity extends Activity {

    private Button bt_back;
    private RecyclerView rv_shopcart;
    private List<CollectInfo> collectInfos;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collected);


        initView();
        initData();
    }

    private void initData() {
        collectInfos = new CollectController().queryCollectInfoListByUserId(UserController.getUserId());
        CollectedInfoAdapter booksInfoAdapter = new CollectedInfoAdapter(collectInfos,this);
        LinearLayoutManager manager = new LinearLayoutManager(this) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        manager.setOrientation(LinearLayoutManager.VERTICAL);

        rv_shopcart.setLayoutManager(manager);
        booksInfoAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(CollectedActivity.this, BookDetailActivity.class);
                Long id = collectInfos.get(position).getBookId();
                intent.putExtra("book_id", id);
                startActivity(intent);
                finish();
            }

            @Override
            public void onItemLongClick(View view) {

            }
        });
        rv_shopcart.setAdapter(booksInfoAdapter);
    }

    private void initView() {

        bt_back = findViewById(R.id.bt_back);
        rv_shopcart = findViewById(R.id.rv_shopcart);
        bt_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}
