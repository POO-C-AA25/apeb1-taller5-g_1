public class Problema1_CarritodeCompras {
    public Problema1_Producto[] productos;
    public int[] cantidades;
    public int contadorProductos;

    public Problema1_CarritodeCompras() {
    }

    public Problema1_CarritodeCompras(int capacidadMaxima) {
        this.productos = new Problema1_Producto[capacidadMaxima];
        this.cantidades = new int[capacidadMaxima];
        this.contadorProductos = 0;
    }
 

    public boolean agregarProducto(Problema1_Producto producto, int cantidad) {
        if (contadorProductos >= productos.length) {
            System.out.println("El carrito esta lleno.");
            return false;
        }

        if (producto.getCantidad() < cantidad) {
            System.out.println("No hay suficiente stock de " + producto.getNombre());
            return false;
        }

        productos[contadorProductos] = producto;
        cantidades[contadorProductos] = cantidad;
        contadorProductos++;
        return true;
    }

    public double calcularTotal() {
        double total = 0;
        for (int i = 0; i < contadorProductos; i++) {
            total += productos[i].getPrecio() * cantidades[i];
        }

        if (total > 1000) {
            total -= total * 0.1;
        }

        return total;
    }

    public String realizarPago(double montoPagado) {
        double total = calcularTotal();
        int nuevaCantidad;
        if (montoPagado >= total) {
            for (int i = 0; i < contadorProductos; i++) {
                nuevaCantidad = productos[i].getCantidad() - cantidades[i];
                productos[i].setCantidad(nuevaCantidad);
            }
            return "Gracias por su compra. Su cambio es: %.2f " + (montoPagado - total);
        } else {
            return "Fondos insuficientes. Faltan: " + (total - montoPagado);
        }
    }

    public void mostrarDetalleCompra() {
        System.out.println("\n--- Factura ---");
        for (int i = 0; i < contadorProductos; i++) {
            System.out.printf("%s - Cantidad: %d - Subtotal: $%.2f%n",
                    productos[i].getNombre(),
                    cantidades[i],
                    productos[i].getPrecio() * cantidades[i]);
        }
        System.out.printf("Total: $%.2f%n", calcularTotal());
        if (calcularTotal() > 1000) {
            System.out.println("Se aplico un descuento del 10%");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Carrito de Compras:\n");
        for (int i = 0; i < contadorProductos; i++) {
            sb.append(String.format("- %s x%d%n", productos[i].getNombre(), cantidades[i]));
        }
        sb.append(String.format("Total: $%.2f", calcularTotal()));
        return sb.toString();
    }
    /***
     * utilizacion de StringBuilder una clase paar una secuencia de caracteres, se encontro esta clase en solucion o la complementacion a 
     * utilizar String.format, como lo podemos observar esta clase nos permite agregar(append), insertar(insert), es como manejar objetos.
     */
}
