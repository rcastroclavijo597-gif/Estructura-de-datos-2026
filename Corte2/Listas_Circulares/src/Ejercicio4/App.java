package Corte2.Listas_Circulares.src.Ejercicio4;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        Restaurante restaurante = new Restaurante();

        do {
            System.out.println("\n==============================================");
            System.out.println("   Gestión de Mesas — Restaurante");
            System.out.println("==============================================");
            System.out.println("1. agregarGrupo");
            System.out.println("2. mostrarGrupos");
            System.out.println("3. atenderSiguiente");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre de la reserva: ");
                    String nombre = sc.next();
                    System.out.print("Ingrese el número de personas: ");
                    int personas = sc.nextInt();
                    System.out.print("¿Es VIP? (true/false): ");
                    boolean esVip = sc.nextBoolean();
                    System.out.print("Ingrese los minutos esperando: ");
                    int minutos = sc.nextInt();
                    Grupo nuevo = new Grupo(nombre, personas, esVip, minutos);
                    restaurante.agregarGrupo(nuevo);
                    break;

                case 2:
                    restaurante.mostrarGrupos();
                    break;

                case 3:
                    for (int i = 0; i < 6; i++) {
                        restaurante.atenderSiguiente();
                    }
                    break;

                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 0);

        sc.close();
    }
}
