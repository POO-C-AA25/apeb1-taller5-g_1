import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Problema5_Ejecutor {
    public static void main(String[] args) {
        Random rand = new Random();
        Scanner input= new Scanner(System.in);
        char opcion = 'S';
        String[] nombresEventos = {"Batalla", "Tratado de paz", "Reunion Diplomatica"};

        while (opcion == 'S' || opcion == 's') {
            ArrayList<Problema5_Pais> paises1 = new ArrayList<>(Arrays.asList(
                new Problema5_Pais("Perú", false, 100, 10),
                new Problema5_Pais("Ecuador", false, 100, 10)
            ));

            ArrayList<Problema5_Pais> paises2 = new ArrayList<>(Arrays.asList(
                new Problema5_Pais("Rusia", true, 100, 60),
                new Problema5_Pais("China", true, 100, 10)
            ));

            ArrayList<Problema5_Evento> eventos = new ArrayList<>(Arrays.asList(
                new Problema5_Evento(
                    nombresEventos[rand.nextInt(nombresEventos.length)],
                    LocalDate.of(2025, 5, 15),
                    "Europa", "Problemas de territorio",
                    rand.nextBoolean(), 
                    paises1
                ),
                new Problema5_Evento(
                    nombresEventos[rand.nextInt(nombresEventos.length)],
                    LocalDate.of(2024, 5, 15),
                    "Asia","Problemas politicos",
                    rand.nextBoolean(), 
                    paises2
                )
            ));

            Problema5_Conflicto conflicto = new Problema5_Conflicto(
                "Conflicto-" + (rand.nextInt(100) + 1000), 
                LocalDate.now(),195,eventos
            );
            
            conflicto.actualizarEstado();
            System.out.println("\n=== Simulacion ===");
            System.out.println(conflicto);
            
            System.out.println("\nEventos:");
            for (Problema5_Evento evento : conflicto.getEventos()) {
                System.out.println(" - " + evento);
            }

            System.out.print("\nSimular (S/N): ");
            opcion = input.next().charAt(0);
        }
    }
}
