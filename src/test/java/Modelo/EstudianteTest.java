/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 * @author Usuario
 */
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import Modelo.Estudiante;

public class EstudianteTest {

    @Test
    public void testToString_Estudiante() {
        Estudiante estudiante = new Estudiante(
            "Ana Gómez", "Avenida 45", "5559876", "2008-10-20", 
            "EST001", "Décimo"
        );
        
        String resultadoEsperado = "Nombre: Ana Gómez | Tel: 5559876 | Dir: Avenida 45 | F.Nac: 2008-10-20| Codigo:EST001 | Grado:Décimo";
        
        assertEquals(resultadoEsperado, estudiante.toString());
    }
}
