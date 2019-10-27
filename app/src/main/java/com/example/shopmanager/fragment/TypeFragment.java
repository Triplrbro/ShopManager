package com.example.shopmanager.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.shopmanager.R;

import org.jetbrains.annotations.Nullable;

public class TypeFragment extends Fragment {

    private View fragment_type;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        fragment_type = inflater.inflate(R.layout.fragment_type, null);
        return fragment_type;
    }
}
