package logica;

import com.mycompany.ObliDDA.domino.Trabajador;
import com.mycompany.ObliDDA.domino.TrabajadorExcepcion;
import java.util.HashMap;

public class ServicioTrabajador {
    
    
    private HashMap<String, Trabajador> trabajadores;
    
    public ServicioTrabajador(){
     this.trabajadores = new HashMap<>();
    }
    
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
