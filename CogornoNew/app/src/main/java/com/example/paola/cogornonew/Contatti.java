package com.example.paola.cogornonew;

public class Contatti {

    private int id_contatti;
    private int idStruttura;
    private String nome;
    private String cognome;
    private String tipo;
    private String valore;

    public Contatti (Contatti c){
        this.id_contatti = c.getId_contatti();
        this.idStruttura = c.getIdStruttura();
        this.nome = c.getNome();
        this.cognome = c.getCognome();
        this.tipo = c.getTipo();
        this.valore = c.getValore();
    }



    public Contatti(int id_contatti, int idStruttura, String nome, String cognome, String tipo, String valore) {

        this.id_contatti = id_contatti;
        this.idStruttura = idStruttura;
        this.nome = nome;
        this.cognome = cognome;
        this.tipo = tipo;
        this.valore = valore;
    }

    public int getId_contatti() {
        return id_contatti;
    }

    public void setId_contatti(int id_contatti) {
        this.id_contatti = id_contatti;
    }

    public int getIdStruttura() {
        return idStruttura;
    }

    public void setIdStruttura(int idStruttura) {
        this.idStruttura = idStruttura;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getValore() {
        return valore;
    }

    public void setValore(String valore) {
        this.valore = valore;
    }
}
