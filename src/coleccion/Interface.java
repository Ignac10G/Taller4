package coleccion;
/**
 * Interface que implementa los metodos del sistema.
 * @author: Ignacio Gavia
 * @author: Vicente Castro
 */
public interface Interface{
    /**
     * Lectura de archivo.
     */
    void lecturaArchivo();

    /**
     * Este método se encarga del control del menu principal del sofware.
     */
    void menu();

    /**
     * Método que pregunta mediante consola la ID o nombre del pokemon a buscar.
     */
    void BuscarPokemon();

    /**
     * Medoto que desplega una tabla con las caracteristicas del pokemon.
     * @param pokemon Nodo pokemon a desplegar.
     */
    void desplegarPoke(NodoDoble pokemon);

    /**
     * Método que recibe una concatenacion y transforma el primer caracte a mayuscula y los demas en minusulas.
     * @param str palabra o cadena a capitalizar.
     * @return String capitalizado.
     */
    String capitalize(String str);

    /**
     * Método que muestra los pokemones de primera evolucion.
     * @param cabeza Nodo pokemon a mostrar.
     */
    void MostrarTodosPrimeraEvo(NodoDoble cabeza);

    /**
     * Método que muestra los pokemones por tipo solicitado por consola.
     */
    void MostrarPokemonTipo();
}
