package Ejercicio2;

/* 2. Supermercado (Control de Inventario con BST)
El inventario se organiza en un BST usando codigoBarras como clave (búsqueda O(log n)).

La Clase Producto (Nodo): codigoBarras (int), nombre, precio (double), stock (int).
El Problema: El gerente necesita identificar cuántos productos tienen stock bajo
(menor a un umbral) para generar órdenes de compra urgentes.
Reto 1: contarStockBajo(int umbral) — recorre el árbol y cuenta productos con stock < umbral.
Reto 2: calcularValorInventario() — suma precio * stock de todos los nodos. */

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ArbolProductos arbol = new ArbolProductos();
        Scanner scanner = new Scanner(System.in);

        arbol.insertar(1050, "Arroz Diana 500g", 4500.0, 80);
        arbol.insertar(530, "Aceite Palma 1L", 12000.0, 5);
        arbol.insertar(1720, "Leche Entera 1L", 3200.0, 3);
        arbol.insertar(320, "Azúcar 1kg", 2800.0, 45);
        arbol.insertar(2100, "Detergente 500g", 8500.0, 2);
        arbol.insertar(890, "Frijol 500g", 3800.0, 30);
        arbol.insertar(1400, "Pasta 250g", 2200.0, 7);
        arbol.insertar(200, "Sal 500g", 1500.0, 60);

        int opcion;
        do {
            System.out.println("\n--- SISTEMA DE INVENTARIO SUPERMERCADO (BST) ---");
            System.out.println("1. Ver productos ordenados por código (InOrden)");
            System.out.println("2. Ver árbol en PreOrden");
            System.out.println("3. Insertar nuevo producto");
            System.out.println("4. Buscar producto por código de barras");
            System.out.println("5. Contar productos con stock bajo");
            System.out.println("6. Calcular valor total del inventario");
            System.out.println("7. Propiedades del árbol (altura y hojas)");
            System.out.println("8. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println();
                    arbol.inOrden();
                    break;
                case 2:
                    System.out.println();
                    arbol.preOrden();
                    break;
                case 3:
                    System.out.print("Código de barras: ");
                    int cod = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nombre: ");
                    String nom = scanner.nextLine();
                    System.out.print("Precio: ");
                    double pre = scanner.nextDouble();
                    System.out.print("Stock: ");
                    int sto = scanner.nextInt();
                    scanner.nextLine();
                    arbol.insertar(cod, nom, pre, sto);
                    System.out.println("Producto insertado correctamente.");
                    break;
                case 4:
                    System.out.print("Código a buscar: ");
                    int busq = scanner.nextInt();
                    scanner.nextLine();
                    Producto enc = arbol.buscar(busq);
                    if (enc != null)
                        System.out.println("Encontrado: " + enc);
                    else
                        System.out.println("No se encontró producto con ese código.");
                    break;
                case 5:
                    System.out.print("Umbral de stock mínimo: ");
                    int umbral = scanner.nextInt();
                    scanner.nextLine();
                    int bajo = arbol.contarStockBajo(umbral);
                    System.out.println("Productos con stock < " + umbral + ": " + bajo);
                    if (bajo > 0)
                        System.out.println("ALERTA: Generar " + bajo + " orden(es) de compra.");
                    break;
                case 6:
                    System.out.printf("Valor total del inventario: $%.2f%n", arbol.calcularValorInventario());
                    break;
                case 7:
                    System.out.println("Altura del árbol: " + arbol.altura());
                    System.out.println("Nodos hoja:       " + arbol.contarHojas());
                    break;
                case 8:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 8);
        scanner.close();
    }
}