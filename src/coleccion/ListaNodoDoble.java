package coleccion;

import model.Pokemon;

import static coleccion.Buscador.desplegarPokemon;
/**
 * Esta clase almacena los Nodos de los Pokemones.
 * @author: Ignacio Gavia
 * @author: Vicente Castro
 */
public class ListaNodoDoble {
    private NodoDoble cabeza;
    private NodoDoble tail;

    /**
     *The constructor.
     */
    public ListaNodoDoble() {
        this.cabeza = null;
    }

    /**
     * Método para saber si la lista esta vacia o no.
     * @return true si esta vacia.
     */
    public boolean IsVacia() {
        return this.cabeza == null;
    }


    /**
     * Método que agrega un pokemon al inicio de la lista.
     * @param pokemon Pokemon a agregar
     */
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

    /**
     * Método que agrega un pokemon al final de la lista.
     * @param pokemon Pokemon a agregar
     */
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

    /**
     * Método que elimina un pokemon de la lista.
     * @param pokemon Pokemon a eliminar
     */
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

    /**
     * Método que muestra los pokemones en orden.
     */
    public void imprimirAdelante() {
        NodoDoble actual = cabeza;
        while (actual != null) {
            desplegarPokemon(actual.getPokemon());
            actual = actual.getSiguiente();
        }
    }
    /**
     * Método que muestra los pokemones en orden contrario.
     */
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

    /**
     * Método que muestra el tamaño de la lista.
     * @return cantidad de elemetos.
     */
    public int tamanio(){
        int contador = 0;
        for(NodoDoble aux = this.cabeza; aux != null; aux = aux.getSiguiente()){
            contador ++;
        }
        return contador;
    }

    /**
     * Método que busca mediante una ID un Pokemon.
     * @param id ID a buscar
     * @return Nodo Pokemon.
     */
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

    /**
     * Método que busca mediante nombre un Pokemon.
     * @param nombre Nombre a buscar
     * @return Nodo Pokemon.
     */
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
    /**
     * Método que muestra los pokemones por tipo solicitado por consola.
     */
    public NodoDoble buscarPorTipo(String tipo) {
        NodoDoble actual = cabeza;
        while (actual != null) {
            if (actual.getPokemon().getTipo1().equals(tipo) || actual.getPokemon().getTipo2().equals(tipo)) {
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

    /**
     * Método que ordena de manera alfabetica mediante los nombres la lista de Pokemones.
     */
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
