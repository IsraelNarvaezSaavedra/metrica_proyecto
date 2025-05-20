package entidades;

/**
 *
 * @author usuarioDAW
 */
public class Productos {
    int id;
    String nombre;
    double precio;

    public Productos(int id, String nombre, double precio) {
        this.id = id;
        this.nombre = nombre;
        if (this.precio > 0){
            this.precio = precio;
        } else {
            throw new IllegalArgumentException("El precio no puede ser negativo");
        }
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    } 

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", precio: " + precio;
    }
    
    
}
