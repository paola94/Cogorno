package com.example.paola.cogornonew;

public class Popolazione {

    private int id_popolazione;
    private int idStruttura;
    private String tipo;
    private String quantita;
    private String intestazione;

    public Popolazione(int id_popolazione,int idStruttura, String tipo, String quantita, String intestazione) {
        this.id_popolazione = id_popolazione;
        this.idStruttura = idStruttura;
        this.tipo = tipo;
        this.quantita = quantita;
        this.intestazione = intestazione;
    }

    public int getId_popolazione() {
        return id_popolazione;
    }

    public void setId_popolazione(int id_popolazione) {
        this.id_popolazione = id_popolazione;
    }

    public int getIdStruttura() {
        return idStruttura;
    }

    public void setIdStruttura(int idStruttura) {
        this.idStruttura = idStruttura;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getQuantita() {
        return quantita;
    }

    public void setQuantita(String quantita) {
        this.quantita = quantita;
    }

    public String getIntestazione() { return intestazione; }

    public void setIntestazione(String intestazione) { this.intestazione = intestazione; }
}
