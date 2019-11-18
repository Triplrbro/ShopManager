package com.example.shopmanager.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.shopmanager.R;
import com.example.shopmanager.controller.ShoppingCarController;
import com.example.shopmanager.service.db.bean.ShoppingCart;

import java.util.List;

import jp.wasabeef.glide.transformations.CropSquareTransformation;

public class MyShopCarAdapter extends RecyclerView.Adapter<MyShopCarAdapter.ViewHolder> {
    private List<ShoppingCart> list;
    private Context context;
    private TextView textView;


    public TextView getTextView() {
        return textView;
    }

    public void setTextView(TextView textView) {
        this.textView = textView;
    }

    public MyShopCarAdapter(Context context, List<ShoppingCart> list) {
        this.list = list;
        this.context = context;
    }
    @NonNull
    @Override
    public MyShopCarAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_shopcart, parent, false);

        return new MyShopCarAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyShopCarAdapter.ViewHolder holder, final int position) {

        System.out.println(list.get(position).getBookInfo().getBookPhoto());
        Glide.with(context).load(list.get(position).getBookInfo().getBookPhoto()).bitmapTransform(new CropSquareTransformation(context)).into(holder.im_book);
        holder.tv_book_name.setText(list.get(position).getBookInfo().getBookNmae());
        holder.tv_shop_num.setText(String.valueOf(list.get(position).getNum()));
        holder.tv_book_author.setText(list.get(position).getBookInfo().getAuthor());
        holder.ll_add_shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = new ShoppingCarController().addShop(list.get(position).get_id());
                holder.tv_shop_num.setText(String.valueOf(i));
            }
        });
        holder.ll_del_shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = new ShoppingCarController().cutShop(list.get(position).get_id());
                holder.tv_shop_num.setText(String.valueOf(i));
            }
        });
    }

    @Override
    public int getItemCount() {
        return  list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView im_book;
        private final TextView tv_book_name;
        private final TextView tv_shop_num;
        private final TextView tv_book_author;
        private final Button ll_del_shop;
        private final Button ll_add_shop;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            im_book = itemView.findViewById(R.id.im_book);
            tv_book_name = itemView.findViewById(R.id.tv_book_name);
            tv_book_author = itemView.findViewById(R.id.tv_book_author);
            ll_del_shop = itemView.findViewById(R.id.ll_del_shop);
            ll_add_shop = itemView.findViewById(R.id.ll_add_shop);
            tv_shop_num = itemView.findViewById(R.id.tv_shop_num);

        }
    }
}
