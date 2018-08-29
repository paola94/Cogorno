package com.example.paola.cogornonew;

public class SedeComunale {
    private int id_sede;
    private int idStruttura;
    private String altitudine;
    private String latitudineSess;
    private String longitudineSess;
    private String latitudineDec;
    private String longitudineDec;

    public SedeComunale(int id_sede, int idStruttura, String altitudine, String latitudineSess, String longitudineSess, String latitudineDec, String longitudineDec) {
        this.id_sede = id_sede;
        this.idStruttura = idStruttura;
        this.altitudine = altitudine;
        this.latitudineSess = latitudineSess;
        this.longitudineSess = longitudineSess;
        this.latitudineDec = latitudineDec;
        this.longitudineDec = longitudineDec;
    }

    public int getId_sede() {
        return id_sede;
    }

    public void setId_sede(int id_sede) {
        this.id_sede = id_sede;
    }

    public int getIdStruttura() {
        return idStruttura;
    }

    public void setIdStruttura(int idStruttura) {
        this.idStruttura = idStruttura;
    }

    public String getAltitudine() {
        return altitudine;
    }

    public void setAltitudine(String altitudine) {
        this.altitudine = altitudine;
    }

    public String getLatitudineSess() {
        return latitudineSess;
    }

    public void setLatitudineSess(String latitudineSess) {
        this.latitudineSess = latitudineSess;
    }

    public String getLongitudineSess() {
        return longitudineSess;
    }

    public void setLongitudineSess(String longitudineSess) {
        this.longitudineSess = longitudineSess;
    }

    public String getLatitudineDec() {
        return latitudineDec;
    }

    public void setLatitudineDec(String latitudineDec) {
        this.latitudineDec = latitudineDec;
    }

    public String getLongitudineDec() {
        return longitudineDec;
    }

    public void setLongitudineDec(String longitudineDec) {
        this.longitudineDec = longitudineDec;
    }
}
