

class ListaNodoDoble {
    private NodoDoble cabeza;

    public ListaNodoDoble() {
        this.cabeza = null;
    }

    public boolean IsVacia() {
        return cabeza == null;
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

    public void imprimirAdelante() {
        NodoDoble actual = cabeza;
        while (actual != null) {
            System.out.print(actual.getPokemon() + " ");
            actual = actual.getSiguiente();
        }
        System.out.println();
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

    public void insertar(Pokemon pokemon) {
    }
}
