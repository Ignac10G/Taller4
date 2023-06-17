import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Buscador implements Interface {
    private ListaNodoDoble listaPokemon;

    public Buscador(){
        this.listaPokemon = new ListaNodoDoble();
    }

    @Override
    public void lecturaArchivo() {
        try {
            Scanner scanner = new Scanner(new File("kanto.txt"));
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine().trim();
                if (!linea.isEmpty()) {
                    continue;
                }
                String[] datos = linea.split(",");
                int id;
                String nombre;
                String etapa;
                String evolucion1;
                String evolucion2;
                String evolucion3;
                String evolucionSiguiente;
                String tipo1;
                String tipo2;

                if (datos.length == 7){
                    id = Integer.parseInt(datos[0].trim());
                    nombre = datos[1].trim();
                    etapa = datos[2].trim();
                    evolucion1 = datos[3].trim();
                    evolucionSiguiente = datos[4].trim();
                    tipo1 = datos[5].trim();
                    tipo2 = datos[6].trim();
                    Pokemon pokemon = new Pokemon(id, nombre, etapa, evolucion1, evolucionSiguiente, tipo1, tipo2);
                    listaPokemon.insertar(pokemon);
                }
                else if (datos.length==8){
                    id = Integer.parseInt(datos[0].trim());
                    nombre = datos[1].trim();
                    etapa = datos[2].trim();
                    evolucion1 = datos[3].trim();
                    evolucion2 = datos[4].trim();
                    evolucion3 = datos[5].trim();
                    tipo1 = datos[6].trim();
                    tipo2 = datos[7].trim();
                    Pokemon pokemon = new Pokemon(id,nombre,etapa,evolucion1,evolucion2,evolucion3,tipo1,tipo2);
                    listaPokemon.insertar(pokemon);
                }
                else if (datos.length==5){
                    id = Integer.parseInt(datos[0].trim());
                    nombre = datos[1].trim();
                    etapa = datos[2].trim();
                    tipo1 = datos[3].trim();
                    tipo2 = datos[4].trim();
                    Pokemon pokemon = new Pokemon(id,nombre,etapa,tipo1,tipo2);
                    listaPokemon.insertar(pokemon);
                }
                else if (datos.length==6){
                    id = Integer.parseInt(datos[0].trim());
                    nombre = datos[1].trim();
                    etapa = datos[2].trim();
                    evolucion1 = datos[3].trim();
                    tipo1 = datos[4].trim();
                    tipo2 = datos[5].trim();
                    Pokemon pokemon = new Pokemon(id,nombre,etapa,evolucion1,tipo1,tipo2);
                    listaPokemon.insertar(pokemon);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void menu() {

        Scanner scanner = new Scanner(System.in);
        String opcion;
        do {
            System.out.println("---------- Pokédex (Contenedor de Pokemons)----------");
            System.out.println("1) Mostrar Pokémon por rango de números");
            System.out.println("2) Mostrar todos los Pokémon ordenados alfabéticamente");
            System.out.println("3) Mostrar Pokémon por tipo");
            System.out.println("4) Mostrar todos los Pokémon de primera evolución");
            System.out.println("5) Búsqueda de un pokemon en particular: ");
            System.out.println("6) Salir");
            System.out.println("Seleccione una opción: ");
            System.out.println("------------------------------------------------------");
            opcion = scanner.nextLine();

            switch (opcion) {
                case "1":

                    break;
                case "2":

                    break;
                case "3":

                    break;
                case "4":

                    break;
                case "5":

                    break;
                case "6":
                    System.out.println("¡Nos vemos en la proxima ocasión!");
                    break;
                default:
                    System.out.println("Opción inválida. Intenta nuevamente");
                    break;
            }
        } while (!opcion.equals("6"));
    }
}
