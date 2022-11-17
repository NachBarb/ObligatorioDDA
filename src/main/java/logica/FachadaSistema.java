package logica;

import com.mycompany.ObliDDA.domino.Cliente;
import com.mycompany.ObliDDA.domino.ClienteExcepcion;
import com.mycompany.ObliDDA.domino.Llamada;
import com.mycompany.ObliDDA.domino.Sector;
import com.mycompany.ObliDDA.domino.SectorExcepcion;
import com.mycompany.ObliDDA.domino.Trabajador;
import com.mycompany.ObliDDA.domino.TrabajadorExcepcion;
import java.util.ArrayList;

public class FachadaSistema {

    private ServicioTrabajador servicioTrabajador;
    private ServicioCliente servicioCliente;
    private ServicioSector servicioSector;
    private static FachadaSistema instancia;

    private FachadaSistema() {
        servicioTrabajador = new ServicioTrabajador();
        servicioCliente = new ServicioCliente();
        servicioSector = new ServicioSector();
    }

    public synchronized static FachadaSistema getInstancia() {
        if (instancia == null) {
            instancia = new FachadaSistema();
        }
        return instancia;
    }

    public Trabajador login(String ci, String password) throws TrabajadorExcepcion {
        return this.servicioTrabajador.loginTrabajador(ci, password);
    }

    public void agregarTrabajador(Trabajador t) {
        this.servicioTrabajador.agregarTrabajador(t);
    }

    public void agregarCliente(Cliente c) {
        this.servicioCliente.agregarCliente(c);
    }

    public void agregarSector(Sector s) {
        this.servicioSector.agregarSector(s);
    }

    public Cliente login(String ciCliente) throws ClienteExcepcion {
        return this.servicioCliente.loginCliente(ciCliente);
    }
    
    public Sector buscarSector(int n) throws SectorExcepcion{
    return this.servicioSector.devolverSector(n);
    }
    
    public ArrayList<Sector> listarSectores() {
        return servicioSector.getSectores();
    }
    
    public ArrayList<Llamada> listarLlamadasPorSector(Sector sector) {
        return servicioSector.listarLlamadasPorSector(sector);
    }

    public ArrayList<Llamada> listarTodasLasLlamadas() {
        return servicioSector.listarTodasLasLlamadas();
    }
    
    public Llamada iniciarLlamada(Cliente cliente) throws SectorExcepcion{
    return servicioSector.crearLlamada(cliente);
    }
    
    public void inicioLlamada() {
        servicioSector.inicioLlamada();
    }
    
    public void terminoLlamada() {
      servicioSector.terminoLlamada();
    }
    
    
    public void logOutCliente(Cliente cliente){
    servicioCliente.logOutCliente(cliente);
    }
    
    public void logOutTrabajador(Trabajador trabajador){
        servicioTrabajador.logOutTrabajador(trabajador);
    }
    
    
}
