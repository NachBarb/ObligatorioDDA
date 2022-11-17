/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import com.mycompany.ObliDDA.domino.Cliente;
import com.mycompany.ObliDDA.domino.ClienteExcepcion;
import java.util.HashMap;

/**
 *
 * @author Martin
 */
public class ServicioCliente {

    private static final String CI_INCORRECTA = "Cedula incorrecta.";
    private static final String YA_LOGUEADO = "El cliente ya se encuentra logueado";
    private HashMap<String, Cliente> clientes = new HashMap<>();
    private HashMap<String, Cliente> clientesLogueados = new HashMap<>();
    

    public boolean agregarCliente(Cliente cliente) {
        boolean trabajadorAgregadoOk = false;
        try {
            clientes.put(cliente.getCi(), cliente);
            trabajadorAgregadoOk = true;
        } finally {
        }

        return trabajadorAgregadoOk;
    }

    public Cliente loginCliente(String ciCliente) throws ClienteExcepcion {
        if(clientesLogueados.containsKey(ciCliente)){
        throw new ClienteExcepcion(YA_LOGUEADO);
        }
        
        Cliente c = clientes.get(ciCliente);
        if (c == null) {
            throw new ClienteExcepcion(CI_INCORRECTA);
        }
        clientesLogueados.put(ciCliente, c);
        return c;
    }
}
