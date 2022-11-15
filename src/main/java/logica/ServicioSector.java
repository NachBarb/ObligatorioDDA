/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import com.mycompany.ObliDDA.domino.Llamada;
import com.mycompany.ObliDDA.domino.Sector;
import com.mycompany.ObliDDA.domino.SectorExcepcion;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Martin
 */
public class ServicioSector {
    private static final String NUMERO_S_INVALIDO = "Numero de sector no existe.";

    private static int cantidadMaxLlamadas = 5;

    private ArrayList<Sector> sectores;
    private ArrayList<Llamada> llamadasEnCurso;

    private ArrayList<Llamada> llamadasEnEspera;

    public ServicioSector() {
        this.sectores = new ArrayList<Sector>();
    }

    public void agregarSector(Sector sector) {
        sectores.add(sector);
    }

    public ArrayList<Sector> getSectores() {
        return sectores;
    }

    public Sector devolverSector(int numSector) throws SectorExcepcion{
        Sector sec = null;
        for (Sector s : sectores) {
            if (s.getNumSector() == numSector) {
                sec = s;
            }
        }
        if(sec == null){
         throw new SectorExcepcion(NUMERO_S_INVALIDO);
        }
        return sec;
    }

}
