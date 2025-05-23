package entidades;

public class Valoracion {

    protected int producto_id;
    protected int cliente_id;
    protected String comentario;
    protected double valoracion;

    public Valoracion(int producto_id, int cliente_id, String comentario, double valoracion) {
        this.producto_id = producto_id;
        this.cliente_id = cliente_id;
        this.comentario = comentario;
        this.valoracion = valoracion;
    }

    public int getProducto_id() {
        return producto_id;
    }

    public int getCliente_id() {
        return cliente_id;
    }

    public String getComentario() {
        return comentario;
    }

    public double getValoracion() {
        return valoracion;
    }

    public void setProducto_id(int producto_id) {
        this.producto_id = producto_id;
    }

    public void setCliente_id(int cliente_id) {
        this.cliente_id = cliente_id;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public void setValoracion(double valoracion) {
        this.valoracion = valoracion;
    }

    @Override
    public String toString() {
        return "Valoracion{" + "producto_id=" + producto_id + ", cliente_id=" + cliente_id + ", comentario=" + comentario + ", valoracion=" + valoracion + '}';
    }
    
    
    
}
