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
        holder.tv_order_date.setText(list.get(position).getCreateData());
        holder.tv_person_address.setText(list.get(position).getAddress());
        holder.tv_person_name.setText(list.get(position).getName());
        holder.tv_person_phone.setText(list.get(position).getPhone());
        holder.tv_order_number.setText(holder.tv_order_number.getText().toString().trim()+list.get(position).get_id());
        List<ShoppingCart> shoppingCartList = list.get(position).getShoppingCartList();
        System.out.println("========shoppingCartList=========="+shoppingCartList);
        OrderListItemAdapter booksInfoAdapter = new OrderListItemAdapter(shoppingCartList,context);
        LinearLayoutManager manager = new LinearLayoutManager(context) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        booksInfoAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

            }

            @Override
            public void onItemLongClick(View view) {

            }
        });
        holder.rv_shopcart.setLayoutManager(manager);
        holder.rv_shopcart.setAdapter(booksInfoAdapter);
    }

    @Override
    public int getItemCount() {
        return  list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView tv_order_date;
        private final TextView tv_order_number;
        private final TextView tv_person_name;
        private final TextView tv_person_address;
        private final TextView tv_person_phone;
        private final RecyclerView rv_shopcart;

        public ViewHolder(@NonNull View itemView, final OnItemClickListener onItemClickListener) {
            super(itemView);

            tv_order_number = itemView.findViewById(R.id.tv_order_number);
            tv_order_date = itemView.findViewById(R.id.tv_order_date);
            tv_person_address = itemView.findViewById(R.id.tv_person_address);
            tv_person_phone = itemView.findViewById(R.id.tv_person_phone);
            tv_person_name = itemView.findViewById(R.id.tv_person_name);
            rv_shopcart = itemView.findViewById(R.id.rv_shopcart);
        }
    }
}
