package controlador;

import com.mycompany.ObliDDA.domino.ClienteExcepcion;
import com.mycompany.ObliDDA.domino.CostoLlamada;
import com.mycompany.ObliDDA.domino.Puesto;
import com.mycompany.ObliDDA.domino.Sector;
import com.mycompany.ObliDDA.domino.SectorExcepcion;
import com.mycompany.ObliDDA.iu.RealizarLlamada;
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
    private RealizarLlamada vista;

    public RealizarLlamadaControlador(RealizarLlamada vista, ModeloRealizarLlamada modelo) {
        this.modelo = modelo;
        this.vista = vista;
        this.modelo.setCedula("");
    }

    public void numeral() {
        if (modelo.getCliente() == null) {
            loginCliente();
        } else {
            try {
                modelo.setSector(FachadaSistema.getInstancia().buscarSector(Integer.parseInt(modelo.getNumSector())));
            } catch (SectorExcepcion sectorExcepcion) {
                JOptionPane.showMessageDialog(vista, sectorExcepcion.getMessage());
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
            JOptionPane.showMessageDialog(vista, clienteExcepcion.getMessage());
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
        try {
            modelo.setLlamada(FachadaSistema.getInstancia().iniciarLlamada(modelo.getCliente()));
            this.vista.limpiarPantalla();
            modelo.getLlamada().addObserver(this);
            modelo.getLlamada().iniciarLlamada();
            Puesto puestoAsignado = modelo.getSector().asignarLlamada(modelo.getLlamada());
            if (puestoAsignado == null) {
                vista.limpiarPantalla();
                vista.mensajeEnPantalla("Su llamada se ha puesto en espera");
            } else {
                modelo.setPuesto(puestoAsignado);
                modelo.getLlamada().addObserver(puestoAsignado);
                modelo.getLlamada().llamadaAtendida();
                puestoAsignado.llamadaAtendida();
            }

        } catch (SectorExcepcion sectorExcepcion) {
            JOptionPane.showMessageDialog(vista, sectorExcepcion.getMessage());
        }
    }

    public void finalizarLlamada() {
        vista.limpiarPantalla();
        modelo.getLlamada().finalizarLlamada();
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
            modelo.getLlamada().setAtencion(new Date());
            vista.mensajeEnPantalla(modelo.mensajeInicioDeLlamada());
        }
        if (event.equals(Observer.Eventos.LlamadaFinalizada)) {
            modelo.getLlamada().setFin(new Date());
            modelo.getCliente().agregarCosto(new CostoLlamada(modelo.getCliente() , modelo.getLlamada()));
            vista.limpiarPantalla();
            vista.mensajeEnPantalla(modelo.mensajeFinDeLlamada());
        }
    }

}
