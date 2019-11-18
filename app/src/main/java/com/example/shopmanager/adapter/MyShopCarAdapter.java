package com.example.shopmanager.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.shopmanager.R;
import com.example.shopmanager.service.db.bean.ShoppingCart;

import java.util.List;

import jp.wasabeef.glide.transformations.CropSquareTransformation;

public class MyShopCarAdapter extends RecyclerView.Adapter<MyShopCarAdapter.ViewHolder> {
    private List<ShoppingCart> list;
    private Context context;




    public MyShopCarAdapter(Context context, List<ShoppingCart> list) {
        this.list = list;
        this.context = context;
    }
    @NonNull
    @Override
    public MyShopCarAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_book_index, parent, false);

        return new MyShopCarAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyShopCarAdapter.ViewHolder holder, int position) {

        System.out.println(list.get(position).getBookInfo().getBookPhoto());
        Glide.with(context).load(list.get(position).getBookInfo().getBookPhoto()).bitmapTransform(new CropSquareTransformation(context)).into(holder.im_book);
        holder.tv_book_name.setText(list.get(position).getBookInfo().getBookNmae());
        holder.tv_book_author.setText(list.get(position).getBookInfo().getAuthor());

    }

    @Override
    public int getItemCount() {
        return  list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView im_book;
        private final TextView tv_book_name;
        private final TextView tv_book_author;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            im_book = itemView.findViewById(R.id.im_book);
            tv_book_name = itemView.findViewById(R.id.tv_book_name);
            tv_book_author = itemView.findViewById(R.id.tv_book_author);
        }
    }
}
