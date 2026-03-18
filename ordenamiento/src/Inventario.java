import java.util.Scanner;

public class Inventario {
    public static void main(String[] args) {
        class Producto {
            String Nombre;
            int Cantidad;
            int Stock;
            double Precio;

        }

        Scanner n = new Scanner(System.in);
        Producto[] productos = new Producto[5];
        for (int i = 0; i < productos.length; i++) {
            productos[i] = new Producto();
            System.out.println("Ingrese el id del prodcuto" + 1 + i);
            int id = n.nextInt();
            n.nextLine();
            System.out.println("Ingrese el nombre del producto" + i + 1);
            productos[i].Nombre = n.nextLine();
            System.out.println("Ingrese el precio del producto" + 1 + i);
            productos[i].Precio = n.nextDouble();
            System.out.println("Ingrese la cantidad de productos" + i + 1);
            productos[i].Stock = n.nextInt();
        }

    }
}
