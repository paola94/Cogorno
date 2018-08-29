package com.example.paola.cogornonew;

public class Vie {
    private int id_via;
    private String nome;
    private int idComune;

    public Vie(int id_via,String nome, int idComune) {
        this.id_via = id_via;
        this.nome = nome;
        this.idComune = idComune;
    }

    public int getId_via() {
        return id_via;
    }

    public void setId_via(int id_via) {
        this.id_via = id_via;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdComune() {
        return idComune;
    }

    public void setIdComune(int idComune) {
        this.idComune = idComune;
    }
}
