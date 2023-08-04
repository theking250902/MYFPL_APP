package com.example.my_app.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

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

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class trangchuFragment extends Fragment {

    ListView lvSchedules;
    ScheduleAdapter adapter;
    List<ListPostResponseDTO.PostResponseDTO> list;
    IRetrofit iRetrofit;
    View view;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_trangchu, container, false);
        iRetrofit = RetrofitHelper.createService(IRetrofit.class);
        lvSchedules = view.findViewById(R.id.listviewne);
        list = new ArrayList<>();
        adapter = new ScheduleAdapter(list);
        lvSchedules.setAdapter(adapter);



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

    @Override
    public void onResume() {
        super.onResume();
        iRetrofit.getAllPost().enqueue(getpost);
    }
    Callback<ListPostResponseDTO> getpost = new Callback<ListPostResponseDTO>() {
        @Override
        public void onResponse(Call<ListPostResponseDTO> call, Response<ListPostResponseDTO> response) {
            if (response.isSuccessful()) {

                    ListPostResponseDTO responseDTO = response.body();
                    list.clear();
                    list.addAll(responseDTO.getPosts());
                    adapter.notifyDataSetChanged();

            }
        }

        @Override
        public void onFailure(Call<ListPostResponseDTO> call, Throwable t) {
            Log.d(">>>>>>>>>> getAll", "onFailure: " + t.getMessage());

        }
    };
}