package com.mycompany.ObliDDA.domino;

public class Puesto {
    private Sector sector;
    private Trabajador trabajador;
    private int numeroPuesto;
    private Llamada llamadaEnCurso;

    public Puesto(int numeroPuesto) {
        this.numeroPuesto = numeroPuesto;
    }
  
    public Sector getSector() {
        return sector;
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
    
    
}
