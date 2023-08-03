package com.example.my_app;
import com.example.my_app.DTO.ApiResponse;
import com.example.my_app.DTO.ListPostResponseDTO;
import com.example.my_app.DTO.ListScheduleDTO;
import com.example.my_app.DTO.Schedule;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface IRetrofit {

    @GET("/api/get-posts.php")
    Call<ListPostResponseDTO> getAllPost();

    @GET("/api/get-schedules.php")
    Call<ApiResponse<Schedule>> getSchedules(
            @Query("user_id") int userId,
            @Query("type") int type,
            @Query("date") String date
    );

}
