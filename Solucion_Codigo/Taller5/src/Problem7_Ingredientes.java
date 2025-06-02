public class Problem7_Ingredientes {

    private String nombre;

    public Problem7_Ingredientes(String name) {
        this.nombre = name;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String name) {
        this.nombre = name;
    }

    @Override
    public String toString() {
        return String.format("Ingrediente: %s", nombre);
    }
}
