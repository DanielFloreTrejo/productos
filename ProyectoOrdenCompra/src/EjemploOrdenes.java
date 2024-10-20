import java.util.Scanner;

public class EjemploOrdenes {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        OrdenCompra ordenCompra;
        Producto producto;


        System.out.print("Nombre de la orden de compra: ");
        ordenCompra = new OrdenCompra(scanner.nextLine());
        System.out.print("Ingrese el nombre de Cliente: ");
        String[] nombreCompleto = scanner.nextLine().split(" ");
        ordenCompra.setCliente(new Cliente(nombreCompleto[0], nombreCompleto[1]));
        System.out.println("Ingrese 4 productos: ");

        for (int j = 0; j < 4; j++) {
            System.out.print("Nombre de la Fabrica: ");
            String fabrica = scanner.nextLine();
            System.out.print("Nombre del Producto: ");
            String nombre = scanner.nextLine();
            System.out.print("Precio del Producto: ");
            float precio = scanner.nextFloat();

            producto = new Producto(fabrica, nombre, precio);
            ordenCompra.addProducto(producto);
            System.out.println();
            scanner.nextLine();
        }
        System.out.println(ordenCompra.getDetalleGeneral());
    }
}
