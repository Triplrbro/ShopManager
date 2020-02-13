package com.example.shopmanager.manager;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shopmanager.activities.BookDetailActivity;
import com.example.shopmanager.adapter.BooksInfoAdapter;
import com.example.shopmanager.controller.BookInfoController;
import com.example.shopmanager.interfaces.OnItemClickListener;
import com.example.shopmanager.service.db.bean.BookInfo;

import java.util.List;

import static android.widget.GridLayout.HORIZONTAL;
import static android.widget.GridLayout.VERTICAL;

public class BookInfoManager implements OnItemClickListener {

    private Context context;
    private BooksInfoAdapter booksInfoAdapter;
    private List<BookInfo> bookInfoList;

    public BookInfoManager(Context context) {
        this.context = context;
    }

    public void initRecycleItem(RecyclerView rcv){

        bookInfoList = new BookInfoController().getBookInfoList();
        booksInfoAdapter = new BooksInfoAdapter(bookInfoList,context);
        LinearLayoutManager manager = new LinearLayoutManager(context) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        manager.setOrientation(GridLayoutManager.VERTICAL);
        rcv.setLayoutManager(manager);
        rcv.setAdapter(booksInfoAdapter);
        booksInfoAdapter.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(View view, int position) {
        Intent intent = new Intent(context, BookDetailActivity.class);
        Long id = bookInfoList.get(position).get_id();
        intent.putExtra("book_id", id);
        context.startActivity(intent);
    }

    @Override
    public void onItemLongClick(View view) {

    }
}
