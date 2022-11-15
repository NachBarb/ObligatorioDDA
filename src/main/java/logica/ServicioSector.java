package logica;

import com.mycompany.ObliDDA.domino.Cliente;
import com.mycompany.ObliDDA.domino.Llamada;
import com.mycompany.ObliDDA.domino.Sector;
import com.mycompany.ObliDDA.domino.SectorExcepcion;
import java.util.ArrayList;

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
            if (s.getId() == numSector) {
                sec = s;
            }
        }
        if(sec == null){
         throw new SectorExcepcion(NUMERO_S_INVALIDO);
        }
        return sec;
    }
    
    public Llamada crearLlamada(Cliente cliente) {
        // Se crea la llamada, una ves pasado el filtro de max 5 llamadas
        // con fecha y hora de inicio desde que se acepto
        Llamada call = new Llamada(cliente);
        
        return call;
    }    

}
