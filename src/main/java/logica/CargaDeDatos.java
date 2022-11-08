/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import com.mycompany.ObliDDA.domino.Trabajador;

/**
 *
 * @author Martin
 */
public class CargaDeDatos {
    public static void cargar(){
        Trabajador t1 = new Trabajador("Trabajador1" , "11111111" , "Password1");
        
        FachadaSistema.getInstancia().agregarTrabajador(t1);
         }
}
