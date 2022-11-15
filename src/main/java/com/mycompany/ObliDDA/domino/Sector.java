package com.mycompany.ObliDDA.domino;

import java.util.ArrayList;

public class Sector {


    @Override
    public String toString() {
        return  id + "- " + nombre;
    }
    
    private String nombre;
    private int cantidadPuestos;
    private ArrayList<Puesto> puestos = new ArrayList<>();
    private static int serial = 1;
    private int id;
    
    private static final String PUESTOS_ASIGNADOS = "No hay puestos disponibles";
    
    public Sector(String nombre, int cantidadPuestos) {

        this.nombre = nombre;
        this.cantidadPuestos = cantidadPuestos;
        this.id = serial++;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
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

    public Puesto asignarTrabajador(Trabajador t) throws TrabajadorExcepcion {
        Puesto puesto = null;
        boolean flag = false;
        for (int i = 0; i < puestos.size() && !flag; i++) {
            if (puestos.get(i).getTrabajador() == null) {
                puesto = puestos.get(i);
                puesto.setTrabajador(t);
                t.setPuesto(puesto);
                flag = true;
            }
        }
        if (puesto == null) {
            throw new TrabajadorExcepcion(PUESTOS_ASIGNADOS);
        }
        return puesto;
    }
    
    public Puesto asignarLlamada(Llamada call) {
        Puesto puesto = null;
        boolean flag = false;
        for (int i = 0; i < puestos.size() && !flag; i++) {
            if (puestos.get(i).getLlamadaEnCurso() == null) {
                puesto = puestos.get(i);
                call.setPuesto(puesto);
                puesto.setLlamadaEnCurso(call);
                flag = true;
            }
        } 
        // IF PARA EN ESPERA        
        
        return puesto;
    }    
    
    //Metodo para la precarga
    public void asignarLlamada(Puesto puesto, Llamada call) {
        puesto.agregarLlamada(call);
    }
}
