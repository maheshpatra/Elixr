package com.example.elixrv10;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    public static final String MSG = "com.example.elixrv10.USERNAME";
    EditText Username;
    String username;
    Button button;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
                , WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        Username = findViewById(R.id.editText);
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);    //Retrieving sharedpreference
        String str1  = pref.getString("username", username);
        Username.setText(str1);
     /*   Username.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {
                if (Username.hasFocus()) {
                    v.getParent().requestDisallowInterceptTouchEvent(true);
                    if ((event.getAction() & MotionEvent.ACTION_MASK) == MotionEvent.ACTION_SCROLL) {
                        v.getParent().requestDisallowInterceptTouchEvent(false);
                        return true;
                    }
                }
                return false;
            }
        }); */
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = Username.getText().toString().trim();
                if(username.length() > 0) {
                        Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
                        SharedPreferences.Editor editor = sharedPreferences.edit();           //saving sharedpreferernce
                        editor.putString("username", username);
                        editor.apply();
                        intent.putExtra(MSG, username);
                        startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Enter your name..", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}




