package com.example.shopmanager.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.shopmanager.R;
import com.example.shopmanager.controller.OrderSettlementController;
import com.example.shopmanager.service.db.bean.OrderSettlementInfo;
import com.example.shopmanager.views.MyListView;

import java.util.List;

/**
 * @author Domineer
 * @data 2019/12/15,18:03
 * ----------为梦想启航---------
 * --Set Sell For Your Dream--
 */
public class AdminOrderAdapter extends BaseAdapter {

    private Context context;
    private List<OrderSettlementInfo> orderInfoList;
    private String type;

    public AdminOrderAdapter(Context context, List<OrderSettlementInfo> orderInfoList, String type) {
        this.context = context;
        this.orderInfoList = orderInfoList;
        this.type = type;
    }

    public List<OrderSettlementInfo> getOrderInfoList() {
        return orderInfoList;
    }

    public void setOrderInfoList(List<OrderSettlementInfo> orderInfoList) {
        this.orderInfoList = orderInfoList;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return orderInfoList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = View.inflate(context, R.layout.item_admin_order, null);
            viewHolder.tv_order_id = convertView.findViewById(R.id.tv_order_id);
            viewHolder.tv_name = convertView.findViewById(R.id.tv_name);
            viewHolder.tv_mobile = convertView.findViewById(R.id.tv_mobile);
            viewHolder.tv_location = convertView.findViewById(R.id.tv_location);
            viewHolder.lv_order_goods_info = convertView.findViewById(R.id.lv_order_goods_info);
            viewHolder.tv_order_send = convertView.findViewById(R.id.tv_order_send);
            viewHolder.tv_order_not_over = convertView.findViewById(R.id.tv_order_not_over);
            viewHolder.tv_order_over = convertView.findViewById(R.id.tv_order_over);
            viewHolder.tv_price_all = convertView.findViewById(R.id.tv_price_all);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.tv_order_id.setText(String.valueOf(orderInfoList.get(position).get_id()));
        viewHolder.tv_name.setText(orderInfoList.get(position).getName());
        viewHolder.tv_mobile.setText(orderInfoList.get(position).getPhone());
        viewHolder.tv_location.setText(orderInfoList.get(position).getAddress());
        OrderGoodsInfoAdapter orderGoodsInfoAdapter = new OrderGoodsInfoAdapter(context, orderInfoList.get(position).getShoppingCartList());
        viewHolder.lv_order_goods_info.setAdapter(orderGoodsInfoAdapter);
        switch (Integer.valueOf(type)){
            case 0:
                viewHolder.tv_order_send.setVisibility(View.VISIBLE);
                viewHolder.tv_order_not_over.setVisibility(View.GONE);
                viewHolder.tv_order_over.setVisibility(View.GONE);
                break;
            case 1:
                viewHolder.tv_order_send.setVisibility(View.GONE);
                viewHolder.tv_order_not_over.setVisibility(View.VISIBLE);
                viewHolder.tv_order_over.setVisibility(View.GONE);
                break;
            case 2:
                viewHolder.tv_order_send.setVisibility(View.GONE);
                viewHolder.tv_order_not_over.setVisibility(View.GONE);
                viewHolder.tv_order_over.setVisibility(View.VISIBLE);
                break;
        }
        viewHolder.tv_order_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OrderSettlementController orderSettlementController = new OrderSettlementController();
                orderSettlementController.updateOrder(orderInfoList.get(position),OrderSettlementController.SEND_ODER);
                orderInfoList.remove(position);
                notifyDataSetChanged();
            }
        });
        viewHolder.tv_price_all.setText("￥"+orderInfoList.get(position).getAllPrice());
        return convertView;
    }

    private class ViewHolder {
        private TextView tv_order_id;
        private TextView tv_name;
        private TextView tv_mobile;
        private TextView tv_location;
        private TextView tv_order_over;
        private TextView tv_order_send;
        private TextView tv_order_not_over;
        private MyListView lv_order_goods_info;
        private TextView tv_price_all;
    }
}
