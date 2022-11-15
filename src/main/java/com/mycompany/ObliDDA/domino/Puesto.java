package com.mycompany.ObliDDA.domino;

import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Puesto {

    private Sector sector;
    private Trabajador trabajador;
    private Llamada llamadaEnCurso;
    private ArrayList<Llamada> llamadas = new ArrayList<>();
    private static int serial = 1;
    private int id;

    public Puesto(Sector sector) {
        this.sector = sector;
        this.trabajador = null;
        this.llamadaEnCurso = null;
        this.llamadas = new ArrayList<>();
        this.id = serial++;
    }

    public int getId() {
        return id;
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

  
    public void finalizarLlamada(Llamada llamadaEnCurso, String descripcion) {
        if (llamadaEnCurso.getFin() == null) {
            llamadaEnCurso.setFin(new Date());
            llamadaEnCurso.setDescripcion(descripcion);
            llamadas.add(llamadaEnCurso);
            llamadaEnCurso = null;
        }
    }

    public void agregarLlamada(Llamada call) {
        if (call.getFin() != null) {
            llamadas.add(call);
        } else {
            llamadaEnCurso = call;
        }
    }

    public int promedioTiempoLlamada() {
        long totalSeconds = 0;
        for (int i = 0; i < llamadas.size(); i++) {
            if (llamadas.get(i) != null) {
                long difMiliSeconds = Math.abs(llamadas.get(i).getFin().getTime() - llamadas.get(i).getInicio().getTime());
                long seconds = (difMiliSeconds / 1000);
                totalSeconds = totalSeconds + seconds;
            }
        }
        int secondsInInt = (int) totalSeconds;
        return secondsInInt;
    }
}
