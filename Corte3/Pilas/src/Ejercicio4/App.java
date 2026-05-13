package Ejercicio4;

/**
 * 4. Farmacia Automatizada (Dispensador Tubo LIFO)
 * En una farmacia de alta tecnología, los medicamentos de alta rotación se almacenan en tubos dispensadores verticales. 
 * El personal introduce las cajas por la parte superior y las retira de la misma forma (el último lote en llegar es el 
 * primero en ser despachado).
 *
 * La Clase Medicamento (Nodo): Debe contener nombre (String), lote (String) y diasParaVencer (int).
 * El Problema: Por norma de seguridad, no se puede despachar un medicamento si le quedan menos de 10 días para vencer.
 * Reto: Implementa un método validarDespacho() que revise el medicamento en el tope. Si está a punto de vencer, 
 * debe ser retirado automáticamente y el sistema debe revisar el siguiente. El proceso se repite hasta que el tope 
 * sea un medicamento seguro o la pila quede vacía.
 */

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        PilaMedicamentos farmacia = new PilaMedicamentos();

        Scanner scanner = new Scanner(System.in);

        farmacia.push(new Medicamento("Ibuprofeno", "LOT-001", 5));
        farmacia.push(new Medicamento("Paracetamol", "LOT-002", 7));
        farmacia.push(new Medicamento("Amoxicilina", "LOT-003", 15));
        farmacia.push(new Medicamento("Vitamina C", "LOT-004", 20));

        int opcion;

        do {

            System.out.println("\n--- FARMACIA AUTOMATIZADA (PILAS) ---");
            System.out.println("1. Ver medicamentos");
            System.out.println("2. Registrar medicamento (Push)");
            System.out.println("3. Retirar medicamento del tope (Pop)");
            System.out.println("4. Validar despacho");
            System.out.println("5. Salir");

            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {

                case 1:

                    System.out.println("\nEstado actual del dispensador:");
                    farmacia.imprimir();

                    break;

                case 2:

                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();

                    System.out.print("Lote: ");
                    String lote = scanner.nextLine();

                    System.out.print("Días para vencer: ");
                    int dias = scanner.nextInt();

                    farmacia.push(new Medicamento(nombre, lote, dias));

                    System.out.println("Medicamento agregado correctamente.");

                    break;

                case 3:

                    Medicamento retirado = farmacia.pop();

                    if (retirado != null) {
                        System.out.println("Se retiró:");
                        System.out.println(retirado);
                    } else {
                        System.out.println("La pila está vacía.");
                    }

                    break;

                case 4:

                    farmacia.validarDespacho();

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
