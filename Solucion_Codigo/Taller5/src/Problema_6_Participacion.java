public class Problema_6_Participacion {
    private Problema_6_Participante participante;
    private Problema_6_Prueba prueba;
    private Problema_6_Disciplina disciplina;
    private boolean asistencia;
    private double puntaje;
    public Problema_6_Participacion(){}
    public Problema_6_Participacion(Problema_6_Participante participante, 
                                    Problema_6_Prueba prueba, 
                                    Problema_6_Disciplina disciplina, 
                                    boolean asistencia, double puntaje) {
        this.participante = participante;
        this.prueba = prueba;
        this.disciplina = disciplina;
        this.asistencia = asistencia;
        this.puntaje = puntaje;
    }
    public boolean getAsistencia() {
        return this.asistencia;
    }
    public double getPuntaje() {
        return this.puntaje;
    }
    public Problema_6_Participante getParticipante() {
        return this.participante;
    }
    public Problema_6_Prueba getPrueba() {
        return this.prueba;
    }
    public Problema_6_Disciplina getDisciplina() {
        return this.disciplina;
    }
    public void registrarParticipacion(String nombreParticipante, 
                                        String nombreDisciplina, 
                                        String nombrePrueba, 
                                        boolean asistencia, double puntaje) {
        participante.buscarParticipante(nombreParticipante);
        disciplina.buscarDisciplina(nombreDisciplina);
        disciplina.buscarPrueba(nombrePrueba);
        if (this.participante != null && this.disciplina != null && this.prueba != null) {
            Problema_6_Participacion participacion = new Problema_6_Participacion(participante, prueba, disciplina, asistencia, puntaje);
            participante.agregarParticipacion(participacion);
        } else {
            System.out.println("Error al registrar participación.");
        }
    }
    @Override
    public String toString() {
        return "Participante: " + this.participante.getNombreParticipante() +
                ", Disciplina: " + this.disciplina.getNombreD() +
                ", Prueba: " + prueba.getNombrePrueba() +
                ", Asistencia: " + (this.asistencia ? "Sí" : "No") +
                ", Puntaje: " + (this.asistencia ? this.puntaje : "N/A");
    }
}
