package com.mycompany.ObliDDA.domino;

import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Puesto {

    private Sector sector;
    private Trabajador trabajador;
    private int numeroPuesto;
    private Llamada llamadaEnCurso;
    private ArrayList<Llamada> llamadas;

    public Puesto(int numeroPuesto, Sector sector) {
        this.numeroPuesto = numeroPuesto;
        this.sector = sector;
        this.trabajador = null;
        this.llamadaEnCurso = null;
        this.llamadas = new ArrayList<>();
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

    public int promedioTiempoLlamada() {
        long totalSeconds = 0;
        for (int i = 0; i < llamadas.size(); i++) {
            if (llamadas.get(i) != null) {
                long difMiliSeconds = Math.abs(llamadas.get(i).getFin().getTime() - llamadas.get(i).getInicio().getTime());
                long seconds = (difMiliSeconds/1000);
                totalSeconds = totalSeconds + seconds;
            }
        }
        int secondsInInt = (int)totalSeconds;
        return secondsInInt;
    }
}
