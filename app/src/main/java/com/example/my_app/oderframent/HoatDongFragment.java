package com.example.my_app.oderframent;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.my_app.R;


public class HoatDongFragment extends Fragment {
    public HoatDongFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceStase){
        return inflater.inflate(R.layout.fragment_hoat_dong, container, false);
    }
}