
/* 2. Urgencias Hospitalarias (Triaje)
En la sala de urgencias de un hospital, los pacientes que llegan son registrados y colocados en una 
fila de atención. Dado el volumen de pacientes, el médico de guardia atiende en estricto orden de llegada. Al momento de 
llamar a un paciente, el sistema debe mostrar su información completa.

La Clase Paciente (Nodo): Debe contener cedula (String), nombreCompleto (String), edad (int) y sintomaPrincipal (String).
El Problema: Al finalizar el turno, el hospital necesita un reporte del total de pacientes atendidos y la lista completa en 
orden de atención.
Reto: Implementa un método atenderTodos() que extraiga (dequeue) a cada paciente uno a uno, imprima su información al momento 
de ser atendido e imprima al final el total de pacientes procesados. */
package Ejercicio2;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        ColaPaciente colaPacientes = new ColaPaciente();
        Scanner scanner = new Scanner(System.in);

        colaPacientes.enqueue(new Paciente("1001234567", "Laura Martínez", 34, "Dolor de cabeza severo"));
        colaPacientes.enqueue(new Paciente("1009876543", "Pedro Salcedo", 58, "Dolor en el pecho"));
        colaPacientes.enqueue(new Paciente("1006543210", "Valentina Ríos", 22, "Fiebre alta"));
        colaPacientes.enqueue(new Paciente("1003456789", "Jorge Herrera", 45, "Fractura en el brazo"));
        colaPacientes.enqueue(new Paciente("1007891234", "Camila Duarte", 67, "Dificultad para respirar"));

        int opcion;
        do {
            System.out.println("\n--- SISTEMA DE GESTIÓN DE URGENCIAS (TRIAJE) ---");
            System.out.println("1. Ver pacientes en espera");
            System.out.println("2. Registrar nuevo paciente");
            System.out.println("3. Atender siguiente paciente");
            System.out.println("4. Atender todos los pacientes del turno");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("\nEstado actual de la cola:");
                    colaPacientes.imprimir();
                    break;
                case 2:
                    System.out.print("Cédula: ");
                    String cedula = scanner.nextLine();
                    System.out.print("Nombre completo: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Edad: ");
                    int edad = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Síntoma principal: ");
                    String sintoma = scanner.nextLine();
                    colaPacientes.enqueue(new Paciente(cedula, nombre, edad, sintoma));
                    System.out.println("Paciente registrado correctamente.");
                    break;
                case 3:
                    Paciente atendido = colaPacientes.dequeue();
                    if (atendido != null) {
                        System.out.println("Atendiendo a: " + atendido.nombreCompleto + " | Síntoma: "
                                + atendido.sintomaPrincipal);
                    } else {
                        System.out.println("No hay pacientes en espera.");
                    }
                    break;
                case 4:
                    colaPacientes.atenderTodos();
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
