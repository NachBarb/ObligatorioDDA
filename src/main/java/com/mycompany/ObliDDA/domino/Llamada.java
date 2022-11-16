package com.mycompany.ObliDDA.domino;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import observer.Observable;
import observer.Observer;

public class Llamada extends Observable {

    private Date inicio;
    private Date atencion;
    private Date fin;
    private String descripcion;
    private Cliente cliente;
    private Puesto puesto; 
    private String nombreTrabajador;
    private static int serial = 1;
    private int id;

    public Llamada(Cliente cliente) {
        this.inicio = new Date();
        this.cliente = cliente;
        this.id = serial++;
    }
    
    public Llamada(Date inicio, Date atencion, Date fin, String descripcion, Cliente cliente, Puesto puesto, String nombreTrabajador) {
        this.inicio = inicio;
        this.atencion = atencion;
        this.fin = fin;
        this.descripcion = descripcion;
        this.cliente = cliente;
        this.puesto = puesto;
        this.nombreTrabajador = nombreTrabajador;
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
    
    public void iniciarLlamada(){
    notifyObservers(Observer.Eventos.LlamadaIniciada);
    }
    
    public void llamadaAtendida() {
        notifyObservers(Observer.Eventos.LlamadaAtendida);
    }

    public void finalizarLlamada() {
        notifyObservers(Observer.Eventos.LlamadaFinalizada);
    }

    @Override
    public String toString() {
        String estado;
        String iniciada = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(this.inicio).toString();
        String atendida = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(this.atencion).toString();
        String finalizada;
        String numPuesto = Integer.toString(puesto.getId());
        String nomTrabajador = nombreTrabajador;
        String duracion = Integer.toString(duracion());
        String costo = "aca va el costo";
        String nomCliente = this.cliente.getNombre();
        String saldo = Double.toString(this.cliente.getSaldo());
        
        if (fin == null) {
            estado = "En curso";
            finalizada = "***";
        } else {
            estado = "Finalizado";
            finalizada = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(this.fin).toString();
        }    
        
        return estado + " - " + iniciada + " - " + atendida + " - " + finalizada + " - " + 
               numPuesto + " - " + nomTrabajador + " - " + duracion + " - " + costo + " - " + nomCliente + " - " + saldo;
    }

}
