package Corte2.Listas_Enlazadas_Dobles.src.Ejercicio4;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Consultorio consultorio = new Consultorio();
        int opcion;

        do {
            System.out.println("\n==============================================");
            System.out.println("   Consultorio Médico — Menú Principal");
            System.out.println("==============================================");
            System.out.println("  [1] Agregar Paciente");
            System.out.println("  [2] Mostrar Pacientes");
            System.out.println("  [3] Paciente de Mayor Edad");
            System.out.println("  [0] Salir");
            System.out.println("==============================================");
            System.out.print("Elige una opción: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Edad: ");
                    int edad = sc.nextInt();
                    System.out.print("Nivel de urgencia (1-5): ");
                    int urgencia = sc.nextInt();
                    sc.nextLine();

                    Paciente nuevo = new Paciente(nombre, edad, urgencia);
                    consultorio.agregarPaciente(nuevo);
                    break;

                case 2:
                    consultorio.mostrarPacientes();
                    break;

                case 3:
                    consultorio.pacienteMayorEdad();
                    break;

                case 0:
                    System.out.println("¡Saliendo del consultorio!");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 0);

        sc.close();
    }
}
