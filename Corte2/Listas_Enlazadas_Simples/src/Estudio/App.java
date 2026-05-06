package Corte2.Listas_Enlazadas_Simples.src.Estudio;

/* 6. Lista de Pacientes (Sistema de Clínica)

Diseña un sistema para gestionar los pacientes de una clínica.

La Clase Paciente (Nodo): Debe contener nombre (String), edad (int) y costoConsulta (double).
El Problema: Los pacientes se agregan al final de la lista.

Reto: Implementa un método que recorra la lista y calcule el total de dinero recaudado por consultas.
*/

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int opcion;

        Lista_Pacientes lista = new Lista_Pacientes();

        do {
            System.out.println("\n==============================================");
            System.out.println("   SISTEMA DE PACIENTES - CLÍNICA");
            System.out.println("==============================================");
            System.out.println("1. Nuevo paciente");
            System.out.println("2. Calcular total recaudado");
            System.out.println();
            System.out.println("0. Salir");
            System.out.println("==============================================");
            System.out.print("Elige una opción: ");

            opcion = sc.nextInt();
            System.out.println();

            switch (opcion) {

                case 1:
                    sc.nextLine();
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();

                    System.out.print("Edad: ");
                    int edad = sc.nextInt();

                    System.out.print("Costo consulta: ");
                    double costo = sc.nextDouble();

                    Paciente nuevo = new Paciente(nombre, edad, costo);
                    lista.agregarPaciente(nuevo);
                    break;

                case 2:
                    double total = lista.calcularTotalConsultas();
                    System.out.println("Total recaudado: " + total);
                    break;

                case 0:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción no válida");
            }

        } while (opcion != 0);

        sc.close();
    }
}
