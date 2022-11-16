package logica;

import com.mycompany.ObliDDA.domino.*;
import controlador.MonitoreoControlador;
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
        Sector s1 = new Sector("RRHH", 1);
        Sector s2 = new Sector("Marketing", 2);
        Sector s3 = new Sector("Administracion", 2);
        Sector s4 = new Sector("Soporte", 3);
        Sector s5 = new Sector("Mantenimiento", 1);     

        //Insertar Sectores a ServicioSector
        FachadaSistema.getInstancia().agregarSector(s1);
        FachadaSistema.getInstancia().agregarSector(s2);
        FachadaSistema.getInstancia().agregarSector(s3);
        FachadaSistema.getInstancia().agregarSector(s4);
        FachadaSistema.getInstancia().agregarSector(s5);

        // Carga TRABAJADORES
        Trabajador t1 = new Trabajador("Damian Martinez", "11111111", "Password1", s1);
        Trabajador t2 = new Trabajador("Facundo Amoroso", "22222222", "Password1", s2);
        Trabajador t3 = new Trabajador("Alexis Cabrera", "33333333", "Password1", s2);
        Trabajador t4 = new Trabajador("Nacho Bove", "44444444", "Password1", s3);
        Trabajador t5 = new Trabajador("Martin Barbisan", "55555555", "Password1", s3);
        Trabajador t6 = new Trabajador("Ignacio Bassetti", "66666666", "Password1", s4);
        Trabajador t7 = new Trabajador("Paola Marti", "77777777", "Password1", s4);
        Trabajador t8 = new Trabajador("Naomi Rodriguez", "88888888", "Password1", s4);
        Trabajador t10 = new Trabajador("Clarisa Martinez", "10345678", "Password1", s5);

        //Carga trabajadores a los sectores
        s1.agregarTrabajador(t1);
        s2.agregarTrabajador(t2);
        s2.agregarTrabajador(t3);
        s3.agregarTrabajador(t4);
        s3.agregarTrabajador(t5);
        s4.agregarTrabajador(t6);
        s4.agregarTrabajador(t7);
        s4.agregarTrabajador(t8);
        s5.agregarTrabajador(t10);
        
        // Carga PUESTOS
        Puesto p1 = new Puesto(s1);
        Puesto p2 = new Puesto(s2);
        Puesto p3 = new Puesto(s2);
        Puesto p4 = new Puesto(s3);
        Puesto p5 = new Puesto(s3);
        Puesto p6 = new Puesto(s4);
        Puesto p7 = new Puesto(s4);
        Puesto p8 = new Puesto(s4);
        Puesto p9 = new Puesto(s5);
        
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

        // Carga LLAMADAS
        Llamada call1 = new Llamada(parseDate("2022-06-25 10:33:00"), parseDate("2022-06-25 10:34:00"), parseDate("2022-06-25 10:37:00"), "Pedido de licencia", cli1, p1, "Damian Martinez");
        Llamada call2 = new Llamada(parseDate("2022-07-05 11:23:00"), parseDate("2022-07-05 11:27:00"), parseDate("2022-07-05 11:40:00"), "Nuevo anuncio publicitario", cli2, p2, "Alexis Cabrera");
        Llamada call3 = new Llamada(parseDate("2022-07-20 11:05:00"), parseDate("2022-07-20 11:07:00"), parseDate("2022-07-20 11:17:00"), "Informe de publicidad", cli3, p3, "Clarisa Martinez");
        Llamada call4 = new Llamada(parseDate("2022-08-15 12:33:00"), parseDate("2022-08-15 12:38:00"), parseDate("2022-08-15 12:47:00"), "Certificacion por enfermedad", cli4, p1, "Clarisa Martinez");
        Llamada call5 = new Llamada(parseDate("2022-09-02 10:27:00"), parseDate("2022-09-02 10:28:00"), parseDate("2022-09-02 10:37:00"), "Coordinacion de reunion", cli5, p4, "Ignacio Bassetti");
        Llamada call6 = new Llamada(parseDate("2022-10-01 13:04:00"), parseDate("2022-10-01 13:08:00"), parseDate("2022-10-01 13:27:00"), "Solicitud de constancia", cli2, p4, "Ignacio Bassetti");
        Llamada call7 = new Llamada(parseDate("2022-10-13 13:33:00"), parseDate("2022-10-13 13:35:00"), parseDate("2022-10-13 13:57:00"), "Conexion de internet inestable", cli2, p8, "Damian Martinez");
        Llamada call8 = new Llamada(parseDate("2022-10-25 14:12:00"), parseDate("2022-10-25 14:15:00"), parseDate("2022-10-25 14:37:00"), "Aire acondicionado para realizar limpieza", cli4, p9, "Naomi Rodriguez");


        //Asiganar llamadas a puestos (llamadas ya finalizadas)
        s1.asignarLlamada(p1, call1);
        s2.asignarLlamada(p2, call2);
        s2.asignarLlamada(p3, call3);
        s1.asignarLlamada(p1, call4);
        s3.asignarLlamada(p4, call5);
        s3.asignarLlamada(p4, call6);
        s4.asignarLlamada(p8, call7);
        s5.asignarLlamada(p9, call8);

        System.out.println("call1 " + call1.getId());
        System.out.println("call2 " + call2.getId());
        System.out.println("call3 " + call3.getId());
        System.out.println("call4 " + call4.getId());
        
        System.out.println("p1 " + p1.getId());
        System.out.println("p2 " + p2.getId());
        System.out.println("p3 " + p3.getId());
        System.out.println("p4 " + p4.getId());

        FachadaSistema.getInstancia().agregarTrabajador(t1);
        FachadaSistema.getInstancia().agregarTrabajador(t2);
        FachadaSistema.getInstancia().agregarTrabajador(t3);
        FachadaSistema.getInstancia().agregarTrabajador(t4);
        FachadaSistema.getInstancia().agregarTrabajador(t5);
        FachadaSistema.getInstancia().agregarTrabajador(t6);
        FachadaSistema.getInstancia().agregarTrabajador(t7);
        FachadaSistema.getInstancia().agregarTrabajador(t8);
        FachadaSistema.getInstancia().agregarTrabajador(t10);

        FachadaSistema.getInstancia().agregarCliente(cli1);
        FachadaSistema.getInstancia().agregarCliente(cli2);
        FachadaSistema.getInstancia().agregarCliente(cli3);
        FachadaSistema.getInstancia().agregarCliente(cli4);
        FachadaSistema.getInstancia().agregarCliente(cli5);

        /*MonitoreoControlador controllerMonitoreo = new MonitoreoControlador();
        System.out.println("Prueba mostrar sectores " + controllerMonitoreo.listarSectores());
        System.out.println("Prueba mostrar llamadas " + controllerMonitoreo.listarLlamadasPorSector(s2));
        System.out.println("Prueba mostrar llamadas " + controllerMonitoreo.listarTodasLasLlamadas());
        */
    }

    // FORMATO "2022-10-25 22:33:00" "yyyy-MM-dd HH:mm:ss"
    private static Date parseDate(String fecha) throws ParseException {
        Date fechaParseada = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(fecha);
        return fechaParseada;
    }

}
