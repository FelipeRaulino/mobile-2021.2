package com.example.crudfilmes;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder {

    TextView txtView_tituloM, txtView_categoriaM, txtView_lancamentoM, txtView_diretorM;
    ImageView imgView_edit, imgView_remove;
    View view;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);

        view = itemView;

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mClickListener.onItemClick(v, getAdapterPosition());
            }
        });

        itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                mClickListener.onItemLongClick(v, getAdapterPosition());
                return true;
            }
        });

        txtView_tituloM = view.findViewById(R.id.txtView_tituloM);
        txtView_categoriaM = view.findViewById(R.id.txtView_categoriaM);
        txtView_lancamentoM = view.findViewById(R.id.txtView_lancamentoM);
        txtView_diretorM = view.findViewById(R.id.txtView_diretorM);
        imgView_edit = view.findViewById(R.id.imgView_edit);
        imgView_remove = view.findViewById(R.id.imgView_remove);
    }

    private ViewHolder.ClickListener mClickListener;

    public interface ClickListener{
        void onItemClick(View view, int position);
        void onItemLongClick(View view, int position);
    }

    public void setOnClickListener(ViewHolder.ClickListener clickListener){
        mClickListener = clickListener;
    }
}
