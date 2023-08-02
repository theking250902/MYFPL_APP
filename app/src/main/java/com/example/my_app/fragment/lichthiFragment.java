package com.example.my_app.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.my_app.MainActivity;
import com.example.my_app.R;


public class lichthiFragment extends Fragment {



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_lichthi, container, false);

        ImageView switchButton2 = view.findViewById(R.id.btn_back);
        switchButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Chuyển đổi sang FragmentB khi nút được nhấp
                ((MainActivity) requireActivity()).home();
            }
        });
        return  view;
    }
}