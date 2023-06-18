package coleccion;

import coleccion.NodoDoble;
import model.Pokemon;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ListaNodoDoble {
    private NodoDoble cabeza;
    private NodoDoble tail;

    public ListaNodoDoble() {
        this.cabeza = null;
    }

    public boolean IsVacia() {
        return this.cabeza == null;
    }

    public void agregarAlInicio(Pokemon pokemon) {
        NodoDoble nuevoNodo = new NodoDoble(pokemon);
        if (IsVacia()) {
            cabeza = nuevoNodo;
        } else {
            nuevoNodo.setSiguiente(cabeza);
            cabeza.setAnterior(nuevoNodo);
            cabeza = nuevoNodo;
        }
    }

    public void agregarAlFinal(Pokemon pokemon) {
        NodoDoble nuevoNodo = new NodoDoble(pokemon);
        if (IsVacia()) {
            cabeza = nuevoNodo;
        } else {
            NodoDoble actual = cabeza;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevoNodo);
            nuevoNodo.setAnterior(actual);
        }
    }

    public void eliminar(Pokemon pokemon) {
        if (IsVacia()) {
            System.out.println("La lista está vacía");
            return;
        }

        if (cabeza.getPokemon() == pokemon) {
            cabeza = cabeza.getSiguiente();
            cabeza.setAnterior(null);
            return;
        }

        NodoDoble actual = cabeza;
        while (actual != null && actual.getPokemon() != pokemon) {
            actual = actual.getSiguiente();
        }

        if (actual == null) {
            System.out.println("El elemento no se encontró en la lista");
            return;
        }

        if (actual.getSiguiente() != null) {
            actual.getSiguiente().setAnterior(actual.getAnterior());
        }
        actual.getAnterior().setSiguiente(actual.getSiguiente());
    }

<<<<<<< HEAD
=======
    public void imprimirAdelante() {
        NodoDoble actual = cabeza;
        while (actual != null) {
            System.out.println(actual.getPokemon().getNombre());
            actual = actual.getSiguiente();
        }
    }

    public void imprimirAtras() {
        if (IsVacia()) {
            System.out.println("La lista está vacía");
            return;
        }

        NodoDoble actual = cabeza;
        while (actual.getSiguiente() != null) {
            actual = actual.getSiguiente();
        }

        while (actual != null) {
            System.out.print(actual.getPokemon() + " ");
            actual = actual.getAnterior();
        }
        System.out.println();
    }

>>>>>>> 37f2dcdbaeb7502f47cb5257eb24511759a2845b
    public void insertar(Pokemon pokemon) {
        NodoDoble nuevoNodo = new NodoDoble(pokemon);
        if (this.cabeza == null) {
            this.cabeza = nuevoNodo;
            this.tail = nuevoNodo;
        }

        NodoDoble aux = this.cabeza;
        while (aux.getSiguiente() != null){
            aux = aux.getSiguiente();
        }
        aux.setSiguiente(nuevoNodo);
        nuevoNodo.setAnterior(aux);
        setTail(nuevoNodo);
    }
    public int tamanio(){
        int contador = 0;
        for(NodoDoble aux = this.cabeza; aux != null; aux = aux.getSiguiente()){
            contador ++;
        }
        return contador;
    }

    public NodoDoble buscarPorId(int id) {
        NodoDoble actual = cabeza;
        while (actual != null) {
            if (actual.getPokemon().getId() == id) {
                return actual;
            }
            actual = actual.getSiguiente();
        }
        return null;
    }
    public NodoDoble buscarPorNombre(String nombre) {
        NodoDoble actual = cabeza;
        while (actual != null) {
            if (actual.getPokemon().getNombre().equals(nombre)) {
                return actual;
            }

            actual = actual.getSiguiente();
        }
        return null;
    }

    public void setTail(NodoDoble tail) {
        this.tail = tail;
    }

    public NodoDoble getTail() {
        return tail;
    }

    public NodoDoble getCabeza() {return cabeza;}


    public void ordenarAlfabeticamente() {
        if (IsVacia()) {
            System.out.println("La lista está vacía");
            return;
        }

        boolean cambio;
        NodoDoble actual;
        NodoDoble siguiente = null;

        do {
            cambio = false;
            actual = cabeza;
            while (actual.getSiguiente() != siguiente) {
                if (actual.getPokemon().getNombre().compareTo(actual.getSiguiente().getPokemon().getNombre()) > 0) {
                    Pokemon nuevo = actual.getPokemon();
                    actual.setPokemon(actual.getSiguiente().getPokemon());
                    actual.getSiguiente().setPokemon(nuevo);
                    cambio = true;
                }
                actual = actual.getSiguiente();
            }
            siguiente = actual;
        } while (cambio);
    }
}
