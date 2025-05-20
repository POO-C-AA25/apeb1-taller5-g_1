import java.util.Scanner;
public class Problema_2_Ejecutor {
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){
            String nombremateria, nombre;
            byte edad;
            int estudiantes;
            double calificacion_acd, calificacion_aa, calificacion_ape;
            System.out.println("Ingrese nombre de la materia: ");
            nombremateria = sc.nextLine();
            Problema_2_Materia materiax = new Problema_2_Materia();
            materiax.setNombrmateria(nombremateria);
            do{
                System.out.println("Ingrese cantidad de estudiantes");
                estudiantes = sc.nextInt();
            }while(estudiantes < 0);
            Problema_2_Estudiante[] estudiantex = new Problema_2_Estudiante[estudiantes];
            for(int i = 0; i < estudiantes; i++){
                System.out.println("Ingreso estudiantes " + (i+1) +" :");
                sc.nextLine();
                System.out.print("Ingrese nombre: ");
                nombre = sc.nextLine();
                System.out.print("Ingrese edad: ");
                edad = sc.nextByte();
                do { 
                    System.out.print("Nota ACD(35%): ");
                    calificacion_acd = sc.nextDouble();
                } while (calificacion_acd >3.5);
                do { 
                    System.out.print("Nota APE(35%): ");
                    calificacion_ape = sc.nextDouble();
                } while (calificacion_ape >3.5);
                do { 
                    System.out.print("Nota AA(30%): ");
                    calificacion_aa = sc.nextDouble();
                } while (calificacion_aa >3.0);
                Problema_2_Materia materia = new Problema_2_Materia(nombremateria, calificacion_aa, 
                                    calificacion_acd, calificacion_ape);
                materia.calcularNotaFinal();
                materia.calcularRecuperacion();
                materia.verificarAprobacion();
                Problema_2_Estudiante estudiante = new Problema_2_Estudiante(nombre, edad, nombremateria);
                estudiantex[i] = estudiante;
                System.out.println("-------Boleta--------");
                if (materia.verificarAprobacion()) {
                    System.out.println(estudiantex[i]); // Imprime el estudiante actual
                    System.out.println(materia);
                    System.out.println("Estado: APROBADO");
                } else {
                    System.out.println(estudiantex[i]);
                    System.out.println(materia);
                    System.out.println("Estado: REPROBADO");
                }
            }
        }
    }
}