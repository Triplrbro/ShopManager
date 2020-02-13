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
import com.example.shopmanager.interfaces.OnItemClickListener;
import com.example.shopmanager.service.db.bean.ShoppingCart;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import jp.wasabeef.glide.transformations.CropTransformation;

public class OrderListItemAdapter extends RecyclerView.Adapter<OrderListItemAdapter.ViewHolder> {
    private List<ShoppingCart> list;
    private Context context;
    private OnItemClickListener onItemClickListener;


    public OrderListItemAdapter(List<ShoppingCart> list, Context context) {
        this.list = list;
        this.context = context;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_book_index, parent, false);
        return new OrderListItemAdapter.ViewHolder(view,onItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tv_book_name.setText(list.get(position).getBookInfo().getBookNmae());
        holder.tv_book_author.setText(list.get(position).getBookInfo().getAuthor());
        holder.tv_book_score.setText(holder.tv_book_score.getText()+list.get(position).getBookInfo().getScore());
        Glide.with(context).load(list.get(position).getBookInfo().getBookPhoto()).bitmapTransform(new CropTransformation(context,1000,1300)).into(holder.im_book);
    }

    @Override
    public int getItemCount() {
        return  list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView im_book;
        private final TextView tv_book_name;
        private final TextView tv_book_author;
        private final TextView tv_book_score;


        public ViewHolder(@NonNull View itemView, final OnItemClickListener onItemClickListener) {
            super(itemView);

            im_book = itemView.findViewById(R.id.im_book);
            tv_book_name = itemView.findViewById(R.id.tv_book_name);
            tv_book_author = itemView.findViewById(R.id.tv_book_author);
            tv_book_score = itemView.findViewById(R.id.tv_book_score);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.onItemClick(v,getPosition());
                }
            });
        }
    }
}
