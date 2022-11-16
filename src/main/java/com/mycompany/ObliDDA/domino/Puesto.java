package com.mycompany.ObliDDA.domino;

import java.util.ArrayList;
import java.util.Date;
<<<<<<< HEAD
=======
import java.util.concurrent.TimeUnit;
import observer.Observable;
import observer.Observer;
>>>>>>> fc9efa6 (Implentacion Exitosa de observer)

public class Puesto extends Observable implements Observer{

    private Sector sector;
    private Trabajador trabajador;
    private Llamada llamadaEnCurso;
    private ArrayList<Llamada> llamadas;
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

    public ArrayList<Llamada> getLlamadas() {
        return llamadas;
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


    public void finalizarLlamada(String descripcion) {
        if (llamadaEnCurso != null) {
            llamadaEnCurso.setFin(new Date());
            llamadaEnCurso.setDescripcion(descripcion);
            llamadas.add(llamadaEnCurso);
        }
    }

    public void agregarLlamada(Llamada call) {
        if (call.getFin() != null) {
            llamadas.add(call);
        } else {
            llamadaEnCurso = call;
            llamadaEnCurso.setAtencion(new Date());
            llamadaEnCurso.addObserver(this);
            llamadaAtendida();
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
    
    public void llamadaAtendida() {
        notifyObservers(Observer.Eventos.LlamadaAtendida);
    }
    
    public void llamadaFinalizada() {
        notifyObservers(Observer.Eventos.LlamadaFinalizada);
    }

    @Override
    public void update(Observable source, Object event) {
        if(event.equals(Observer.Eventos.LlamadaFinalizada)){
            notifyObservers(Observer.Eventos.LlamadaFinalizada);
        }
    }
}
