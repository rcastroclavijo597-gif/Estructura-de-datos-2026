package ejerciciosclase.src;

import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double precio;
        int cantidad;
        double descuento;
        double total;
        double totalConDescuento;

        System.out.print("Ingrese el precio del producto: ");
        precio = sc.nextDouble();

        System.out.print("Ingrese la cantidad comprada: ");
        cantidad = sc.nextInt();

        System.out.print("Ingrese el descuento (%): ");
        descuento = sc.nextDouble();

        total = precio * cantidad;

        totalConDescuento = total - (total * descuento / 100);

        for (int i = 0; i < 20; i++) {
            System.out.println();
        }

        System.out.println("----- FACTURA -----");
        System.out.println("Precio unitario: " + precio);
        System.out.println("Cantidad: " + cantidad);
        System.out.println("Descuento: " + descuento + "%");
        System.out.println("Total a pagar: " + totalConDescuento);

        sc.close();
    }
}
