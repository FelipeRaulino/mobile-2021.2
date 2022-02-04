package com.example.projetofinalitech.Pedidos;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projetofinalitech.Agendamento.AgendamentoModel;
import com.example.projetofinalitech.Agendamento.MeusAgendamentos;
import com.example.projetofinalitech.Agendamento.ViewHolder;
import com.example.projetofinalitech.Pedidos.ViewHolderPedidos;
import com.example.projetofinalitech.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.List;

class CustomAdapterPedido extends RecyclerView.Adapter<ViewHolderPedidos> {

    private MeusPedidos meusPedidos;
    private List<Pedido> listaDePedidos;
    private FirebaseFirestore db;
    private DocumentReference documentReference;

    public CustomAdapterPedido(MeusPedidos meusPedidos, List<Pedido> listaDePedidos) {
        this.meusPedidos = meusPedidos;
        this.listaDePedidos = listaDePedidos;
    }

    @NonNull
    @Override
    public ViewHolderPedidos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.pedido_item, parent, false);

        ViewHolderPedidos viewHolder = new ViewHolderPedidos(itemView);

        viewHolder.setOnClickListener(new ViewHolder.ClickListener() {
            @Override
            public void onItemClick(View view, int position) {

            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderPedidos holder, int position) {
        db = FirebaseFirestore.getInstance();

        String idProduto = listaDePedidos.get(position).getIdProduto();

        documentReference = db.collection("Produto").document(idProduto);

        documentReference.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                DocumentSnapshot document = task.getResult();
                holder.textView_nome.setText(document.getString("nome"));
                holder.textView_preco.setText(document.getString("preco"));
                holder.textView_tipo.setText(document.getString("tipo"));
            }
        });

    }

    @Override
    public int getItemCount() {
        return listaDePedidos.size();
    }
}
