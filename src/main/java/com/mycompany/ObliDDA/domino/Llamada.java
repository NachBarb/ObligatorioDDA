package com.mycompany.ObliDDA.domino;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import observer.Observable;
import observer.Observer;


public class Llamada extends Observable {

    private static AtomicInteger count = new AtomicInteger(0);
    private int numeroDeLlamada;
    private Date inicio;
    private Date fin;
    private String descripcion;
    private Cliente cliente;


    public Llamada(Cliente cliente) {
        this.inicio = new Date();
        this.cliente = cliente;
    }

    public Llamada(Date inicio, Date fin, String descripcion, Cliente cliente) {
        this.inicio = inicio;
        this.fin = fin;
        this.descripcion = descripcion;
        this.cliente = cliente;
        this.numeroDeLlamada = count.incrementAndGet();

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

    public int duracion() {
        long delta = getFin().getTime() - getInicio().getTime();
        TimeUnit time = TimeUnit.SECONDS;
        int result = (int) time.convert(delta, TimeUnit.MILLISECONDS);
        return result;
    }

    public void finalizarLlamada() {
        setFin(new Date());
        notifyObservers(Observer.Eventos.LlamadaFinalizada);
    }

}
