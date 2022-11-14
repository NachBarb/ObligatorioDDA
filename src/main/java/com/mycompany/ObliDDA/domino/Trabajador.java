package com.mycompany.ObliDDA.domino;

public class Trabajador {

    private String ci;
    private String nombre;
    private String pass;
    private Sector sector;
    private Puesto puesto;

    public Puesto getPuesto() {
        return puesto;
    }

    public void setPuesto(Puesto puesto) {
        this.puesto = puesto;
    }

    public Sector getSector() {
        return sector;
    }

    public String getCi() {
        return this.ci;
    }

    public String getNombre() {
        return this.nombre;
    }

    public Trabajador(String nombre, String ci, String pass, Sector sector) {
        this.ci = ci;
        this.nombre = nombre;
        this.pass = pass;
        this.sector = sector;
        this.puesto = null;
    }

    public boolean esPassValida(String passToValidate) {
        return passToValidate.equals(this.pass);
    }
}
