package Ejercicio1;

/* 1. Hospital (Sala de Espera)
Un hospital maneja su sala de espera con turno de llegada (FIFO).
Cada paciente se asigna a una especialidad: "Medicina General", "Pediatría",
"Cardiología" u "Ortopedia".

La Clase Paciente (Nodo): idPaciente (int), nombre, especialidad, edadAnios (int).
El Problema: La jefe de enfermería necesita saber cuántos pacientes esperan
por una especialidad específica para reforzar ese consultorio.
Reto 1: contarPorEspecialidad(String especialidad) — recorre sin modificar la cola.
Reto 2: promedioEdad() — retorna el promedio de edad de todos los pacientes en espera. */

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ColaPacientes salaEspera = new ColaPacientes();
        Scanner scanner = new Scanner(System.in);

        salaEspera.enqueue(new Paciente(1, "Carlos Perez", "Medicina General", 35));
        salaEspera.enqueue(new Paciente(2, "Ana Gomez", "Pediatría", 8));
        salaEspera.enqueue(new Paciente(3, "Luis Ruiz", "Cardiología", 62));
        salaEspera.enqueue(new Paciente(4, "Maria Lopez", "Medicina General", 28));
        salaEspera.enqueue(new Paciente(5, "Pedro Diaz", "Ortopedia", 45));

        int opcion;
        do {
            System.out.println("\n--- SISTEMA DE GESTIÓN HOSPITALARIA (COLAS) ---");
            System.out.println("1. Ver pacientes en sala de espera");
            System.out.println("2. Registrar nuevo paciente");
            System.out.println("3. Atender siguiente paciente");
            System.out.println("4. Contar pacientes por especialidad");
            System.out.println("5. Calcular promedio de edad");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    salaEspera.imprimir();
                    break;
                case 2:
                    System.out.print("ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nombre: ");
                    String nom = scanner.nextLine();
                    System.out.print("Especialidad: ");
                    String esp = scanner.nextLine();
                    System.out.print("Edad: ");
                    int edad = scanner.nextInt();
                    scanner.nextLine();
                    salaEspera.enqueue(new Paciente(id, nom, esp, edad));
                    System.out.println("Paciente registrado.");
                    break;
                case 3:
                    Paciente atendido = salaEspera.dequeue();
                    if (atendido != null)
                        System.out.println("Atendiendo a: " + atendido.nombre + " (" + atendido.especialidad + ")");
                    else
                        System.out.println("No hay pacientes en espera.");
                    break;
                case 4:
                    System.out.print("Especialidad: ");
                    String busEsp = scanner.nextLine();
                    System.out.println("Pacientes en \"" + busEsp + "\": " + salaEspera.contarPorEspecialidad(busEsp));
                    break;
                case 5:
                    System.out.printf("Promedio de edad en sala: %.1f años%n", salaEspera.promedioEdad());
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