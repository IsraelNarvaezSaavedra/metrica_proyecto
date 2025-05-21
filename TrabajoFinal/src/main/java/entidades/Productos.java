package entidades;

/**
 *
 * @author usuarioDAW
 */
public class Productos {
    protected int id;
    protected String nombre;
    protected double precio;
    protected Categoria categoria;
    protected int stock;

    public Productos(int id, String nombre, Categoria categoria, double precio, int stock) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        if (this.precio > 0){
            this.precio = precio;
        } else {
            throw new IllegalArgumentException("El precio no puede ser negativo");
        }
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
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
