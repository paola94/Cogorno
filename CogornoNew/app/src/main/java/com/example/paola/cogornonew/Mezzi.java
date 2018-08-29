package com.example.paola.cogornonew;

public class Mezzi {
    private int idMezzo;
    private String quantita, tipologia, locazione, disponibilita, targa, proprietario;

    public Mezzi(int idMezzo, String quantita, String tipologia, String locazione, String disponibilita, String targa, String proprietario) {
        this.idMezzo = idMezzo;
        this.quantita = quantita;
        this.tipologia = tipologia;
        this.locazione = locazione;
        this.disponibilita = disponibilita;
        this.targa = targa;
        this.proprietario = proprietario;
    }

    public int getIdMezzo() { return idMezzo; }

    public void setIdMezzo(int idMezzo) { this.idMezzo = idMezzo; }

    public String getQuantita() { return quantita; }

    public void setQuantita(String quantita) { this.quantita = quantita; }

    public String getTipologia() { return tipologia; }

    public void setTipologia(String tipologia) { this.tipologia = tipologia; }

    public String getLocazione() { return locazione; }

    public void setLocazione(String locazione) { this.locazione = locazione; }

    public String getDisponibilita() { return disponibilita; }

    public void setDisponibilita(String disponibilita) { this.disponibilita = disponibilita; }

    public String getTarga() { return targa; }

    public void setTarga(String targa) { this.targa = targa; }

    public String getProprietario() { return proprietario; }

    public void setProprietario(String proprietario) { this.proprietario = proprietario; }
}
