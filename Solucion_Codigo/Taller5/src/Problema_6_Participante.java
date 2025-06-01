import java.util.ArrayList;
import java.util.List;
public class Problema_6_Participante {
    private String nombreParticipante;
    private ArrayList<Problema_6_Participante> participantes;
    private ArrayList<Problema_6_Participacion> participaciones;
    public Problema_6_Participante() {
        this.participaciones = new ArrayList<>();
        this.participantes = new ArrayList<>(); 
    }
    public Problema_6_Participante(String nombreParticipante) {
        this.nombreParticipante = nombreParticipante;
        this.participaciones = new ArrayList<>();
        this.participantes = new ArrayList<>(); 
    }
    public String getNombreParticipante(){
        return this.nombreParticipante;
    }
    public void agregarParticipacion(Problema_6_Participacion participacion){
        participaciones.add(participacion);
    }
    public void agregarParticipante(String nombreParticipante) {
        participantes.add(new Problema_6_Participante(nombreParticipante));
    }
    public double calcularPromedio(){
        double total = 0;
        int cont = 0;
        for(Problema_6_Participacion p: this.participaciones){
            if(p.getAsistencia()){
                total += p.getPuntaje();
                cont++;
            }
        }
        return cont > 0 ? total/cont : 0;
    }
    public int contarPruebasSuperadas(double minpuntuacion){
        int cont = 0;
        for(Problema_6_Participacion p : this.participaciones){
            if(p.getAsistencia() && p.getPuntaje() >= minpuntuacion){
                cont++;
            }
        }
        return cont;
    }
    public void buscarParticipante(String nombreParticipante) {
        for (Problema_6_Participante p : participantes) {
            if (p.getNombreParticipante().equalsIgnoreCase(nombreParticipante)) {
                System.out.println("Participante encontrado: " + p.getNombreParticipante());
                return;
            }
        }
        System.out.println("Participante no encontrado.");
    }
    public static List<Problema_6_Participante> mejoresParticipantes(List<Problema_6_Participante> participantes) {
        ArrayList<Problema_6_Participante> mejores = new ArrayList<>();
        if (participantes != null) {
            for (Problema_6_Participante p : participantes) {
                if (p.calcularPromedio() > 90) {
                    mejores.add(p);
                }
            }
        }
        return mejores;
    }
    public List<Problema_6_Participacion> getParticipaciones() {
        return this.participaciones;
    }
    @Override
    public String toString() {
        return "Participante: " + this.nombreParticipante;
    }
    
}