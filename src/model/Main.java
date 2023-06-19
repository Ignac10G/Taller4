package model;

import coleccion.Buscador;
/**
 * The Main.
 *@author: Ignacio Gavia
 *@author: Vicente Castro
 */
public class Main {
    public static void main(String[] args) {
        Buscador nuevo = new Buscador();
        nuevo.lecturaArchivo();
        nuevo.menu();
    }
}
