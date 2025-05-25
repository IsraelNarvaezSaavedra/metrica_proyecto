package testEntidades;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import entidades.Productos;
import entidades.Valoracion;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Minino
 */
public class ValoracionTest {
    private Valoracion valoracion;
    
    @BeforeEach
    void setUp() {
        valoracion = new Valoracion(5, 9, "nueva valoracion", 5.00);
    }
    
    @Test
    @DisplayName("Test Getter y Setter de id_producto de valoracion")
    void testIdProductoValoracion(){
        valoracion.setProducto_id(3);
        assertEquals(3, valoracion.getProducto_id());
    }
    
    @Test
    @DisplayName("Test Getter y Setter de id_producto de valoracion")
    void testIdClienteValoracion(){
        valoracion.setCliente_id(4);
        assertEquals(4, valoracion.getCliente_id());
    }
    
    @Test
    @DisplayName("Test Getter y Setter de comentario de valoracion")
    void testComentarioValoracion(){
        valoracion.setComentario("una valoracion es...");
        assertEquals("una valoracion es...", valoracion.getComentario());
    }
    
    @Test
    @DisplayName("Test Getter y Setter de estrellas de valoracion")
    void testEstrellasValoracion(){
        valoracion.setValoracion(4.50);
        assertEquals(4.50, valoracion.getValoracion());
    }
    
    @Test
    @DisplayName("Verificar que el método toString devuelve la información correcta")
    void testToString() {
        
        String expectedString = "Valoracion{" + "producto_id=" + valoracion.getProducto_id() + ", cliente_id=" +valoracion.getCliente_id() 
        + ", comentario=" + valoracion.getComentario() + ", valoracion=" + valoracion.getValoracion() + '}';
        
        assertEquals(expectedString, valoracion.toString());
    }
}
