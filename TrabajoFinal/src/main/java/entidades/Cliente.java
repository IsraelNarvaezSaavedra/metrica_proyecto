package entidades;



import java.util.List;
import java.util.ArrayList;

public class Cliente extends Persona {

    protected String calle;
    protected String nCasa;
    protected List<Factura> historial = new ArrayList();

    public Cliente(int id, String nombre, String apellidos, String tlf, String email, String localidad, String ciudad, String calle, String nCasa, String nombreUsuario, String contraseñaUsuario) {
        super(id, nombre, apellidos, tlf, email, localidad, ciudad, nombreUsuario, contraseñaUsuario);
        this.calle = calle;
        this.nCasa = nCasa;

        this.historial = new ArrayList();
    }

    
     public List<Factura> getHistorial() {
        return historial;
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

    public void setHistorial(List<Factura> historial) {
        this.historial = historial;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String getApellidos() {
        return apellidos;
    }

    @Override
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    @Override
    public String getTlf() {
        return tlf;
    }

    @Override
    public void setTlf(String tlf) {
        this.tlf = tlf;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getLocalidad() {
        return localidad;
    }

    @Override
    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    @Override
    public String getCiudad() {
        return ciudad;
    }

    @Override
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContraseñaUsuario() {
        return contraseñaUsuario;
    }

    public void setContraseñaUsuario(String contraseñaUsuario) {
        this.contraseñaUsuario = contraseñaUsuario;
    }

}
