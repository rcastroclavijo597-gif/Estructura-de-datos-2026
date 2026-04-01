/* 2. Inventario de Alimentos (Control de Caducidad)
Un supermercado necesita gestionar su estante de lácteos. Los productos que vencen más pronto deben colocarse 
al principio para ser vendidos primero.

La Clase Producto (Nodo): Debe contener nombre (String), cantidad (int) y diasParaVencer (int).
El Problema: Si llega un producto que vence en menos de 3 días, debe insertarse al inicio de la lista 
(prioridad de venta). Si vence en más tiempo, se pone al final.
Reto: Crea un método que imprima solo los productos que tienen menos de 5 días para vencer. */

package Ejercicio2;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int opcion;

        Inventario inventario = new Inventario();

        do {
            System.out.println("\n==============================================");
            System.out.println("   INVENTARIO DE LACTEOS - Menu");
            System.out.println("==============================================");
            System.out.println("1. Agregar producto");
            System.out.println("2. Mostrar productos con menos de 5 dias");
            System.out.println();
            System.out.println("0. Salir");
            System.out.println("==============================================");
            System.out.print("Elige una opcion: ");

            opcion = sc.nextInt();

            System.out.println();

            switch (opcion) {

                case 1:
                    System.out.print("Ingrese el nombre del producto: ");
                    sc.nextLine();
                    String nombre = sc.nextLine();

                    System.out.print("Ingrese la cantidad: ");
                    int cantidad = sc.nextInt();

                    System.out.print("Ingrese dias para vencer: ");
                    int dias = sc.nextInt();

                    Producto nuevoProducto = new Producto(nombre, cantidad, dias);
                    inventario.agregarProducto(nuevoProducto);
                    break;

                case 2:
                    inventario.mostrarProductosMenos5Dias();
                    break;

                case 0:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opcion no valida.");
            }

        } while (opcion != 0);

        sc.close();
    }
}
