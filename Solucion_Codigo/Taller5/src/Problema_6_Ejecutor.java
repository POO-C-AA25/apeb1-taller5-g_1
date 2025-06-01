import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;
public class Problema_6_Ejecutor {
    private List<Problema_6_Participante> participantes;
    private List<Problema_6_Disciplina> disciplinas; 
    private List<Problema_6_Prueba> pruebas; 
    public static final double minPuntajeParaSuperar = 65.0;
    public Problema_6_Ejecutor() {
        this.participantes = new ArrayList<>();
        this.disciplinas = new ArrayList<>();
        this.pruebas = new ArrayList<>();
    }
    public List<Problema_6_Participante> getParticipantes() {
        return participantes;
    }
    public List<Problema_6_Disciplina> getDisciplinas() {
        return disciplinas;
    }
    public List<Problema_6_Prueba> getPruebas() {
        return pruebas;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Problema_6_Ejecutor sistema = new Problema_6_Ejecutor();
        boolean continuar = true;
        int opcion;
        while (continuar) {
            System.out.println("\n=== Sistema de Gestión de Eventos Deportivos ===");
            System.out.println("1. Agregar Participante");
            System.out.println("2. Agregar Disciplina");
            System.out.println("3. Agregar Prueba a Disciplina");
            System.out.println("4. Registrar Participación en Prueba");
            System.out.println("5. Mostrar Estadísticas de Participantes");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            try {
                opcion = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor ingrese un número.");
                sc.next();
                continue;
            }
            sc.nextLine(); // Consumir la nueva línea
            switch (opcion) {
                case 1:
                    System.out.print("Nombre del Participante: ");
                    String nombreParticipante = sc.nextLine();
                    sistema.participantes.add(new Problema_6_Participante(nombreParticipante));
                    break;
                case 2:
                    System.out.print("Nombre de la Disciplina: ");
                    String nombreDisciplina = sc.nextLine();
                    sistema.disciplinas.add(new Problema_6_Disciplina(nombreDisciplina)); // CORRECCIÓN AQUÍ
                    break;
                case 3:
                    System.out.print("Nombre de la Disciplina (para agregar la prueba): ");
                    String nombreDisciplinaParaPrueba = sc.nextLine();
                    Problema_6_Disciplina disciplinaEncontrada = null;
                    for (Problema_6_Disciplina d : sistema.disciplinas) {
                        if (d.getNombreD().equalsIgnoreCase(nombreDisciplinaParaPrueba)) {
                            disciplinaEncontrada = d;
                            break;
                        }
                    }
                    if (disciplinaEncontrada != null) {
                        System.out.print("Nombre de la Nueva Prueba: ");
                        String nombreNuevaPrueba = sc.nextLine();
                        Problema_6_Prueba nuevaPrueba = new Problema_6_Prueba(nombreNuevaPrueba);
                        sistema.pruebas.add(nuevaPrueba); // Agregar la prueba a la lista general
                        disciplinaEncontrada.agregarPrueba(nuevaPrueba); // Agregar la prueba a la disciplina
                    } else {
                        System.out.println("Disciplina no encontrada.");
                    }
                    break;
                case 4:
                    System.out.print("Nombre del Participante: ");
                    String nombreParticipanteReg = sc.nextLine();
                    System.out.print("Nombre de la Disciplina: ");
                    String nombreDisciplinaReg = sc.nextLine();
                    System.out.print("Nombre de la Prueba: ");
                    String nombrePruebaReg = sc.nextLine();
                    Problema_6_Participante participanteReg = null;
                    for (Problema_6_Participante p : sistema.participantes) {
                        if (p.getNombreParticipante().equalsIgnoreCase(nombreParticipanteReg)) {
                            participanteReg = p;
                            break;
                        }
                    }
                    Problema_6_Disciplina disciplinaReg = null;
                    for (Problema_6_Disciplina d : sistema.disciplinas) {
                        if (d.getNombreD().equalsIgnoreCase(nombreDisciplinaReg)) {
                            disciplinaReg = d;
                            break;
                        }
                    }
                    Problema_6_Prueba pruebaReg = null;
                    if (disciplinaReg != null) {
                        for (Problema_6_Prueba pr : disciplinaReg.getPruebas()) {
                            if (pr.getNombrePrueba().equalsIgnoreCase(nombrePruebaReg)) {
                                pruebaReg = pr;
                                break;
                            }
                        }
                    }
                    if (participanteReg != null && disciplinaReg != null && pruebaReg != null) {
                        boolean asistenciaReg = false;
                        while (true) {
                            System.out.print("¿El participante asistió? (true/false): ");
                            String asistencia = sc.nextLine().trim().toLowerCase();
                            if (asistencia.equals("true")) {
                                asistenciaReg = true;
                                break;
                            } else if (asistencia.equals("false")) {
                                asistenciaReg = false;
                                break;
                            } else {
                                System.out.println("Entrada inválida. Por favor ingrese 'true' o 'false'.");
                            }
                        }
                        Double puntajeReg = null;
                        if (asistenciaReg) {
                            while (true) {
                                System.out.print("Puntaje obtenido (ej: 75.5, o deje vacío si no aplica): ");
                                String puntajeInputStr = sc.nextLine().trim();
                                if (puntajeInputStr.isEmpty()) {
                                    puntajeReg = null;
                                    break;
                                }
                                try {
                                    puntajeReg = Double.parseDouble(puntajeInputStr);
                                    break;
                                } catch (NumberFormatException e) {
                                    System.out.println("Entrada inválida para puntaje. Por favor ingrese un número o deje vacío.");
                                }
                            }
                        }
                        Problema_6_Participacion participacion = new Problema_6_Participacion(participanteReg, pruebaReg, disciplinaReg, asistenciaReg, puntajeReg);
                        participanteReg.agregarParticipacion(participacion);
                        System.out.println("Participación registrada.");
                    } else {
                        System.out.println("No se encontró el participante, la disciplina o la prueba.");
                    }
                    break;
                case 5:
                    if (sistema.participantes.isEmpty()) {
                        System.out.println("No hay participantes registrados.");
                    } else {
                        Problema_6_Estadisticas.mostrarMejoresParticipantes(sistema.participantes, minPuntajeParaSuperar);
                    }
                    break;
                case 6:
                    continuar = false;
                    System.out.println("Saliendo del sistema. ¡Hasta pronto!");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
        }
        sc.close();
    }
}