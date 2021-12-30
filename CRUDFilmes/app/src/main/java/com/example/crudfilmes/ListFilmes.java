package com.example.crudfilmes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class ListFilmes extends AppCompatActivity {

    private ArrayList<Filme> listaFilmes = new ArrayList<Filme>();

    private RecyclerView recyclerView;
    private FloatingActionButton btnAddFilmes;
    private RecyclerView.LayoutManager layoutManager;
    private CustomAdapter adapter;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_filmes);

        db = FirebaseFirestore.getInstance();

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        showData();

        btnAddFilmes = findViewById(R.id.btn_add);

        btnAddFilmes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ListFilmes.this, MainActivity.class));
            }
        });

    }

    public void showData(){
        db.collection("Filmes")
                .orderBy("titulo")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        listaFilmes.clear();

                        for(DocumentSnapshot doc: task.getResult()){
                            Filme filme = new Filme(doc.getString("id"), doc.getString("titulo"), doc.getString("categoria"), doc.getString("dataDeLancamento"), doc.getString("diretor"));
                            listaFilmes.add(filme);
                        }

                        adapter = new CustomAdapter(ListFilmes.this, listaFilmes);

                        recyclerView.setAdapter(adapter);
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(ListFilmes.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    public void deleteData(int index){
        db.collection("Filmes").document(listaFilmes.get(index).getId())
                .delete()
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(ListFilmes.this, "Filme deletado com sucesso!", Toast.LENGTH_LONG).show();
                        showData();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(ListFilmes.this, "Não foi possível remover o filme devido: "+e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
    }
}
















