
package entidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author usuarioDAW
 */
public class Cliente extends Persona{
    protected String calle;
    protected String nCasa;
    protected List<Factura> historial;
    
    public Cliente(int id, String nombre, String apellidos, String tlf, String email, String localidad, String ciudad, String calle, String nCasa, String nombreUsuario, String contraseñaUsuario) {
        super(id, nombre, apellidos, tlf, email, localidad, ciudad, nombreUsuario, contraseñaUsuario);
        this.calle = calle;
        this.nCasa = nCasa;
        this.historial = new ArrayList();
    }

    public String getCalle() {
        return calle;
    }

    public String getnCasa() {
        return nCasa;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public void setnCasa(String nCasa) {
        this.nCasa = nCasa;
    }
}
