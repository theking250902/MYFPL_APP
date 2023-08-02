package com.example.my_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.my_app.fragment.canhanFragment;
import com.example.my_app.fragment.lichhocFragment;
import com.example.my_app.fragment.lichthiFragment;
import com.example.my_app.fragment.trangchuFragment;

public class MainActivity extends AppCompatActivity {

    private int selectedTab = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        trangchuFragment trangchuFragment = new trangchuFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentcontainer, trangchuFragment)
                .commit();
        lichthiFragment lichthiFragment = new lichthiFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentcontainer, lichthiFragment)
                .commit();
        lichhocFragment lichhocFragment = new lichhocFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentcontainer, lichhocFragment)
                .commit();


        final LinearLayout homeLayout = findViewById(R.id.homelayout);
        final LinearLayout lichhocLayout = findViewById(R.id.lichhoclayout);
        final LinearLayout lichthiLayout = findViewById(R.id.lichthilayout);
        final LinearLayout canhanLayout = findViewById(R.id.canhanlayout);

        final ImageView homeImage = findViewById(R.id.homeImage);
        final ImageView lichhocImage = findViewById(R.id.lichhocImage);
        final ImageView lichthiImage = findViewById(R.id.lichthiImage);
        final ImageView canhanImage = findViewById(R.id.canhanImage);

        final TextView homeTxt = findViewById(R.id.homeTxt);
        final TextView lichhocTxt = findViewById(R.id.lichhocTxt);
        final TextView lichthiTxt = findViewById(R.id.lichthiTxt);
        final TextView canhanTxt = findViewById(R.id.canhanTxt);


        getSupportFragmentManager().beginTransaction()
                        .setReorderingAllowed(true)
                                .replace(R.id.fragmentcontainer, trangchuFragment.class, null)
                                        .commit();
        homeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(selectedTab !=1){
                    getSupportFragmentManager().beginTransaction()
                            .setReorderingAllowed(true)
                            .replace(R.id.fragmentcontainer, trangchuFragment.class, null)
                            .commit();
                    lichhocTxt.setVisibility(View.GONE);
                    lichthiTxt.setVisibility(View.GONE);
                    canhanTxt.setVisibility(View.GONE);

                    lichhocImage.setImageResource(R.drawable.icon_lichhoc);
                    lichthiImage.setImageResource(R.drawable.icon_lichthi);
                    canhanImage.setImageResource(R.drawable.icon_profile);

                    homeTxt.setVisibility(View.VISIBLE);
                    homeImage.setImageResource(R.drawable.icon_home_click);
                    homeLayout.setBackgroundResource(R.drawable.round_back_home_100);

                    ScaleAnimation scaleAnimation = new ScaleAnimation(0.8f,1.0f,1f,1f, Animation.RELATIVE_TO_SELF,0.0f,Animation.RELATIVE_TO_SELF,0.0f);
                    scaleAnimation.setDuration(200);
                    scaleAnimation.setFillAfter(true);
                    homeLayout.startAnimation(scaleAnimation);

                    selectedTab = 1;


                }
            }
        });
        lichhocLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(selectedTab !=2){

                    getSupportFragmentManager().beginTransaction()
                            .setReorderingAllowed(true)
                            .replace(R.id.fragmentcontainer, lichhocFragment.class, null)
                            .commit();
                    homeTxt.setVisibility(View.GONE);
                    lichthiTxt.setVisibility(View.GONE);
                    canhanTxt.setVisibility(View.GONE);

                    homeImage.setImageResource(R.drawable.icon_home);
                    lichthiImage.setImageResource(R.drawable.icon_lichthi);
                    canhanImage.setImageResource(R.drawable.icon_profile);

                    lichhocTxt.setVisibility(View.VISIBLE);
                    lichhocImage.setImageResource(R.drawable.icon_lichhoc_click);
                    lichhocLayout.setBackgroundResource(R.drawable.round_back_lichhoc_100);

                    ScaleAnimation scaleAnimation = new ScaleAnimation(0.8f,1.0f,1f,1f, Animation.RELATIVE_TO_SELF,1.0f,Animation.RELATIVE_TO_SELF,0.0f);
                    scaleAnimation.setDuration(200);
                    scaleAnimation.setFillAfter(true);
                    lichhocLayout.startAnimation(scaleAnimation);

                    selectedTab = 2;


                }
            }
        });
        lichthiLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(selectedTab !=3){
                    getSupportFragmentManager().beginTransaction()
                            .setReorderingAllowed(true)
                            .replace(R.id.fragmentcontainer, lichthiFragment.class, null)
                            .commit();
                    homeTxt.setVisibility(View.GONE);
                    lichhocTxt.setVisibility(View.GONE);
                    canhanTxt.setVisibility(View.GONE);

                    homeImage.setImageResource(R.drawable.icon_home);
                    lichhocImage.setImageResource(R.drawable.icon_lichhoc);
                    canhanImage.setImageResource(R.drawable.icon_profile);

                    lichthiTxt.setVisibility(View.VISIBLE);
                    lichthiImage.setImageResource(R.drawable.icon_lichthi_click);
                    lichthiLayout.setBackgroundResource(R.drawable.round_back_lichthi_100);

                    ScaleAnimation scaleAnimation = new ScaleAnimation(0.8f,1.0f,1f,1f, Animation.RELATIVE_TO_SELF,1.0f,Animation.RELATIVE_TO_SELF,0.0f);
                    scaleAnimation.setDuration(200);
                    scaleAnimation.setFillAfter(true);
                    lichthiLayout.startAnimation(scaleAnimation);

                    selectedTab = 3;


                }
            }
        });
        canhanLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(selectedTab !=4){
                    getSupportFragmentManager().beginTransaction()
                            .setReorderingAllowed(true)
                            .replace(R.id.fragmentcontainer, canhanFragment.class, null)
                            .commit();
                    homeTxt.setVisibility(View.GONE);
                    lichhocTxt.setVisibility(View.GONE);
                    lichthiTxt.setVisibility(View.GONE);

                    homeImage.setImageResource(R.drawable.icon_home);
                    lichhocImage.setImageResource(R.drawable.icon_lichhoc);
                    lichthiImage.setImageResource(R.drawable.icon_lichthi);

                    canhanTxt.setVisibility(View.VISIBLE);
                    canhanImage.setImageResource(R.drawable.icon_profile_click);
                    canhanLayout.setBackgroundResource(R.drawable.round_back_canhan_100);

                    ScaleAnimation scaleAnimation = new ScaleAnimation(0.8f,1.0f,1f,1f, Animation.RELATIVE_TO_SELF,1.0f,Animation.RELATIVE_TO_SELF,0.0f);
                    scaleAnimation.setDuration(200);
                    scaleAnimation.setFillAfter(true);
                    canhanLayout.startAnimation(scaleAnimation);

                    selectedTab = 4;


                }
            }
        });

    }

    public void lichhocBTN() {
        lichhocFragment lichhocFragment = new lichhocFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentcontainer, lichhocFragment)
                .addToBackStack(null)  // Thêm fragment hiện tại vào back stack
                .commit();
    }
    public void lichthiBTN() {
        lichthiFragment lichthiFragment = new lichthiFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentcontainer, lichthiFragment)
                .addToBackStack(null)  // Thêm fragment hiện tại vào back stack
                .commit();
    }
    public void home() {
        trangchuFragment trangchuFragment = new trangchuFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentcontainer, trangchuFragment)
                .addToBackStack(null)  // Thêm fragment hiện tại vào back stack
                .commit();
    }
}