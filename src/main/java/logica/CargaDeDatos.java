package logica;

import com.mycompany.ObliDDA.domino.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CargaDeDatos {
    public static void cargar() throws ParseException {
        
        // Carga CLIENTES
        Cliente cli1 = new Cliente("Ignacio Barbisan", "12345678");
        Cliente cli2 = new Cliente("Martin Bove", "87654321");
        Cliente cli3 = new Cliente("Federico Garcia", "23456789", 300);
        Cliente cli4 = new Cliente("Monica Pereira", "43287564", 500);
        Cliente cli5 = new Cliente("Carolina Perez", "73625196", 650);

        // Carga SECTORES 
        Sector s1 = new Sector("RRHH", 1, 1);
        Sector s2 = new Sector("Marketing", 2, 2);
        Sector s3 = new Sector("Administracion", 3, 2);
        Sector s4 = new Sector("Soporte", 4, 3);
        Sector s5 = new Sector("Mantenimiento", 5, 1);   
        
        // Carga TRABAJADORES
        Trabajador t1 = new Trabajador("Damian Martinez" , "11111111" , "Password1", s1);
        Trabajador t2 = new Trabajador("Facundo Amoroso", "22222222", "Password1", s2);
        Trabajador t3 = new Trabajador("Alexis Cabrera", "33333333", "Password1", s2);
        Trabajador t4 = new Trabajador("Nacho Bove", "44444444", "Password1", s3);
        Trabajador t5 = new Trabajador("Martin Barbisan", "55555555", "Password1", s3);
        Trabajador t6 = new Trabajador("Ignacio Bassetti", "66666666", "Password1", s4);
        Trabajador t7 = new Trabajador("Paola Marti", "77777777", "Password1", s4);
        Trabajador t8 = new Trabajador("Naomi Rodriguez", "88888888", "Password1", s4);
        Trabajador t10 = new Trabajador("Clarisa Martinez", "10345678", "Password1",s5);
                
        // Carga PUESTOS
        Puesto p1 = new Puesto(1, s1);
        Puesto p2 = new Puesto(2, s2);
        Puesto p3 = new Puesto(3, s2);
        Puesto p4 = new Puesto(4, s3);
        Puesto p5 = new Puesto(5, s3);
        Puesto p6 = new Puesto(6, s4);
        Puesto p7 = new Puesto(7, s4);
        Puesto p8 = new Puesto(8, s4);
        Puesto p9 = new Puesto(9, s5);
        
        // Asignar lista de puestos a sector
        s1.asignarPuestoASector(p1);
        s2.asignarPuestoASector(p2);
        s2.asignarPuestoASector(p3);
        s3.asignarPuestoASector(p4);
        s3.asignarPuestoASector(p5);
        s4.asignarPuestoASector(p6);
        s4.asignarPuestoASector(p7);
        s4.asignarPuestoASector(p8);
        s5.asignarPuestoASector(p9);     
        
        // Asignar Llamada
        Llamada llamada1 = new Llamada(parseDate("2022-10-25 22:33:00"), parseDate("2022-10-25 22:37:00"), "Pedido de licencia");
        Llamada llamada2 = new Llamada(parseDate("2022-10-25 22:33:00"), parseDate("2022-10-25 22:37:00"), "Pedido de licencia");

           
        System.out.println("llamada1  " + llamada1 );
        System.out.println("llamada2  " + llamada1);       

        FachadaSistema.getInstancia().agregarTrabajador(t1);
    }
    
    // FORMATO "2022-10-25 22:33:00"
    private static Date parseDate(String fecha) throws ParseException {
            Date fechaParseada = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(fecha);
            return fechaParseada;
        }

}
