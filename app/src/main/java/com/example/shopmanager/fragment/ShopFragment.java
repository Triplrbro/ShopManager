package com.example.shopmanager.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shopmanager.R;
import com.example.shopmanager.adapter.MyShopCarAdapter;
import com.example.shopmanager.controller.ShoppingCarController;
import com.example.shopmanager.controller.UserController;
import com.example.shopmanager.service.db.bean.ShoppingCart;

import java.util.List;


public class ShopFragment extends Fragment {

    private View fragment_shop;
    private ShoppingCarController shoppingCarController;
    private RecyclerView rv_shopcart;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        fragment_shop = inflater.inflate(R.layout.fragment_shop, null);

        rv_shopcart = fragment_shop.findViewById(R.id.rv_shopcart);
        shoppingCarController = new ShoppingCarController();
        List<ShoppingCart> shoppingCarts = shoppingCarController.queryUserCarList(UserController.getUserId());

        MyShopCarAdapter myShopCarAdapter = new MyShopCarAdapter(getActivity(),shoppingCarts);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity()) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        manager.setOrientation(LinearLayoutManager.VERTICAL);

        rv_shopcart.setLayoutManager(manager);
        rv_shopcart.setAdapter(myShopCarAdapter);
        return fragment_shop;
    }
}
