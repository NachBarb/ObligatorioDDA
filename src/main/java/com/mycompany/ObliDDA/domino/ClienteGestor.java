/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ObliDDA.domino;

/**
 *
 * @author Martin
 */
public class ClienteGestor extends TipoCliente {

    @Override
    public double calculoCosto(CostoLlamada costo) {
        if (costo.getLlamada().getAtencion() == null) {
            System.out.println("Le erre atencion");
            return 0;
        }
        if(costo.getLlamada().duracion() > 180){
        return (costo.getCostoFijoPorSegundos() * costo.getLlamada().duracion());
        }
        double totalAPagar = ((costo.getCostoFijoPorSegundos()/2) * (costo.getLlamada().duracion())) - ((costo.getDescuentoPorEspera() * costo.getLlamada().espera()));
        if(totalAPagar > 0){
        return totalAPagar;
        }else{            
        return 0;
        }
    }
    
}
