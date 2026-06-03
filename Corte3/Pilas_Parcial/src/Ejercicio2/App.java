package Ejercicio2;

// 2. Almacén de Supermercado (Gestión de Inventario Apilado)
// En un almacén, los productos se colocan en estantes verticales (LIFO).
// Solo se puede acceder al producto que está en la cima del estante.
//
// La Clase Producto (Nodo): codigo, nombre, categoria, precio (double), cantidad (int).
// El Problema: El encargado necesita el valor total del inventario para reportes contables.
// Reto 1: calcularValorTotal() — recorre la pila sumando precio * cantidad de cada producto.
// Reto 2: contarPorCategoria(String categoria) — cuenta productos de esa categoría.

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        PilaProductos almacen = new PilaProductos();
        Scanner scanner = new Scanner(System.in);

        almacen.push(new Producto("P001", "Arroz Diana", "Granos", 4500.0, 50));
        almacen.push(new Producto("P002", "Aceite Palma", "Aceites", 12000.0, 30));
        almacen.push(new Producto("P003", "Frijol Rojo", "Granos", 3800.0, 40));
        almacen.push(new Producto("P004", "Leche Entera", "Lácteos", 3200.0, 60));
        almacen.push(new Producto("P005", "Azúcar Manuelita", "Endulzantes", 2800.0, 25));

        int opcion;
        do {
            System.out.println("\n--- SISTEMA DE GESTIÓN DE ALMACÉN (PILAS) ---");
            System.out.println("1. Ver productos en el almacén");
            System.out.println("2. Registrar nuevo producto (Push)");
            System.out.println("3. Retirar producto del tope (Pop)");
            System.out.println("4. Calcular valor total del inventario");
            System.out.println("5. Contar productos por categoría");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    almacen.imprimir();
                    break;
                case 2:
                    System.out.print("Código: ");
                    String cod = scanner.nextLine();
                    System.out.print("Nombre: ");
                    String nom = scanner.nextLine();
                    System.out.print("Categoría: ");
                    String cat = scanner.nextLine();
                    System.out.print("Precio: ");
                    double pre = scanner.nextDouble();
                    System.out.print("Cantidad: ");
                    int can = scanner.nextInt();
                    scanner.nextLine();
                    almacen.push(new Producto(cod, nom, cat, pre, can));
                    System.out.println("Producto registrado correctamente.");
                    break;
                case 3:
                    Producto retirado = almacen.pop();
                    if (retirado != null)
                        System.out.println("Producto retirado: " + retirado);
                    else
                        System.out.println("El almacén está vacío.");
                    break;
                case 4:
                    System.out.printf("Valor total del inventario: $%.2f%n", almacen.calcularValorTotal());
                    break;
                case 5:
                    System.out.print("Categoría a buscar: ");
                    String buscat = scanner.nextLine();
                    System.out.println("Productos en \"" + buscat + "\": " + almacen.contarPorCategoria(buscat));
                    break;
                case 6:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 6);
        scanner.close();
    }
}