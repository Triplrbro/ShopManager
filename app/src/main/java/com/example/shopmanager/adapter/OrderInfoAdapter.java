package com.example.shopmanager.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.shopmanager.R;
import com.example.shopmanager.service.db.bean.ShoppingCart;

import java.util.List;

import jp.wasabeef.glide.transformations.CropTransformation;

public class OrderInfoAdapter extends RecyclerView.Adapter<OrderInfoAdapter.ViewHolder>{
    private List<ShoppingCart> list;
    private Context context;

    public OrderInfoAdapter(List<ShoppingCart> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public OrderInfoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_order, parent, false);
        getNumPrice();
        return new OrderInfoAdapter.ViewHolder(view);

    }
    private TextView textView;


    public TextView getNumTextView() {
        return textView;
    }

    public void setNumTextView(TextView numTextView) {
        this.textView = numTextView;
    }
    private void getNumPrice() {
        double num = 0.0;
        for (ShoppingCart shoppingCart : list) {
            double v = Double.parseDouble(shoppingCart.getBookInfo().getPrice()) * shoppingCart.getNum();
            num = num + v;
        }

        String s = String.format("%.2f",num);
        textView.setText(s);
    }
    @Override
    public void onBindViewHolder(@NonNull OrderInfoAdapter.ViewHolder holder, int position) {
        holder.tv_book_author.setText(list.get(position).getBookInfo().getAuthor());
        holder.tv_book_name.setText(list.get(position).getBookInfo().getBookNmae());
        holder.tv_book_price.setText(holder.tv_book_price.getText().toString().trim()+list.get(position).getBookInfo().getPrice());
        holder.tv_shop_num.setText(String.valueOf(list.get(position).getNum()));
        Glide.with(context).load(list.get(position).getBookInfo().getBookPhoto()).bitmapTransform(new CropTransformation(context,1000,1300)).into(holder.im_book);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView im_book;
        private final TextView tv_book_name;
        private final TextView tv_shop_num;
        private final TextView tv_book_author;
        private final TextView tv_book_price;
        private final RelativeLayout rl_book_item;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            im_book = itemView.findViewById(R.id.im_book);
            tv_book_name = itemView.findViewById(R.id.tv_book_name);
            tv_book_author = itemView.findViewById(R.id.tv_book_author);
            tv_shop_num = itemView.findViewById(R.id.tv_shop_num);
            rl_book_item = itemView.findViewById(R.id.rl_book_item);
            tv_book_price = itemView.findViewById(R.id.tv_book_price);
        }
    }
}
