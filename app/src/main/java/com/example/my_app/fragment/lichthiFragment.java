package com.example.my_app.fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.my_app.ApiClient;
import com.example.my_app.DTO.ApiResponse;
import com.example.my_app.DTO.Schedule;
import com.example.my_app.IRetrofit;
import com.example.my_app.MainActivity;
import com.example.my_app.OnclickItem_lichhoc;
import com.example.my_app.R;
import com.example.my_app.RetrofitHelper;
import com.example.my_app.lichhocAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class lichthiFragment extends Fragment {

    ListView lvlichhoc;
    lichhocAdapter adapter;
    List<Schedule> list;
    IRetrofit iRetrofit;

    Dialog dialog;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    public Dialog onCreateDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        // Định nghĩa giao diện của dialog từ layout đã tạo
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dia_log, null);


        builder.setView(dialogView);


        // Tạo và trả về dialog đã thiết lập
        return builder.create();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_lichthi, container, false);

        dialog = onCreateDialog();

        ImageView switchButton2 = view.findViewById(R.id.btn_back);
        switchButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Chuyển đổi sang FragmentB khi nút được nhấp
                ((MainActivity) requireActivity()).home();
            }








        });



        iRetrofit = RetrofitHelper.createService(IRetrofit.class);
        lvlichhoc = view.findViewById(R.id.listview3);
        list = new ArrayList<>();
        adapter = new lichhocAdapter(list, new OnclickItem_lichhoc() {
            @Override
            public void OnClick(Schedule schedule) {
                dialog.show();
            }
        });
        lvlichhoc.setAdapter(adapter);

        IRetrofit apiService = ApiClient.getApiService();

        int userId = 1;
        int type = 0;
        String date = "2022-10-24";

        Call<ApiResponse<Schedule>> call = apiService.getSchedules(userId, type, date);
        call.enqueue(new Callback<ApiResponse<Schedule>>() {
            @Override
            public void onResponse(Call<ApiResponse<Schedule>> call, Response<ApiResponse<Schedule>> response) {
                if (response.isSuccessful() && response.body() != null && response.body().isStatus()) {

                    List<Schedule> scheduleList = response.body().getData();

                    list.addAll(scheduleList);
                    adapter.notifyDataSetChanged();

                    //           Log.d("API Response", "ID: " + schedule.getId() + "");
                    // Xử lý dữ liệu lịch học/thi trong schedule




                    // Xử lý dữ liệu lịch học/thi

                } else {
                    // Xử lý trạng thái không thành công hoặc lỗi từ API
                }
            }

            @Override
            public void onFailure(Call<ApiResponse<Schedule>> call, Throwable t) {
                // Xử lý lỗi kết nối mạng hoặc lỗi khác
                Log.e("API", "Error: " + t.getMessage());
            }
        });
        return  view;
    }
}