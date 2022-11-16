package controlador;

import com.mycompany.ObliDDA.domino.Trabajador;
import com.mycompany.ObliDDA.domino.TrabajadorExcepcion;
import com.mycompany.ObliDDA.iu.Login;
import javax.swing.JOptionPane;
import logica.FachadaSistema;

/**
 *
 * @author MSI
 */
public class LoginControlador {

    private Login vista;

    public LoginControlador(Login vista) {
        this.vista = vista;
    }

    public void loginTrabajador() {

        String ci = vista.getCi();
        String password = vista.getPassword();

        try {
            Trabajador trabajador = FachadaSistema.getInstancia().login(ci, password);
            trabajador.getSector().asignarTrabajador(trabajador);
            vista.ejecutarSiguienteCU(trabajador);
        } catch (TrabajadorExcepcion trabajadorExcepcion) {
            JOptionPane.showMessageDialog(vista, trabajadorExcepcion.getMessage());
        }

    }

}
