package com.example.my_app.lich_hoc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.my_app.Home.HomeActivity;
import com.example.my_app.R;

public class LichHocActivity extends AppCompatActivity {

    ImageView btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lich_hoc);
        btn_back = findViewById(R.id.btn_back);

    }


    public void click2(View view){
        Intent intent = new Intent(LichHocActivity.this, HomeActivity.class);
        startActivity(intent);
    }

}