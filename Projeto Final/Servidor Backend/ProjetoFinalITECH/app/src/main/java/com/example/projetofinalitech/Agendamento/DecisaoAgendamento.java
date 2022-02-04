package com.example.projetofinalitech.Agendamento;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.projetofinalitech.MainActivity;
import com.example.projetofinalitech.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

public class DecisaoAgendamento extends AppCompatActivity {

    private ImageView imageView_profile;
    private TextView txtView_nomeUsuario;
    private BottomNavigationView bottom_navigation;
    private LinearLayout agendar_item, listarAgendamentos;

    private DocumentReference documentReference;
    private FirebaseFirestore fStore;
    private FirebaseAuth fAuth;

    private String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decisao_agendamento);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
//        storageReference = FirebaseStorage.getInstance().getReference();

        imageView_profile = findViewById(R.id.imageView_profile);
        txtView_nomeUsuario = findViewById(R.id.txtView_nomeUsuario);
        bottom_navigation = findViewById(R.id.bottom_navigation);
        agendar_item = findViewById(R.id.agendar_item);
        listarAgendamentos = findViewById(R.id.listarAgendamentos);

        userID = fAuth.getCurrentUser().getUid();

        documentReference = fStore.collection("Usuarios").document(userID);
        documentReference.addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
                txtView_nomeUsuario.setText(value.getString("nome"));
            }
        });

        bottom_navigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.page_1:
                        finish();
                        startActivity(new Intent(DecisaoAgendamento.this, MainActivity.class));
                        break;

                    case R.id.page_2:
//                        finish();
//                        startActivity(new Intent(DecisaoAgendamento.this, Me.class));
//                        break;

                    default:
                        break;
                }

                return false;
            }
        });

        agendar_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(DecisaoAgendamento.this, Agendamento.class));
            }
        });

        listarAgendamentos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(DecisaoAgendamento.this, MeusAgendamentos.class));
            }
        });

    }
}