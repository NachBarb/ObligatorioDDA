package com.mycompany.ObliDDA.domino;

import java.util.Date;

public class Llamada {
    private Date inicio;
    private Date fin;
    private String descripcion;

    public Llamada() {
        this.inicio = new Date();

    }
    
    public Llamada(Date inicio, Date fin, String descripcion) {
        this.inicio = inicio;
        this.fin = fin;
        this.descripcion = descripcion;
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
