/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.ObliDDA.iu;

/**
 *
 * @author Martin
 */
public interface IMonitoreo {

    void cargarLlamadas(String[] listaLlamadas);

    void cargarSectores(String[] listaSectores);
    
    void mostrarError(String error);
}
