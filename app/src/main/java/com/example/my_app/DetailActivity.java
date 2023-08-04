package com.example.my_app;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.my_app.DTO.DetailpostDTO;
import com.example.my_app.DTO.ListPostResponseDTO;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailActivity extends AppCompatActivity {

    TextView title,content,created_at;

    IRetrofit iRetrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        title = findViewById(R.id.title);
        content = findViewById(R.id.content);
        created_at = findViewById(R.id.created_at);

        iRetrofit = RetrofitHelper.createService(IRetrofit.class);

        int postId = getIntent().getIntExtra("post_id", -1);
        Log.d(">>>>TAG", "onCreate: "+postId);

        iRetrofit.getPostDetail(postId).enqueue(DetailpostDTO);

    }

    Callback<DetailpostDTO> DetailpostDTO = new Callback<DetailpostDTO>() {
        @Override
        public void onResponse(Call<DetailpostDTO> call, Response<DetailpostDTO> response) {
            if (response.isSuccessful()) {
                if(response.body().isStatus()){
                    ListPostResponseDTO.PostResponseDTO post = response.body().getData();
                    if (post != null) {
                        // Hiển thị dữ liệu lấy được lên các view
                        title.setText(post.getTitle());
                        content.setText(post.getContent());
                        created_at.setText(post.getCreated_at() + "");


                    }
                }
            }
        }

        @Override
        public void onFailure(Call<DetailpostDTO> call, Throwable t) {
            Log.d(">>>>>>>>>>>>>>>>>>>>>> DETAIL", "onFailure: " + t.getMessage());

        }
    };
}