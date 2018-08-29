package com.example.paola.cogornonew;

public class Materiali {
    private int id_materiale;
    private String quantita, genere, locazione, disponibilita;

    public Materiali(int id_materiale, String quantita, String genere, String locazione, String disponibilita) {
        this.id_materiale = id_materiale;
        this.quantita = quantita;
        this.genere = genere;
        this.locazione = locazione;
        this.disponibilita = disponibilita;
        }


    public int getId_materiale() {
        return id_materiale;
    }

    public void setId_materiale(int id_materiale) {
        this.id_materiale = id_materiale;
    }

    public String getQuantita() {
        return quantita;
    }

    public void setQuantita(String quantita) {
        this.quantita = quantita;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    public String getLocazione() {
        return locazione;
    }

    public void setLocazione(String locazione) {
        this.locazione = locazione;
    }

    public String getDisponibilita() {
        return disponibilita;
    }

    public void setDisponibilita(String disponibilita) {
        this.disponibilita = disponibilita;
    }
}
