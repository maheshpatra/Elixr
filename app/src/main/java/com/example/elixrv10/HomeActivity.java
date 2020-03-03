package com.example.elixrv10;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.R;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;


public class HomeActivity extends AppCompatActivity {
    TextView textView;
    String  username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_AppCompat_DayNight);
        setContentView(R.layout.);
        Intent intent = getIntent();
        username = intent.getStringExtra(MainActivity.MSG);
        textView = findViewById(R.id.title);
        String welcome = "Hello ";
        textView.setText(welcome +username);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.favourites_page){
            Toast.makeText(this,"Created by Dipantan Chakraborty",Toast.LENGTH_SHORT).show();
        }
        else if(item.getItemId() == R.id.mode){
            if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            }
        }
        return super.onOptionsItemSelected(item);
    }

}
