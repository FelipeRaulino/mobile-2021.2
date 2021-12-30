package com.example.crudfilmes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    private Button btn_adicionarFilme, btn_listarFilmes;
    private EditText edtText_titulo, edtText_categoria, edtText_dataLancamento, edtText_diretor;
    private TextView txtView_descricao;

    private FirebaseFirestore db;

    private String Uid, Utitulo, Ucategoria, UdataLancamento, Udiretor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = FirebaseFirestore.getInstance();

        txtView_descricao = findViewById(R.id.txtView_descricao);
        edtText_titulo = findViewById(R.id.edtText_titulo);
        edtText_categoria = findViewById(R.id.edtText_categoria);
        edtText_dataLancamento = findViewById(R.id.edtText_dataLancamento);
        edtText_diretor = findViewById(R.id.edtText_diretor);

        btn_adicionarFilme = findViewById(R.id.btn_adicionarFilme);
        btn_listarFilmes = findViewById(R.id.btn_listarFilmes);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            txtView_descricao.setText("Atualizando filme");
            btn_adicionarFilme.setText("Atualizar filme");

            Uid = bundle.getString("id");
            Ucategoria = bundle.getString("categoria");
            Utitulo = bundle.getString("titulo");
            UdataLancamento = bundle.getString("dataLancamento");
            Udiretor = bundle.getString("diretor");

            edtText_titulo.setText(Utitulo);
            edtText_categoria.setText(Ucategoria);
            edtText_dataLancamento.setText(UdataLancamento);
            edtText_diretor.setText(Udiretor);
        }

        btn_adicionarFilme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bundle != null){
                    String id = Uid;
                    String titulo = edtText_titulo.getText().toString().trim();
                    String categoria = edtText_categoria.getText().toString().trim();
                    String dataLancamento = edtText_dataLancamento.getText().toString().trim();
                    String diretor = edtText_diretor.getText().toString().trim();

                    updateData(id, titulo, categoria, dataLancamento, diretor);
                }else{
                    addData();
                }
            }
        });

        btn_listarFilmes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ListFilmes.class));
            }
        });
    }

    public void addData(){
        String id = UUID.randomUUID().toString();
        String titulo = edtText_titulo.getText().toString().trim();
        String categoria = edtText_categoria.getText().toString().trim();
        String dataLancamento = edtText_dataLancamento.getText().toString().trim();
        String diretor = edtText_diretor.getText().toString().trim();

        if (!titulo.isEmpty() && !categoria.isEmpty() && !dataLancamento.isEmpty() && !diretor.isEmpty()){
            Filme filme = new Filme(id, titulo, categoria, dataLancamento, diretor);

            db.collection("Filmes").document(id)
                    .set(filme)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            Toast.makeText(MainActivity.this, "Filme adicionado com sucesso!", Toast.LENGTH_LONG).show();
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(MainActivity.this, "Não foi possível adicionar o filme devido: " +e.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    });

            edtText_titulo.setText("");
            edtText_categoria.setText("");
            edtText_dataLancamento.setText("");
            edtText_diretor.setText("");
        }else{
            Toast.makeText(MainActivity.this, "Não foi possível adicionar um novo filme, pois algum(ns) campo(s) está(ão) vazio(os).", Toast.LENGTH_LONG).show();
            edtText_titulo.setText("");
            edtText_categoria.setText("");
            edtText_dataLancamento.setText("");
            edtText_diretor.setText("");
        }


    }

    public void updateData(String id, String titulo, String categoria, String dataLancamento, String diretor){
        db.collection("Filmes").document(id)
                .update("titulo", titulo, "categoria", categoria, "dataDeLancamento", dataLancamento, "diretor", diretor)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(MainActivity.this, "Dados atualizados com sucesso", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MainActivity.this, "Infelizmente não foi possível atualizar os dados!", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}





























