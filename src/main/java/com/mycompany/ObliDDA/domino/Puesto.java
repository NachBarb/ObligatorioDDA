package com.mycompany.ObliDDA.domino;

import java.util.ArrayList;
import java.util.Date;

public class Puesto {
    private Sector sector;
    private Trabajador trabajador;
    private int numeroPuesto;
    private Llamada llamadaEnCurso;
    private ArrayList<Llamada> llamadas = new ArrayList<>();

    public Puesto(int numeroPuesto, Sector sector) {
        this.numeroPuesto = numeroPuesto;
        this.sector = sector;
    }
  
    public Sector getSector() {
        return sector;
    }

    public void setTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
    }

    public Trabajador getTrabajador() {
        return trabajador;
    }

    public int getNumeroPuesto() {
        return numeroPuesto;
    }

    public Llamada getLlamadaEnCurso() {
        return llamadaEnCurso;
    }

    public void setLlamadaEnCurso(Llamada llamadaEnCurso) {
        this.llamadaEnCurso = llamadaEnCurso;
    }
    
    public int getCantidadLlamadas() {
        int cantidadLlamadas = llamadas.size();
        if (llamadaEnCurso != null) {
            cantidadLlamadas++;
        }
        return cantidadLlamadas;
    }
    
    public void agregarDescripcionLlamada(Llamada llamadaEnCurso, String descripcion) {
        llamadaEnCurso.setDescripcion(descripcion);
    }
    
    public void finalizarLlamada(Llamada llamadaEnCurso) {
        if (llamadaEnCurso.getFin() == null) {
            llamadaEnCurso.setFin(new Date());
            llamadas.add(llamadaEnCurso);
            llamadaEnCurso = null;            
        }
    }
    
    public void agregarLlamada(Llamada call) {
        llamadas.add(call);
    }
}
