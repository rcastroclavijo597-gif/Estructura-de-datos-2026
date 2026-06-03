package Ejercicio1;

/* 1. Universidad (Registro de Estudiantes por Promedio)
Una universidad almacena el récord académico en un BST usando el promedio como clave.

La Clase Estudiante (Nodo): promedio (double), nombre, codigo, carrera.
El Problema: El director necesita identificar cuántos estudiantes superan un promedio
umbral para otorgar becas de mérito.
Reto 1: contarSobre(double umbral) — aprovecha el BST para podar subárboles.
Reto 2: contarEnRango(double min, double max) — cuenta estudiantes en ese rango. */

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ArbolEstudiantes arbol = new ArbolEstudiantes();
        Scanner scanner = new Scanner(System.in);

        arbol.insertar(3.8, "Sofia Ramirez", "EST-001", "Ingenieria de Sistemas");
        arbol.insertar(4.2, "Andres Torres", "EST-002", "Medicina");
        arbol.insertar(3.1, "Camila Perez", "EST-003", "Derecho");
        arbol.insertar(4.6, "Luis Gomez", "EST-004", "Ingenieria de Sistemas");
        arbol.insertar(2.9, "Maria Diaz", "EST-005", "Administración");
        arbol.insertar(3.5, "Carlos Ruiz", "EST-006", "Medicina");
        arbol.insertar(4.9, "Valentina Cruz", "EST-007", "Derecho");
        arbol.insertar(3.3, "Felipe Mora", "EST-008", "Ingenieria Civil");

        int opcion;
        do {
            System.out.println("\n--- SISTEMA ACADÉMICO UNIVERSITARIO (BST) ---");
            System.out.println("1. Ver estudiantes ordenados por promedio (InOrden)");
            System.out.println("2. Ver árbol en PreOrden");
            System.out.println("3. Insertar nuevo estudiante");
            System.out.println("4. Buscar estudiante por promedio");
            System.out.println("5. Contar estudiantes sobre un umbral");
            System.out.println("6. Contar estudiantes en rango de promedios");
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
                    System.out.print("Promedio: ");
                    double prom = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Nombre: ");
                    String nom = scanner.nextLine();
                    System.out.print("Código: ");
                    String cod = scanner.nextLine();
                    System.out.print("Carrera: ");
                    String car = scanner.nextLine();
                    arbol.insertar(prom, nom, cod, car);
                    System.out.println("Estudiante insertado correctamente.");
                    break;
                case 4:
                    System.out.print("Promedio a buscar: ");
                    double busq = scanner.nextDouble();
                    scanner.nextLine();
                    Estudiante enc = arbol.buscar(busq);
                    if (enc != null)
                        System.out.println("Encontrado: " + enc);
                    else
                        System.out.println("No se encontró estudiante con ese promedio.");
                    break;
                case 5:
                    System.out.print("Umbral de promedio: ");
                    double umbral = scanner.nextDouble();
                    scanner.nextLine();
                    int cant = arbol.contarSobre(umbral);
                    System.out.println("Estudiantes con promedio > " + umbral + ": " + cant);
                    if (cant > 0)
                        System.out.println("Se recomienda otorgar " + cant + " beca(s).");
                    break;
                case 6:
                    System.out.print("Mínimo: ");
                    double min = scanner.nextDouble();
                    System.out.print("Máximo: ");
                    double max = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.println("Estudiantes entre " + min + " y " + max + ": " + arbol.contarEnRango(min, max));
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