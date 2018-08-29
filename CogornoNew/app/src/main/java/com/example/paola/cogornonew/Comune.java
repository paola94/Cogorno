package com.example.paola.cogornonew;

public class Comune {

    private int id_comune;
    private String nome_comune;

    public Comune(int id_comune, String nome_comune) {
        this.id_comune = id_comune;
        this.nome_comune = nome_comune;
    }

    public int getId_comune() {
        return id_comune;
    }

    public void setId_comune(int id_comune) {
        this.id_comune = id_comune;
    }

    public String getNome_comune() {
        return nome_comune;
    }

    public void setNome_comune(String nome_comune) {
        this.nome_comune = nome_comune;
    }
}
