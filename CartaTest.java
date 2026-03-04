package PooLab.practica_5;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Pruebas unitarias para verificar la clase Carta.
 *
 * @author Ramiro Maldonado Madujano (Matrícula: 1184001)
 */
public class CartaTest {

    @Test
    public void testToString() {
        // Prueba de valores numéricos normales
        Carta cincoCorazones = new Carta(5, Figura.CORAZONES);
        assertEquals("5 de CORAZONES", cincoCorazones.toString());

        // Prueba de valores especiales (AS, JOTA, REINA, REY)
        Carta asDiamantes = new Carta(1, Figura.DIAMANTES);
        assertEquals("AS de DIAMANTES", asDiamantes.toString());

        Carta jotaTreboles = new Carta(11, Figura.TRÉBOLES);
        assertEquals("JOTA de TRÉBOLES", jotaTreboles.toString());

        Carta reyEspadas = new Carta(13, Figura.ESPADAS);
        assertEquals("REY de ESPADAS", reyEspadas.toString());
    }
}