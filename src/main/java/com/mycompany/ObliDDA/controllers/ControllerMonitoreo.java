package com.mycompany.ObliDDA.controllers;

import com.mycompany.ObliDDA.domino.Llamada;
import com.mycompany.ObliDDA.domino.Sector;
import java.util.ArrayList;
import logica.ServicioSector;

public class ControllerMonitoreo {
    private ServicioSector servicioSector = new ServicioSector();
    
    public ServicioSector getServicioSector() {
        return servicioSector;
    }
    
    public ArrayList<Sector> listarSectores() {
        ArrayList<Sector> aux = servicioSector.getSectores();
        return aux;
    }
    
    public ArrayList<Llamada> listarLlamadasPorSector(Sector sector) {
        ArrayList<Llamada> aux = servicioSector.listarLlamadasPorSector(sector);
        return aux;
    }

    public ArrayList<Llamada> listarTodasLasLlamadas() {
        ArrayList<Llamada> aux = servicioSector.listarTodasLasLlamadas();
        return aux;
    }

}
