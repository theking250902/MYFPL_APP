package com.example.my_app.login;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.my_app.Home.HomeActivity;
import com.example.my_app.R;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

public class LoginActivity extends AppCompatActivity {

    //google
    private Button btnSignIn;
    GoogleSignInOptions gso;
    GoogleSignInClient gsc;
    //google

    Button btn_google;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btn_google = findViewById(R.id.btn_login);

        //google
        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        gsc = GoogleSignIn.getClient(LoginActivity.this, gso);
        initializeViews();
        btnEvent();
        //google

    }
    //google
    private void btnEvent(){
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SignIn();
            }
        });
    }


    private void SignIn(){
        Intent signInIntent = gsc.getSignInIntent();
        startActivityForResult(signInIntent, 1000);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1000){
            try {
                Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
                handleSignInResult(task);
            }catch (Exception e){

            }
        }
    }

    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);
            if (account!= null){
                String email = account.getEmail();
                if (email.endsWith("@fpt.edu.vn")) {
                    Log.d("TAG", "handleSignInResult: " + email);
                    Intent intent = new Intent(LoginActivity.this , HomeActivity.class);
                    startActivity(intent);
                } else {
                    Log.d("TAG", "handleSignInResult: Email không hợp lệ");
                    gsc.signOut();
                }
            }

        } catch (ApiException e) {

        }
    }

    private void initializeViews(){
        btnSignIn = findViewById(R.id.btn_login);
    }

    //google


    public void click(View view){
        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
        startActivity(intent);
    }
}