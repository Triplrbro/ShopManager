package com.example.shopmanager.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.shopmanager.R;
import com.example.shopmanager.controller.BookInfoController;
import com.example.shopmanager.service.BookInfoService;
import com.example.shopmanager.service.db.bean.BookInfo;

import java.util.List;

public class AddDataActivity extends Activity implements View.OnClickListener {
    private Button bt_add_data_book;
    private Button bt_remove_data_book;
    private Button bt_add_img;
    private BookInfoController bookInfoController;
    private TextView tv_show_data_book;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_resource);

        bookInfoController = new BookInfoController();

        initView();
    }

    private void initView() {
        bt_add_data_book = findViewById(R.id.bt_add_data_book);
        bt_remove_data_book = findViewById(R.id.bt_remove_data_book);
        bt_add_img = findViewById(R.id.bt_add_img);
        tv_show_data_book = (TextView) findViewById(R.id.tv_show_data_book);

        bt_add_data_book.setOnClickListener(this);
        bt_remove_data_book.setOnClickListener(this);
        bt_add_img.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.bt_add_data_book:
                testInsert();
                break;
            case R.id.bt_remove_data_book:
                List<BookInfo> query = query();
                for(BookInfo bookInfo : query){
                    tv_show_data_book.setText(tv_show_data_book.getText()+" \n  "+bookInfo.toString());
                }
                break;
        }
    }



    private void testInsert(){
        BookInfo bookInfo = new BookInfo(null, "xxxx", "新华字典", "200", "400", "中国人民", "北京邮电", "精装", "4.5", "这是简介啊~~~~~~", "hrrp://location");
        BookInfoService bookInfoService = new BookInfoService();
        bookInfoService.setBookInfo(bookInfo);
    }

    private List<BookInfo> query(){
        BookInfoService bookInfoService = new BookInfoService();
        List<BookInfo> bookInfos = bookInfoService.queryBookInfoList();
        return bookInfos;
    }

}
