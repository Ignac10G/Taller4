    class ListaDoble {
    private Nodo cabeza;

    public ListaDoble() {
        this.cabeza = null;
    }

    public boolean estaVacia() {
        return cabeza == null;
    }

    public void agregarAlInicio(int dato) {
        Nodo nuevoNodo = new Nodo(dato);
        if (estaVacia()) {
            cabeza = nuevoNodo;
        } else {
            nuevoNodo.siguiente = cabeza;
            cabeza.anterior = nuevoNodo;
            cabeza = nuevoNodo;
        }
    }

    public void agregarAlFinal(int dato) {
        Nodo nuevoNodo = new Nodo(dato);
        if (estaVacia()) {
            cabeza = nuevoNodo;
        } else {
            Nodo actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevoNodo;
            nuevoNodo.anterior = actual;
        }
    }

    public void eliminar(int dato) {
        if (estaVacia()) {
            System.out.println("La lista está vacía");
            return;
        }

        if (cabeza.dato == dato) {
            cabeza = cabeza.siguiente;
            cabeza.anterior = null;
            return;
        }

        Nodo actual = cabeza;
        while (actual != null && actual.dato != dato) {
            actual = actual.siguiente;
        }

        if (actual == null) {
            System.out.println("El elemento no se encontró en la lista");
            return;
        }

        if (actual.siguiente != null) {
            actual.siguiente.anterior = actual.anterior;
        }
        actual.anterior.siguiente = actual.siguiente;
    }

    public void imprimirAdelante() {
        Nodo actual = cabeza;
        while (actual != null) {
            System.out.print(actual.dato + " ");
            actual = actual.siguiente;
        }
        System.out.println();
    }

    public void imprimirAtras() {
        if (estaVacia()) {
            System.out.println("La lista está vacía");
            return;
        }

        Nodo actual = cabeza;
        while (actual.siguiente != null) {
            actual = actual.siguiente;
        }

        while (actual != null) {
            System.out.print(actual.dato + " ");
            actual = actual.anterior;
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        ListaDoble lista = new ListaDoble();
        lista.agregarAlInicio(3);
        lista.agregarAlInicio(2);
        lista.agregarAlInicio(1);

        lista.imprimirAdelante();  // Salida: 1 2 3
        lista.imprimirAtras();     // Salida: 3 2 1

        lista.agregarAlFinal(4);
        lista.agregarAlFinal(5);

        lista.imprimirAdelante();  // Salida: 1 2 3 4 5
        lista.imprimirAtras();     // Salida: 5 4 3 2 1

        lista.eliminar(3);

        lista.imprimirAdelante();  // Salida: 1 2 4 5
        lista.imprimirAtras();     // Salida:
