package com.mycompany.ObliDDA.domino;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import observer.Observable;
import observer.Observer;


public class Llamada extends Observable {

    private Date inicio;
    private Date atencion; //
    private Date fin;
    private String descripcion;
    private Cliente cliente;
    private Puesto puesto; //
    private static int serial = 1;
    private int id;
    
    public Llamada(Cliente cliente) {
        this.inicio = new Date();
        this.cliente = cliente;
        this.id = serial++;
    }
    
    public Llamada(Date inicio, Date atencion, Date fin, String descripcion, Cliente cliente, Puesto puesto) {
        this.inicio = inicio;
        this.atencion = atencion;
        this.fin = fin;
        this.descripcion = descripcion;
        this.cliente = cliente;
        this.puesto = puesto;
        this.id = serial++;
    }
   
    public int getId() {
        return id;
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

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getAtencion() {
        return atencion;
    }

    public void setAtencion(Date atencion) {
        this.atencion = atencion;
    }

    public Puesto getPuesto() {
        return puesto;
    }

    public void setPuesto(Puesto puesto) {
        this.puesto = puesto;
    }
    
    //Setear atencion cuando se atiende
    public int duracion() {
        long delta = getFin().getTime() - getAtencion().getTime();
        TimeUnit time = TimeUnit.SECONDS;
        int result = (int) time.convert(delta, TimeUnit.MILLISECONDS);
        return result;
    }

    public void finalizarLlamada() {
        setFin(new Date());
        notifyObservers(Observer.Eventos.LlamadaFinalizada);
    }

}
