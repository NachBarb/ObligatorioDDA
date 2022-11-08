/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import com.mycompany.ObliDDA.domino.Trabajador;
import com.mycompany.ObliDDA.domino.TrabajadorExcepcion;

/**
 *
 * @author Martin
 */
public class FachadaSistema {
        private ServicioTrabajador servicioTrabajador;

    private static FachadaSistema instancia;

    private FachadaSistema() {
        servicioTrabajador = new ServicioTrabajador();
    }

    public synchronized static FachadaSistema getInstancia() {
        if (instancia == null) {
            instancia = new FachadaSistema();
        }
        return instancia;
    }
    
    public Trabajador login(String ci, String password) throws TrabajadorExcepcion{
        return this.servicioTrabajador.loginTrabajador(ci, password);
    }
    
    public void agregarTrabajador(Trabajador t){
        this.servicioTrabajador.agregarTrabajador(t);
    }
}
