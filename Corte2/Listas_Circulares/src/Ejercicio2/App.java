package Corte2.Listas_Circulares.src.Ejercicio2;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        Carrusel carrusel = new Carrusel();

        do {
            System.out.println("\n==============================================");
            System.out.println("   Carrusel de Anuncios — Menú Principal");
            System.out.println("==============================================");
            System.out.println("1. agregarAnuncio");
            System.out.println("2. mostrarAnuncios");
            System.out.println("3. reproducir");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el título del anuncio: ");
                    String titulo = sc.next();
                    System.out.print("Ingrese la duración en segundos: ");
                    int duracion = sc.nextInt();
                    System.out.print("Ingrese la categoría: ");
                    String categoria = sc.next();
                    Anuncio nuevo = new Anuncio(titulo, duracion, categoria);
                    carrusel.agregarAnuncio(nuevo);
                    break;

                case 2:
                    carrusel.mostrarAnuncios();
                    break;

                case 3:
                    System.out.print("Ingrese el número de ciclos: ");
                    int ciclos = sc.nextInt();
                    carrusel.reproducir(ciclos);
                    break;

                case 0:
                    System.out.println("Saliendo del carrusel...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 0);

        sc.close();
    }
}
