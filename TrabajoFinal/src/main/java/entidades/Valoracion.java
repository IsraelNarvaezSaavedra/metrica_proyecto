/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author isran
 */
public class Valoracion {
    
    protected int producto_id;
    protected int cliente_id;
    protected String comentario;
    protected Double valoracion;

    public Valoracion(int producto_id, int cliente_id, String comentario, Double valoracion) {
        this.producto_id = producto_id;
        this.cliente_id = cliente_id;
        this.comentario = comentario;
        this.valoracion = valoracion;
    }

    public int getProducto_id() {
        return producto_id;
    }

    public void setProducto_id(int producto_id) {
        this.producto_id = producto_id;
    }

    public int getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(int cliente_id) {
        this.cliente_id = cliente_id;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Double getValoracion() {
        return valoracion;
    }

    public void setValoracion(Double valoracion) {
        this.valoracion = valoracion;
    }
    
    
}
