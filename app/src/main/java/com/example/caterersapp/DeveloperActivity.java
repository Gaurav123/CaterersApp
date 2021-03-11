package com.example.caterersapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class DeveloperActivity extends AppCompatActivity {
    TextView textView, textView2, textView3;
    View toptext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developer);
        toptext= findViewById(R.id.topView);
        textView = findViewById(R.id.textView7);
        textView2 = findViewById(R.id.textView8);
        textView3 = findViewById(R.id.textView9);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.id_about);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.id_home:
                        startActivity(new Intent(getApplicationContext(), hotelmain.class));
                        overridePendingTransition(0, 0);
                        finish();
                        return true;

                    case R.id.id_account:
                        startActivity(new Intent(getApplicationContext(), AccountActivity.class));
                        overridePendingTransition(0, 0);
                        finish();
                        return true;
                    case R.id.id_about:

                        return true;
                }

                return false;
            }
        });
    }

}