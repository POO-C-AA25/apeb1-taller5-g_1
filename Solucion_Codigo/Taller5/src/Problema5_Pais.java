public class Problema5_Pais {
    
    public String nombre;
    public boolean esDesarrollado;
    public int totalHabitantes;
    public int numeroBajas;

    public Problema5_Pais() {
    }
    
    public Problema5_Pais(String nombre, boolean esDesarrollado, int totalHabitantes, int numeroBajas) {
        this.nombre = nombre;
        this.esDesarrollado = esDesarrollado;
        this.totalHabitantes = totalHabitantes;
        this.numeroBajas = numeroBajas;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean esDesarrollado() {
        return esDesarrollado;
    }

    public double getPorcentajeBajas() {
        return (double) numeroBajas / totalHabitantes * 100;
    }

    @Override
    public String toString() {
        return nombre + " - " + (esDesarrollado ? "Desarrollado" : "En desarrollo") + 
               " | Bajas: " + numeroBajas + "/" + totalHabitantes;
    }
}
