package com.example.paola.cogornonew;

public class UtenteAut {
    private String nome_utenteAut;
    private String cognome_utenteAut;
    private String ruolo_utenteAut;

    public UtenteAut(String nome_utenteAut, String cognome_utenteAut, String ruolo_utenteAut){
        this.nome_utenteAut = nome_utenteAut;
        this.cognome_utenteAut = cognome_utenteAut;
        this.ruolo_utenteAut = ruolo_utenteAut;
    }

    public String getNome_utenteAut() {
        return nome_utenteAut;
    }

    public void setNome_utenteAut(String nome_utenteAut) {
        this.nome_utenteAut = nome_utenteAut;
    }

    public String getCognome_utenteAut() {
        return cognome_utenteAut;
    }

    public void setCognome_utenteAut(String cognome_utenteAut) {
        this.cognome_utenteAut = cognome_utenteAut;
    }

    public String getRuolo_utenteAut() {
        return ruolo_utenteAut;
    }

    public void setRuolo_utenteAut(String ruolo_utenteAut) {
        this.ruolo_utenteAut = ruolo_utenteAut;
    }

}
