/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import com.mycompany.ObliDDA.domino.Cliente;
import com.mycompany.ObliDDA.domino.ClienteExcepcion;
import com.mycompany.ObliDDA.domino.Sector;
import com.mycompany.ObliDDA.domino.SectorExcepcion;
import com.mycompany.ObliDDA.iu.RealizarLlamada;
import java.util.ArrayList;
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

    
    public void numeral(){
    if(modelo.getCliente()==null){
    loginCliente();
    }else{
        try{
                FachadaSistema.getInstancia().buscarSector(Integer.parseInt(modelo.getNumSector()));
        }catch(SectorExcepcion sectorExcepcion){
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
            this.vista.mensajeEnPantalla("Para comunicarse con un sector digite su identificador seguido de la tecla numeral");

            cargarSectores();
        } catch (ClienteExcepcion clienteExcepcion) {
            JOptionPane.showMessageDialog(vista, clienteExcepcion.getMessage());
            this.modelo.setCedula("");
        }
        
    }

    public void cargarSectores() {
        ArrayList<Sector> sectores = FachadaSistema.getInstancia().getSectores();
        String[] array = new String[sectores.size()];
        int index = 0;
        for (Object value : sectores) {
            array[index] = value.toString();
            index++;
        }

        this.vista.cargarSectores(array);
    }

    public void iniciarLlamada() {
        this.vista.limpiarPantalla();
        this.vista.mensajeEnPantalla("Llamada");
    }

    public void digito(String caracter) {
        if(modelo.getCliente() == null){
        this.modelo.updateCedula(caracter);
        }else{
        this.modelo.setNumSector(caracter);
        }
    }

    @Override
    public void update(Observable source, Object event) {
        if (event.equals(Observer.Eventos.LlamadaIniciada)) {
            vista.mensajeEnPantalla(modelo.mensajeInicioDeLlamada());
        }
    }

}
