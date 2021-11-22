package com.example.navegacaotelas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.navegacaotelas.transactions.Constants;

public class MovieActivity extends AppCompatActivity {

    EditText editTextNome;
    EditText editTextCategoria;
    EditText editTextAnoLancamento;
    EditText editTextDiretor;

    boolean edit;
    int idContatoEditar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        editTextNome = findViewById(R.id.editTextNome);
        editTextCategoria = findViewById(R.id.editTextCategoria);
        editTextAnoLancamento = findViewById(R.id.editTextAnoLancamento);
        editTextDiretor = findViewById(R.id.editTextDiretor);

        edit = false;

        if (getIntent().getExtras() != null){
            String nome = (String) getIntent().getExtras().get("nome");
            String categoria = (String) getIntent().getExtras().get("categoria");
            String anoLancamento = (String) getIntent().getExtras().get("anoLancamento");
            String diretor = (String) getIntent().getExtras().get("diretor");
            idContatoEditar = (int) getIntent().getExtras().get("id");

            editTextNome.setText(nome);
            editTextCategoria.setText(categoria);
            editTextAnoLancamento.setText(anoLancamento);
            editTextDiretor.setText(diretor);

            edit = true;
        }
    }

    public void adicionar(View view){
        Intent intent = new Intent();

        String nome = editTextNome.getText().toString();
        intent.putExtra("nome", nome);

        String categoria = editTextCategoria.getText().toString();
        intent.putExtra("categoria", categoria);

        String anoLancamento = editTextAnoLancamento.getText().toString();
        intent.putExtra("anoLancamento", anoLancamento);

        String diretor = editTextDiretor.getText().toString();
        intent.putExtra("diretor", diretor);

        if (edit) intent.putExtra("id", idContatoEditar);

        setResult(Constants.RESULT_ADD, intent);

        finish();
    }

    public void cancelar(View view){
        setResult(Constants.RESULT_CANCEL);
        finish();
    }
}