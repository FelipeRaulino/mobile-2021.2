package com.example.navegacaotelas.transactions;

public class Filme {
    private static int contadorId = 0;

    private int id;
    private String nome;
    private String categoria;
    private String anoLancamento;
    private String diretor;

    public Filme(String nome, String categoria, String anoLancamento, String diretor) {
        this.id = contadorId++;

        this.nome = nome;
        this.categoria = categoria;
        this.anoLancamento = anoLancamento;
        this.diretor = diretor;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(String anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    @Override
    public String toString() {
        return nome;
    }
}
