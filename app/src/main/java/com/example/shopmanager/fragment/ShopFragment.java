package com.example.shopmanager.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.annotation.Nullable;

import com.example.shopmanager.R;
import com.example.shopmanager.controller.ShoppingCarController;
import com.example.shopmanager.controller.UserController;
import com.example.shopmanager.service.db.bean.ShoppingCart;

import java.util.List;


public class ShopFragment extends Fragment {

    private View fragment_loves;
    private ShoppingCarController shoppingCarController;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        fragment_loves = inflater.inflate(R.layout.fragment_shop, null);

        shoppingCarController = new ShoppingCarController();
        List<ShoppingCart> shoppingCarts = shoppingCarController.queryUserCarList(UserController.getUserId());

        return fragment_loves;
    }
}
