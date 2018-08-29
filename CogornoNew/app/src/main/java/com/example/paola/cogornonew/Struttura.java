package com.example.paola.cogornonew;

public class Struttura {
    private int id_struttura;
    private String nome;
    private int idVie;
    private int idComune;
    private String tipo;

    public Struttura(int id_struttura, String nome, int idVie, int idComune, String tipo) {
        this.id_struttura = id_struttura;
        this.nome = nome;
        this.idVie = idVie;
        this.idComune = idComune;
        this.tipo = tipo;
    }

    public int getId_struttura() {
        return id_struttura;
    }

    public void setId_struttura(int id_struttura) {
        this.id_struttura = id_struttura;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdVie() {
        return idVie;
    }

    public void setIdVie(int idVie) {
        this.idVie = idVie;
    }

    public int getIdComune() { return idComune; }

    public void setIdComune(int idComune) { this.idComune = idComune; }

    public String getTipo() { return tipo; }

    public void setTipo(String tipo) { this.tipo = tipo; }
}
