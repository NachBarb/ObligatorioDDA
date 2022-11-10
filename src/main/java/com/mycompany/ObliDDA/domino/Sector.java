package com.mycompany.ObliDDA.domino;

import java.util.ArrayList;

public class Sector {
    private String nombre;
    private int numSector;
    private int cantidadPuestos;
    private ArrayList<Puesto> puestos;

    public Sector(String nombre, int numSector, int cantidadPuestos) {
        this.nombre = nombre;
        this.numSector = numSector;
        this.cantidadPuestos = cantidadPuestos;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNumSector() {
        return numSector;
    }

    public int getCantidadPuestos() {
        return cantidadPuestos;
    }

    public ArrayList<Puesto> getPuestos() {
        return puestos;
    }   
    
    public void asignarPuestoASector(Puesto p) {
        int existePuesto = 0;
        if (puestos.size() < cantidadPuestos) {
            for (int i = 0; i < puestos.size(); i++) {
                if (puestos.get(i).getNumeroPuesto() == p.getNumeroPuesto()) {
                    existePuesto ++;
                }
            }
            if (existePuesto == 0) {
                puestos.add(p);
            }
        }
    }
    
    public Puesto asignarTrabajador(Trabajador t) {
        Puesto puesto = null;
        boolean flag = false;
        for (int i = 0; i < puestos.size() && !flag; i++) {
            if (puestos.get(i) == null){
                puesto = puestos.get(i);
                puesto.setTrabajador(t);
                flag = true;
            }
        }
        return puesto;
    }
    
    //asignarLlamada()
}
