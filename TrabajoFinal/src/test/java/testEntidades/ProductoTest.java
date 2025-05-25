package testEntidades;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import entidades.Productos;
import entidades.Categoria;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Minino
 */
public class ProductoTest {
private Productos productos;
private Categoria categoria;
    
    @BeforeEach
    void setUp() {
        productos = new Productos(1, "poster", categoria.merch, 2.00, 4);
    }
    
    @Test
   	@DisplayName("Debería lanzar una excepción si el precio es negativo")
   	void testPrecioProductoNegativo() throws Exception{
   		Exception exception = assertThrows(IllegalArgumentException.class, ()->{
               new Productos(4,"estanteria",categoria.otros,-45.00,2); });
   		String mensajeEsperado = "El precio no puede ser negativo";
   		assertEquals(mensajeEsperado, exception.getMessage());
   	}
    @Test
    @DisplayName("Test Getter y Setter de id producto")
    void testIdProducto(){
        productos.setId(3);
        assertEquals(3, productos.getId());
    }
    
    @Test
    @DisplayName("Test Getter y Setter de nombre de producto")
    void testNombreProducto(){
        productos.setNombre("papaya");
        assertEquals("papaya", productos.getNombre());
    }
    
    @Test
    @DisplayName("Test Getter y Setter de categoria de producto")
    void testcategoriaProducto(){
        productos.setCategoria(categoria.otros);
        assertEquals(categoria.otros, productos.getCategoria());
    }
    
    @Test
    @DisplayName("Test Getter y Setter de precio de producto")
    void testPrecioProducto(){
        productos.setPrecio(80.00);
        assertEquals(80.00, productos.getPrecio());
    }
    
    @Test
    @DisplayName("Test Getter y Setter de stock de producto")
    void testStockProducto(){
        productos.setStock(7);
        assertEquals(7, productos.getStock());
    }
}
