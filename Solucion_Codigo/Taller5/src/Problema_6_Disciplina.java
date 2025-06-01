import java.util.ArrayList;
import java.util.List;
public class Problema_6_Disciplina {
    private String nombreD;
    private List<Problema_6_Prueba> pruebas;
    public Problema_6_Disciplina() {
        this.pruebas = new ArrayList<>();
    }
    public Problema_6_Disciplina(String nombreD) {
        this.nombreD = nombreD;
        this.pruebas = new ArrayList<>();
    }
    public String getNombreD() {
        return this.nombreD;
    }
    public void agregarPrueba(Problema_6_Prueba prueba) {
        pruebas.add(prueba);
    }
    public List<Problema_6_Prueba> getPruebas() {
        return this.pruebas;
    }
    public void buscarPrueba(String nombrePrueba) {
        for (Problema_6_Prueba p : pruebas) {
            if (p.getNombrePrueba().equalsIgnoreCase(nombrePrueba)) {
                System.out.println("Prueba encontrada: " + p.getNombrePrueba());
                return;
            }
        }
        System.out.println("Prueba no encontrada.");
    }
    public void buscarDisciplina(String nombreD) {
        if (this.nombreD.equalsIgnoreCase(nombreD)) {
            System.out.println("Disciplina encontrada: " + this.nombreD);
        } else {
            System.out.println("Disciplina no encontrada.");
        }
    }
    @Override
    public String toString() {
        return this.nombreD;
    }
}
