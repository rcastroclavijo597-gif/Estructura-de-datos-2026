package Corte2.Listas_Enlazadas_Dobles.src.Ejercicio3;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Navegador navegador = new Navegador();
        int opcion;

        do {
            System.out.println("\n==============================================");
            System.out.println("   Navegador — Menú Principal");
            System.out.println("==============================================");
            System.out.println("  [1] Abrir Pestaña");
            System.out.println("  [2] Cerrar Pestaña por URL");
            System.out.println("  [3] Mostrar Pestañas Abiertas");
            System.out.println();
            System.out.println("  [0] Salir");
            System.out.println("==============================================");
            System.out.print("Elige una opción: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Título de la página: ");
                    String titulo = sc.nextLine();
                    System.out.print("URL: ");
                    String url = sc.nextLine();
                    System.out.print("Hora de apertura: ");
                    String hora = sc.nextLine();

                    Pestana nueva = new Pestana(titulo, url, hora);
                    navegador.abrirPestana(nueva);
                    break;

                case 2:
                    System.out.print("Ingrese la URL de la pestaña a cerrar: ");
                    String urlCerrar = sc.nextLine();
                    navegador.cerrarPestanaActual(urlCerrar);
                    break;

                case 3:
                    navegador.mostrarPestanas();
                    break;

                case 0:
                    System.out.println("¡Saliendo del navegador!");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 0);

        sc.close();
    }
}
