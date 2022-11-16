package com.mycompany.ObliDDA.domino;

public class CostoLlamada {
    // Constante
    private static double costoFijoPorSegundos = 1;

    private static double descuentoPorEspera = 0.5;
    private Cliente cliente;
    private Llamada llamada;

    public Llamada getLlamada() {
        return llamada;
    }
    
    public CostoLlamada(Cliente cliente ,Llamada llamada){
    
        this.llamada= llamada;
        this.cliente = cliente;
    }
    
    public static double getCostoFijoPorSegundos() {
        return costoFijoPorSegundos;
    }

    public static double getDescuentoPorEspera() {
        return descuentoPorEspera;
    }
    
    public double CostoToal(){
    return cliente.getTipoCliente().calculoCosto(this);
    }
}
