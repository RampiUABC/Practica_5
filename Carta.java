package PooLab.practica_5;

/**
 * Representa una carta individual del mazo con un valor numérico y una figura.
 *
 * @author Ramiro Maldonado Madujano (Matrícula: 1184001)
 */
public class Carta {
    private int valor;
    private Figura figura;

    /**
     * Constructor que inicializa los atributos de la carta.
     *
     * @param valor  El valor numérico de la carta (1 al 13).
     * @param figura La figura de la carta especificada por el enum Figura.
     */
    public Carta(int valor, Figura figura) {
        this.valor = valor;
        this.figura = figura;
    }

    /**
     * Regresa la representación en cadena de la carta.
     * Utiliza letras para los valores numéricos especiales (AS, JOTA, REINA, REY).
     *
     * @return Cadena con el valor y la figura de la carta en el formato solicitado.
     */
    @Override
    public String toString() {
        String valorStr;
        switch (valor) {
            case 1:
                valorStr = "AS";
                break;
            case 11:
                valorStr = "JOTA";
                break;
            case 12:
                valorStr = "REINA";
                break;
            case 13:
                valorStr = "REY";
                break;
            default:
                valorStr = String.valueOf(valor);
                break;
        }
        return valorStr + " de " + figura;
    }
}