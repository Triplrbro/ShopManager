package com.example.shopmanager.fragment;


import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.shopmanager.R;

public class BottomFragment extends Fragment implements View.OnClickListener{

    private View fragment_bottom;
    private LinearLayout ll_first;
    private LinearLayout ll_BBS;
    private LinearLayout ll_loves;
    private LinearLayout ll_myself;
    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;
    private Button bt_first;
    private Button bt_BBS;
    private Button bt_loves;
    private Button bt_myself;
    private TextView tv_first;
    private TextView tv_BBS;
    private TextView tv_loves;
    private TextView tv_myself;

    private Button lastFunctionButton;
    private TextView lastFunctionTextView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        fragment_bottom = inflater.inflate(R.layout.fragment_bottom, null);
        initView();
        setOnClick();
        fragmentManager = getActivity().getFragmentManager();
        return fragment_bottom;
    }

    private void initView() {
        ll_first = fragment_bottom.findViewById(R.id.ll_first);
        ll_BBS = fragment_bottom.findViewById(R.id.ll_BBS);
        ll_loves = fragment_bottom.findViewById(R.id.ll_loves);
        ll_myself = fragment_bottom.findViewById(R.id.ll_myself);
        bt_first = fragment_bottom.findViewById(R.id.bt_first);
        bt_BBS = fragment_bottom.findViewById(R.id.bt_BBS);
        bt_loves = fragment_bottom.findViewById(R.id.bt_loves);
        bt_myself = fragment_bottom.findViewById(R.id.bt_myself);
        tv_first = fragment_bottom.findViewById(R.id.tv_first);
        tv_BBS = fragment_bottom.findViewById(R.id.tv_BBS);
        tv_loves = fragment_bottom.findViewById(R.id.tv_loves);
        tv_myself = fragment_bottom.findViewById(R.id.tv_myself);

        if (lastFunctionTextView == null) {
            lastFunctionTextView = tv_first;
        }
        if (lastFunctionButton == null) {
            lastFunctionButton = bt_first;
        }

    }

    public void setOnClick() {

        ll_first.setOnClickListener(this);
        ll_BBS.setOnClickListener(this);
        ll_loves.setOnClickListener(this);
        ll_myself.setOnClickListener(this);
        bt_first.setOnClickListener(this);
        bt_BBS.setOnClickListener(this);
        bt_loves.setOnClickListener(this);
        bt_myself.setOnClickListener(this);
        tv_first.setOnClickListener(this);
        tv_BBS.setOnClickListener(this);
        tv_loves.setOnClickListener(this);
        tv_myself.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_first:
            case R.id.bt_first:
            case R.id.tv_first:
                transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.fl_content, new FirstPageFragment());
                transaction.commit();
                changeImageForButton(lastFunctionButton, bt_first);
                lastFunctionTextView.setTextColor(Color.GRAY);
                tv_first.setTextColor(Color.BLACK);
                lastFunctionTextView = tv_first;
                break;
            case R.id.ll_BBS:
            case R.id.bt_BBS:
            case R.id.tv_BBS:
                transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.fl_content, new BBSFragment());
                transaction.commit();
                changeImageForButton(lastFunctionButton, bt_BBS);
                lastFunctionTextView.setTextColor(Color.GRAY);
                tv_BBS.setTextColor(Color.BLACK);
                lastFunctionTextView = tv_BBS;
                break;
            case R.id.ll_loves:
            case R.id.bt_loves:
            case R.id.tv_loves:
                transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.fl_content, new ShopFragment());
                transaction.commit();
                changeImageForButton(lastFunctionButton, bt_loves);
                lastFunctionTextView.setTextColor(Color.GRAY);
                tv_loves.setTextColor(Color.BLACK);
                lastFunctionTextView = tv_loves;
                break;
            case R.id.ll_myself:
            case R.id.bt_myself:
            case R.id.tv_myself:
                transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.fl_content, new MyselfFragment());
                transaction.commit();
                changeImageForButton(lastFunctionButton, bt_myself);
                lastFunctionTextView.setTextColor(Color.GRAY);
                tv_myself.setTextColor(Color.BLACK);
                lastFunctionTextView = tv_myself;
                break;
        }
    }

    private void changeImageForButton(Button lastFunctionButton, Button onClickButton) {
        switch (lastFunctionButton.getId()) {
            case R.id.bt_first:
                lastFunctionButton.setBackgroundResource(R.mipmap.ic_index_unclick);
                break;
            case R.id.bt_BBS:
                lastFunctionButton.setBackgroundResource(R.mipmap.ic_bbs_unclick);
                break;
            case R.id.bt_loves:
                lastFunctionButton.setBackgroundResource(R.mipmap.ic_shop_unclick);
                break;
            case R.id.bt_myself:
                lastFunctionButton.setBackgroundResource(R.mipmap.ic_myself_unclick);
                break;
        }
        switch (onClickButton.getId()) {
            case R.id.bt_first:
                onClickButton.setBackgroundResource(R.mipmap.ic_index_click);
                break;
            case R.id.bt_BBS:
                onClickButton.setBackgroundResource(R.mipmap.ic_bbs_click);
                break;
            case R.id.bt_loves:
                onClickButton.setBackgroundResource(R.mipmap.ic_shop_click);
                break;
            case R.id.bt_myself:
                onClickButton.setBackgroundResource(R.mipmap.ic_myself_click);
                break;
        }
        this.lastFunctionButton =onClickButton;
    }
}
