package controlador;

import com.mycompany.ObliDDA.domino.Llamada;
import com.mycompany.ObliDDA.domino.Sector;
import com.mycompany.ObliDDA.domino.SectorExcepcion;
import com.mycompany.ObliDDA.iu.IMonitoreo;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import logica.FachadaSistema;
import modelo.ModeloMonitoreo;
import observer.Observable;
import observer.Observer;

public class MonitoreoControlador implements Observer {
    
    private IMonitoreo vista;
    private ModeloMonitoreo modelo;
    private boolean mostrando = false;

 
    
    public MonitoreoControlador(IMonitoreo vista, ModeloMonitoreo modelo) {
        this.vista = vista;
        this.modelo = modelo;
        
        for(Sector s : FachadaSistema.getInstancia().listarSectores()){
        s.addObserver(this);
        }
        
    }
    
       public void setMostrando(boolean mostrando) {
        this.mostrando = mostrando;
    }
    
    public void aster(){
    this.modelo.setNumSector("");
    }
    
    
    public void numeral(){
        setMostrando(true);
        int numLlamada = 1;
        if (modelo.getNumSector() == "") {            
            ArrayList<Llamada> llamadasSectores = listarTodasLasLlamadas();    
            String[] arr = new String[llamadasSectores.size()];
            for (int i = 0; i < llamadasSectores.size(); i++) {
                if (llamadasSectores.get(i) != null && llamadasSectores.get(i).getAtencion() != null ) {
                    arr[i] = "                 " + Integer.toString(numLlamada) + " - " + llamadasSectores.get(i).toString();
                    numLlamada++;
                }
            }
            
            this.vista.cargarLlamadas(arr);
        } else {
            try{
                Sector sector = FachadaSistema.getInstancia().buscarSector(Integer.parseInt(modelo.getNumSector()));
                ArrayList<Llamada> llamadasSector = listarLlamadasPorSector(sector);
                String[] arr2 = new String[llamadasSector.size()];
                for (int i = 0; i < llamadasSector.size(); i++) {
                    if (llamadasSector.get(i) != null && llamadasSector.get(i).getAtencion() != null) {
                        arr2[i] = sector.getNombre() + " - " + Integer.toString(numLlamada) + " - " + llamadasSector.get(i).toString();
                        numLlamada++;
                    }
                }

                this.vista.cargarLlamadas(arr2);

            } catch(SectorExcepcion sectorExcepcion){
                vista.mostrarError(sectorExcepcion.getMessage());
                this.modelo.setNumSector("");
            }                 
        }
    }    
    
    public void listarSectores() {
        ArrayList<Sector> sectores = FachadaSistema.getInstancia().listarSectores();
        String[] arr = new String[sectores.size()];
        for (int i = 0; i < sectores.size(); i++) {
            arr[i] = sectores.get(i).toString();
        }
        
        this.vista.cargarSectores(arr);
    }
    
    public ArrayList<Llamada> listarLlamadasPorSector(Sector sector) {
        return FachadaSistema.getInstancia().listarLlamadasPorSector(sector);
    }
    
    public ArrayList<Llamada> listarTodasLasLlamadas() {
        return FachadaSistema.getInstancia().listarTodasLasLlamadas();
    }
    
    public void digito(String caracter) {
        this.modelo.setNumSector(caracter);
    }

    @Override
    public void update(Observable source, Object event) {
        if(event.equals(Observer.Eventos.SectorAtiende) || event.equals(Observer.Eventos.SectorFinaliza) ){
            if(mostrando){
        numeral();
            }
        }
        
    }
}
