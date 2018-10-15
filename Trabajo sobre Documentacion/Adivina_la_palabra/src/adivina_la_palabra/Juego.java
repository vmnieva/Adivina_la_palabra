/*
 * Clase Juego, en la cual estan los metodos principales del juego.
 */
package adivina_la_palabra;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Victor Manuel Nieva Sanchez
 * @version 1.0
 */
public class Juego {

    private char vector[];      //Vector de la palabra oculta.
    private String palabra;     //String para recoger la palabra oculta.
    private char letra;         //Letra que introduce el usuario.
    private char solucion[];    //Vector en el que se añaden las letras acertadas.

    /**
     * Constructor que llama a pedirPalabra(), a rellenarS() y finalmente
     * pone la variable letra en ' '.
     */
    public Juego() {
        pedirPalabra();
        rellenarS();
        this.letra = ' ';
    }
    
    /**
     * Rellena el vector de soluciones en blanco para darle memoria.
     */
    private void rellenarS(){
        this.solucion = new char[this.vector.length];
        for (int i = 0; i < this.solucion.length; i++) {
            this.solucion[i] = ' ';
        }
    }

    /**
     * Desde el constructor se llama a este metodo que pide que pongas una 
     * palabra a sacar y la descompone letra a letra en un vector oculto.
     */
    private void pedirPalabra() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Dime una palabra a adivinar");
        this.palabra = sc.nextLine().trim();
        for (int i = 0; i < 100; i++) {
            System.out.println("");
        }
        this.vector = new char[this.palabra.length()];
        for (int i = 0; i < this.palabra.length(); i++) {
            this.vector[i] = (char) (this.palabra.charAt(i));
        }
    }

    /**
     * Va pidiendo letra a letra y las compara con todas las letras del vector 
     * y si hay coincidencias se añade la letra en cada posición del vector 
     * visible cada acierto devuelve true y evita que el contador de 
     * oportunidades baje.
     * 
     * @return 
     */
    public boolean pedirLetra() {
        System.out.println("Dame una letra");
        Scanner sc = new Scanner(System.in);
        boolean acierto = false;
        this.letra = sc.nextLine().charAt(0);
        for (int i = 0; i < this.vector.length; i++) {
            if (this.vector[i] == letra) {
                this.solucion[i] = this.vector[i];
                acierto = true;
            }
        }
        return acierto;
    }

    /**
     * Compara cada posición de los dos vectores y si son iguales pinta la
     * posición i de solución y si son distintos pinta un hueco vacío.
     */
    public void pintarHuecos() {
        for (int i = 0; i < this.vector.length; i++) {
            if (this.vector[i] == this.solucion[i]) {
                System.out.print("[" + this.solucion[i] + "]");
            } else {
                System.out.print("[_]");
            }
        }
        System.out.println("");
    }

    /**
     * Pasa los dos vectores a String y si son completamente iguales
     * devuelve un true, si no devuelve false.
     * 
     * @return 
     */
    public boolean verSiganar(){
        boolean ganar = false;
        String sol = Arrays.toString(this.solucion).trim();
        String vec = Arrays.toString(this.vector).trim();
        if (sol.equals(vec)) {
            ganar = true;
        }
        return ganar;
    }
    
}