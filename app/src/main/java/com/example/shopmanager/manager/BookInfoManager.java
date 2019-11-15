package com.example.shopmanager.manager;

import android.content.Context;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shopmanager.adapter.BooksInfoAdapter;
import com.example.shopmanager.controller.BookInfoController;
import com.example.shopmanager.service.db.bean.BookInfo;

import java.util.List;

import static android.widget.GridLayout.HORIZONTAL;
import static android.widget.GridLayout.VERTICAL;

public class BookInfoManager {

    private Context context;

    public BookInfoManager(Context context) {
        this.context = context;
    }

    public void initRecycleItem(RecyclerView rcv){

        List<BookInfo> bookInfoList = new BookInfoController().getBookInfoList();
        BooksInfoAdapter booksInfoAdapter = new BooksInfoAdapter(bookInfoList,context);
        GridLayoutManager manager = new GridLayoutManager(context, 2) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        manager.setOrientation(GridLayoutManager.VERTICAL);
        rcv.setLayoutManager(manager);
        rcv.setAdapter(booksInfoAdapter);
    }

}
