/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import com.mycompany.ObliDDA.domino.Trabajador;
import com.mycompany.ObliDDA.domino.TrabajadorExcepcion;
import java.util.HashMap;

/**
 *
 * @author Martin
 */
public class ServicioTrabajador {
    private HashMap<String, Trabajador> trabajadores = new HashMap<>();
    
    private static final String CI_YO_CONTRASEÑA_INCORRECTA = "Cedula y/o contraseña incorrecta.";

    
    public boolean agregarTrabajador(Trabajador trabajador){
            boolean trabajadorAgregadoOk = false;
        try {
            trabajadores.put(trabajador.getCi(), trabajador);
            trabajadorAgregadoOk = true;
        } finally {
        }

        return trabajadorAgregadoOk;
    }
    
        public Trabajador loginTrabajador(String ciTrabajador, String password) throws TrabajadorExcepcion {
        Trabajador t = trabajadores.get(ciTrabajador);
        if (t == null || !t.esPassValida(password)) {
            throw new TrabajadorExcepcion(CI_YO_CONTRASEÑA_INCORRECTA);
        }
        return t;
    }
    
    
    
    
    
}
