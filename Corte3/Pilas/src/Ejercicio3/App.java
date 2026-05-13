package Ejercicio3;

/**
 * 3. Logística de Distribución (Callejón sin Salida)
 * Un centro de logística urbana tiene un muelle de carga ubicado al final de un callejón muy estrecho. Los 
 * camiones de reparto entran uno tras otro y quedan "atrapados" en el orden de llegada. El último camión en entrar
 *  debe ser obligatoriamente el primero en salir para permitir que los demás se retiren.
 *
 * La Clase Camion (Nodo): Debe contener placa (String), conductor (String) y cargaToneladas (double).
 * El Problema: El supervisor necesita saber cuánta carga total hay en el callejón sin mover los camiones 
 * físicamente (solo consultando la estructura).
 * Reto: Implementa un método que recorra la pila (sin destruirla permanentemente, o reconstruyéndola) y 
 * calcule la suma total de cargaToneladas de todos los camiones estacionados.
 */

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        PilaCamiones callejon = new PilaCamiones();

        Scanner scanner = new Scanner(System.in);

        callejon.push(new Camion("ABC-101", "Carlos Pérez", 5.5));
        callejon.push(new Camion("DEF-202", "Luis Gómez", 8.2));
        callejon.push(new Camion("GHI-303", "Ana Torres", 3.7));
        callejon.push(new Camion("JKL-404", "Pedro Díaz", 6.1));

        int opcion;

        do {

            System.out.println("\n--- LOGÍSTICA DE DISTRIBUCIÓN (PILAS) ---");
            System.out.println("1. Ver camiones en el callejón");
            System.out.println("2. Registrar nuevo camión (Push)");
            System.out.println("3. Retirar camión del tope (Pop)");
            System.out.println("4. Calcular carga total");
            System.out.println("5. Salir");

            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {

                case 1:

                    System.out.println("\nEstado actual de la pila:");
                    callejon.imprimir();

                    break;

                case 2:

                    System.out.print("Placa: ");
                    String placa = scanner.nextLine();

                    System.out.print("Conductor: ");
                    String conductor = scanner.nextLine();

                    System.out.print("Carga en toneladas: ");
                    double carga = scanner.nextDouble();

                    callejon.push(new Camion(placa, conductor, carga));

                    System.out.println("Camión agregado correctamente.");

                    break;

                case 3:

                    Camion retirado = callejon.pop();

                    if (retirado != null) {

                        System.out.println("Se retiró:");
                        System.out.println(retirado);

                    } else {

                        System.out.println("La pila está vacía.");
                    }

                    break;

                case 4:

                    double total = callejon.calcularCargaTotal();

                    System.out.println("\nCarga total en el callejón: "
                            + total + " toneladas.");

                    break;

                case 5:

                    System.out.println("Saliendo del sistema...");

                    break;

                default:

                    System.out.println("Opción inválida.");
            }

        } while (opcion != 5);

        scanner.close();
    }
}
