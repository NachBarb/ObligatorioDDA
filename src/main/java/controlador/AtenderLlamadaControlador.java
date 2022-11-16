/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import com.mycompany.ObliDDA.domino.Trabajador;
import com.mycompany.ObliDDA.domino.Llamada;
import com.mycompany.ObliDDA.domino.Puesto;
import com.mycompany.ObliDDA.iu.AtenderLlamada;
import java.util.ArrayList;
import logica.FachadaSistema;
import observer.Observable;
import observer.Observer;

/**
 *
 * @author MSI
 */
public class AtenderLlamadaControlador implements Observer {

    private AtenderLlamada vista;
    private Puesto puesto;

    public AtenderLlamadaControlador(AtenderLlamada vista, Trabajador trabajador) {

        this.vista = vista;
        this.puesto = trabajador.getPuesto();
        this.puesto.addObserver(this);

    }

    public void finalizarLlamada() {
        String descrip = vista.devolverDesc();
        if (puesto.getLlamadaEnCurso() != null) {
            puesto.finalizarLlamada(descrip);
            puesto.setLlamadaEnCurso(null);
            puesto.getLlamadas().get(puesto.getCantidadLlamadas() - 1).finalizarLlamada();
        vista.setStatus("No hay llamada en curso...");
        vista.setDescripcion("");
        vista.setCliente("");
        vista.setTiempoP(puesto.promedioTiempoLlamada());
            this.puesto.puestoLibre();
        }

    }

    public void inicializar(Puesto puesto) {

        vista.setTrabajadorNombre(puesto.getTrabajador().getNombre());
        if (puesto.getLlamadaEnCurso() != null) {
            vista.setCliente(puesto.getLlamadaEnCurso().getCliente().getNombre());
            vista.setStatus("Llamada en curso...");
        } else {
            vista.setStatus("No hay llamada en curso...");
        }

        vista.setSector(puesto.getTrabajador().getSector().getNombre());
        vista.setPuesto(puesto.getTrabajador().getPuesto().getId());
        vista.setLlamada(puesto.getTrabajador().getPuesto().getCantidadLlamadas());
        vista.setTiempoP(puesto.getTrabajador().getPuesto().promedioTiempoLlamada());
    }

    @Override
    public void update(Observable source, Object event) {
        if (event.equals(Observer.Eventos.LlamadaAtendida)) {
            inicializar(puesto);
        }
        if (event.equals(Observer.Eventos.LlamadaFinalizada)) {
            if (puesto.getLlamadaEnCurso() != null) {
                finalizarLlamada();
            }
        }
    }

}
