package com.example.projetofinalitech;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.projetofinalitech.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    LinearLayout categoria_smartphone, lnLayout_categoriaTablet;
    LinearLayout agendarReparo;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        categoria_smartphone = findViewById(R.id.categoria_smartphone);
        lnLayout_categoriaTablet = findViewById(R.id.lnLayout_categoriaTablet);
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        agendarReparo = findViewById(R.id.agendamentoContainer);

        agendarReparo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Agendamento.class));
            }
        });

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.page_1:

                    case R.id.page_2:
                        startActivity(new Intent(MainActivity.this, Mapa.class));
                        break;
                    case R.id.page_3:
                        startActivity(new Intent(MainActivity.this, ProfileEdit.class));

                    default:
                        break;
                }

                return false;
            }
        });

        categoria_smartphone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(MainActivity.this, Produtos.class));
            }
        });

        lnLayout_categoriaTablet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(MainActivity.this, Produtos.class));
            }
        });

    }
}