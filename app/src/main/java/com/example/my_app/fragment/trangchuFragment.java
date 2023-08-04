package com.example.my_app.fragment;

import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.my_app.IRetrofit;
import com.example.my_app.DTO.ListPostResponseDTO;
import com.example.my_app.MainActivity;
import com.example.my_app.R;
import com.example.my_app.RetrofitHelper;
import com.example.my_app.ScheduleAdapter;
import com.example.my_app.RetrofitHelper;
import com.example.my_app.oderframent.OderViewFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class trangchuFragment extends Fragment {

//    ListView lvSchedules;
//    ScheduleAdapter adapter;
//    List<ListPostResponseDTO.PostResponseDTO> list;
//    IRetrofit iRetrofit;
    private View view;

    private TabLayout tabLayout;
    private ViewPager viewPager;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_trangchu, container, false);

        tabLayout = view.findViewById(R.id.tab_layout);
        viewPager = view.findViewById(R.id.oder_viewpager);
        OderViewFragment adapter1 = new OderViewFragment(getChildFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(adapter1);
        tabLayout.setupWithViewPager(viewPager);

        int selectedTabColor = ContextCompat.getColor(getContext(), R.color.canhan);
        int unselectedTabColor = ContextCompat.getColor(getContext(), R.color.black);

        tabLayout.setTabTextColors(unselectedTabColor, selectedTabColor);

        ImageView switchButton2 = view.findViewById(R.id.btn_canhan);
        switchButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Chuyển đổi sang FragmentB khi nút được nhấp
                ((MainActivity) requireActivity()).canhan();
            }
        });


        return view;
    }
//
//    @Override
//    public void onResume() {
//        super.onResume();
//        iRetrofit.getAllPost().enqueue(getpost);
//    }
//    Callback<ListPostResponseDTO> getpost = new Callback<ListPostResponseDTO>() {
//        @Override
//        public void onResponse(Call<ListPostResponseDTO> call, Response<ListPostResponseDTO> response) {
//            if (response.isSuccessful()) {
//
//                    ListPostResponseDTO responseDTO = response.body();
//                    list.clear();
//                    list.addAll(responseDTO.getPosts());
//                    adapter.notifyDataSetChanged();
//
//            }
//        }
//
//        @Override
//        public void onFailure(Call<ListPostResponseDTO> call, Throwable t) {
//            Log.d(">>>>>>>>>> getAll", "onFailure: " + t.getMessage());
//
//        }
//    };
}