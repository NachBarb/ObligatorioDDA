/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import com.mycompany.ObliDDA.iu.RealizarLlamada;

/**
 *
 * @author Martin
 */
public class RealizarLlamadaControlador {
        private RealizarLlamada vista;

    public RealizarLlamadaControlador(RealizarLlamada vista) {
        this.vista = vista;
    }

    public void iniciarLlamada(){
    this.vista.mensajeDeInicio();
    }
    
    
}
