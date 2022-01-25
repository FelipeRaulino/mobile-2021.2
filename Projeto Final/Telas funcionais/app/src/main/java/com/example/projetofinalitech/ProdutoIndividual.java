package com.example.projetofinalitech;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class ProdutoIndividual extends AppCompatActivity {

    TextView txtView_nomeProduto, txtView_precoProduto;
    Button btn_adicionarProduto;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produto_individual);

        txtView_nomeProduto = findViewById(R.id.txtView_nomeProduto);
        txtView_precoProduto = findViewById(R.id.txtView_precoProduto);
        btn_adicionarProduto = findViewById(R.id.btn_adicionarProduto);
        bottomNavigationView = findViewById(R.id.bottom_navigation);

        Bundle bundle = getIntent().getExtras();

        if (bundle != null){
            String id = bundle.getString("id");
            String nome = bundle.getString("nome");
            String preco = bundle.getString("preco");

            txtView_nomeProduto.setText(nome);
            txtView_precoProduto.setText(preco);
        }

        btn_adicionarProduto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Adicionado com sucesso!!", Toast.LENGTH_LONG).show();
                finish();
                startActivity(new Intent(ProdutoIndividual.this, MainActivity.class));
            }
        });

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.page_1:
                        finish();
                        startActivity(new Intent(ProdutoIndividual.this, MainActivity.class));
                        break;
                    case R.id.page_2:
                        finish();
                        startActivity(new Intent(ProdutoIndividual.this, Mapa.class));
                        break;
                    case R.id.page_3:
                        finish();
                        startActivity(new Intent(ProdutoIndividual.this, ProfileEdit.class));
                        break;
                    default:
                        break;
                }

                return false;
            }
        });

    }
}