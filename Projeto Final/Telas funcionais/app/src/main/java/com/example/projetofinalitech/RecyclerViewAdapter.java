package com.example.projetofinalitech;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<ViewHolder> {

    private final ArrayList<Produto> listaProdutos;
    private Produtos produtos;

    RecyclerViewAdapter(Produtos produtos, ArrayList<Produto> listaProdutos){
        this.produtos = produtos;
        this.listaProdutos = listaProdutos;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.produto_item, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);

        viewHolder.setOnClickListener(new ViewHolder.ClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                String id = listaProdutos.get(position).getId();
                String nome = listaProdutos.get(position).getNome();
                String preco = listaProdutos.get(position).getPreco();

                Intent intent = new Intent(produtos, ProdutoIndividual.class);
                intent.putExtra("id", id);
                intent.putExtra("nome", nome);
                intent.putExtra("preco", preco);

                produtos.startActivity(intent);

            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtView_preco.setText(listaProdutos.get(position).getPreco());
        holder.txtView_descricaoProduto.setText(listaProdutos.get(position).getNome());
    }

    @Override
    public int getItemCount() {
        return listaProdutos.size();
    }


}
