package Corte2.Listas_Circulares.src.Ejercicio5;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Torneo torneo = new Torneo();
        int opcion;

        do {
            System.out.println("\n==============================================");
            System.out.println("   Torneo de Fútbol — Round Robin");
            System.out.println("==============================================");
            System.out.println("1. Agregar equipo");
            System.out.println("2. Mostrar equipos");
            System.out.println("3. Generar fixture");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del equipo: ");
                    String nombre = sc.next();
                    System.out.print("Ingrese la ciudad: ");
                    String ciudad = sc.next();
                    Equipo nuevo = new Equipo(nombre, ciudad);
                    torneo.agregarEquipo(nuevo);
                    break;

                case 2:
                    torneo.mostrarEquipos();
                    break;

                case 3:
                    torneo.generarFixture();
                    break;

                case 0:
                    System.out.println("Saliendo del torneo...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);

        sc.close();
    }
}
