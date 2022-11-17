/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.ObliDDA.iu;

import com.mycompany.ObliDDA.domino.Trabajador;
import controlador.AtenderLlamadaControlador;

/**
 *
 * @author Martin
 */
public interface IAtenderLlamada {

    String devolverDesc();

    Trabajador getTrabajador();

    void setCliente(String cliente);

    void setDescripcion(String descripcion);

    void setLlamada(int llamada);

    void setPuesto(int puesto);

    void setSector(String sector);

    void setStatus(String status);

    void setTiempoP(int tiempoP);

    void setTrabajadorNombre(String trabajador);
    
}
