package com.mycompany.ObliDDA.domino;

import java.util.Date;

public class Llamada {

    private Date inicio;
    private Date fin;
    private String descripcion;
    private Cliente cliente;

    public Llamada(Date inicio, Date fin, String descripcion) {
        this.inicio = inicio;
        this.fin = fin;
        this.descripcion = descripcion;
        this.cliente = null;
    }

    public Llamada() {
        this.inicio = new Date();

    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getInicio() {
        return inicio;
    }

    public Date getFin() {
        return fin;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setFin(Date fin) {
        this.fin = fin;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
