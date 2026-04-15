package Corte2.Listas_Enlazadas_Dobles.src.Ejercicio5;

/* 5. Reproductor de Música Premium
Mejora el ejercicio de Spotify de la semana pasada usando listas dobles.

La Clase Cancion (Nodo): Debe contener titulo (String), artista (String) y duracion (int).
El Problema: El reproductor ahora permite la función "Canción Anterior" de manera eficiente 
sin tener que recorrer toda la lista desde el principio.
Reto: Implementa un método saltarAtras() que retroceda una posición y saltarAdelante() 
que avance una. Si se intenta saltar atrás desde la primera canción, debe mostrar un mensaje de error. */

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Reproductor reproductor = new Reproductor();
        Cancion actual = null;
        int opcion;

        do {
            System.out.println("\n==============================================");
            System.out.println("   Reproductor de Música Premium");
            System.out.println("==============================================");
            System.out.println("  [1] Agregar Canción");
            System.out.println("  [2] Mostrar Lista");
            System.out.println("  [3] Saltar Adelante");
            System.out.println("  [4] Saltar Atrás");
            System.out.println("  [0] Salir");
            System.out.println("==============================================");
            System.out.print("Elige una opción: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Título: ");
                    String titulo = sc.nextLine();
                    System.out.print("Artista: ");
                    String artista = sc.nextLine();
                    System.out.print("Duración (segundos): ");
                    int duracion = sc.nextInt();
                    sc.nextLine();

                    Cancion nueva = new Cancion(titulo, artista, duracion);
                    reproductor.agregarCancion(nueva);
                    actual = nueva;
                    break;

                case 2:
                    reproductor.mostrarLista();
                    break;

                case 3:
                    actual = reproductor.saltarAdelante(actual);
                    if (actual != null) {
                        System.out.println("Reproduciendo: " + actual.titulo + " - " + actual.artista);
                    }
                    break;

                case 4:
                    actual = reproductor.saltarAtras(actual);
                    if (actual != null) {
                        System.out.println("Reproduciendo: " + actual.titulo + " - " + actual.artista);
                    }
                    break;

                case 0:
                    System.out.println("¡Saliendo del reproductor!");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 0);

        sc.close();
    }
}
