import java.util.List;
import java.util.ArrayList;
public class Problema_6_Estadisticas {
    public static void mostrarMejoresParticipantes(List<Problema_6_Participante> participantes, double minPuntajeParaSuperar) {
        System.out.println("\n=== Mejores Participantes (Puntuación > 90) ===");
        if (participantes == null || participantes.isEmpty()) {
            System.out.println("No hay participantes para mostrar.");
            return;
        }
        List<Problema_6_Participante> mejores = obtenerMejoresParticipantes(participantes);
        if (mejores.isEmpty()) {
            System.out.println("No hay participantes con al menos una puntuación superior a 90.");
            return;
        }
        System.out.println("Participantes con al menos una puntuación mayor a 90:");
        for (Problema_6_Participante p : mejores) {
            System.out.println("- " + p.getNombreParticipante());
        }
        System.out.println("\n=== Estadísticas ===");
        if (participantes == null || participantes.isEmpty()) {
            System.out.println("No hay participantes para mostrar estadísticas.");
            return;
        }
        System.out.println("Estadísticas Generales:");
        System.out.printf("%-25s | %-10s | %-20s\n",
                "Participante", "Promedio", "Pruebas Superadas");
        System.out.println(new String(new char[80]).replace('\0', '-'));
        for (Problema_6_Participante p : participantes) {
            System.out.printf("%-25s | %-10.2f | %-20d\n",
                    p.getNombreParticipante(),
                    p.calcularPromedio(),
                    p.contarPruebasSuperadas(minPuntajeParaSuperar));
        }
    }
    private static List<Problema_6_Participante> obtenerMejoresParticipantes(List<Problema_6_Participante> participantes) {
        List<Problema_6_Participante> mejores = new ArrayList<>();
        for (Problema_6_Participante participante : participantes) {
            for (Problema_6_Participacion participacion : participante.getParticipaciones()) {
                if (participacion.getAsistencia() && participacion.getPuntaje() > 90) {
                    mejores.add(participante);
                    break;
                }
            }
        }
        return mejores;
    }
}