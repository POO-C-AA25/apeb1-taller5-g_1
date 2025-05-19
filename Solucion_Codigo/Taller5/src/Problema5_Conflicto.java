import java.time.LocalDate;
import java.util.ArrayList;

public class Problema5_Conflicto {
    public String nombre;
    public LocalDate fechaInicio;
    public String estadoActual;
    public int totalPaisesMundo;
    public ArrayList<Problema5_Evento> eventos;

    public Problema5_Conflicto() {
    }

    public Problema5_Conflicto(String nombre, LocalDate fechaInicio, int totalPaisesMundo, ArrayList<Problema5_Evento> eventos) {
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.totalPaisesMundo = totalPaisesMundo;
        this.eventos = eventos;
        this.estadoActual = "Iniciado";
    }

    public ArrayList<Problema5_Evento> getEventos() {
        return eventos;
    }

    public void actualizarEstado() {
        int totalBatallas = 0;
        boolean hayBatallaNuclear = false;
        double porcentaje;

        for (Problema5_Evento evento : eventos) {
            if (evento.getNombre().equals("Batalla")) {
                totalBatallas++;
                if (evento.UsoArmasNucleares()) {
                    hayBatallaNuclear = true;
                }
            }
        }

        porcentaje = (double) totalBatallas / totalPaisesMundo * 100;

        if (porcentaje > 50 || hayBatallaNuclear) {
            estadoActual = "GUERRA MUNDIAL";
        } else if (porcentaje > 30) {
            estadoActual = "CONVOCAR ONU URGENTE";
        }
    }

    @Override
    public String toString() {
        return "Conflicto: " + nombre + 
               "\nEstado: " + estadoActual + 
               "\nTotal paises involucrados: " + eventos.get(0).getPaises().size();
    }
}