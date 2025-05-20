import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit; 
public class Problema_4_CasoCorrupcion {
    private String nombreCaso;
    private Date fecha_inicio; 
    private String estado_caso; 
    private String detallesAdicionales;
    private List<Problema_4_PersonaImplicada> listaPersonasImplicadas; 
    public Problema_4_CasoCorrupcion(){}
    public Problema_4_CasoCorrupcion(String nombreCaso, Date fecha_inicio, String detallesAdicionales) {
        this.nombreCaso = nombreCaso;
        this.fecha_inicio = fecha_inicio; 
        this.detallesAdicionales = detallesAdicionales;
        this.estado_caso = "Iniciado";
        this.listaPersonasImplicadas = new ArrayList<>(); 
    }

    // Getters: Nombres de métodos según el diagrama
    public String getNombreCaso() {
        return nombreCaso;
    }

    public Date getFecha_inicio() { // Nombre de método según el diagrama
        return fecha_inicio;
    }

    public String getEstado_caso() { // Nombre de método según el diagrama
        return estado_caso;
    }

    public String getDetallesAdicionales() {
        return detallesAdicionales;
    }

    public List<Problema_4_PersonaImplicada> getListaPersonasImplicadas() {
        return listaPersonasImplicadas;
    }

    // Setters: Nombres de métodos según el diagrama
    public void setNombreCaso(String nombreCaso) {
        this.nombreCaso = nombreCaso;
    }

    public void setDetallesAdicionales(String detallesAdicionales) {
        this.detallesAdicionales = detallesAdicionales;
    }

    // Método para agregar una persona implicada
    public void agregarPersonaImplicada(Problema_4_PersonaImplicada persona) {
        if (persona != null) {
            this.listaPersonasImplicadas.add(persona);
            System.out.println("Persona '" + persona.getNombre() + "' agregada al caso '" + this.nombreCaso + "'.");
        }
    }

    // Método para actualizar el estado del caso basado en la fecha actual
    public void actualizarEstado(Date fecha_actual) { // Parámetro según el diagrama
        long diffInMillies = Math.abs(fecha_actual.getTime() - this.fecha_inicio.getTime());
        long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);

        if (diff > 14) {
            this.estado_caso = "Urgente";
        } else if (diff > 7) {
            this.estado_caso = "Alerta";
        } else {
            this.estado_caso = "Iniciado";
        }
    }

    @Override
    public String toString() {
        String resultado = "";

        resultado = resultado + "--- Detalles del Caso de Corrupción ---\n";
        resultado = resultado + "Nombre del Caso: " + nombreCaso + "\n";
        resultado = resultado + "Fecha de Inicio: " + fecha_inicio + "\n";
        resultado = resultado + "Estado Actual: " + estado_caso + "\n";
        resultado = resultado + "Detalles: " + detallesAdicionales + "\n";
        resultado = resultado + "Personas Implicadas:\n";

        if (listaPersonasImplicadas.isEmpty()) {
            resultado = resultado + "  (Ninguna persona implicada registrada)\n";
        } else {
            for (int i = 0; i < listaPersonasImplicadas.size(); i++) {
                resultado = resultado + "  " + listaPersonasImplicadas.get(i).toString() + "\n";
            }
        }
        return resultado;
    }
}