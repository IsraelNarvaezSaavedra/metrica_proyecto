
package entidades;

import javax.swing.JOptionPane;

/**
 *
 * @author usuarioDAW
 */
public class Persona {
    protected int id;
    protected String nombre;
    protected String apellidos;
    protected String tlf;
    protected String email;
    protected String localidad;
    protected String ciudad;
    protected String nombreUsuario;
    protected String contraseñaUsuario;
    

    public Persona(int id, String nombre, String apellidos, String tlf, String email, String localidad, String ciudad, String nombreUsuario, String contraseñaUsuario) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.tlf = tlf;
        this.email = email;
        this.localidad = localidad;
        this.ciudad = ciudad;
        this.nombreUsuario = nombreUsuario;
        this.contraseñaUsuario = contraseñaUsuario;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getTlf() {
        return tlf;
    }

    public String getEmail() {
        return email;
    }

    public String getLocalidad() {
        return localidad;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setTlf(String tlf) {
        this.tlf = tlf;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    
    public static void UsuarioVacio(String mensaje, String titulo) {
        JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.DEFAULT_OPTION);
    }

    @Override
    public String toString() {
        return "Nombre del cliente: " + nombre + " " + apellidos + ", teléfono: " + tlf + ", email: " + email + "vive en: " + localidad + " " + ciudad;
    }
    
    
}
