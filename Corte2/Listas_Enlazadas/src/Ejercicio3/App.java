/* 3. Torre de Control (Aterrizajes de Emergencia)
Simula la cola de aviones esperando para aterrizar en un aeropuerto congestionado.

La Clase Vuelo (Nodo): Debe contener numeroVuelo (String), aerolinea (String), combustibleRestante (int) y pasajeros (int).
El Problema: Normalmente los vuelos se forman al final de la cola. Sin embargo, si un vuelo reporta menos de 10 unidades de combustible, 
debe ser movido inmediatamente al inicio de la lista (Cabeza).
Reto: Implementar el método reportarEmergencia(String numeroVuelo) que busque un vuelo en la cola y lo mueva al principio. */

package Ejercicio3;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int opcion;

        ColaVuelos cola = new ColaVuelos();

        do {
            System.out.println("\n==============================================");
            System.out.println("   TORRE DE CONTROL - Menu Principal");
            System.out.println("==============================================");
            System.out.println("1. Nuevo vuelo");
            System.out.println("2. Reportar emergencia");
            System.out.println("3. Mostrar vuelos");
            System.out.println();
            System.out.println("0. Salir");
            System.out.println("==============================================");
            System.out.print("Elige una opcion: ");

            opcion = sc.nextInt();

            System.out.println();

            switch (opcion) {

                case 1:
                    System.out.print("Numero de vuelo: ");
                    sc.nextLine();
                    String numero = sc.nextLine();

                    System.out.print("Aerolinea: ");
                    String aerolinea = sc.nextLine();

                    System.out.print("Combustible restante: ");
                    int combustible = sc.nextInt();

                    System.out.print("Pasajeros: ");
                    int pasajeros = sc.nextInt();

                    Vuelo nuevo = new Vuelo(numero, aerolinea, combustible, pasajeros);
                    cola.agregarVuelo(nuevo);
                    break;

                case 2:
                    System.out.print("Ingrese numero de vuelo en emergencia: ");
                    sc.nextLine();
                    String vueloEmergencia = sc.nextLine();

                    cola.reportarEmergencia(vueloEmergencia);
                    break;

                case 3:
                    cola.mostrarVuelos();
                    break;

                case 0:
                    System.out.println("¡Saliendo de la torre de control!");
                    break;

                default:
                    System.out.println("Opcion no valida.");
            }

        } while (opcion != 0);

        sc.close();
    }
}
