package model;

import coleccion.Buscador;

public class Main {
    public static void main(String[] args) {
        Buscador nuevo = new Buscador();

        nuevo.lecturaArchivo();
        nuevo.menu();

    }
}
