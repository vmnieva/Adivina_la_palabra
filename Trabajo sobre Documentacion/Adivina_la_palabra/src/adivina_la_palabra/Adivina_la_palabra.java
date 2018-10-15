/*
 * Clase Main
 */
package adivina_la_palabra;

/**
 *
 * @author Victor Manuel Nieva Sanchez
 * @version 1.0
 */
public class Adivina_la_palabra {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Juego j = new Juego();
        int n = 5;
        while (n != 0 && !j.verSiganar()) {
            j.pintarHuecos();
            if (!j.pedirLetra()) {
                n--;
                System.out.println("Error!");
            }
        }
        if (j.verSiganar()) {
            System.out.println("Has ganado");
        } else {
            System.out.println("Has perdido");
        }
    }
    
}