import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
public class Problema_4_Ejecutor {

    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            System.out.println("\n--- Registro de Nuevo Caso de Corrupción ---");
            System.out.print("Nombre del Caso: ");
            String nombreCaso = sc.nextLine();
            Date fechaInicio = null;
            boolean fechaValida = false;
            while (!fechaValida) {
                System.out.print("Fecha de Inicio (dd/MM/yyyy): ");
                String fechaStr = sc.nextLine();
                try {
                    fechaInicio = sdf.parse(fechaStr);
                    fechaValida = true;
                } catch (ParseException e) {
                    System.out.println("Formato de fecha inválido. Use dd/MM/yyyy.");
                }
            }
            System.out.print("Detalles Adicionales: ");
            String detalles = sc.nextLine();
            Problema_4_CasoCorrupcion caso = new Problema_4_CasoCorrupcion(nombreCaso, fechaInicio, detalles);
            int opcion;
            do {
                System.out.println("\n--- Menú del Caso: " + caso.getNombreCaso() + " (Estado: " + caso.getEstado_caso() + ") ---");
                System.out.println("1. Agregar Persona Implicada");
                System.out.println("2. Actualizar Estado del Caso (según fecha actual)");
                System.out.println("3. Mostrar Detalles del Caso");
                System.out.println("4. Salir");
                System.out.print("Seleccione una opción: ");
                while (true) {
                    if (sc.hasNextInt()) {
                        opcion = sc.nextInt();
                        break;
                    } else {
                        System.out.println("Entrada inválida. Por favor, ingrese un número.");
                        sc.next();
                    }
                }
                sc.nextLine();
                switch (opcion) {
                    case 1:
                        System.out.println("\n--- Agregar Persona Implicada ---");
                        System.out.print("Nombre: ");
                        String nombre = sc.nextLine();
                        System.out.print("Edad: ");
                        byte edad = -1; 
                        while (true) {
                            if (sc.hasNextByte()) {
                                edad = sc.nextByte();
                                break;
                            } else {
                                System.out.println("Edad inválida. Ingrese un número entre -128 y 127.");
                                sc.next();
                            }
                        }
                        sc.nextLine();
                        System.out.print("Ocupación: ");
                        String ocupacion = sc.nextLine();
                        System.out.print("Nivel de Implicación (acusado, testigo, victima, etc.): ");
                        String implicacion = sc.nextLine(); 
                        Problema_4_PersonaImplicada persona = new Problema_4_PersonaImplicada(nombre, edad, ocupacion, implicacion);
                        if ("acusado".equals(implicacion)) { 
                            System.out.print("¿Tiene sentencia menor a 1 año? (si/no): ");
                            String respuestaSentencia = sc.nextLine();
                            persona.setSentenciaMenorUnAnio("si".equals(respuestaSentencia)); 
                            System.out.print("¿Colabora con información útil para resolver el caso? (si/no): ");
                            String respuestaColabora = sc.nextLine();
                            persona.setColabora("si".equals(respuestaColabora)); 
                            System.out.print("¿Confiesa la verdad? (si/no): ");
                            String respuestaConfiesa = sc.nextLine();
                            persona.setConfiesa("si".equals(respuestaConfiesa)); 
                            System.out.print("Daño económico causado ($): ");
                            double dano = -1;
                            while (true) {
                                if (sc.hasNextDouble()) {
                                    dano = sc.nextDouble();
                                    break;
                                } else {
                                    System.out.println("Cantidad inválida. Ingrese un número.");
                                    sc.next();
                                }
                            }
                            sc.nextLine();
                            persona.setDanoEconomico(dano); 
                        }
                        caso.agregarPersonaImplicada(persona);
                        break;
                    case 2:
                        System.out.println("\n--- Actualizando Estado del Caso ---");
                        System.out.print("Ingrese la fecha actual (dd/MM/yyyy) para actualizar el estado: ");
                        Date fechaActual = null;
                        fechaValida = false;
                        while (!fechaValida) {
                            String fechaStr = sc.nextLine();
                            try {
                                fechaActual = sdf.parse(fechaStr);
                                fechaValida = true;
                            } catch (ParseException e) {
                                System.out.println("Formato de fecha inválido. Use dd/MM/yyyy.");
                            }
                        }
                        caso.actualizarEstado(fechaActual); // Llamada a método según el diagrama
                        System.out.println("Estado del caso actualizado a: " + caso.getEstado_caso()); // Getter según el diagrama
                        break;
                    case 3:
                        System.out.println(caso.toString());
                        break;
                    case 4:
                        System.out.println("Saliendo de la aplicación. ¡Adiós!");
                        break;
                    default:
                        System.out.println("Opción no válida. Por favor, intente de nuevo.");
                }
            } while (opcion != 4);
        }
    }
}