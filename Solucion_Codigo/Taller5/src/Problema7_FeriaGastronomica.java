
public class Problema7_FeriaGastronomica {

    public static void main(String[] args) {

        Problem7_Ingredientes ing1 = new Problem7_Ingredientes("Tomate");
        Problem7_Ingredientes ing2 = new Problem7_Ingredientes("Queso");
        Problem7_Ingredientes ing3 = new Problem7_Ingredientes("Pollo");
        Problem7_Ingredientes ing4 = new Problem7_Ingredientes("Arroz");
        Problem7_Ingredientes ing5 = new Problem7_Ingredientes("Cilantro");
        Problem7_Ingredientes ing6 = new Problem7_Ingredientes("Café");

        Problema7_Expositor expositor1 = new Problema7_Expositor(1, "La Cocina Andina", "Stand A1");
        Problema7_Platos plato1 = new Problema7_Platos(1, "Ceviche", 50.0);
        plato1.agregarIngredientes(ing1);
        plato1.agregarIngredientes(ing5);
        expositor1.registrarPlato(plato1);

        Problema7_Platos plato2 = new Problema7_Platos(2, "Arroz con Pollo", 20.0);
        plato2.agregarIngredientes(ing3);
        plato2.agregarIngredientes(ing4);
        plato2.agregarIngredientes(ing5);
        expositor1.registrarPlato(plato2);

        Problema7_Expositor expositor2 = new Problema7_Expositor(2, "Sabores del Caribe", "Stand B1");
        Problema7_Platos plato3 = new Problema7_Platos(3, "Arepa con Queso", 30.0);
        plato3.agregarIngredientes(ing2);
        plato3.agregarIngredientes(ing1);
        expositor2.registrarPlato(plato3);

        Problema7_Platos plato4 = new Problema7_Platos(4, "Cafe de Olla", 20.0);
        plato4.agregarIngredientes(ing6);
        expositor2.registrarPlato(plato4);


        expositor1.venderPlato(1, 10); 
        expositor1.venderPlato(2, 5);  
        expositor2.venderPlato(3, 20);
        expositor2.venderPlato(4, 15); 


        expositor1.actualizarDisponibilidadPlato(2, false); 


        mostrarReporteExpositor(expositor1);
        mostrarReporteExpositor(expositor2);


        System.out.println("\nPlatos mas vendidos en " + expositor1.getNombreExpositor() + ":");
        for (Problema7_Platos d : expositor1.getPlatosmasVendidos()) {
            System.out.println("- " + d.getNombrePlato() + " vendidos: " + d.getCantVendida());
        }

   
        System.out.println("\nPlatos mas vendidos en " + expositor2.getNombreExpositor() + ":");
        for (Problema7_Platos d : expositor2.getPlatosmasVendidos()) {
            System.out.println("- " + d.getNombrePlato() + " vendidos: " + d.getCantVendida());
        }

    }

    public static void mostrarReporteExpositor(Problema7_Expositor expositor) {
        System.out.println("Reporte del expositor: " + expositor.getNombreExpositor() + " (" + expositor.getStands() + ")");
        System.out.println("Total ingresos: S/ " + expositor.calcularPlatosVendidos());
        System.out.println("Total platos vendidos: " + expositor.calcularPlatosVendidos());
        System.out.println("Platos disponibles:");
        for (Problema7_Platos dish : expositor.getPlatos()) {
            System.out.println("  * " + dish.getNombrePlato() + " - Precio: S/ " + dish.getPrecio() + ", Disponible: " + (dish.visualizardisponibilidad() ? "Si" : "No"));
        }
        System.out.println();
    }
}
