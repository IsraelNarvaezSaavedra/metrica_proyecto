package entidades;

import bdd.DAOValoracion;
import java.util.List;

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
        if (precio > 0.00){
            this.precio = precio;
        } else {
            throw new IllegalArgumentException("El precio no puede ser negativo");
        }
        this.stock = stock;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
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

    public List<Valoracion> getValoraciones() {
        return DAOValoracion.valoracionProducto(this.id);
    }
    
    public double getMediaValoraciones() {
        List<Valoracion> valoraciones = getValoraciones();
        if (valoraciones.isEmpty()) return 0.0;

        double suma = 0;
        for (Valoracion v : valoraciones) {
            suma += v.getValoracion();
        }
        return suma / valoraciones.size();
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", precio: " + precio;
    }
}
