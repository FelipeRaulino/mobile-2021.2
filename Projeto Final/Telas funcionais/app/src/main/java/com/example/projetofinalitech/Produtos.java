package com.example.projetofinalitech;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.UUID;

public class Produtos extends AppCompatActivity {

    private static final int numberOfColumns = 2;

    private RecyclerView recyclerView;
    private RecyclerViewAdapter adapter;
    private ArrayList<Produto> produtos;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produtos);

        bottomNavigationView = findViewById(R.id.bottom_navigation);

        String id = UUID.randomUUID().toString();

        Produto tripe = new Produto(id, "Tripé fotográfico p/ camêra e smartphone",
                "R$ 19,00", "Acessório");

         Produto tripe2 = new Produto(id, "Tripé fotográfico p/ camêra e smartphone",
                "R$ 35,00", "Acessório");

        Produto tripe3 = new Produto(id, "Tripé fotográfico p/ camêra e smartphone",
                "R$ 19,00", "Acessório");

        produtos = new ArrayList<Produto>();
        produtos.add(tripe);
        produtos.add(tripe2);
        produtos.add(tripe3);

        recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new GridLayoutManager(this, numberOfColumns));

        adapter = new RecyclerViewAdapter(Produtos.this, produtos);
        recyclerView.setAdapter(adapter);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.page_1:
                        startActivity(new Intent(Produtos.this, MainActivity.class));
                        finish();
                        break;
                    case R.id.page_2:

                    case R.id.page_3:

                    default:
                        break;
                }

                return false;
            }
        });
    }
}