package com.example.crudfilmes;

import java.util.ArrayList;

public class Filme {

    private String id;
    private String titulo;
    private String categoria;
    private String dataDeLancamento;
    private String diretor;

    public Filme(){}

    public Filme(String id, String titulo, String categoria, String dataDeLancamento, String diretor) {
        this.id = id;
        this.titulo = titulo;
        this.categoria = categoria;
        this.dataDeLancamento = dataDeLancamento;
        this.diretor = diretor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDataDeLancamento() {
        return dataDeLancamento;
    }

    public void setDataDeLancamento(String dataDeLancamento) {
        this.dataDeLancamento = dataDeLancamento;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }
}
