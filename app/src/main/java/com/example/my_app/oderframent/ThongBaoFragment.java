package com.example.my_app.oderframent;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.example.my_app.DTO.ListPostResponseDTO;
import com.example.my_app.IRetrofit;
import com.example.my_app.R;
import com.example.my_app.RetrofitHelper;
import com.example.my_app.ScheduleAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ThongBaoFragment extends Fragment {
    ListView lvSchedules;
    ScheduleAdapter adapter;
    List<ListPostResponseDTO.PostResponseDTO> list;
    IRetrofit iRetrofit;
    private View view;
    public ThongBaoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceStase){
        view = inflater.inflate(R.layout.fragment_thong_bao, container, false);

        iRetrofit = RetrofitHelper.createService(IRetrofit.class);
        lvSchedules = view.findViewById(R.id.listviewne);
        list = new ArrayList<>();
        adapter = new ScheduleAdapter(list);
        lvSchedules.setAdapter(adapter);

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