public class Problema_6_Prueba {
    private String nombrePrueba;
    public Problema_6_Prueba() {}
    public Problema_6_Prueba(String nombrePrueba) {
        this.nombrePrueba = nombrePrueba;
    }
    public String getNombrePrueba() {
        return this.nombrePrueba;
    }
    @Override
    public String toString() {
        return this.nombrePrueba;
    }
}