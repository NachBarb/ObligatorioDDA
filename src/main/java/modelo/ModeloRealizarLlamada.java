/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import com.mycompany.ObliDDA.domino.Cliente;
import com.mycompany.ObliDDA.domino.Puesto;
import java.text.SimpleDateFormat;

/**
 *
 * @author Martin
 */
public class ModeloRealizarLlamada {
    private String numSector;
    private Cliente cliente;
    private Puesto puesto;
    private String cedula;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Puesto getPuesto() {
        return puesto;
    }

    public void setPuesto(Puesto puesto) {
        this.puesto = puesto;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String password) {
        this.cedula = password;
    }
    
       public void updateCedula(String caracter) {
       setCedula(cedula.concat(caracter));
    }

    public String getNumSector() {
        return numSector;
    }

    public void setNumSector(String numSector) {
        this.numSector = numSector;
    }
    
    public void updateNumSector(String caracter) {
       setCedula(numSector.concat(caracter));
    }
    
    public String mensajeInicioDeLlamada() {
        return "Llamada en curso… ud. se está comunicando con el sector " 
                + puesto.getSector().getNombre() 
                + "Y está siendo atendido por " 
                + puesto.getTrabajador().getNombre() 
                + " Su llamada se ha iniciado en " 
                + new SimpleDateFormat("yyyy-MM-dd").format(puesto.getLlamadaEnCurso().getInicio());
    }
    
    
}
