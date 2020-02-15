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
import com.example.shopmanager.controller.OrderSettlementController;
import com.example.shopmanager.controller.UserController;
import com.example.shopmanager.interfaces.OnItemClickListener;
import com.example.shopmanager.service.db.bean.OrderSettlementInfo;
import com.example.shopmanager.service.db.bean.ShoppingCart;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class OrderListAdapter extends RecyclerView.Adapter<OrderListAdapter.ViewHolder> {
    private List<OrderSettlementInfo> list;
    private Context context;
    private OnItemClickListener onItemClickListener;
    private OrderSettlementController orderSettlementController;


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
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        String state = list.get(position).getState();
        switch (Integer.valueOf(state)){
            case 0:
                holder.tv_order_send.setVisibility(View.VISIBLE);
                holder.tv_order_not_over.setVisibility(View.GONE);
                holder.tv_order_over.setVisibility(View.GONE);
                break;
            case 1:
                holder.tv_order_send.setVisibility(View.GONE);
                holder.tv_order_not_over.setVisibility(View.VISIBLE);
                holder.tv_order_over.setVisibility(View.GONE);
                break;
            case 2:
                holder.tv_order_send.setVisibility(View.GONE);
                holder.tv_order_not_over.setVisibility(View.GONE);
                holder.tv_order_over.setVisibility(View.VISIBLE);
                break;
        }
        holder.tv_order_date.setText(list.get(position).getCreateData());
        holder.tv_person_address.setText(list.get(position).getAddress());
        holder.tv_person_name.setText(list.get(position).getName());
        holder.tv_person_phone.setText(list.get(position).getPhone());
        holder.tv_order_number.setText("订单编号"+list.get(position).get_id());
        holder.tv_order_not_over.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                orderSettlementController = new OrderSettlementController();
                orderSettlementController.updateOrder(list.get(position),OrderSettlementController.FINISH_ODER);
                List<OrderSettlementInfo> orderSettlementInfos = new OrderSettlementController().queryOrderList(UserController.getUserId());
                list = orderSettlementInfos;
                    notifyDataSetChanged();
            }
        });
        List<ShoppingCart> shoppingCartList = list.get(position).getShoppingCartList();
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
        private final TextView tv_order_send;
        private final TextView tv_order_over;
        private final TextView tv_order_not_over;



        public ViewHolder(@NonNull View itemView, final OnItemClickListener onItemClickListener) {
            super(itemView);

            tv_order_send = itemView.findViewById(R.id.tv_order_send);
            tv_order_over = itemView.findViewById(R.id.tv_order_over);
            tv_order_not_over = itemView.findViewById(R.id.tv_order_not_over);
            tv_order_number = itemView.findViewById(R.id.tv_order_number);
            tv_order_date = itemView.findViewById(R.id.tv_order_date);
            tv_person_address = itemView.findViewById(R.id.tv_person_address);
            tv_person_phone = itemView.findViewById(R.id.tv_person_phone);
            tv_person_name = itemView.findViewById(R.id.tv_person_name);
            rv_shopcart = itemView.findViewById(R.id.rv_shopcart);
        }
    }
}
