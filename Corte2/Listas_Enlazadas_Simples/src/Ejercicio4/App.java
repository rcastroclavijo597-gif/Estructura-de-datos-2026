/* 4. Monitoreo Industrial (Sensores en Tiempo Real)
Una planta química registra lecturas de sus tanques cada hora en una lista enlazada para auditoría.

La Clase Lectura (Nodo): Debe contener idSensor (int), temperatura (double), presion (double) y hora (String).
El Problema: Las lecturas se van agregando al inicio para que la más reciente sea siempre la primera que vea el supervisor.
Reto: Implementa un método que busque y muestre la lectura con la temperatura más alta registrada en el historial. */

package Ejercicio4;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int opcion;

        ListaLecturas lista = new ListaLecturas();

        do {
            System.out.println("\n==============================================");
            System.out.println("   MONITOREO INDUSTRIAL - Menu Principal");
            System.out.println("==============================================");
            System.out.println("1. Nueva lectura");
            System.out.println("2. Mostrar temperatura maxima");
            System.out.println("3. Mostrar lecturas");
            System.out.println();
            System.out.println("0. Salir");
            System.out.println("==============================================");
            System.out.print("Elige una opcion: ");

            opcion = sc.nextInt();

            System.out.println();

            switch (opcion) {

                case 1:
                    System.out.print("ID del sensor: ");
                    int id = sc.nextInt();

                    System.out.print("Temperatura: ");
                    double temp = sc.nextDouble();

                    System.out.print("Presion: ");
                    double presion = sc.nextDouble();

                    sc.nextLine();
                    System.out.print("Hora: ");
                    String hora = sc.nextLine();

                    Lectura nueva = new Lectura(id, temp, presion, hora);
                    lista.agregarLectura(nueva);
                    break;

                case 2:
                    lista.mostrarTemperaturaMaxima();
                    break;

                case 3:
                    lista.mostrarLecturas();
                    break;

                case 0:
                    System.out.println("¡Saliendo del sistema!");
                    break;

                default:
                    System.out.println("Opcion no valida.");
            }

        } while (opcion != 0);

        sc.close();
    }
}
