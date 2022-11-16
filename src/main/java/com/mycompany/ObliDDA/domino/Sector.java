package com.mycompany.ObliDDA.domino;

import java.util.ArrayList;
import java.util.HashMap;
import observer.Observable;
import observer.Observer;

public class Sector{


    @Override
    public String toString() {
        return  id + "- " + nombre;
    }
    
    private HashMap<String, Trabajador> trabajadores; 
    private HashMap<String, Trabajador> trabajadoresLogueados;
    private ArrayList<Llamada> llamadasEnEspera;
    private String nombre;
    private int cantidadPuestos;
    private ArrayList<Puesto> puestos = new ArrayList<>();
    private static int serial = 1;
    private int id;
    
    private static final String PUESTOS_ASIGNADOS = "No hay puestos disponibles";
    private static final String TRABAJADOR_NO_SECTOR = "No corresponde al sector que intenta loguear";
    private static final String TRABAJADOR_YA_LOGUEADO = "El trabajador ya se encuentra en el sistema";
    
    public Sector(String nombre, int cantidadPuestos) {
        this.trabajadores = new HashMap<>();
        this.trabajadoresLogueados = new HashMap<>();
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
    
    public ArrayList<Llamada> listarLlamadas(){
        ArrayList<Llamada> aux = new ArrayList<>();
        for (Puesto p: puestos) {
            for (Llamada l: p.getLlamadas())
                aux.add(l);
        }
        return aux;
    } 
    
    public boolean asignarPuestoASector(Puesto p) {
        boolean ok = false;
        boolean existePuesto = false;
        if (puestos.size() < cantidadPuestos) {
            for (int i = 0; i < puestos.size(); i++) {
                if (puestos.get(i).getId() == p.getId()) {
                    existePuesto = true;
                }
            }
            if (!existePuesto) {
                puestos.add(p);
                ok = true;
            }
        }
        return ok;
    }
    
    public boolean agregarTrabajador(Trabajador trabajador){
            boolean trabajadorAgregadoOk = false;
        try {
            trabajadores.put(trabajador.getCi(), trabajador);
            trabajadorAgregadoOk = true;
        } finally {
        }

        return trabajadorAgregadoOk;
    }
    
       public boolean loguearTrabajador(Trabajador trabajador){
            boolean trabajadorAgregadoOk = false;
        try {
            trabajadoresLogueados.put(trabajador.getCi(), trabajador);
            trabajadorAgregadoOk = true;
        } finally {
        }

        return trabajadorAgregadoOk;
    }
       
       
    public Puesto asignarTrabajador(Trabajador t) throws TrabajadorExcepcion {
        if(!trabajadores.containsKey(t.getCi())){
        throw new TrabajadorExcepcion(TRABAJADOR_NO_SECTOR);
        }
                if(trabajadoresLogueados.containsKey(t.getCi())){
        throw new TrabajadorExcepcion(TRABAJADOR_YA_LOGUEADO);
        }
    
        Puesto puesto = null;
        boolean flag = false;
        for (int i = 0; i < puestos.size() && !flag; i++) {
            if (puestos.get(i).getTrabajador() == null) {
                puesto = puestos.get(i);
                puesto.setTrabajador(t);
                t.setPuesto(puesto);
                loguearTrabajador(t);
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
        boolean hayPuestoLibre = false;
        for (int i = 0; i < puestos.size() && !hayPuestoLibre; i++) {
            if (puestos.get(i).getLlamadaEnCurso() == null) {
                puesto = puestos.get(i);
                call.setPuesto(puesto);
                puesto.setLlamadaEnCurso(call);
                hayPuestoLibre = true;
            }
        }
        if(!hayPuestoLibre){
        this.llamadasEnEspera.add(call);
        }
        
        return puesto;
    }    
    
    //Metodo para la precarga
    public void asignarLlamada(Puesto puesto, Llamada call) {
        puesto.agregarLlamada(call);
    }
}
