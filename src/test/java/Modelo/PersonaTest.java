package Modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import Modelo.Persona;

public class PersonaTest {

    @Test
    public void testConstructorYGetters() {
        Persona persona = new Persona("María Pérez", "Calle 10", "3001234567", "1990-01-01");
        
        assertEquals("María Pérez", persona.getNombre());
        assertEquals("Calle 10", persona.getDireccion());
        assertEquals("3001234567", persona.getTelefono());
        assertEquals("1990-01-01", persona.getFechaNacimiento());
    }

    @Test
    public void testSetters() {
        Persona persona = new Persona("Temp", "Temp", "Temp", "Temp");
        
        persona.setNombre("Carlos Ruiz");
        persona.setDireccion("Carrera 5");
        persona.setTelefono("3119876543");
        persona.setFechaNacimiento("1985-12-12");
        
        assertEquals("Carlos Ruiz", persona.getNombre());
        assertEquals("Carrera 5", persona.getDireccion());
        assertEquals("3119876543", persona.getTelefono());
        assertEquals("1985-12-12", persona.getFechaNacimiento());
    }

    @Test
    public void testToString() {
        Persona persona = new Persona("Juan", "Calle 1", "12345", "2000-05-05");
        String esperado = "Nombre: Juan | Tel: 12345 | Dir: Calle 1 | F.Nac: 2000-05-05";
        
        assertEquals(esperado, persona.toString());
    }
} 