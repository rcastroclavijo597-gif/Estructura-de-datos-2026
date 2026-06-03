package Ejercicio3;

// 3. Historial Bancario (Transacciones con Pila)
// Un sistema bancario guarda el historial de una cuenta usando una pila:
// la transacción más reciente queda en el tope, permitiendo "deshacer" fácilmente.
//
// La Clase Transaccion (Nodo): idTransaccion, tipo ("CREDITO"/"DEBITO"), monto (double), descripcion.
// El Problema: El auditor necesita el saldo neto sumando créditos y restando débitos.
// Reto 1: calcularSaldoNeto() — recorre la pila y retorna créditos - débitos.
// Reto 2: contarPorTipo(String tipo) — cuenta cuántas son de ese tipo.

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        PilaTransacciones historial = new PilaTransacciones();
        Scanner scanner = new Scanner(System.in);

        historial.push(new Transaccion("TXN-001", "CREDITO", 500000.0, "Salario mensual"));
        historial.push(new Transaccion("TXN-002", "DEBITO", 120000.0, "Pago arriendo"));
        historial.push(new Transaccion("TXN-003", "DEBITO", 45000.0, "Mercado"));
        historial.push(new Transaccion("TXN-004", "CREDITO", 80000.0, "Transferencia recibida"));
        historial.push(new Transaccion("TXN-005", "DEBITO", 30000.0, "Recarga celular"));

        int opcion;
        do {
            System.out.println("\n--- SISTEMA BANCARIO - HISTORIAL (PILAS) ---");
            System.out.println("1. Ver historial de transacciones");
            System.out.println("2. Registrar nueva transacción (Push)");
            System.out.println("3. Deshacer última transacción (Pop)");
            System.out.println("4. Calcular saldo neto");
            System.out.println("5. Contar transacciones por tipo");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    historial.imprimir();
                    break;
                case 2:
                    System.out.print("ID Transacción: ");
                    String id = scanner.nextLine();
                    System.out.print("Tipo (CREDITO/DEBITO): ");
                    String tipo = scanner.nextLine();
                    System.out.print("Monto: ");
                    double mon = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Descripción: ");
                    String desc = scanner.nextLine();
                    historial.push(new Transaccion(id, tipo, mon, desc));
                    System.out.println("Transacción registrada correctamente.");
                    break;
                case 3:
                    Transaccion deshecha = historial.pop();
                    if (deshecha != null)
                        System.out.println("Transacción deshecha: " + deshecha);
                    else
                        System.out.println("No hay transacciones en el historial.");
                    break;
                case 4:
                    double saldo = historial.calcularSaldoNeto();
                    System.out.printf("Saldo neto: $%.2f  —  %s%n", saldo, saldo >= 0 ? "POSITIVO ✓" : "NEGATIVO ✗");
                    break;
                case 5:
                    System.out.print("Tipo a buscar (CREDITO/DEBITO): ");
                    String busTipo = scanner.nextLine();
                    System.out
                            .println("Transacciones de tipo \"" + busTipo + "\": " + historial.contarPorTipo(busTipo));
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