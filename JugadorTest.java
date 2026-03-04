package PooLab.practica_5;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Pruebas unitarias para verificar la clase Jugador.
 *
 * @author Ramiro Maldonado Madujano (Matrícula: 1184001)
 */
public class JugadorTest {

    @Test
    public void testAsignarCarta() {
        Jugador jugador = new Jugador("Ana");
        Carta carta = new Carta(10, Figura.DIAMANTES);

        jugador.asignarCarta(carta);

        assertTrue(jugador.tieneCarta("10 de DIAMANTES"));
    }

    @Test
    public void testDeshacerseDeCarta() {
        Jugador jugador = new Jugador("Carlos");
        Carta carta1 = new Carta(2, Figura.ESPADAS);
        Carta carta2 = new Carta(3, Figura.CORAZONES);

        jugador.asignarCarta(carta1);
        jugador.asignarCarta(carta2);

        // Se deshace de la primera carta (índice 0)
        Carta devuelta = jugador.deshacerseDeCarta(0);

        assertNotNull(devuelta);
        assertEquals("2 de ESPADAS", devuelta.toString());
        assertFalse(jugador.tieneCarta("2 de ESPADAS"));
        assertTrue(jugador.tieneCarta("3 de CORAZONES"));
    }

    @Test
    public void testTieneCarta() {
        Jugador jugador = new Jugador("María");
        jugador.asignarCarta(new Carta(12, Figura.TRÉBOLES)); // REINA de TRÉBOLES

        assertTrue(jugador.tieneCarta("REINA de TRÉBOLES"));
        assertFalse(jugador.tieneCarta("AS de CORAZONES"));
    }

    @Test
    public void testToString() {
        Jugador jugador = new Jugador("Ramiro");
        jugador.asignarCarta(new Carta(5, Figura.CORAZONES));

        String salidaEsperada = "Ramiro tiene: [5 de CORAZONES]";
        assertEquals(salidaEsperada, jugador.toString());
    }

    @Test
    public void testVerCarta() {
        Jugador jugador = new Jugador("Ana");
        jugador.asignarCarta(new Carta(7, Figura.ESPADAS));

        Carta vista = jugador.verCarta(0);

        assertNotNull(vista);
        assertEquals("7 de ESPADAS", vista.toString());
        // Comprobar que verla no la elimina de la mano
        assertTrue(jugador.tieneCarta("7 de ESPADAS"));
    }
}