package com.example.my_app;
import com.example.my_app.DTO.ListPostResponseDTO;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IRetrofit {

    @GET("/api/get-posts.php")
    Call<ListPostResponseDTO> getAllPost();

}
