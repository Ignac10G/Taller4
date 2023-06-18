package model;

public class Pokemon {
    private int id;
    private String nombre;
    private String etapa;
    private String evolucionSiguiente;
    private String evolucionPrevia;
    private String evolucion3;
    private String tipo1;
    private String tipo2;

    public Pokemon() {
    }

    public Pokemon(int id, String nombre, String etapa, String evolucionSiguiente, String evolucionPrevia, String tipo1, String tipo2) {
        this.id = id;
        this.nombre = nombre;
        this.etapa = etapa;
        this.evolucionPrevia = evolucionPrevia;
        this.evolucionSiguiente = evolucionSiguiente;
        this.tipo1 = tipo1;
        this.tipo2 = tipo2;
    }


    public Pokemon(int id, String nombre, String etapa, String evolucionPrevia, String tipo1, String tipo2) {
        this.id = id;
        this.nombre = nombre;
        this.etapa = etapa;
        this.evolucionPrevia = evolucionPrevia;
        this.evolucionSiguiente = null;
        this.evolucion3 = null;
        this.tipo1 = tipo1;
        this.tipo2 = tipo2;

    }

    public Pokemon(int id, String nombre, String etapa, String tipo1, String tipo2) {
        this.id = id;
        this.nombre = nombre;
        this.etapa = etapa;
        this.evolucionPrevia = null;
        this.evolucionSiguiente = null;
        this.evolucion3 = null;
        this.tipo1 = tipo1;
        this.tipo2 = tipo2;
    }

    public Pokemon(int id, String nombre, String etapa, String evolucionSiguiente, String evolucionPrevia,String evolucion3, String tipo1, String tipo2) {
        this.id = id;
        this.nombre = nombre;
        this.etapa = etapa;
        this.evolucionPrevia = evolucionPrevia;
        this.evolucionSiguiente = evolucionSiguiente;
        this.evolucion3 = evolucion3;
        this.tipo1 = tipo1;
        this.tipo2 = tipo2;
    }


    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEtapa() {
        return etapa;
    }

    public String getEvolucionSiguiente() {
        return evolucionSiguiente;
    }

    public String getEvolucionPrevia() {
        return evolucionPrevia;
    }

    public String getTipo1() {
        return tipo1;
    }

    public String getTipo2() {
        return tipo2;
    }
}