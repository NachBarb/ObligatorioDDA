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

/**
 *
 * @author MSI
 */
public class AtenderLlamadaControlador {

    private AtenderLlamada vista;
    private Trabajador trabajador;

    public AtenderLlamadaControlador(AtenderLlamada vista, Trabajador trabajador) {

        this.vista = vista;
        this.trabajador = trabajador;

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

        if (trabajador.getPuesto().getLlamadaEnCurso() == null) {
            vista.setStatus("No hay llamada en curso...");
            vista.setDescripcion("");
            vista.setTiempoP(trabajador.getPuesto().promedioTiempoLlamada());
        }

    }

    public void inicializar(Puesto puesto) {

        vista.setTrabajadorNombre(trabajador.getNombre());
        if (trabajador.getPuesto().getLlamadaEnCurso() != null) {
            vista.setCliente(trabajador.getPuesto().getLlamadaEnCurso().getCliente().getNombre());
            vista.setStatus("Llamada en curso...");
        } else {
            vista.setStatus("No hay llamada en curso...");
        }

        vista.setSector(trabajador.getSector().getNombre());
        vista.setPuesto(trabajador.getPuesto().getId());
        vista.setLlamada(trabajador.getPuesto().getCantidadLlamadas());
        vista.setTiempoP(trabajador.getPuesto().promedioTiempoLlamada());
    }

}
