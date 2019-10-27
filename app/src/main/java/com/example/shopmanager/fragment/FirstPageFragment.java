package com.example.shopmanager.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import com.example.shopmanager.R;

public class FirstPageFragment extends Fragment {
    private View fragment_firstpage;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        fragment_firstpage = inflater.inflate(R.layout.fragment_firstpage, null);
        return fragment_firstpage;
    }
}
