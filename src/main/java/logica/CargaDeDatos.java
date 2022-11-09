package logica;

import com.mycompany.ObliDDA.domino.*;

public class CargaDeDatos {
    public static void cargar(){
        
        // Carga CLIENTES
        Cliente cli1 = new Cliente("Ignacio Barbisan", "12345678");
        Cliente cli2 = new Cliente("Martin Bove", "87654321");
        Cliente cli3 = new Cliente("Federico Garcia", "23456789", 300);
        Cliente cli4 = new Cliente("Monica Pereira", "43287564", 500);
        Cliente cli5 = new Cliente("Carolina Perez", "73625196", 650);
        
        // Carga TRABAJADORES
        Trabajador t1 = new Trabajador("Damian Martinez" , "11111111" , "Password1");
        Trabajador t2 = new Trabajador("Facundo Amoroso", "22222222", "Password1");
        Trabajador t3 = new Trabajador("Alexis Cabrera", "33333333", "Password1");
        Trabajador t4 = new Trabajador("Nacho Bove", "44444444", "Password1");
        Trabajador t5 = new Trabajador("Martin Barbisan", "55555555", "Password1");
        Trabajador t6 = new Trabajador("Ignacio Bassetti", "66666666", "Password1");
        Trabajador t7 = new Trabajador("Paola Marti", "77777777", "Password1");
        Trabajador t8 = new Trabajador("Naomi Rodriguez", "88888888", "Password1");
        Trabajador t9 = new Trabajador("Fernando García", "99999999", "Password1");
        Trabajador t10 = new Trabajador("Clarisa Martinez", "10345678", "Password1");
        
        // Carga PUESTOS
        Puesto p1 = new Puesto();
        Puesto p2 = new Puesto();
        Puesto p3 = new Puesto();
        Puesto p4 = new Puesto();
        Puesto p5 = new Puesto();
        Puesto p6 = new Puesto();
        Puesto p7 = new Puesto();
        Puesto p8 = new Puesto();
        Puesto p9 = new Puesto();
        Puesto p10 = new Puesto();
        Puesto p11 = new Puesto();
        Puesto p12 = new Puesto();
        Puesto p13 = new Puesto();
        Puesto p14 = new Puesto();
        Puesto p15 = new Puesto();
        Puesto p16 = new Puesto();
        Puesto p17 = new Puesto();
        Puesto p18 = new Puesto();
        Puesto p19 = new Puesto();
        Puesto p20 = new Puesto();                
      
        // Carga SECTORES 
        
        // Asignar Sector, Trabajador, Llamada
        
        // Asignar lista de puestos
        
        
        
        
        
        FachadaSistema.getInstancia().agregarTrabajador(t1);
         }
}
