package com.example.elixrv10;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        , WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        Objects.requireNonNull(getSupportActionBar()).hide();
        int splash_time_out = 3000;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent homeIntent  =new Intent(splash.this, MainActivity.class);
                startActivity(homeIntent);
                finish();

            }
        }, splash_time_out);

    }
}
