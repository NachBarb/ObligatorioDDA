/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.ObliDDA.iu;

import com.mycompany.ObliDDA.domino.Trabajador;

/**
 *
 * @author Martin
 */
public interface ILogin {

    void ejecutarSiguienteCU(Trabajador trabajador);

    String getCi();

    String getPassword();
    
    void mostrarError( String mensaje);
    
}
