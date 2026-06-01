package Ejercicio2;

/* 2. Catálogo Digital (Biblioteca Universitaria)
La biblioteca de la universidad organiza su colección de libros en un BST usando el ISBN
como clave única. Cada vez que ingresa un libro nuevo, se inserta automáticamente en el árbol.
El sistema debe poder confirmar si un ISBN ya existe antes de registrar un nuevo ejemplar
y listar toda la colección ordenada por ISBN.

La Clase Libro (Nodo): isbn (long), titulo (String), autor (String), anioPublicacion (int).
El Problema: Al final del semestre, el bibliotecario necesita imprimir el inventario completo
ordenado de menor a mayor por ISBN para enviarlo a la sede central. También debe verificar
si un ISBN específico ya existe en el catálogo antes de registrar una donación.
Reto: Implementa imprimirCatalogo() usando InOrden para listar todos los libros en orden
ascendente de ISBN (imprime isbn - titulo - autor). Además, implementa existeISBN(long isbn)
que retorne true si el libro ya está registrado y false en caso contrario. */

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ArbolBiblioteca arbol = new ArbolBiblioteca();
        Scanner scanner = new Scanner(System.in);

        arbol.insertar(9780143127550L, "El Quijote", "Miguel de Cervantes", 1605);
        arbol.insertar(9780062316097L, "Sapiens", "Yuval Noah Harari", 2011);
        arbol.insertar(9780743273565L, "El Gran Gatsby", "F. Scott Fitzgerald", 1925);
        arbol.insertar(9780451524935L, "1984", "George Orwell", 1949);
        arbol.insertar(9780307474278L, "Cien Años de Soledad", "Gabriel García M.", 1967);
        arbol.insertar(9780141439518L, "Orgullo y Prejuicio", "Jane Austen", 1813);
        arbol.insertar(9780671027032L, "Cómo Ganar Amigos", "Dale Carnegie", 1936);
        arbol.insertar(9780316769174L, "El Guardián entre el Centeno", "J.D. Salinger", 1951);

        int opcion;
        do {
            System.out.println("\n--- SISTEMA DE CATÁLOGO DIGITAL (BST) ---");
            System.out.println("1. Ver registros ordenados por ISBN (InOrden)");
            System.out.println("2. Ver árbol en PreOrden");
            System.out.println("3. Insertar nuevo libro");
            System.out.println("4. Buscar libro por ISBN");
            System.out.println("5. Imprimir catálogo (isbn - titulo - autor)");
            System.out.println("6. Verificar si un ISBN ya existe");
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
                    System.out.print("ISBN (solo números): ");
                    long isbn = scanner.nextLong();
                    scanner.nextLine();
                    System.out.print("Título: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Autor: ");
                    String autor = scanner.nextLine();
                    System.out.print("Año de publicación: ");
                    int anio = scanner.nextInt();
                    scanner.nextLine();
                    arbol.insertar(isbn, titulo, autor, anio);
                    System.out.println("Libro insertado correctamente.");
                    break;

                case 4:
                    System.out.print("ISBN a buscar: ");
                    long busqueda = scanner.nextLong();
                    scanner.nextLine();
                    Libro encontrado = arbol.buscar(busqueda);
                    if (encontrado != null)
                        System.out.println("Libro encontrado: " + encontrado);
                    else
                        System.out.println("No se encontró ningún libro con ISBN " + busqueda + ".");
                    break;

                case 5:
                    System.out.println();
                    arbol.imprimirCatalogo();
                    break;

                case 6:
                    System.out.print("ISBN a verificar: ");
                    long verificar = scanner.nextLong();
                    scanner.nextLine();
                    if (arbol.existeISBN(verificar))
                        System.out.println("El ISBN " + verificar
                                + " YA existe en el catálogo. No se puede registrar la donación.");
                    else
                        System.out.println("El ISBN " + verificar + " NO existe. La donación puede registrarse.");
                    break;

                case 7:
                    System.out.println("Altura del árbol:  " + arbol.altura());
                    System.out.println("Nodos hoja:        " + arbol.contarHojas());
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
