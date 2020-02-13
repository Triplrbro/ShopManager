package com.example.shopmanager.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shopmanager.R;
import com.example.shopmanager.interfaces.OnItemClickListener;
import com.example.shopmanager.service.db.bean.OrderSettlementInfo;
import com.example.shopmanager.service.db.bean.ShoppingCart;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class OrderListAdapter extends RecyclerView.Adapter<OrderListAdapter.ViewHolder> {
    private List<OrderSettlementInfo> list;
    private Context context;
    private OnItemClickListener onItemClickListener;


    public OrderListAdapter(List<OrderSettlementInfo> list, Context context) {
        this.list = list;
        this.context = context;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_order_list, parent, false);

        return new OrderListAdapter.ViewHolder(view,onItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        List<ShoppingCart> shoppingCartList = list.get(position).getShoppingCartList();
        OrderListItemAdapter booksInfoAdapter = new OrderListItemAdapter(shoppingCartList,context);
        LinearLayoutManager manager = new LinearLayoutManager(context) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        manager.setOrientation(LinearLayoutManager.VERTICAL);

        holder.rv_shopcart.setLayoutManager(manager);
        holder.rv_shopcart.setAdapter(booksInfoAdapter);
    }

    @Override
    public int getItemCount() {
        return  list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView tv_order_date;
        private final RecyclerView rv_shopcart;

        public ViewHolder(@NonNull View itemView, final OnItemClickListener onItemClickListener) {
            super(itemView);

            tv_order_date = itemView.findViewById(R.id.tv_order_date);
            rv_shopcart = itemView.findViewById(R.id.rv_shopcart);
        }
    }
}
