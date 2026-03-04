package PooLab.practica_5;

/**
 * Clase principal que ejecuta la prueba secuencial del mazo de cartas.
 *
 * @author Ramiro Maldonado Madujano (Matrícula: 1184001)
 */
public class Juego {

    /**
     * Método principal que estructura la salida en consola para validar el
     * funcionamiento.
     *
     * @param args Argumentos de la línea de comandos.
     */
    public static void main(String[] args) {
        System.out.println("CREANDO MAZO DE 52 CARTAS");
        Mazo mazo = new Mazo();
        System.out.println("Mazo creado con " + mazo.getCantidadCartas() + " cartas\n");

        System.out.println("MOSTRANDO PRIMERAS 5 CARTAS DEL MAZO SIN BARAJAR:");
        System.out.println(mazo.obtenerPrimerasCartas(5) + "\n");

        System.out.println("BARAJANDO MAZO...");
        mazo.barajar();
        System.out.println("¡Mazo barajado!\n");

        System.out.println("MOSTRANDO PRIMERAS 5 CARTAS DEL MAZO DESPUÉS DE BARAJAR:");
        System.out.println(mazo.obtenerPrimerasCartas(5) + "\n");

        System.out.println("CREANDO 3 JUGADORES");
        Jugador j1 = new Jugador("Ana");
        Jugador j2 = new Jugador("Carlos");
        Jugador j3 = new Jugador("María");
        System.out.println("Jugador 1: " + j1.nombre);
        System.out.println("Jugador 2: " + j2.nombre);
        System.out.println("Jugador 3: " + j3.nombre + "\n");

        Jugador[] mesa = { j1, j2, j3 };

        System.out.println("REPARTIENDO 5 CARTAS A CADA JUGADOR");
        mazo.repartir(mesa, 5);
        System.out.println("Repartiendo... ¡Listo!\n");

        System.out.println("MOSTRANDO CARTAS DE CADA JUGADOR:");
        System.out.println(j1.toString());
        System.out.println(j2.toString());
        System.out.println(j3.toString() + "\n");

        System.out.println("CARTAS RESTANTES EN EL MAZO (DESPUÉS DE REPARTIR):");
        System.out.println("Quedan " + mazo.getCantidadCartas() + " cartas en el mazo");
        System.out.println("Primeras 5 cartas del mazo: " + mazo.obtenerPrimerasCartas(5) + "\n");

        // Ana (Jugador 1) se deshace de sus primeras 2 cartas dinámicamente
        Carta cartaDevuelta1 = j1.deshacerseDeCarta(0);
        Carta cartaDevuelta2 = j1.deshacerseDeCarta(0);

        System.out.println(j1.nombre.toUpperCase() + " DEVUELVE 2 CARTAS AL MAZO ("
                + cartaDevuelta1.toString() + " y " + cartaDevuelta2.toString() + ")\n");

        mazo.regresarCarta(cartaDevuelta1);
        mazo.regresarCarta(cartaDevuelta2);

        System.out.println("CARTAS DE " + j1.nombre.toUpperCase() + " DESPUÉS DE DEVOLVER:");
        System.out.println(j1.toString() + "\n");

        System.out.println("MAZO DESPUÉS DE RECIBIR CARTAS DEVUELTAS:");
        System.out.println("Quedan " + mazo.getCantidadCartas() + " cartas en el mazo");
        System.out.println("Las cartas devueltas se agregaron al final: ... " + mazo.obtenerUltimasCartas(2) + "\n");

        // Extraemos una carta real de la mano de Ana para asegurar que la búsqueda
        // funcione en la prueba
        String cartaABuscar = j1.verCarta(0).toString();
        System.out.println("BUSCANDO CARTA \"" + cartaABuscar + "\":");

        String poseedor = "Nadie";
        for (Jugador j : mesa) {
            if (j.tieneCarta(cartaABuscar)) {
                poseedor = j.nombre;
                break;
            }
        }
        System.out.println("La carta " + cartaABuscar + " está en posesión de: " + poseedor);
    }
}