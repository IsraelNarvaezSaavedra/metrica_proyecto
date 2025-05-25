package testEntidades;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import entidades.Persona;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Minino
 */
public class PersonaTest {
    private Persona persona;
    
    @BeforeEach
    void setUp() {
        persona = new Persona(1, "Luis", "Garcia", "987654321", "sip@sip.sip", "bollullos", "A Coruña", "pardo", "123");
    }
    
    @Test
    @DisplayName("Test Getter y Setter de id")
    void testIdpersona(){
        persona.setId(3);
        assertEquals(3, persona.getId());
    }
    
    @Test
    @DisplayName("Test Getter y Setter de nombre de persona")
    void testNombrePersona(){
        persona.setNombre("Pablo");
        assertEquals("Pablo", persona.getNombre());
    }
    
    @Test
    @DisplayName("Test Getter y Setter de apellido de persona")
    void testApellidoPersona(){
        persona.setApellidos("Palacios");
        assertEquals("Palacios", persona.getApellidos());
    }
    
    @Test
    @DisplayName("Test Getter y Setter de telefono de persona")
    void testTlfPersona(){
        persona.setTlf("850167307");
        assertEquals("850167307", persona.getTlf());
    }
    
    @Test
    @DisplayName("Test Getter y Setter de Email de persona")
    void testEmailPersona(){
        persona.setEmail("nop@nop.nop");
        assertEquals("nop@nop.nop", persona.getEmail());
    }
    
    @Test
    @DisplayName("Test Getter y Setter de Localidad de persona")
    void testLocalidadPersona(){
        persona.setLocalidad("Bormujos");
        assertEquals("Bormujos", persona.getLocalidad());
    }
    
    @Test
    @DisplayName("Test Getter y Setter de ciudad de persona")
    void testCiudadPersona(){
        persona.setCiudad("Albacete");
        assertEquals("Albacete", persona.getCiudad());
    }
    
    @Test
    @DisplayName("Test Getter y Setter de nombre de usuario")
    void testNombreUsuario(){
        persona.setNombreUsuario("xXMininoXx");
        assertEquals("xXMininoXx", persona.getNombreUsuario());
    }
    
    @Test
    @DisplayName("Test Getter y Setter de contraseña de usuario")
    void testContraseñaUsuario(){
        persona.setContraseñaUsuario("holaaa");
        assertEquals("holaaa", persona.getContraseñaUsuario());
    }
    
    @Test
    @DisplayName("Test de un telefono valido")
    void testTlfvalido(){
        persona.setTlf("holaaa");
        boolean esValido = false;
        assertEquals(esValido, persona.esTelefonoValido(persona.getTlf()));
    }
    
    @Test
    @DisplayName("Test de un email valido sin @ ni .")
    void testEmailvalidoSinNada(){
        persona.setEmail("asjdhf");
        boolean esValido = false;
        assertEquals(esValido, persona.esEmailValido(persona.getEmail()));
    }
    
    @Test
    @DisplayName("Test de un email valido sin .")
    void testEmailvalidoSinPunto(){
        persona.setEmail("asjdhf@dsd");
        boolean esValido = false;
        assertEquals(esValido, persona.esEmailValido(persona.getEmail()));
    }
    
    @Test
    @DisplayName("Test de un email valido sin @")
    void testEmailvalidoSinArroba(){
        persona.setEmail("asjdhf.dsd");
        boolean esValido = false;
        assertEquals(esValido, persona.esEmailValido(persona.getEmail()));
    }
}
