package coleccion;

import model.Pokemon;
/**
 * Esta clase almacena las clases tipo Pokemon.
 * @author: Ignacio Gavia
 * @author: Vicente Castro
 */
public class NodoDoble {
    private Pokemon pokemon;
    private NodoDoble siguiente;
    private NodoDoble anterior;

    /**
     * the constructor
     */
    public NodoDoble(Pokemon pokemon) {
        this.pokemon = pokemon;
        this.siguiente = null;
        this.anterior = null;
    }

    public Pokemon getPokemon() {
        return pokemon;
    }

    public void setPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    public NodoDoble getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoDoble siguiente) {
        this.siguiente = siguiente;
    }

    public NodoDoble getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoDoble anterior) {
        this.anterior = anterior;
    }
}

