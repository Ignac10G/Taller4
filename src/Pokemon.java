public class Pokemon {
    private int id;
    private String nombre;
    private String etapa;
    private String evolucionSiguiente;

    public Pokemon(int id, String nombre, String etapa, String evolucionSiguiente) {
        this.id = id;
        this.nombre = nombre;
        this.etapa = etapa;
        this.evolucionSiguiente = evolucionSiguiente;
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
}
