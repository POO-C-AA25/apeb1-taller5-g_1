
import java.util.Scanner;

public class Problema1_Ejecutor {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int opc, cantidad;
        boolean agregandoProdu, continuar;
        double monto;

        Problema1_Producto[] inventario = new Problema1_Producto[5];
        inventario[0] = new Problema1_Producto("Laptop", 899.99, 10);
        inventario[1] = new Problema1_Producto("Celular", 499.99, 15);
        inventario[2] = new Problema1_Producto("Tablet", 299.99, 8);
        inventario[3] = new Problema1_Producto("Auriculares", 59.99, 20);
        inventario[4] = new Problema1_Producto("Cargador", 19.99, 30);

        System.out.println("--- Inventario ---");
        for (int i = 0; i < inventario.length; i++) {
            System.out.println((i + 1) + ". " + inventario[i]);
        }

        Problema1_CarritodeCompras carrito = new Problema1_CarritodeCompras(10);

        continuar = true;
        while (continuar) {
            System.out.print("Seleccione una opcion: ");
            System.out.println("\nMENU ");
            System.out.println("1. Agregar productos al carrito");
            System.out.println("2. Ver carrito");
            System.out.println("3. Realizar pago");
            System.out.println("4. Salir");
            opc = input.nextInt();

            switch (opc) {
                case 1:
                    agregandoProdu = true;
                    while (agregandoProdu) {
                        System.out.print("\nIngrese el numero del producto (1-5) o 0 para terminar: ");
                        int numProducto = input.nextInt();

                        if (numProducto == 0) {
                            agregandoProdu = false;
                            break;
                        }

                        if (numProducto < 1 || numProducto > inventario.length) {
                            System.out.println("Numero de producto invalido");
                            continue;
                        }

                        System.out.print("Ingrese la cantidad: ");
                        cantidad = input.nextInt();

                        if (carrito.agregarProducto(inventario[numProducto - 1], cantidad)) {
                            System.out.println("Producto agregado al carrito");
                        } else {
                            System.out.println("No se pudo agregar el producto");
                        }
                    }
                    break;

                case 2:
                    carrito.mostrarDetalleCompra();
                    break;

                case 3:
                    carrito.mostrarDetalleCompra();
                    System.out.print("Ingrese el monto a pagar: ");
                    monto = input.nextDouble();
                    System.out.println(carrito.realizarPago(monto));
                    continuar = false;
                    break;

                case 4:
                    continuar = false;
                    break;

                default:
                    System.out.println("Opcion Invalida");
            }
        }
    }
}
