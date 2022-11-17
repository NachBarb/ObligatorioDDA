package controlador;

import com.mycompany.ObliDDA.domino.ClienteExcepcion;
import com.mycompany.ObliDDA.domino.CostoLlamada;
import com.mycompany.ObliDDA.domino.Puesto;
import com.mycompany.ObliDDA.domino.Sector;
import com.mycompany.ObliDDA.domino.SectorExcepcion;
import com.mycompany.ObliDDA.iu.IRealizarLlamada;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import logica.FachadaSistema;
import modelo.ModeloRealizarLlamada;
import observer.Observable;
import observer.Observer;

/**
 *
 * @author Martin
 */
public class RealizarLlamadaControlador implements Observer {

    private ModeloRealizarLlamada modelo;
    private IRealizarLlamada vista;

    public RealizarLlamadaControlador(IRealizarLlamada vista, ModeloRealizarLlamada modelo) {
        this.modelo = modelo;
        this.vista = vista;
        this.modelo.setCedula("");
    }

    public void numeral() {
        if (modelo.getCliente() == null) {
            loginCliente();
        } else {
            try {
                Sector sector = FachadaSistema.getInstancia().buscarSector(Integer.parseInt(modelo.getNumSector()));
                modelo.setSector(sector);
                this.vista.limpiarPantalla();
                this.vista.mensajeEnPantalla("Usted se esta queriendo comunicar con \n " + sector);
            } catch (SectorExcepcion sectorExcepcion) {
                vista.mostrarError(sectorExcepcion.getMessage());
                this.modelo.setNumSector("");
            }

        }
    }

    public void loginCliente() {
        String cedula = modelo.getCedula();
        try {
            modelo.setCliente(FachadaSistema.getInstancia().login(cedula));
            this.vista.limpiarPantalla();
            this.vista.mensajeEnPantalla("Para comunicarse con un sector digite \n su identificador seguido de la tecla numeral \n y presione iniciar");
            cargarSectores();
        } catch (ClienteExcepcion clienteExcepcion) {
            vista.mostrarError(clienteExcepcion.getMessage());
            this.modelo.setCedula("");
        }

    }

    public void cargarSectores() {
        ArrayList<Sector> sectores = FachadaSistema.getInstancia().listarSectores();
        String[] array = new String[sectores.size()];
        int index = 0;
        for (Object value : sectores) {
            array[index] = value.toString();
            index++;
        }

        this.vista.cargarSectores(array);
    }

    public void iniciarLlamada() {
        if(modelo.getSector() == null){
        vista.mostrarError("No ha selecionado ningun sector para realizar llamadas");
        }else{
        try {
            modelo.setLlamada(FachadaSistema.getInstancia().iniciarLlamada(modelo.getCliente()));
            modelo.getLlamada().addObserver(this);
            Puesto puestoAsignado = modelo.getSector().asignarLlamada(modelo.getLlamada());
            this.vista.limpiarPantalla();
            modelo.getLlamada().iniciarLlamada();
                FachadaSistema.getInstancia().inicioLlamada();
                if (puestoAsignado == null) {
                    mensajeEspera();
                } else {
                    modelo.setPuesto(puestoAsignado);
                    modelo.getSector().atender(puestoAsignado, modelo.getLlamada());
                }
        } catch (SectorExcepcion sectorExcepcion) {
            vista.mostrarError(sectorExcepcion.getMessage());
        }
        }
    }
    
    
    public void mensajeEspera(){
                        vista.limpiarPantalla();
                    vista.mensajeEnPantalla("Aguarde en línea, Ud. se encuentra a " + modelo.getSector().getLlamadasEnEspera().size() 
                            + " llamadas de ser atendido, \n la espera estimada es de "+ 
                            Integer.toString(modelo.getSector().tiempoEsperaEstimado() * modelo.getSector().getLlamadasEnEspera().size())
                            +" minutos");
    }

    public void finalizarLlamada() {
        if (modelo.getLlamada() != null && modelo.getLlamada().getFin() == null) {
            vista.limpiarPantalla();
            modelo.getLlamada().finalizarLlamada();
            modelo.setLlamada(null);
            FachadaSistema.getInstancia().terminoLlamada();
        }
    }

    public void logOut() {
        if (modelo.getLlamada() != null) {
            if (modelo.getLlamada().getFin() == null) {

                finalizarLlamada();
            }

        }
        FachadaSistema.getInstancia().logOutCliente(modelo.getCliente());
    }

    public void digito(String caracter) {
        if (modelo.getCliente() == null) {
            this.modelo.updateCedula(caracter);
        } else {
            this.modelo.setNumSector(caracter);
        }
    }

    @Override
    public void update(Observable source, Object event) {
        if (event.equals(Observer.Eventos.LlamadaIniciada)) {
            vista.mensajeEnPantalla("Su llamada esta siendo derivada");
        }
        if (event.equals(Observer.Eventos.LlamadaAtendida)) {
            vista.limpiarPantalla();
            modelo.getLlamada().setAtencion(new Date());
            modelo.setPuesto(modelo.getLlamada().getPuesto());
            vista.mensajeEnPantalla(modelo.mensajeInicioDeLlamada());
        }
        if (event.equals(Observer.Eventos.LlamadaFinalizada)) {
            modelo.getLlamada().setFin(new Date());
            vista.limpiarPantalla();
            vista.mensajeEnPantalla(modelo.mensajeFinDeLlamada());
            modelo.setSector(null);
        }        
    }

}
