
import java.util.ArrayList;
import java.util.List;

public class Problema7_Platos {

    public int id;
    public String nombrePlato;
    public double precio;
    public List<Problem7_Ingredientes> ingredientes;
    public boolean disponible;
    public int cantVendida;

    public Problema7_Platos(int id, String nombrePlato, double precio) {
        this.id = id;
        this.nombrePlato = nombrePlato;
        this.precio = precio;
        this.ingredientes = new ArrayList();
        this.disponible = true;
        this.cantVendida = 0;
    }

    public int getId() {
        return id;
    }

    public String getNombrePlato() {
        return nombrePlato;
    }

    public double getPrecio() {
        return precio;
    }
    public List<Problem7_Ingredientes> getIngredients() {
        return ingredientes;
    }

    public boolean visualizardisponibilidad() {
        return disponible;
    }

    public int getCantVendida() {
        return cantVendida;
    }

    public void agregarIngredientes(Problem7_Ingredientes ingredientes) {
        this.ingredientes.add(ingredientes);
    }

    public void actualizarDisponibilidad(boolean status) {
        this.disponible = status;
    }

    public void venderPlatos(int cantidad) {
        if (cantidad > 0 && disponible) {
            this.cantVendida += cantidad;
        } else {
            System.out.println("No se puede registrar venta: cantidad inválida o plato no disponible");
        }
    }

    public double getIngresos() {
        return this.cantVendida * this.precio;
    }

    @Override
    public String toString() {
        StringBuilder ingredientsStr = new StringBuilder();
        for (Problem7_Ingredientes ing : ingredientes) {
            ingredientsStr.append(ing.toString()).append(", ");
        }

        if (ingredientsStr.length() > 0) {
            ingredientsStr.setLength(ingredientsStr.length() - 2);
        }
        return String.format("Plato[id=%d, Nombre=%s, Precio=%.2f, Disponible=%b, Vendidos=%d, Ingredientes=[%s]]",
                id, nombrePlato, precio, disponible, cantVendida, ingredientsStr.toString()
        );
    }

}
