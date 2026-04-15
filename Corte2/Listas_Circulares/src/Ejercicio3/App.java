package Corte2.Listas_Circulares.src.Ejercicio3;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        Planificador planificador = new Planificador();

        do {
            System.out.println("\n==============================================");
            System.out.println("   Planificador CPU — Round Robin");
            System.out.println("==============================================");
            System.out.println("1. agregarProceso");
            System.out.println("2. mostrarProcesos");
            System.out.println("3. ejecutar");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del proceso: ");
                    String nombre = sc.next();
                    System.out.print("Ingrese el PID: ");
                    int pid = sc.nextInt();
                    System.out.print("Ingrese el tiempo restante: ");
                    int tiempo = sc.nextInt();
                    System.out.print("Ingrese la prioridad (1-3): ");
                    int prioridad = sc.nextInt();
                    Proceso nuevo = new Proceso(nombre, pid, tiempo, prioridad);
                    planificador.agregarProceso(nuevo);
                    break;

                case 2:
                    planificador.mostrarProcesos();
                    break;

                case 3:
                    System.out.print("Ingrese el quantum: ");
                    int quantum = sc.nextInt();
                    planificador.ejecutar(quantum);
                    break;

                case 0:
                    System.out.println("Saliendo del planificador...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 0);

        sc.close();
    }
}
