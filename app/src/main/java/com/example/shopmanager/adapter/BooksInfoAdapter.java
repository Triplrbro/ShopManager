package com.example.shopmanager.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shopmanager.R;
import com.example.shopmanager.activities.BookDetailActivity;
import com.example.shopmanager.service.db.bean.BookInfo;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class BooksInfoAdapter extends RecyclerView.Adapter<BooksInfoAdapter.ViewHolder> {
    private List<BookInfo> list;
    private Context context;


    public BooksInfoAdapter(List<BookInfo> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_book_index, parent, false);
        return new BooksInfoAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tv_book_name.setText(list.get(position).getBookNmae());
    }

    @Override
    public int getItemCount() {
        return  list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView im_book;
        private final TextView tv_book_name;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            im_book = itemView.findViewById(R.id.im_book);
            tv_book_name = itemView.findViewById(R.id.tv_book_name);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, BookDetailActivity.class);
                    Long id = list.get(getPosition()).get_id();
                    intent.putExtra("book_id", id);
                    context.startActivity(intent);
                }
            });
        }
    }
}
