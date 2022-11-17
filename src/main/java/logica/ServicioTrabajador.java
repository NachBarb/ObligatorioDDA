package logica;

import com.mycompany.ObliDDA.domino.Trabajador;
import com.mycompany.ObliDDA.domino.TrabajadorExcepcion;
import java.util.HashMap;

public class ServicioTrabajador {
    
    
    private HashMap<String, Trabajador> trabajadores;
    private HashMap<String, Trabajador> trabajadoresLogueados;
    
    public ServicioTrabajador(){
     this.trabajadores = new HashMap<>();
     this.trabajadoresLogueados = new HashMap<>();
    }
    
    private static final String CI_YO_CONTRASEÑA_INCORRECTA = "Cedula y/o contraseña incorrecta.";
    private static final String TRABAJADOR_YA_LOGUEADO = "El trabajador ya se encuentra en el sistema";
    
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
        if(trabajadoresLogueados.containsKey(t.getCi())){
        throw new TrabajadorExcepcion(TRABAJADOR_YA_LOGUEADO);
        }
        if (t == null || !t.esPassValida(password)) {
            throw new TrabajadorExcepcion(CI_YO_CONTRASEÑA_INCORRECTA);
        }
        
        return t;
    }    
        
        public void logOutCliente(Trabajador trabajador){
        
    }
}
