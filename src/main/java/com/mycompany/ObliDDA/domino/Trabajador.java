/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ObliDDA.domino;

/**
 *
 * @author Martin
 */
public class Trabajador {
    	private String ci;
        private String nombre;
	private String pass;
        
        public String getCi(){
        return this.ci;
        }
        
        public String getNombre(){
        return this.nombre;
        }
        
        public Trabajador(String nombre,String ci,String pass){
            this.ci = ci;
            this.nombre = nombre;
            this.pass = pass;
        
        }
        
        public boolean esPassValida(String passToValidate){
        return passToValidate.equals(this.pass);
        }
}
