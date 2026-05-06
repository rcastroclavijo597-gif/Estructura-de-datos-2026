package Corte2.Listas_Enlazadas_Dobles.src.Estudio;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int opcion;

        Lista_Videos lista = new Lista_Videos();

        do {
            System.out.println("\n==============================================");
            System.out.println("   HISTORIAL DE VIDEOS");
            System.out.println("==============================================");
            System.out.println("1. Agregar video");
            System.out.println("2. Avanzar");
            System.out.println("3. Retroceder");
            System.out.println("4. Mostrar video actual");
            System.out.println();
            System.out.println("0. Salir");
            System.out.println("==============================================");
            System.out.print("Elige una opción: ");

            opcion = sc.nextInt();
            System.out.println();

            switch (opcion) {

                case 1:
                    sc.nextLine();
                    System.out.print("Título: ");
                    String titulo = sc.nextLine();

                    System.out.print("Duración (min): ");
                    int duracion = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Categoría: ");
                    String categoria = sc.nextLine();

                    lista.agregarVideo(new Video(titulo, duracion, categoria));
                    break;

                case 2:
                    lista.avanzar();
                    break;

                case 3:
                    lista.retroceder();
                    break;

                case 4:
                    lista.mostrarActual();
                    break;

                case 0:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción no válida");
            }

        } while (opcion != 0);

        sc.close();
    }
}
