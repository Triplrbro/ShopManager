package com.example.shopmanager.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
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

public class ChangeOrDeleteActivity extends Activity implements View.OnClickListener, OnItemClickListener {

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
        LinearLayoutManager layout = new LinearLayoutManager(this);
        layout.setOrientation(GridLayoutManager.VERTICAL);
        rv_change_or_delete_book.setLayoutManager(layout);
    }

    private void initData() {
        Intent intent = getIntent();
        from = intent.getStringExtra("from");
        bookInfoController = new BookInfoController();
        bookInfoList = bookInfoController.getBookInfoList();
        booksInfoAdapter = new BooksInfoAdapter(bookInfoList, this);
        if (from.equals("change")) {
            tv_title.setText("修改书籍信息");
        } else {
            tv_title.setText("删除书籍信息");
        }
        rv_change_or_delete_book.setAdapter(booksInfoAdapter);
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
    public void onItemClick(View view, final int position) {
        if (from.equals("change")) {
            Intent changeBook = new Intent(this, ChangeBookActivity.class);
            changeBook.putExtra("bookInfo", JSON.toJSON(bookInfoList.get(position)).toString());
            startActivity(changeBook);
        } else {
            AlertDialog.Builder builder = new AlertDialog.Builder(this, AlertDialog.THEME_HOLO_DARK);
            builder.setTitle("删除书籍信息");
            builder.setMessage("是否删除此书籍信息？");
            builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    BookInfo bookInfo = bookInfoList.get(position);
                    bookInfo.setDeleSign("1");
                    bookInfoController.setBookInfo(bookInfo);
                    bookInfoList.remove(position);
                    booksInfoAdapter.setList(bookInfoList);
                }
            });
            builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        }
    }

    @Override
    public void onItemLongClick(View view) {

    }
}
