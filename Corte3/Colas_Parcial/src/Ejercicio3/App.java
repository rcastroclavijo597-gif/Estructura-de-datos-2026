package Ejercicio3;

/* 3. Aeropuerto (Pista de Espera para Despegue)
Los vuelos esperan autorización para despegar en orden de solicitud (FIFO).

La Clase Vuelo (Nodo): codigoVuelo, destino, aerolinea, pasajeros (int).
El Problema: El controlador aéreo necesita el total de pasajeros en pista
para coordinar con servicios de tierra.
Reto 1: totalPasajeros() — recorre la cola sumando el campo pasajeros de cada vuelo.
Reto 2: contarPorAerolinea(String aerolinea) — vuelos pendientes de esa aerolínea. */

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        ColaVuelos pista = new ColaVuelos();
        Scanner scanner = new Scanner(System.in);

        pista.enqueue(new Vuelo("AV123", "Bogotá", "Avianca", 180));
        pista.enqueue(new Vuelo("LA456", "Lima", "LATAM", 200));
        pista.enqueue(new Vuelo("AV789", "Medellín", "Avianca", 150));
        pista.enqueue(new Vuelo("CO321", "Miami", "Copa Airlines", 220));
        pista.enqueue(new Vuelo("LA654", "Caracas", "LATAM", 160));

        int opcion;
        do {
            System.out.println("\n--- SISTEMA DE CONTROL DE PISTA (COLAS) ---");
            System.out.println("1. Ver vuelos en pista de espera");
            System.out.println("2. Registrar nuevo vuelo");
            System.out.println("3. Autorizar despegue (Dequeue)");
            System.out.println("4. Total de pasajeros en pista");
            System.out.println("5. Contar vuelos por aerolínea");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    pista.imprimir();
                    break;
                case 2:
                    System.out.print("Código: ");
                    String cod = scanner.nextLine();
                    System.out.print("Destino: ");
                    String dest = scanner.nextLine();
                    System.out.print("Aerolínea: ");
                    String aero = scanner.nextLine();
                    System.out.print("Pasajeros: ");
                    int pax = scanner.nextInt();
                    scanner.nextLine();
                    pista.enqueue(new Vuelo(cod, dest, aero, pax));
                    System.out.println("Vuelo registrado en pista.");
                    break;
                case 3:
                    Vuelo autorizado = pista.dequeue();
                    if (autorizado != null)
                        System.out.println("Despegando: " + autorizado.codigoVuelo
                                + " → " + autorizado.destino + " (" + autorizado.aerolinea + ")");
                    else
                        System.out.println("No hay vuelos en espera.");
                    break;
                case 4:
                    System.out.println("Total de pasajeros en pista: " + pista.totalPasajeros());
                    break;
                case 5:
                    System.out.print("Aerolínea: ");
                    String busAero = scanner.nextLine();
                    System.out.println("Vuelos de \"" + busAero + "\": " + pista.contarPorAerolinea(busAero));
                    break;
                case 6:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 6);
        scanner.close();
    }
}