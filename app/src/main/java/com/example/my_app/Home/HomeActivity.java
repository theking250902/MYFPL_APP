package com.example.my_app.Home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.my_app.R;
import com.example.my_app.lich_hoc.LichHocActivity;
import com.example.my_app.lich_hoc.LichThiActivity;

public class HomeActivity extends AppCompatActivity {
    TextView btn_home;TextView btn_home2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        btn_home = findViewById(R.id.btn_home);
        btn_home2 = findViewById(R.id.btn_home2);


    }
    public void click(View view){
        Intent intent = new Intent(HomeActivity.this, LichHocActivity.class);
        startActivity(intent);
    }
    public void click2(View view){
        Intent intent = new Intent(HomeActivity.this, LichThiActivity.class);
        startActivity(intent);
    }
}