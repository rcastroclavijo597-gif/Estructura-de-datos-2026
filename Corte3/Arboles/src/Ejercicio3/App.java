package Ejercicio3;

/* 3. Sistema de Nómina (Recursos Humanos)
Una empresa de logística administra a sus empleados en un BST organizado por número de
cédula. El área de RRHH consulta frecuentemente el empleado con el menor y el mayor número
de cédula para procesar los extremos de la nómina. También necesita conocer la altura del
árbol para auditar si la estructura sigue siendo eficiente después de muchas incorporaciones.

La Clase Empleado (Nodo): cedula (long), nombreCompleto (String), cargo (String), salario (double).
El Problema: El sistema debe ubicar al empleado con la cédula más baja (el más antiguo en
el registro) y al de cédula más alta (el más reciente), y reportar la altura actual del árbol
para verificar que las búsquedas siguen siendo eficientes.
Reto: Implementa buscarMinimo() y buscarMaximo(), que recorran el BST siguiendo siempre el
subárbol izquierdo o derecho respectivamente hasta llegar a una hoja e impriman los datos del
empleado encontrado. Implementa también reporteEficiencia() que imprima la altura actual del
árbol y el número total de hojas (contarHojas()). */

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ArbolNomina arbol = new ArbolNomina();
        Scanner scanner = new Scanner(System.in);

        arbol.insertar(10458321L, "Carlos Mendoza Ríos", "Conductor", 2850000.0);
        arbol.insertar(7234561L, "Luisa Fernanda Torres", "Coordinadora", 3900000.0);
        arbol.insertar(15672890L, "Andrés Felipe Gómez", "Auxiliar Bodega", 2100000.0);
        arbol.insertar(5109847L, "María Alejandra Ruiz", "Gerente Logística", 7500000.0);
        arbol.insertar(12384756L, "Jorge Iván Castillo", "Despachador", 2600000.0);
        arbol.insertar(9871234L, "Valentina Ospina Mora", "Analista RRHH", 3400000.0);
        arbol.insertar(18903412L, "Sebastián Vargas Peña", "Conductor", 2850000.0);
        arbol.insertar(3456789L, "Gloria Inés Salcedo", "Contadora", 4800000.0);

        int opcion;
        do {
            System.out.println("\n--- SISTEMA DE NÓMINA (BST) ---");
            System.out.println("1. Ver empleados ordenados por cédula (InOrden)");
            System.out.println("2. Ver árbol en PreOrden");
            System.out.println("3. Insertar nuevo empleado");
            System.out.println("4. Buscar empleado por cédula");
            System.out.println("5. Empleado con cédula mínima");
            System.out.println("6. Empleado con cédula máxima");
            System.out.println("7. Reporte de eficiencia del árbol");
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
                    long cedula = scanner.nextLong();
                    scanner.nextLine();
                    System.out.print("Nombre completo: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Cargo: ");
                    String cargo = scanner.nextLine();
                    System.out.print("Salario: ");
                    double salario = scanner.nextDouble();
                    scanner.nextLine();
                    arbol.insertar(cedula, nombre, cargo, salario);
                    System.out.println("Empleado insertado correctamente.");
                    break;

                case 4:
                    System.out.print("Cédula a buscar: ");
                    long busqueda = scanner.nextLong();
                    scanner.nextLine();
                    Empleado encontrado = arbol.buscar(busqueda);
                    if (encontrado != null)
                        System.out.println("Empleado encontrado: " + encontrado);
                    else
                        System.out.println("No se encontró ningún empleado con cédula " + busqueda + ".");
                    break;

                case 5:
                    System.out.println();
                    arbol.buscarMinimo();
                    break;

                case 6:
                    System.out.println();
                    arbol.buscarMaximo();
                    break;

                case 7:
                    System.out.println();
                    arbol.reporteEficiencia();
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
