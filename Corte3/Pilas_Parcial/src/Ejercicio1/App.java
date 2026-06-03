package Ejercicio1;

// 1. Biblioteca Digital (Gestión de Libros Apilados)
// Una biblioteca organiza sus libros en estantes verticales donde solo se puede
// acceder al libro que está en la cima de la pila.
//
// La Clase Libro (Nodo): isbn (String), titulo (String), autor (String), anio (int).
// El Problema: El bibliotecario necesita saber cuántos libros de un autor específico
// hay en el estante sin desorganizarlo.
// Reto 1: contarPorAutor(String autor) — recorre la pila y retorna el conteo.
// Reto 2: existeIsbn(String isbn) — verifica si un ISBN ya está registrado.

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        PilaLibros estante = new PilaLibros();
        Scanner scanner = new Scanner(System.in);

        estante.push(new Libro("ISBN-001", "Clean Code", "Robert Martin", 2008));
        estante.push(new Libro("ISBN-002", "El Quijote", "Cervantes", 1605));
        estante.push(new Libro("ISBN-003", "Effective Java", "Joshua Bloch", 2018));
        estante.push(new Libro("ISBN-004", "Design Patterns", "Robert Martin", 1994));
        estante.push(new Libro("ISBN-005", "The Pragmatic Programmer", "David Thomas", 1999));

        int opcion;
        do {
            System.out.println("\n--- SISTEMA DE GESTIÓN DE BIBLIOTECA (PILAS) ---");
            System.out.println("1. Ver libros en el estante");
            System.out.println("2. Agregar libro (Push)");
            System.out.println("3. Retirar libro del tope (Pop)");
            System.out.println("4. Contar libros por autor");
            System.out.println("5. Verificar existencia por ISBN");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    estante.imprimir();
                    break;
                case 2:
                    System.out.print("ISBN: ");
                    String isbn = scanner.nextLine();
                    System.out.print("Título: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Autor: ");
                    String autor = scanner.nextLine();
                    System.out.print("Año: ");
                    int anio = scanner.nextInt();
                    scanner.nextLine();
                    estante.push(new Libro(isbn, titulo, autor, anio));
                    System.out.println("Libro agregado correctamente.");
                    break;
                case 3:
                    Libro retirado = estante.pop();
                    if (retirado != null)
                        System.out.println("Libro retirado: " + retirado);
                    else
                        System.out.println("El estante está vacío.");
                    break;
                case 4:
                    System.out.print("Nombre del autor: ");
                    String busAutor = scanner.nextLine();
                    System.out.println("Libros de \"" + busAutor + "\": " + estante.contarPorAutor(busAutor));
                    break;
                case 5:
                    System.out.print("ISBN a verificar: ");
                    String busIsbn = scanner.nextLine();
                    System.out.println(
                            estante.existeIsbn(busIsbn) ? "El ISBN sí está registrado." : "ISBN no encontrado.");
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
