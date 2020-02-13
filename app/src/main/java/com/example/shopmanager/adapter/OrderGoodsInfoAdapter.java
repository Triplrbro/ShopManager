package com.example.shopmanager.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.shopmanager.R;
import com.example.shopmanager.service.db.bean.OrderSettlementInfo;
import com.example.shopmanager.service.db.bean.ShoppingCart;
import com.example.shopmanager.views.MyListView;

import java.util.List;

/**
 * @author Domineer
 * @data 2019/12/15,18:03
 * ----------为梦想启航---------
 * --Set Sell For Your Dream--
 */
public class OrderGoodsInfoAdapter extends BaseAdapter {

    private Context context;
    private List<ShoppingCart> shoppingCartList;

    public OrderGoodsInfoAdapter(Context context, List<ShoppingCart> shoppingCartList) {
        this.context = context;
        this.shoppingCartList = shoppingCartList;
    }

    public List<ShoppingCart> getShoppingCartList() {
        return shoppingCartList;
    }

    public void setShoppingCartList(List<ShoppingCart> shoppingCartList) {
        this.shoppingCartList = shoppingCartList;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return shoppingCartList.size();
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
            convertView = View.inflate(context, R.layout.item_order_goods_info, null);
            viewHolder.tv_goods_name = convertView.findViewById(R.id.tv_goods_name);
            viewHolder.tv_price = convertView.findViewById(R.id.tv_price);
            viewHolder.tv_count = convertView.findViewById(R.id.tv_count);
            viewHolder.iv_goods = convertView.findViewById(R.id.iv_goods);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.tv_goods_name.setText(shoppingCartList.get(position).getBookInfo().getBookNmae());
        viewHolder.tv_price.setText(shoppingCartList.get(position).getBookInfo().getPrice());
        viewHolder.tv_count.setText(shoppingCartList.get(position).getNum());
        if (shoppingCartList.get(position).getBookInfo().getBookPhoto().length() == 0 || shoppingCartList.get(position).getBookInfo().getBookPhoto().equals("hrrp://location") || shoppingCartList.get(position).getBookInfo().getBookPhoto() == null) {
            Glide.with(context).load(R.drawable.photo_default).into(viewHolder.iv_goods);
        } else {
            Glide.with(context).load(shoppingCartList.get(position).getBookInfo().getBookPhoto()).into(viewHolder.iv_goods);
        }
        return convertView;
    }

    private class ViewHolder {
        private TextView tv_goods_name;
        private TextView tv_price;
        private TextView tv_count;
        private ImageView iv_goods;
    }
}
