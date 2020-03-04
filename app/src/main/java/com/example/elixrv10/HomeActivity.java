package com.example.elixrv10;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;


public class HomeActivity extends AppCompatActivity {
    TextView textView;
    String  username;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Intent intent = getIntent();
        username = intent.getStringExtra(MainActivity.MSG);
        textView = findViewById(R.id.title1);
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
        else if(item.getItemId() == R.id.settings){
           Intent intent = new Intent(this, SettingsActivity.class);
           startActivity(intent);
        }
        else if(item.getItemId() == R.id.logout){
            sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.clear();
            editor.apply();
            finish();
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

}
