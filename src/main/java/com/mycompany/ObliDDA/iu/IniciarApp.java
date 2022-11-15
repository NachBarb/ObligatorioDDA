/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.ObliDDA.iu;

import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.CargaDeDatos;

/**
 *
 * @author Martin
 */
public class IniciarApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            CargaDeDatos.cargar();
        } catch (ParseException ex) {
            Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("No se pudo cargar los datos");
        }
        new Inicio().setVisible(true);
    }
}
