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
    private HashMap<String, Cliente> clientes = new HashMap<>();

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
        Cliente c = clientes.get(ciCliente);
        if (c == null) {
            throw new ClienteExcepcion(CI_INCORRECTA);
        }
        return c;
    }
}
