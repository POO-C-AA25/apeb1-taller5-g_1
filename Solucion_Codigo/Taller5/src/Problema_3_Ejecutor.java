import java.util.Scanner;
public class Problema_3_Ejecutor {
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){
            System.out.println("--- Inicio del Sistema de Gestión Empresarial ---");
            System.out.println("\n--- Creación de la Empresa ---");
            System.out.print("Ingrese el nombre de la empresa: ");
            String nombre_empresa = sc.nextLine();
            System.out.print("Ingrese el RUC de la empresa: ");
            String ruc = sc.nextLine();
            System.out.print("Ingrese la dirección de la empresa: ");
            String direccion = sc.nextLine();
            Problema_3_Empresa empresax = new Problema_3_Empresa(nombre_empresa, ruc, direccion);
            Problema_3_Ejecutor ejecutorx = new Problema_3_Ejecutor();
            int opcion;
            do { 
                System.out.println("\n--- Menú Principal ---");
                System.out.println("1. Agregar Departamento");
                System.out.println("2. Mostrar Información de la Empresa");
                System.out.println("3. Salir");
                System.out.print("Seleccione una opción: ");
                opcion = sc.nextInt();
                switch (opcion) {
                case 1:
                    sc.nextLine();
                    System.out.println("\n--- Agregar Nuevo Departamento ---");
                    System.out.print("Nombre del departamento: ");
                    String nombre_departamento = sc.nextLine();
                    System.out.print("Cantidad de empleados: ");
                    int cantEmpleados = sc.nextInt();
                    System.out.print("Producción anual: ");
                    int produccion_anual = sc.nextInt();
                    sc.nextLine();
                    Problema_3_Departamento departamentox = new Problema_3_Departamento(cantEmpleados, produccion_anual, nombre_departamento);
                    departamentox.calcularCategoria();
                    empresax.agregarDepartamento(departamentox);
                    break;
                case 2:
                    System.out.println("\n--- Información de la Empresa ---");
                    System.out.println(empresax.toString());
                    break;
                case 3:
                    System.out.println("Programa finalizado");
                    break;
                default:
                    throw new AssertionError();
            }
            } while (opcion != 3);
        }
    }
}