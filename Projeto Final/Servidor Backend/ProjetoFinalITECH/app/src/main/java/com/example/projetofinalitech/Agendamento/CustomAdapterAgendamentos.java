package com.example.projetofinalitech.Agendamento;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projetofinalitech.Pedidos.MeusPedidos;
import com.example.projetofinalitech.Pedidos.Pedido;
import com.example.projetofinalitech.R;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapterAgendamentos extends RecyclerView.Adapter<ViewHolder>{

    private MeusAgendamentos meusAgendamentos;
    private List<AgendamentoModel> listaDeAgendamentos;

    public CustomAdapterAgendamentos(MeusAgendamentos meusAgendamentos, List<AgendamentoModel> listaDeAgendamentos) {
        this.meusAgendamentos = meusAgendamentos;
        this.listaDeAgendamentos = listaDeAgendamentos;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.agendamento_item, parent, false);

        ViewHolder viewHolder = new ViewHolder(itemView);

        viewHolder.setOnClickListener(new ViewHolder.ClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(meusAgendamentos, "Clicou!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(View view, int position) {
                Toast.makeText(meusAgendamentos, "Longo clique!", Toast.LENGTH_SHORT).show();
            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textView_tipoDispositivo.setText(listaDeAgendamentos.get(position).getTipoDispositivo());
        holder.textView_modelo.setText(listaDeAgendamentos.get(position).getModeloDispositivo());
        holder.textView_dia.setText(listaDeAgendamentos.get(position).getDia());
        holder.textView_horario.setText(listaDeAgendamentos.get(position).getHorario());
    }

    @Override
    public int getItemCount() {
        return listaDeAgendamentos.size();
    }


}
