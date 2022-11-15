/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import com.mycompany.ObliDDA.domino.Llamada;
import com.mycompany.ObliDDA.domino.Puesto;
import com.mycompany.ObliDDA.iu.AtenderLlamada;
import java.util.ArrayList;
import logica.FachadaSistema;

/**
 *
 * @author MSI
 */
public class AtenderLlamadaControlador {
    
    private AtenderLlamada vista;
    
    public AtenderLlamadaControlador(AtenderLlamada vista) {
        
        this.vista = vista;
        
    }
    
    public void finalizarLlamada(Puesto puesto, String descrip) {
        puesto.finalizarLlamada(descrip); 
        
        ArrayList<Llamada> llamadas = vista.getTrabajador().getPuesto().getLlamadas();
        String[] array = new String[llamadas.size()];
        int index = 0;
        for (Object value : llamadas) {
            System.out.println(value.toString());
            index++;
        }

              
             
    }
    
}
