package Corte2.Listas_Circulares_Dobles.src.Ejercicio2;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Historial historial = new Historial();
        int opcion;

        do {
            System.out.println("\n==============================================");
            System.out.println("   Historial de Comandos — Menú Principal");
            System.out.println("==============================================");
            System.out.println("1. Agregar comando");
            System.out.println("2. Mostrar historial completo");
            System.out.println("3. Mostrar comando actual");
            System.out.println("4. Ir al comando anterior (↑)");
            System.out.println("5. Ir al comando siguiente (↓)");
            System.out.println("6. Eliminar comando actual");
            System.out.println("7. Cargar comandos de ejemplo");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();
            System.out.println();

            switch (opcion) {
                case 1:
                    System.out.print("Texto del comando: ");
                    String texto = sc.nextLine();
                    System.out.print("¿Fue exitoso? (true/false): ");
                    boolean exitoso = sc.nextBoolean();
                    sc.nextLine();
                    System.out.print("Directorio: ");
                    String dir = sc.nextLine();
                    historial.agregarComando(texto, exitoso, dir);
                    System.out.println("Comando agregado.");
                    break;

                case 2:
                    historial.mostrarHistorial();
                    break;

                case 3:
                    historial.mostrarCursor();
                    break;

                case 4:
                    historial.arriba();
                    historial.mostrarCursor();
                    break;

                case 5:
                    historial.abajo();
                    historial.mostrarCursor();
                    break;

                case 6:
                    historial.eliminarActual();
                    System.out.println("Comando eliminado.");
                    break;

                case 7:
                    historial = new Historial();
                    historial.agregarComando("ls", true, "/home");
                    historial.agregarComando("cd documentos", true, "/home");
                    historial.agregarComando("mkdir pruebas", true, "/home/documentos");
                    historial.agregarComando("rm archivo.txt", false, "/home/documentos");
                    historial.agregarComando("nano notas.txt", true, "/home/documentos");
                    System.out.println("Historial de ejemplo cargado.");
                    historial.mostrarHistorial();
                    break;

                case 0:
                    System.out.println("Hasta luego.");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 0);

        sc.close();
    }
}