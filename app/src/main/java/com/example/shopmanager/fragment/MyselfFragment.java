package com.example.shopmanager.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;

import com.example.shopmanager.R;
import com.example.shopmanager.activities.AddDataActivity;


public class MyselfFragment extends Fragment implements View.OnClickListener {

    private View fragment_myself;
    private Button bt_set;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        fragment_myself = inflater.inflate(R.layout.fragment_myself, null);

        initView();

        return fragment_myself;
    }

    private void initView() {


        bt_set = fragment_myself.findViewById(R.id.bt_set);
        bt_set.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_set:
                Intent intent = new Intent(getContext(), AddDataActivity.class);
                startActivity(intent);
                break;
        }
    }
}
