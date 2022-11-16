package com.mycompany.ObliDDA.domino;

import java.util.ArrayList;

public class Cliente {
    private String nombre;
    private String ci;
    private double saldo;
    private TipoCliente tipoCliente;
    private ArrayList<CostoLlamada> costos;
    
    public Cliente(String nombre, String ci , TipoCliente tipoCliente) {
        this.nombre = nombre;
        this.ci = ci;
        this.saldo = 0;
        this.costos = new ArrayList<CostoLlamada>();
        this.tipoCliente = tipoCliente;
    }

    public Cliente(String nombre, String ci, double saldo, TipoCliente tipoCliente) {
        this.nombre = nombre;
        this.ci = ci;
        this.saldo = saldo;
        this.costos = new ArrayList<CostoLlamada>();
        this.tipoCliente = tipoCliente;
    }

    public TipoCliente getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(TipoCliente tipoCliente) {
        this.tipoCliente = tipoCliente;
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
    
    public void agregarCosto(CostoLlamada costo){
        costos.add(costo);
    }
    
    
    public double saldoDeCliente(){
        double saldoTotal = saldo;
        System.out.println("Saldo" + Double.toString(saldoTotal));
        for(CostoLlamada c : costos){
            System.out.println("Costo" + Double.toString(c.CostoToal()));
        saldoTotal = saldoTotal + c.CostoToal();
        }
    return saldoTotal;
    }
    
}
