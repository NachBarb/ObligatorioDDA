/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import com.mycompany.ObliDDA.domino.Cliente;
import com.mycompany.ObliDDA.domino.ClienteExcepcion;
import com.mycompany.ObliDDA.iu.RealizarLlamada;
import javax.swing.JOptionPane;
import logica.FachadaSistema;

/**
 *
 * @author Martin
 */
public class RealizarLlamadaControlador {
        private RealizarLlamada vista;

    public RealizarLlamadaControlador(RealizarLlamada vista) {
        this.vista = vista;
    }

    public void loginCliente(){
    
        String cedula = vista.getCedula();

        try {
            Cliente cliente = FachadaSistema.getInstancia().login(cedula);
            this.vista.mensajeEnPantalla("Login exitoso");
        } catch (ClienteExcepcion clienteExcepcion) {
            JOptionPane.showMessageDialog(vista, clienteExcepcion.getMessage());
        }

    }
    
    
    public void iniciarLlamada(){
    this.vista.mensajeEnPantalla("");
    }
    
    public void actualizarCedula(String caracter){
    this.vista.updateCedula(caracter);
    }
    
    
}
