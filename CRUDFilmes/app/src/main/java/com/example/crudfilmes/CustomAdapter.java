package com.example.crudfilmes;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<ViewHolder> {

    private ListFilmes listFilmes;
    private List<Filme> filmesList;

    private final int limit = 3;

    public CustomAdapter(ListFilmes listFilmes, List<Filme> filmesList) {
        this.listFilmes = listFilmes;
        this.filmesList = filmesList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.filme_item, parent, false);

        ViewHolder viewHolder = new ViewHolder(itemView);

        viewHolder.setOnClickListener(new ViewHolder.ClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(listFilmes, "Clicou!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(View view, int position) {
                Toast.makeText(listFilmes, "Longo clique!", Toast.LENGTH_SHORT).show();
            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.txtView_tituloM.setText(filmesList.get(position).getTitulo());
        holder.txtView_categoriaM.setText(filmesList.get(position).getCategoria());
        holder.txtView_lancamentoM.setText(filmesList.get(position).getDataDeLancamento());
        holder.txtView_diretorM.setText(filmesList.get(position).getDiretor());

        holder.imgView_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = filmesList.get(position).getId();
                String titulo = filmesList.get(position).getTitulo();
                String categoria = filmesList.get(position).getCategoria();
                String dataLancamento = filmesList.get(position).getDataDeLancamento();
                String diretor = filmesList.get(position).getDiretor();

                Intent intent = new Intent(listFilmes, MainActivity.class);
                intent.putExtra("id", id);
                intent.putExtra("titulo", titulo);
                intent.putExtra("categoria", categoria);
                intent.putExtra("dataLancamento", dataLancamento);
                intent.putExtra("diretor", diretor);

                listFilmes.startActivity(intent);

            }
        });

        holder.imgView_remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listFilmes.deleteData(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return filmesList.size();
    }
}
