package com.mycompany.ObliDDA.domino;

public class Cliente {
    private String nombre;
    private String ci;
    private double saldo;
    
    public Cliente(String nombre, String ci) {
        this.nombre = nombre;
        this.ci = ci;
        this.saldo = 0;
    }

    public Cliente(String nombre, String ci, double saldo) {
        this.nombre = nombre;
        this.ci = ci;
        this.saldo = saldo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCi() {
        return ci;
    }   

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
}
