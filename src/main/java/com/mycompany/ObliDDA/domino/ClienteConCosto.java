/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ObliDDA.domino;

/**
 *
 * @author Martin
 */
public class ClienteConCosto extends TipoCliente {

    @Override
    public double calculoCosto(CostoLlamada costo) {
        if (costo.getLlamada().getAtencion() == null) {
            return 0;
        }
        if (costo.getLlamada().espera() < 60) {
            return (costo.getCostoFijoPorSegundos() * costo.getLlamada().duracion());
        }
        return ((costo.getCostoFijoPorSegundos() / 2) * costo.getLlamada().duracion());
    }

}
