package com.example.elixrv10;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
                , WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);getSupportActionBar().hide();
    }
    public void c(View view){
        Intent intent = new Intent(this,LanguageC.class);
        startActivity(intent);
    }

    public void cpp(View view){
        Intent intent = new Intent(this,LanguageCpp.class);
        startActivity(intent);
    }

    public void python(View view){
        Intent intent = new Intent(this,LanguagePython.class);
        startActivity(intent);
    }

    public void java(View view){
        Intent intent = new Intent(this,LanguageJava.class);
        startActivity(intent);
    }

}
