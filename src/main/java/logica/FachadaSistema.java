package logica;

import com.mycompany.ObliDDA.domino.Cliente;
import com.mycompany.ObliDDA.domino.ClienteExcepcion;
import com.mycompany.ObliDDA.domino.Trabajador;
import com.mycompany.ObliDDA.domino.TrabajadorExcepcion;

public class FachadaSistema {

    private ServicioTrabajador servicioTrabajador;
    private ServicioCliente servicioCliente;
    private static FachadaSistema instancia;

    private FachadaSistema() {
        servicioTrabajador = new ServicioTrabajador();
        servicioCliente = new ServicioCliente();
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

    public void agregarCliente(Cliente c){
        this.servicioCliente.agregarCliente(c);
    }
    
    public Cliente login(String ciCliente) throws ClienteExcepcion{
        return this.servicioCliente.loginCliente(ciCliente);
    }
}
