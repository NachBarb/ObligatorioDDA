/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ObliDDA.domino;

/**
 *
 * @author Martin
 */
public class ClienteExonerado extends TipoCliente{

    @Override
    public double calculoCosto(CostoLlamada costo) {
        return 0;
    }
    
}
