package com.example.my_app.lich_hoc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.my_app.Home.HomeActivity;
import com.example.my_app.R;

public class LichThiActivity extends AppCompatActivity {
    ImageView btn_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lich_thi);
        btn_back = findViewById(R.id.btn_back);
    }
    public void click2(View view){
        Intent intent = new Intent(LichThiActivity.this, HomeActivity.class);
        startActivity(intent);
    }
}