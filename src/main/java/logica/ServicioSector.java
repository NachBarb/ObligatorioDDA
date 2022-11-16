package logica;

import com.mycompany.ObliDDA.domino.Cliente;
import com.mycompany.ObliDDA.domino.Llamada;
import com.mycompany.ObliDDA.domino.Puesto;
import com.mycompany.ObliDDA.domino.Sector;
import com.mycompany.ObliDDA.domino.SectorExcepcion;
import java.util.ArrayList;
import java.util.Date;
import observer.Observable;
import observer.Observer;

public class ServicioSector implements Observer {
    private static final String NUMERO_S_INVALIDO = "Numero de sector no existe.";
    private static final String CANTIDADLLAMADAS = "Se ha alcanzado la cantidad maxima de llamadas";

    private static int cantidadMaxLlamadas = 5;
    private int cantidadLlamadasActuales;

    private ArrayList<Sector> sectores;

    public ServicioSector() {
        this.cantidadLlamadasActuales = 0;
        this.sectores = new ArrayList<Sector>();
    }

    public void inicioLlamada() {
        this.cantidadLlamadasActuales = cantidadLlamadasActuales+1;
    }
    
    public void terminoLlamada() {
      this.cantidadLlamadasActuales = cantidadLlamadasActuales-1;
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
    
    public Llamada crearLlamada(Cliente cliente) throws SectorExcepcion {
        if(cantidadLlamadasActuales == cantidadMaxLlamadas){
        throw new SectorExcepcion(CANTIDADLLAMADAS);
        }
        
        Llamada call = new Llamada(cliente);
        return call;
    }
    
    public ArrayList<Llamada> listarLlamadasPorSector(Sector sector) {
        return sector.listarLlamadas();  
    }
    
    public ArrayList<Llamada> listarTodasLasLlamadas() {
        ArrayList<Llamada> aux = new ArrayList<>();
        ArrayList<Llamada> aux2 = new ArrayList<>();
        for (Sector s: sectores) {
            aux2 = s.listarLlamadas();
            for (Llamada l: aux2) {
                aux.add(l);
            }
        }
        return aux;
    }

    @Override
    public void update(Observable source, Object event) {
    }
    
}