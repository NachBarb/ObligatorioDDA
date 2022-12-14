package com.mycompany.ObliDDA.domino;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import observer.Observable;
import observer.Observer;

public class Sector extends Observable implements Observer{


    @Override
    public String toString() {
        return  id + "- " + nombre;
    }
    
    private HashMap<String, Trabajador> trabajadores; 
    private ArrayList<Llamada> llamadasEnEspera;
    private String nombre;
    private int cantidadPuestos;
    private ArrayList<Puesto> puestos = new ArrayList<>();
    private static int serial = 1;
    private int id;
    
    private static final String PUESTOS_ASIGNADOS = "No hay puestos disponibles";
    private static final String TRABAJADOR_NO_SECTOR = "No corresponde al sector que intenta loguear";
    private static final String NO_TRABAJADOR_SECTOR = "Sector no disponible";
    
    public Sector(String nombre, int cantidadPuestos) {
        this.trabajadores = new HashMap<>();
        this.nombre = nombre;
        this.cantidadPuestos = cantidadPuestos;
        this.id = serial++;
        this.llamadasEnEspera = new ArrayList<Llamada>();
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

    public ArrayList<Llamada> getLlamadasEnEspera() {
        return llamadasEnEspera;
    }
    
    public ArrayList<Llamada> listarLlamadas(){
        ArrayList<Llamada> aux = new ArrayList<>();
        for (Puesto p: puestos) {
            for (Llamada l: p.getLlamadas())
                aux.add(l);
            aux.add(p.getLlamadaEnCurso());
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
                p.addObserver(this);
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
       
    public Puesto asignarTrabajador(Trabajador t) throws TrabajadorExcepcion {
        if(!trabajadores.containsKey(t.getCi())){
        throw new TrabajadorExcepcion(TRABAJADOR_NO_SECTOR);
        }
                
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
    
    public Puesto asignarLlamada(Llamada call) throws SectorExcepcion{
        System.out.println("Entre a asignar");
        Puesto puesto = null;
        boolean hayPuestoLibre = false;
        boolean trabajadorEnSector = false;
        for (int i = 0; i < puestos.size() && !hayPuestoLibre; i++) {
            if ( puestos.get(i).getTrabajador() != null ) {
                trabajadorEnSector = true;
                if(puestos.get(i).getLlamadaEnCurso() == null){
                puesto = puestos.get(i);
                call.setPuesto(puesto);
                call.setNombreTrabajador(puesto.getTrabajador().getNombre());
                puesto.setLlamadaEnCurso(call);
                System.out.println("EncontrePuestoLibre");
                hayPuestoLibre = true;
                call.addObserver(puesto);
                }
            }
        }
        if(!trabajadorEnSector){
            throw new SectorExcepcion(NO_TRABAJADOR_SECTOR);
        }
        if(!hayPuestoLibre){
        this.llamadasEnEspera.add(call);
            System.out.println("Cantidad llmadas en espera "+llamadasEnEspera.size());
        call.llamadaEspera();
        }
        return puesto;
    }    
    
    public void atender(Puesto puesto , Llamada call){
        call.llamadaAtendida();
        puesto.llamadaAtendida();
        llamadaAtendidaSector();
    }
    
    @Override
    public void update(Observable source, Object event) {
        if(event.equals(Observer.Eventos.PuestoLibre)){
            System.out.println("Espera" + llamadasEnEspera.size());
        if(llamadasEnEspera.size() > 0){
            System.out.println("Entre");
            Llamada proxLlamada = llamadasEnEspera.get(0);
            llamadasEnEspera.remove(0);
            try{
            asignarLlamada(proxLlamada);
            }catch(SectorExcepcion sectorExcepcion){
                System.out.println(sectorExcepcion.getMessage());
            }
            atender(proxLlamada.getPuesto(),proxLlamada);
            
        }
    }
    }
    
    public int tiempoEsperaEstimado(){
        int tiempoEspera = 0;
        
        for(Puesto p : puestos){
        tiempoEspera = tiempoEspera + p.promedioTiempoLlamada();
        }
        
        TimeUnit time = TimeUnit.MINUTES;
        return (int) time.convert(tiempoEspera, TimeUnit.SECONDS);
        
        }
    
    public void llamadaAtendidaSector(){
        notifyObservers(Observer.Eventos.SectorAtiende);
    }
    
    public void llamadaFinalizadaSector(){
        notifyObservers(Observer.Eventos.SectorFinaliza);
    }
    
    
    //Metodo para la precarga
    public void asignarLlamada(Puesto puesto, Llamada call) {
        puesto.agregarLlamada(call);
    }
    
}
