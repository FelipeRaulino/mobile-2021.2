package com.example.navegacaotelas;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.navegacaotelas.transactions.Constants;
import com.example.navegacaotelas.transactions.Filme;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    int selected;
    ArrayList<Filme> listaFilmes;
    ArrayAdapter adapter;
    ListView listViewFilmes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        selected = -1;

        listaFilmes = new ArrayList<Filme>();

        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaFilmes);

        listViewFilmes = findViewById(R.id.listViewFilmes);
        listViewFilmes.setAdapter(adapter);
        listViewFilmes.setSelector(android.R.color.holo_blue_light);

        listViewFilmes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selected = position;
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main_activity, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.add:
                clicarAdicionar();
                break;
            case R.id.edit:
                clicarEditar();
                break;
            case R.id.delete:
                removerItemLista();
                break;
            case R.id.settings:
                break;
            case R.id.about:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void removerItemLista(){
        if (selected >= 0){
            listaFilmes.remove(selected);
            adapter.notifyDataSetChanged();
        }else{
            Toast.makeText(this, "Selecione um item para remover", Toast.LENGTH_SHORT).show();
        }
    }

    public void clicarAdicionar(){
        Intent contact = new Intent(this, MovieActivity.class);
        startActivityForResult(contact, Constants.REQUEST_ADD);
    }

    public void clicarEditar(){
        Intent contact = new Intent(this, MovieActivity.class);

        if (selected >= 0){
            Filme filme = listaFilmes.get(selected);

            contact.putExtra("nome", filme.getNome());
            contact.putExtra("categoria", filme.getCategoria());
            contact.putExtra("anoLancamento", filme.getAnoLancamento());
            contact.putExtra("diretor", filme.getDiretor());
            contact.putExtra("id", filme.getId());

            startActivityForResult(contact, Constants.REQUEST_EDIT);

        }else{
            Toast.makeText(MainActivity.this, "Selecione um item", Toast.LENGTH_SHORT).show();
        }


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == Constants.REQUEST_ADD && resultCode == Constants.RESULT_ADD){
            String nome = (String) data.getExtras().get("nome");
            String categoria = (String) data.getExtras().get("categoria");
            String anoLancamento = (String) data.getExtras().get("anoLancamento");
            String diretor = (String) data.getExtras().get("diretor");

            Filme filme = new Filme(nome, categoria, anoLancamento, diretor);

            listaFilmes.add(filme);
            adapter.notifyDataSetChanged();
        }else if (requestCode == Constants.REQUEST_EDIT && resultCode == Constants.RESULT_ADD){

            String nome = (String) data.getExtras().get("nome");
            String categoria = (String) data.getExtras().get("categoria");
            String anoLancamento = (String) data.getExtras().get("anoLancamento");
            String diretor = (String) data.getExtras().get("diretor");
            int idEditar = (int) data.getExtras().get("id");

            for(Filme filme: listaFilmes){
                if(filme.getId() == idEditar){
                    filme.setNome(nome);
                    filme.setCategoria(categoria);
                    filme.setAnoLancamento(anoLancamento);
                    filme.setDiretor(diretor);
                }
            }

            adapter.notifyDataSetChanged();
        }else if(resultCode == Constants.RESULT_CANCEL){
            Toast.makeText(this, "Cancelado", Toast.LENGTH_LONG).show();
        }
    }
}

















