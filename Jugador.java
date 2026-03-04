package PooLab.practica_5;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa a un jugador que maneja una mano de cartas.
 *
 * @author Ramiro Maldonado Madujano (Matrícula: 1184001)
 */
public class Jugador {
    /**
     * Nombre del jugador, accesible públicamente según los requerimientos.
     */
    public String nombre;
    private List<Carta> mano;

    /**
     * Constructor que inicializa el jugador.
     *
     * @param nombre El nombre del jugador.
     */
    public Jugador(String nombre) {
        this.nombre = nombre;
        this.mano = new ArrayList<>();
    }

    /**
     * Asigna una carta a la mano del jugador.
     *
     * @param c La carta recibida.
     */
    public void asignarCarta(Carta c) {
        mano.add(c);
    }

    /**
     * Elimina y regresa la carta en la posición indicada de la mano.
     *
     * @param indice El índice de la carta a descartar.
     * @return La carta removida.
     */
    public Carta deshacerseDeCarta(int indice) {
        if (indice >= 0 && indice < mano.size()) {
            return mano.remove(indice);
        }
        return null;
    }

    /**
     * Permite ver una carta sin removerla de la mano (útil para búsquedas).
     *
     * @param indice Índice de la carta.
     * @return La carta en esa posición.
     */
    public Carta verCarta(int indice) {
        if (indice >= 0 && indice < mano.size()) {
            return mano.get(indice);
        }
        return null;
    }

    /**
     * Verifica si el jugador posee una carta específica basándose en su nombre.
     *
     * @param nombreCarta La representación en String de la carta (ej. "AS de
     *                    CORAZONES").
     * @return True si el jugador tiene la carta, False en caso contrario.
     */
    public boolean tieneCarta(String nombreCarta) {
        for (Carta c : mano) {
            if (c.toString().equalsIgnoreCase(nombreCarta)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Regresa la cadena estructurada con las cartas del jugador.
     *
     * @return Nombre del jugador y su mano entre corchetes.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(nombre).append(" tiene:");
        for (Carta c : mano) {
            sb.append(" [").append(c.toString()).append("]");
        }
        return sb.toString();
    }
}