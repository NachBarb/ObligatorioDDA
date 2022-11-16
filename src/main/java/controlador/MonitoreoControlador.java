package controlador;

import com.mycompany.ObliDDA.domino.Llamada;
import com.mycompany.ObliDDA.domino.Sector;
import com.mycompany.ObliDDA.domino.SectorExcepcion;
import com.mycompany.ObliDDA.iu.Monitoreo;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import logica.FachadaSistema;
import modelo.ModeloMonitoreo;
import observer.Observable;
import observer.Observer;

public class MonitoreoControlador implements Observer {
    
    private Monitoreo vista;
    private ModeloMonitoreo modelo;
    
    public MonitoreoControlador(Monitoreo vista, ModeloMonitoreo modelo) {
        this.vista = vista;
        this.modelo = modelo;
    }
    
    public void numeral(){
        int numLlamada = 1;
        if (modelo.getNumSector() == "") {            
            ArrayList<Llamada> llamadasSectores = listarTodasLasLlamadas();    
            String[] arr = new String[llamadasSectores.size()];
            for (int i = 0; i < llamadasSectores.size(); i++) {
                if (llamadasSectores.get(i).getAtencion() != null) {
                    arr[i] = Integer.toString(numLlamada) + " - " + llamadasSectores.get(i).toString();
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
                    if (llamadasSector.get(i).getAtencion() != null) {
                        arr2[i] = Integer.toString(numLlamada) + " - " + llamadasSector.get(i).toString();
                        numLlamada++;
                    }
                }

                this.vista.cargarLlamadas(arr2);
                this.modelo.setNumSector("");

            } catch(SectorExcepcion sectorExcepcion){
                JOptionPane.showMessageDialog(vista, sectorExcepcion.getMessage());
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
