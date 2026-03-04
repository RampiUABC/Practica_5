package PooLab.practica_5;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Pruebas unitarias para verificar la clase Mazo.
 *
 * @author Ramiro Maldonado Madujano (Matrícula: 1184001)
 */
public class MazoTest {

    @Test
    public void testBarajar() {
        Mazo mazo = new Mazo();
        String estadoOriginal = mazo.obtenerPrimerasCartas(52);

        mazo.barajar();
        String estadoBarajado = mazo.obtenerPrimerasCartas(52);

        // Al barajar 52 cartas, es estadísticamente imposible que el string sea
        // idéntico
        assertNotEquals("El mazo barajado no debería ser igual al original", estadoOriginal, estadoBarajado);
        assertEquals(52, mazo.getCantidadCartas());
    }

    @Test
    public void testGetCantidadCartas() {
        Mazo mazo = new Mazo();
        assertEquals(52, mazo.getCantidadCartas());
    }

    @Test
    public void testObtenerPrimerasCartas() {
        Mazo mazo = new Mazo();
        // Sabiendo que Corazones es la primera figura y 1, 2, 3 son los primeros
        // valores
        String primerasTres = mazo.obtenerPrimerasCartas(3);
        assertEquals("[AS de CORAZONES] [2 de CORAZONES] [3 de CORAZONES]", primerasTres);
    }

    @Test
    public void testObtenerUltimasCartas() {
        Mazo mazo = new Mazo();
        // Sabiendo que Espadas es la última figura y JOTA, REINA, REY son los últimos
        // valores
        String ultimasTres = mazo.obtenerUltimasCartas(3);
        assertEquals("[JOTA de ESPADAS] [REINA de ESPADAS] [REY de ESPADAS]", ultimasTres);
    }

    @Test
    public void testRegresarCarta() {
        Mazo mazo = new Mazo();
        Carta cartaExtra = new Carta(1, Figura.DIAMANTES);

        mazo.regresarCarta(cartaExtra);

        // El mazo ahora debería tener 53 cartas
        assertEquals(53, mazo.getCantidadCartas());
        // Y la carta debería estar al final
        assertTrue(mazo.obtenerUltimasCartas(1).contains("AS de DIAMANTES"));
    }

    @Test
    public void testRepartir() {
        Mazo mazo = new Mazo();
        Jugador j1 = new Jugador("Jugador1");
        Jugador j2 = new Jugador("Jugador2");
        Jugador[] mesa = { j1, j2 };

        // Repartimos 5 cartas a cada uno (10 cartas en total)
        mazo.repartir(mesa, 5);

        assertEquals(42, mazo.getCantidadCartas()); // 52 - 10 = 42
        assertTrue(j1.toString().contains("[AS de CORAZONES]")); // El J1 recibe la 1ra
        assertTrue(j2.toString().contains("[2 de CORAZONES]")); // El J2 recibe la 2da
    }

    @Test
    public void testRestablecerMazo() {
        Mazo mazo = new Mazo();
        Jugador[] mesa = { new Jugador("Prueba") };

        // Alteramos el mazo repartiendo 10 cartas
        mazo.repartir(mesa, 10);
        assertEquals(42, mazo.getCantidadCartas());

        // Lo restablecemos
        mazo.restablecerMazo();

        assertEquals(52, mazo.getCantidadCartas());
        assertEquals("[AS de CORAZONES] [2 de CORAZONES]", mazo.obtenerPrimerasCartas(2));
    }
}