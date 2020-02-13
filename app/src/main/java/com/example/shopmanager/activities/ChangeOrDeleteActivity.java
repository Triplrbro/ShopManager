package com.example.shopmanager.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.example.shopmanager.R;
import com.example.shopmanager.adapter.BooksInfoAdapter;
import com.example.shopmanager.controller.BookInfoController;
import com.example.shopmanager.interfaces.OnItemClickListener;
import com.example.shopmanager.service.db.bean.BookInfo;

import java.util.List;

public class ChangeOrDeleteActivity extends Activity implements View.OnClickListener, AdapterView.OnItemClickListener, OnItemClickListener {

    private TextView tv_title;
    private Button bt_back;
    private String from;
    private RecyclerView rv_change_or_delete_book;
    private BookInfoController bookInfoController;
    private List<BookInfo> bookInfoList;
    private BooksInfoAdapter booksInfoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_or_delete);
        initView();
        initData();
        setOnClickListener();
    }

    private void initView() {
        tv_title = (TextView) findViewById(R.id.tv_title);
        bt_back = (Button) findViewById(R.id.bt_back);
        rv_change_or_delete_book = (RecyclerView) findViewById(R.id.rv_change_or_delete_book);
    }

    private void initData() {
        Intent intent = getIntent();
        from = intent.getStringExtra("from");
        bookInfoController = new BookInfoController();
        bookInfoList = bookInfoController.getBookInfoList();
        booksInfoAdapter = new BooksInfoAdapter(bookInfoList, this);
        if (from.equals("change")) {
            tv_title.setText("修改书籍信息");
            rv_change_or_delete_book.setAdapter(booksInfoAdapter);
        } else {
            tv_title.setText("删除书籍信息");
        }
    }

    private void setOnClickListener() {
        bt_back.setOnClickListener(this);
        booksInfoAdapter.setOnItemClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_back:
                finish();
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        if (from.equals("change")) {
            Intent changeBook = new Intent(this, ChangeBookActivity.class);
            changeBook.putExtra("bookInfo", JSON.toJSON(new BookInfo(1l, "1", "1", "1", "1", "1", "1", "1", "1", "1", "1")).toString());
            startActivity(changeBook);
        } else {
            AlertDialog.Builder builder = new AlertDialog.Builder(this, AlertDialog.THEME_HOLO_DARK);
            AlertDialog alertDialog = builder.create();
            alertDialog.setTitle("删除书籍信息");
            alertDialog.setMessage("是否删除此书籍信息？");
            alertDialog.setButton("确认", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });
            alertDialog.setButton("取消", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });
            alertDialog.show();
        }
    }

    @Override
    public void onItemClick(View view, int position) {

    }

    @Override
    public void onItemLongClick(View view) {

    }
}
