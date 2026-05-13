package Ejercicio5;

/**
 * 5. Ruta de Rescate (Espeleología Geológica)
 * Un equipo de rescatistas entra en una cueva inexplorada. Para no perderse, van dejando "Estaciones de Seguridad" 
 * representadas por una baliza que registra los datos del entorno.
 *
 * La Clase Estacion (Nodo): Debe contener nombrePunto (String), profundidad (int) y nivelOxigeno (double).
 * El Problema: Para salir de la cueva, el equipo debe seguir las estaciones en el orden inverso al que fueron 
 * colocadas (de la más profunda a la entrada).
 * Reto: Implementa el método retrocederASuperficie(). Este debe mostrar el nombre de cada estación a medida que 
 * se desapila. Importante: Si en alguna estación el nivelOxigeno es inferior al 18%, el sistema debe imprimir 
 * una alerta de "Uso de Tanque de Emergencia Requerido" al pasar por ese punto.
 */

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        PilaEstaciones cueva = new PilaEstaciones();

        Scanner scanner = new Scanner(System.in);

        cueva.push(new Estacion("Entrada Norte", 10, 21.0));
        cueva.push(new Estacion("Galería Rocosa", 35, 19.5));
        cueva.push(new Estacion("Cámara Subterránea", 60, 17.2));
        cueva.push(new Estacion("Zona Cristalina", 90, 15.8));

        int opcion;

        do {

            System.out.println("\n--- RUTA DE RESCATE (PILAS) ---");
            System.out.println("1. Ver estaciones");
            System.out.println("2. Registrar estación (Push)");
            System.out.println("3. Retirar estación (Pop)");
            System.out.println("4. Retroceder a la superficie");
            System.out.println("5. Salir");

            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {

                case 1:

                    cueva.imprimir();

                    break;

                case 2:

                    System.out.print("Nombre del punto: ");
                    String nombre = scanner.nextLine();

                    System.out.print("Profundidad (m): ");
                    int profundidad = scanner.nextInt();

                    System.out.print("Nivel de oxígeno (%): ");
                    double oxigeno = scanner.nextDouble();

                    cueva.push(
                            new Estacion(nombre,
                                    profundidad,
                                    oxigeno));

                    System.out.println(
                            "Estación registrada correctamente.");

                    break;

                case 3:

                    Estacion retirada = cueva.pop();

                    if (retirada != null) {

                        System.out.println("Se retiró:");
                        System.out.println(retirada);

                    } else {

                        System.out.println(
                                "La pila está vacía.");
                    }

                    break;

                case 4:

                    cueva.retrocederASuperficie();

                    break;

                case 5:

                    System.out.println(
                            "Saliendo del sistema...");

                    break;

                default:

                    System.out.println(
                            "Opción inválida.");
            }

        } while (opcion != 5);

        scanner.close();
    }
}
