package Ejercicio3;

/* 3. Empresa (Sistema de Nómina con BST)
La empresa organiza empleados en un BST usando la cédula como clave.

La Clase Empleado (Nodo): cedula (int), nombre, departamento, salario (double).
El Problema: Contabilidad necesita la nómina total mensual y saber cuántos
empleados superan cierto salario para aplicar políticas de retención.
Reto 1: calcularNominaTotal() — recorre todo el árbol sumando salarios.
Reto 2: contarSalarioMayorA(double umbral) — cuenta empleados con salario > umbral. */

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ArbolNomina arbol = new ArbolNomina();
        Scanner scanner = new Scanner(System.in);

        arbol.insertar(10234567, "Carlos Mendez", "Ingenieria", 4500000.0);
        arbol.insertar(5123456, "Maria Ospina", "Recursos Humanos", 3200000.0);
        arbol.insertar(20345678, "Luis Vargas", "Finanzas", 5800000.0);
        arbol.insertar(3456789, "Ana Florez", "Ingenieria", 4200000.0);
        arbol.insertar(15678901, "Pedro Suarez", "Ventas", 2900000.0);
        arbol.insertar(8901234, "Sofia Reyes", "Finanzas", 6100000.0);
        arbol.insertar(25012345, "Andres Mora", "Ventas", 2700000.0);
        arbol.insertar(1234567, "Elena Castro", "Recursos Humanos", 3500000.0);

        int opcion;
        do {
            System.out.println("\n--- SISTEMA DE NÓMINA EMPRESARIAL (BST) ---");
            System.out.println("1. Ver empleados ordenados por cédula (InOrden)");
            System.out.println("2. Ver árbol en PreOrden");
            System.out.println("3. Insertar nuevo empleado");
            System.out.println("4. Buscar empleado por cédula");
            System.out.println("5. Calcular nómina total");
            System.out.println("6. Contar empleados con salario mayor a un umbral");
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
                    System.out.print("Cédula: ");
                    int ced = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nombre: ");
                    String nom = scanner.nextLine();
                    System.out.print("Departamento: ");
                    String dep = scanner.nextLine();
                    System.out.print("Salario: ");
                    double sal = scanner.nextDouble();
                    scanner.nextLine();
                    arbol.insertar(ced, nom, dep, sal);
                    System.out.println("Empleado insertado correctamente.");
                    break;
                case 4:
                    System.out.print("Cédula a buscar: ");
                    int busq = scanner.nextInt();
                    scanner.nextLine();
                    Empleado enc = arbol.buscar(busq);
                    if (enc != null)
                        System.out.println("Encontrado: " + enc);
                    else
                        System.out.println("No se encontró empleado con esa cédula.");
                    break;
                case 5:
                    System.out.printf("Nómina total: $%.2f%n", arbol.calcularNominaTotal());
                    break;
                case 6:
                    System.out.print("Umbral de salario: ");
                    double umbral = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.println("Empleados con salario > $" + umbral + ": " + arbol.contarSalarioMayorA(umbral));
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