package testEntidades;

import entidades.Cliente;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Minino
 */
public class ClienteTest {

    private Cliente cliente;

    @BeforeEach
    void setUp() {
        cliente = new Cliente(0, "Jose Mi", "Xerpa Suares", "123456789", "serpa@serpa.serpa",
                "Camerun", "Albacete", "si", "45", "RAul", "hola");
    }
    
    @Test
    @DisplayName("Test Getter y Setter de calle")
    void testCalle(){
        cliente.setCalle("cadiz");
        assertEquals("cadiz", cliente.getCalle());
    }
    
    @Test
    @DisplayName("Test Getter y Setter de nombre cliente")
    void testNombreCliente(){
        cliente.setNombre("javi");
        assertEquals("javi", cliente.getNombre());
    }
    
    @Test
    @DisplayName("Test Getter y Setter de nombre usuario")
    void testNombreUsuario(){
        cliente.setNombreUsuario("pepex");
        assertEquals("pepex", cliente.getNombreUsuario());
    }
    
    @Test
    @DisplayName("Test Getter y Setter de localidad")
    void testLocalidad(){
        cliente.setLocalidad("camas");
        assertEquals("camas", cliente.getLocalidad());
    }
    
    @Test
    @DisplayName("Test Getter y Setter de contraseña")
    void testContraseña(){
        cliente.setContraseñaUsuario("sorpresa");
        assertEquals("sorpresa", cliente.getContraseñaUsuario());
    }
    
    @Test
    @DisplayName("Test Getter y Setter de telefono")
    void testTelefono(){
        cliente.setTlf("012345678");
        assertEquals("012345678", cliente.getTlf());
    }
    
    @Test
    @DisplayName("Test Getter y Setter de email")
    void testEmail(){
        cliente.setEmail("no@no.no");
        assertEquals("no@no.no", cliente.getEmail());
    }
    
    @Test
    @DisplayName("Test Getter y Setter de numero de casa")
    void testNCasa(){
        cliente.setnCasa("5B");
        assertEquals("5B", cliente.getnCasa());
    }
    
    @Test
    @DisplayName("Test Getter y Setter de id")
    void testId(){
        cliente.setId(4);
        assertEquals(4, cliente.getId());
    }
    
    @Test
    @DisplayName("Test Getter y Setter de apellidos")
    void testApellidos(){
        cliente.setApellidos("perez perez");
        assertEquals("perez perez", cliente.getApellidos());
    }
    
    @Test
    @DisplayName("Test Getter y Setter de ciudad")
    void testCiudad(){
        cliente.setCiudad("Sevilla");
        assertEquals("Sevilla", cliente.getCiudad());
    }
}
