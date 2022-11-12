package com.mycompany.ObliDDA.domino;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Llamada {
    private Date inicio;
    private Date fin;
    private String descripcion;
    private Cliente cliente;
    private static int serial = 1;
    private int id;
    
    public Llamada(Cliente cliente) {
        this.inicio = new Date();
        this.cliente = cliente;
        this.id = serial++;
    }
    
    public Llamada(Date inicio, Date fin, String descripcion, Cliente cliente) {
        this.inicio = inicio;
        this.fin = fin;
        this.descripcion = descripcion;
        this.cliente = cliente;
        this.id = serial++;
    }

    public int getId() {
        return id;
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
    
    public int duracion() {
        long delta = getFin().getTime() - getInicio().getTime();
        TimeUnit time = TimeUnit.SECONDS;
        int result = (int)time.convert(delta, TimeUnit.MILLISECONDS);
        return result; 
    }
    
    public void finalizarLlamada() {
        setFin(new Date());
    }
}
