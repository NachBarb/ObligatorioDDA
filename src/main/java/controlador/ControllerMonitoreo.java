package controlador;

import com.mycompany.ObliDDA.domino.Llamada;
import com.mycompany.ObliDDA.domino.Sector;
import java.util.ArrayList;
import logica.FachadaSistema;

public class ControllerMonitoreo {
    public ArrayList<Sector> listarSectores() {
        return FachadaSistema.getInstancia().listarSectores();
    }
    
    public ArrayList<Llamada> listarLlamadasPorSector(Sector sector) {
        return FachadaSistema.getInstancia().listarLlamadasPorSector(sector);
    }
    
    public ArrayList<Llamada> listarTodasLasLlamadas() {
        return FachadaSistema.getInstancia().listarTodasLasLlamadas();
    }
}
