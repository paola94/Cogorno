package com.example.paola.cogornonew;

public class Utente {
    private int id_utente;
    private String nome_utente;
    private String cognome_utente;
    private String ruolo_utente;
    private String username_utente;
    private String password_utente;

    public Utente(String nome_utente, String cognome_utente, String ruolo_utente, String username_utente, String password_utente){
        this.nome_utente = nome_utente;
        this.cognome_utente = cognome_utente;
        this.ruolo_utente = ruolo_utente;
        this.username_utente = username_utente;
        this.password_utente = password_utente;
    }

    public int getId_utente() {
        return id_utente;
    }

    public void setId_utente(int id_utente) {
        this.id_utente = id_utente;
    }

    public String getNome_utente() {
        return nome_utente;
    }

    public void setNome_utente(String nome_utente) {
        this.nome_utente = nome_utente;
    }

    public String getCognome_utente() {
        return cognome_utente;
    }

    public void setCognome_utente(String cognome_utente) {
        this.cognome_utente = cognome_utente;
    }

    public String getRuolo_utente() {
        return ruolo_utente;
    }

    public void setRuolo_utente(String ruolo_utente) {
        this.ruolo_utente = ruolo_utente;
    }

    public String getUsername_utente() {
        return username_utente;
    }

    public void setUsername_utente(String username_utente) {
        this.username_utente = username_utente;
    }

    public String getPassword_utente() {
        return password_utente;
    }

    public void setPassword_utente(String password_utente) {
        this.password_utente = password_utente;
    }
}
