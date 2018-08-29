package com.example.paola.cogornonew;

public class Personale {

    private int id_personale;
    private String nome_personale;
    private String cognome_personale;
    private String funzione_personale;
    private String residenza_personale;
    private String telefono_personale;
    private String titolo_personale;

    public Personale(int id_personale, String nome_personale, String cognome_personale, String funzione_personale, String residenza_personale, String telefono_personale, String titolo) {
        this.id_personale = id_personale;
        this.nome_personale = nome_personale;
        this.cognome_personale = cognome_personale;
        this.funzione_personale = funzione_personale;
        this.residenza_personale = residenza_personale;
        this.telefono_personale = telefono_personale;
        this.titolo_personale = titolo;
    }

    public int getId_personale() { return id_personale; }

    public void setId_personale(int id_personale) { this.id_personale = id_personale; }

    public String getNome_personale() { return nome_personale; }

    public void setNome_personale(String intestazione_personale) { this.nome_personale = nome_personale; }

    public String getCognome_personale() { return cognome_personale; }

    public void setCognome_personale(String cognome_personale) { this.nome_personale = cognome_personale; }

    public String getFunzione_personale() { return funzione_personale; }

    public void setFunzione_personale(String funzione_personale) { this.funzione_personale = funzione_personale; }

    public String getResidenza_personale() { return residenza_personale; }

    public void setResidenza_personale(String residenza_personale) { this.residenza_personale = residenza_personale; }

    public String getTelefono_personale() { return telefono_personale; }

    public void setTelefono_personale(String telefono_personale) { this.telefono_personale = telefono_personale; }
}
