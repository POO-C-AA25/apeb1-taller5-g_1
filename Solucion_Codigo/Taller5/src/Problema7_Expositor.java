import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Problema7_Expositor {

    public  int id;
    public String nombreExpositor;
    public String puesto;
    public List<Problema7_Platos> platos;

    public Problema7_Expositor(int id, String nombreExpositor, String puesto) {
        this.id = id;
        this.nombreExpositor = nombreExpositor;
        this.puesto = puesto;
        this.platos = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getNombreExpositor() {
        return nombreExpositor;
    }

    public String getStands() {
        return puesto;
    }

    public List<Problema7_Platos> getPlatos() {
        return platos;
    }

    public void registrarPlato(Problema7_Platos plato) {
        this.platos.add(plato);
    }

    public void actualizarDisponibilidadPlato(int idPlato, boolean disponible) {
        for (Problema7_Platos plato : platos) {
            if (plato.getId() == idPlato) {
                plato.actualizarDisponibilidad(disponible);
                return;
            }
        }
        System.out.println("Plato con ID " + idPlato + " no encontrado.");
    }

    public void venderPlato(int idPlato, int cantidad) {
        for (Problema7_Platos plato : platos) {
            if (plato.getId() == idPlato) {
                plato.venderPlatos(cantidad);
                return;
            }
        }
        System.out.println("Plato con ID " + idPlato + " no encontrado para venta.");
    }

    public double calcularIngresosTotales() {
        double total = 0;
        for (Problema7_Platos plato : platos) {
            total += plato.getIngresos();
        }
        return total;
    }

    public int calcularPlatosVendidos() {
        int total = 0;
        for (Problema7_Platos plato : platos) {
            total += plato.getCantVendida();
        }
        return total;
    }

    public List<Problema7_Platos> getPlatosmasVendidos() {
        List<Problema7_Platos> platosOrdenados = new ArrayList<>(platos);
        platosOrdenados.sort(Comparator.comparingInt(Problema7_Platos::getCantVendida).reversed());
        return platosOrdenados;
    }
    /***
     * Utilice el paquete de comparator de java.util para la comparacion de los platos y evitar crar un codigo mas grande como la utilizacion del algoritmo
    cual numero es mayor. Entonces lo que hace comparator es que me ordena los platos mas vendisdos de menor a mayor, pero con los metodos utilizados 
    realiza lo siquiente en este orden, Comparator.comparingInt->Crea un comparador y me ordena los datos de menor a mayor segun el metodo getCantVendidad
    .reversed()-> invierte este orden entonces tenemos datos de mayor a menor, .sort()-> ingresa estos datos ordenados en la lista Platos ordenados 
    * ::-> referencia directa a un metodo, da una orden a java como "ordena estos datos con el valor del metodo tal ... del objeto Problema7_Platos"
     * @Cristhian Quizhpe
     */
   

    @Override
    public String toString() {
        return String.format("Expositor[id=%d, Nombre=%s, Puesto=%s, Cantidad de platos=%d]",
                id, nombreExpositor, puesto, platos.size()
        );
    }
}
