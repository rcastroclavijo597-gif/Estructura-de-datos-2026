package Ejercicio4;

/* 4. Peaje Inteligente (Control de Tráfico)
En una autopista de peaje, los vehículos ingresan a un carril y avanzan en fila hasta la cabina de cobro. El sistema 
registra automáticamente cada vehículo al entrar al carril. El cajero cobra en el orden estricto de llegada.

La Clase Vehiculo (Nodo): Debe contener placa (String), tipoVehiculo (String), tarifa (double) y esExento (boolean).
El Problema: Al cerrar el turno, el sistema debe calcular el total recaudado, ignorando los vehículos exentos de pago.
Reto: Implementa un método cerrarTurno() que extraiga (dequeue) todos los vehículos de la cola, acumule la tarifa solo de
 los que tengan esExento = false e imprima el total recaudado al finalizar. */

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        ColaVehiculo colaVehiculos = new ColaVehiculo();
        Scanner scanner = new Scanner(System.in);

        colaVehiculos.enqueue(new Vehiculo("ABC-123", "Auto", 5500.00, false));
        colaVehiculos.enqueue(new Vehiculo("XYZ-456", "Camión", 12000.00, false));
        colaVehiculos.enqueue(new Vehiculo("AMB-001", "Ambulancia", 0.00, true));
        colaVehiculos.enqueue(new Vehiculo("DEF-789", "Moto", 2500.00, false));
        colaVehiculos.enqueue(new Vehiculo("POL-007", "Patrulla", 0.00, true));
        colaVehiculos.enqueue(new Vehiculo("GHI-321", "Bus", 8000.00, false));

        int opcion;
        do {
            System.out.println("\n--- SISTEMA DE PEAJE INTELIGENTE (CONTROL DE TRÁFICO) ---");
            System.out.println("1. Ver vehículos en carril");
            System.out.println("2. Registrar nuevo vehículo");
            System.out.println("3. Cobrar siguiente vehículo");
            System.out.println("4. Cerrar turno y calcular recaudación");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("\nEstado actual del carril:");
                    colaVehiculos.imprimir();
                    break;
                case 2:
                    System.out.print("Placa: ");
                    String placa = scanner.nextLine();
                    System.out.print("Tipo de vehículo: ");
                    String tipo = scanner.nextLine();
                    System.out.print("Tarifa: ");
                    double tarifa = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("¿Es exento? (true/false): ");
                    boolean exento = scanner.nextBoolean();
                    scanner.nextLine();
                    colaVehiculos.enqueue(new Vehiculo(placa, tipo, tarifa, exento));
                    System.out.println("Vehículo registrado correctamente.");
                    break;
                case 3:
                    Vehiculo cobrado = colaVehiculos.dequeue();
                    if (cobrado != null) {
                        if (!cobrado.esExento) {
                            System.out.println("Cobrado: " + cobrado.placa + " (" + cobrado.tipoVehiculo + ") - $"
                                    + cobrado.tarifa);
                        } else {
                            System.out.println("Vehículo exento: " + cobrado.placa + " (" + cobrado.tipoVehiculo
                                    + ") - Sin cobro");
                        }
                    } else {
                        System.out.println("No hay vehículos en el carril.");
                    }
                    break;
                case 4:
                    colaVehiculos.cerrarTurno();
                    break;
                case 5:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 5);

        scanner.close();
    }
}
