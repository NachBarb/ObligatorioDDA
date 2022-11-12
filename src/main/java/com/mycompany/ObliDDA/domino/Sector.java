package com.mycompany.ObliDDA.domino;

import java.util.ArrayList;

public class Sector {
    private String nombre;
    private int numSector;
    private int cantidadPuestos;
    private ArrayList<Puesto> puestos = new ArrayList<>();

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
    
    public boolean asignarPuestoASector(Puesto p) {
        boolean ok = false;
        int existePuesto = 0;
        if (puestos.size() < cantidadPuestos) {
            for (int i = 0; i < puestos.size(); i++) {
                if (puestos.get(i).getId() == p.getId()) {
                    existePuesto ++;
                }
            }
            if (existePuesto == 0) {
                puestos.add(p);
                ok = true;
            }
        }
        return ok;
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
          
    public Puesto asignarLlamada(Cliente cliente) {
        Puesto puesto = null;
        Llamada call = null;
        boolean flag = false;
        for (int i = 0; i < puestos.size() && !flag; i++) {
           if (puestos.get(i).getLlamadaEnCurso() == null) {
               call = new Llamada(cliente);
               puesto = puestos.get(i);
               puesto.setLlamadaEnCurso(call);
               flag = true;
           } 
        } //IF PARA EN ESPERA
        return puesto;
    } 
    
    public void asignarLlamada(Puesto puesto, Llamada call) {
        puesto.agregarLlamada(call);
    }
}
