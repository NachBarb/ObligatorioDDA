/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import com.mycompany.ObliDDA.domino.Sector;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Martin
 */
public class ServicioSector {
    private ArrayList<Sector> sectores;
    
    public ServicioSector(){
    this.sectores = new ArrayList<Sector>();
    }

    public void agregarSector(Sector sector) {
        sectores.add(sector);
    }

    public ArrayList<Sector> getSectores() {
        return sectores;
    }
    
    public Sector devolverSector(int numSector){
        for(Sector s : sectores){
               if (s.getNumSector() == numSector) {
                return s;
            }
        }
        return null;
    }

}
