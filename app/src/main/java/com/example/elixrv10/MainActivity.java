package com.example.elixrv10;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    public static final String MSG = "com.example.elixrv10.USERNAME";
    EditText Username;
    String username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
          getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
         getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
              , WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
          Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_main);
        loaddata();
    }

    public void savedata(){
        SharedPreferences sharedPreferences = getSharedPreferences("username",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("Username",username);
        editor.apply();
    }

    public void loaddata(){
        try {
            SharedPreferences sharedPreferences = getSharedPreferences("username",MODE_PRIVATE);
            username = sharedPreferences.getString("Username", String.valueOf(MODE_PRIVATE));
            Username.setText(username);
        }
        catch (Exception e){
            Toast.makeText(this,"Failed",Toast.LENGTH_LONG).show();
        }


    }

    public void str(View view) {

        Username = findViewById(R.id.editText);
        username = Username.getText().toString().trim();
      //  Toast.makeText(this,username,Toast.LENGTH_LONG).show();
       if(username.length() > 0) {
             Intent intent = new Intent(this, HomeActivity.class);
             intent.putExtra(MSG, username);
             startActivity(intent);
           // finish();
       }
        else{
          Toast.makeText(this,"Enter your name..",Toast.LENGTH_SHORT).show();
           }
    }

    @Override
    protected void onPause() {
        super.onPause();
        savedata();
    }
}



