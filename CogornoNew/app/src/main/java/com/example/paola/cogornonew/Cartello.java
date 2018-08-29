package com.example.paola.cogornonew;

public class Cartello {

    private int idCartello;
    private String quantitaCartello, locCartello;

    public Cartello(int idCartello, String quantitaCartello, String locCartello) {
        this.idCartello = idCartello;
        this.quantitaCartello = quantitaCartello;
        this.locCartello = locCartello;
    }

    public int getIdCartello() {
        return idCartello;
    }

    public void setIdCartello(int idCartello) {
        this.idCartello = idCartello;
    }

    public String getQuantitaCartello() {
        return quantitaCartello;
    }

    public void setQuantitaCartello(String quantitaCartello) {
        this.quantitaCartello = quantitaCartello;
    }

    public String getLocCartello() {
        return locCartello;
    }

    public void setLocCartello(String locCartello) {
        this.locCartello = locCartello;
    }
}
