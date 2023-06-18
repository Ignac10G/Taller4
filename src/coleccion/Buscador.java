package coleccion;

import coleccion.Interface;
import coleccion.ListaNodoDoble;
import model.Pokemon;

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
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("kanto.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        while (scanner.hasNextLine()) {
            String linea = scanner.nextLine().trim();
            if (!linea.isEmpty()) {
                String[] datos = linea.split(",");
                int id;
                String nombre;
                String etapa;
                String evolucion1;
                String evolucion2;
                String evolucion3;
                String evolucionAnterior;
                String tipo1;
                String tipo2;

                if (datos.length == 7){
                    id = Integer.parseInt(datos[0].trim());
                    nombre = datos[1].trim();
                    etapa = datos[2].trim();
                    evolucion1 = datos[3].trim();
                    evolucionAnterior = datos[4].trim();
                    tipo1 = datos[5].trim();
                    tipo2 = datos[6].trim();
                    Pokemon pokemon = new Pokemon(id, nombre, etapa, evolucion1, evolucionAnterior, tipo1, tipo2);
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
        }
        scanner.close();
    }


    @Override
    public void menu() {

        Scanner scanner1 = new Scanner(System.in);
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
            opcion = scanner1.nextLine();

            switch (opcion) {
                case "1":
                    //MostrarPokemonPorRango();
                    break;
                case "2":

                    //MostrarPokemonAlfabet();
                    break;
                case "3":

                    //MostrarPokemonTipo();
                    break;
                case "4":

                    //MostrarTodosPrimeraEvo();
                    break;
                case "5":

                    //BuscarPokemon();
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

