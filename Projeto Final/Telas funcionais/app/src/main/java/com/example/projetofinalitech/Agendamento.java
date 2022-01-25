package com.example.projetofinalitech;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

public class Agendamento extends AppCompatActivity {

    private Spinner spinner;
    private Button btn_agendar;
    private ImageView imgView_voltarHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agendamento);

        spinner = findViewById(R.id.spinner);
        btn_agendar = findViewById(R.id.btn_agendar);
        imgView_voltarHome = findViewById(R.id.imgView_voltarHome);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.opcoes_dispositivos, android.R.layout.simple_spinner_dropdown_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);

        btn_agendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Agendado com sucesso!", Toast.LENGTH_LONG).show();
                finish();
                startActivity(new Intent(Agendamento.this, MainActivity.class));
            }
        });

        imgView_voltarHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(Agendamento.this, MainActivity.class));
            }
        });
    }
}