package com.example.projetofinalitech;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class Mapa extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa);

        bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.page_1:
                        finish();
                        startActivity(new Intent(Mapa.this, MainActivity.class));
                        break;
                    case R.id.page_2:
                        finish();
                        startActivity(new Intent(Mapa.this, Mapa.class));
                        break;
                    case R.id.page_3:
                        finish();
                        startActivity(new Intent(Mapa.this, ProfileEdit.class));
                        break;
                    default:
                        break;
                }

                return false;
            }
        });

    }
}