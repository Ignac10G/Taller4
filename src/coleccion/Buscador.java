package coleccion;

import coleccion.Interface;
import coleccion.ListaNodoDoble;
import model.Pokemon;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;


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
        } catch (FileNotFoundException var14) {
            throw new RuntimeException(var14);
        }

        while(scanner.hasNextLine()) {
            String linea = scanner.nextLine().trim();
            if (!linea.isEmpty()) {
                String[] datos = linea.split(",");
                int id;
                String nombre;
                String etapa;
                String evolucion1;
                String tipo1;
                String tipo2;
                Pokemon pokemon;
                if (datos.length == 7) {
                    id = Integer.parseInt(datos[0].trim());
                    nombre = datos[1].trim();
                    etapa = datos[2].trim();
                    evolucion1 = datos[3].trim();
                    String evolucionAnterior = datos[4].trim();
                    tipo1 = datos[5].trim();
                    tipo2 = datos[6].trim();
                    System.out.println(nombre);
                    pokemon = new Pokemon(id, nombre, etapa, evolucion1, evolucionAnterior, tipo1, tipo2);
                    this.listaPokemon.agregarAlInicio(pokemon);
                } else if (datos.length == 8) {
                    id = Integer.parseInt(datos[0].trim());
                    nombre = datos[1].trim();
                    etapa = datos[2].trim();
                    evolucion1 = datos[3].trim();
                    String evolucion2 = datos[4].trim();
                    String evolucion3 = datos[5].trim();
                    tipo1 = datos[6].trim();
                    tipo2 = datos[7].trim();
                    System.out.println(nombre);
                    pokemon = new Pokemon(id, nombre, etapa, evolucion1, evolucion2, evolucion3, tipo1, tipo2);
                    this.listaPokemon.agregarAlInicio(pokemon);

                } else if (datos.length == 5) {
                    id = Integer.parseInt(datos[0].trim());
                    nombre = datos[1].trim();
                    etapa = datos[2].trim();
                    tipo1 = datos[3].trim();
                    tipo2 = datos[4].trim();
                    System.out.println(nombre);
                    pokemon = new Pokemon(id, nombre, etapa, tipo1, tipo2);
                    this.listaPokemon.agregarAlInicio(pokemon);
                } else if (datos.length == 6) {
                    id = Integer.parseInt(datos[0].trim());
                    nombre = datos[1].trim();
                    etapa = datos[2].trim();
                    evolucion1 = datos[3].trim();
                    tipo1 = datos[4].trim();
                    tipo2 = datos[5].trim();
                    System.out.println(nombre);
                    pokemon = new Pokemon(id, nombre, etapa, evolucion1, tipo1, tipo2);
                    this.listaPokemon.agregarAlInicio(pokemon);
                }
            }
        }
        scanner.close();
    }





    @Override
    public void menu () {
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
                    ordenarPokemonMenorMayor(listaPokemon.getCabeza());
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

                    BuscarPokemon();
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

    public static void ordenarPokemonMenorMayor(NodoDoble cabeza) {
        List<Pokemon> listaPoke = new ArrayList<>();
        NodoDoble nodoActual = cabeza;
        while (nodoActual != null) {
            listaPoke.add(nodoActual.getPokemon());
            nodoActual = nodoActual.getSiguiente();
        }

        listaPoke.sort(Comparator.comparingInt(Pokemon::getId));

        for (Pokemon pokemon : listaPoke) {
            desplegarPokemon(pokemon);
        }
    }
    private static void desplegarPokemon(Pokemon pokemon){
        String etapa = pokemon.getEtapa();
        String evoluciones = null;
        if (Objects.equals(etapa, "Basico")){
            String evolucionSi = pokemon.getEvolucionSiguiente();
            if (evolucionSi == null){
                evoluciones = "No tiene mas evoluciones";
            }else{
                evoluciones = evolucionSi;
            }
        }else if (Objects.equals(etapa, "Primera Evolucion") || Objects.equals(etapa, "Segunda Evolucion")){
            String evolucionSi = pokemon.getEvolucionSiguiente();
            String evolucionPr = pokemon.getEvolucionPrevia();
            if (evolucionSi == null){
                evoluciones = evolucionPr;
            } else {
                evoluciones = evolucionPr +", " +evolucionSi;
            }
        }
        System.out.print("-----------------------------------\n" +
                "| Pokemon: " +pokemon.getNombre() +"\n"+
                "| ID: " +pokemon.getId() +"\n"+
                "| Etapa: " +pokemon.getEtapa()+"\n"+
                "| Evoluciones: " +evoluciones +"\n"+
                "| Tipo1 : " +pokemon.getTipo1() +"\n"+
                "| Tipo2 : " +pokemon.getTipo2() +"\n"+
                "-----------------------------------\n" );
    }
    public void BuscarPokemon(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese nombre o ID del Pokemon que desee buscar: ");
        String opcion = sc.nextLine();
        NodoDoble pokemon = listaPokemon.buscarPorNombre(capitalize(opcion));
        if (pokemon == null){
            pokemon = listaPokemon.buscarPorId(Integer.parseInt(opcion));
            desplegarPokemon(pokemon.getPokemon());
            desplegarPoke(pokemon);

        }else{
            desplegarPokemon(pokemon.getPokemon());
            desplegarPoke(pokemon);
        }
    }
    public void desplegarPoke(NodoDoble pokemon){
        Scanner sc = new Scanner(System.in);
        while (true) {
            if (pokemon.getPokemon().getEvolucionSiguiente() != null || pokemon.getPokemon().getEvolucionPrevia() != null) {
                System.out.println("¿Desea averiguar sobre sus evoluciones?(SI/NO): ");
                String opcion2 = sc.nextLine();
                if (opcion2.equalsIgnoreCase("SI")) {
                    System.out.println("Ingrese nombre del Pokemon: ");
                    String nombre = sc.nextLine();
                    pokemon = listaPokemon.buscarPorNombre(capitalize(nombre));
                    desplegarPokemon(pokemon.getPokemon());
                } else {
                    break;
                }
            }else {
                break;
            }
        }
    }
    public String capitalize(String str){
        return str.substring(0,1).toUpperCase()+str.substring(1).toLowerCase();
    }

}


