package PooLab.practica_5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Simula el manejo de un mazo de cartas.
 *
 * @author Ramiro Maldonado Madujano (Matrícula: 1184001)
 */
public class Mazo {
    private List<Carta> cartas;

    /**
     * Constructor que inicializa y llena el mazo con 52 cartas.
     */
    public Mazo() {
        cartas = new ArrayList<>();
        restablecerMazo();
    }

    /**
     * Restablece el mazo a su configuración inicial.
     */
    public void restablecerMazo() {
        cartas.clear();
        for (Figura f : Figura.values()) {
            for (int i = 1; i <= 13; i++) {
                cartas.add(new Carta(i, f));
            }
        }
    }

    /**
     * Baraja el mazo de cartas de forma aleatoria.
     */
    public void barajar() {
        Collections.shuffle(cartas);
    }

    /**
     * Reparte un número determinado de cartas a un arreglo de jugadores.
     *
     * @param jugadores Arreglo de jugadores que recibirán las cartas.
     * @param numCartas Número de cartas a repartir a cada jugador.
     */
    public void repartir(Jugador[] jugadores, int numCartas) {
        for (int i = 0; i < numCartas; i++) {
            for (Jugador j : jugadores) {
                if (!cartas.isEmpty()) {
                    j.asignarCarta(cartas.remove(0));
                }
            }
        }
    }

    /**
     * Permite regresar una carta a la pila (se agrega al final).
     *
     * @param c La carta a devolver.
     */
    public void regresarCarta(Carta c) {
        if (c != null) {
            cartas.add(c);
        }
    }

    /**
     * Obtiene la cantidad actual de cartas en el mazo.
     *
     * @return Número de cartas restantes.
     */
    public int getCantidadCartas() {
        return cartas.size();
    }

    /**
     * Regresa un String con las primeras N cartas del mazo para su visualización.
     *
     * @param cantidad Cantidad de cartas a mostrar.
     * @return Cadena con las representaciones de las cartas.
     */
    public String obtenerPrimerasCartas(int cantidad) {
        StringBuilder sb = new StringBuilder();
        int limite = Math.min(cantidad, cartas.size());
        for (int i = 0; i < limite; i++) {
            sb.append("[").append(cartas.get(i).toString()).append("] ");
        }
        return sb.toString().trim();
    }

    /**
     * Regresa un String con las últimas N cartas del mazo para comprobar
     * devoluciones.
     *
     * @param cantidad Cantidad de cartas a mostrar.
     * @return Cadena con las representaciones de las cartas.
     */
    public String obtenerUltimasCartas(int cantidad) {
        StringBuilder sb = new StringBuilder();
        int limite = Math.min(cantidad, cartas.size());
        int inicio = cartas.size() - limite;
        for (int i = inicio; i < cartas.size(); i++) {
            sb.append("[").append(cartas.get(i).toString()).append("] ");
        }
        return sb.toString().trim();
    }
}