package com.example.my_app;

import com.example.my_app.IRetrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static final String BASE_URL = "http://10.0.2.2:1234/"; // Thay thế bằng URL của API thật

    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static IRetrofit getApiService() {
        return retrofit.create(IRetrofit.class);
    }
}
