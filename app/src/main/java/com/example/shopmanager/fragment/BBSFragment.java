package com.example.shopmanager.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


import com.example.shopmanager.R;
import com.example.shopmanager.activities.SendBBSActivity;

import org.jetbrains.annotations.Nullable;

public class BBSFragment extends Fragment {

    private View fragment_brand;
    private Button bt_send;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        fragment_brand = inflater.inflate(R.layout.fragment_bbs, null);
        initView();



        return fragment_brand;
    }

    private void initView() {
        bt_send = fragment_brand.findViewById(R.id.bt_send);
        bt_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), SendBBSActivity.class);
                startActivity(intent);
            }
        });
    }
}
