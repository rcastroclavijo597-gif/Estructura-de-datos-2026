package Ejercicio2;

/* 2. Sistema de Gestión de Tareas (Empresa de Software)
Un equipo de desarrollo procesa tickets en orden de creación (FIFO).
Prioridades posibles: "ALTA", "MEDIA", "BAJA".

La Clase Tarea (Nodo): idTarea (int), titulo, prioridad, asignadoA.
El Problema: El líder técnico necesita saber cuántas tareas de prioridad ALTA
están pendientes para decidir si agrega más desarrolladores.
Reto 1: contarPorPrioridad(String prioridad) — recorre sin modificar la cola.
Reto 2: tieneAreasTareas(String persona) — true si esa persona tiene tareas. */

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ColaTareas backlog = new ColaTareas();
        Scanner scanner = new Scanner(System.in);

        backlog.enqueue(new Tarea(101, "Corregir bug login", "ALTA", "Sofia"));
        backlog.enqueue(new Tarea(102, "Actualizar documentación", "BAJA", "Andres"));
        backlog.enqueue(new Tarea(103, "Implementar módulo pagos", "ALTA", "Sofia"));
        backlog.enqueue(new Tarea(104, "Diseñar pantalla inicio", "MEDIA", "Camila"));
        backlog.enqueue(new Tarea(105, "Optimizar consultas BD", "ALTA", "Andres"));

        int opcion;
        do {
            System.out.println("\n--- SISTEMA DE GESTIÓN DE TAREAS (COLAS) ---");
            System.out.println("1. Ver tareas pendientes");
            System.out.println("2. Registrar nueva tarea");
            System.out.println("3. Procesar siguiente tarea");
            System.out.println("4. Contar tareas por prioridad");
            System.out.println("5. Verificar si persona tiene tareas");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    backlog.imprimir();
                    break;
                case 2:
                    System.out.print("ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Título: ");
                    String ti = scanner.nextLine();
                    System.out.print("Prioridad (ALTA/MEDIA/BAJA): ");
                    String pr = scanner.nextLine();
                    System.out.print("Asignado a: ");
                    String as = scanner.nextLine();
                    backlog.enqueue(new Tarea(id, ti, pr, as));
                    System.out.println("Tarea registrada correctamente.");
                    break;
                case 3:
                    Tarea procesada = backlog.dequeue();
                    if (procesada != null)
                        System.out.println("Procesando: [" + procesada.titulo + "] — " + procesada.asignadoA);
                    else
                        System.out.println("No hay tareas pendientes.");
                    break;
                case 4:
                    System.out.print("Prioridad: ");
                    String busPrio = scanner.nextLine();
                    System.out.println("Tareas \"" + busPrio + "\": " + backlog.contarPorPrioridad(busPrio));
                    break;
                case 5:
                    System.out.print("Nombre: ");
                    String persona = scanner.nextLine();
                    System.out.println(backlog.tieneAreasTareas(persona)
                            ? persona + " SÍ tiene tareas pendientes."
                            : persona + " NO tiene tareas pendientes.");
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