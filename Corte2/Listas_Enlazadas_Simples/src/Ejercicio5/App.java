/* 5. Spotify Lite (Lista de Reproducción)
Crea un reproductor de música simplificado que gestione una lista de canciones.

La Clase Cancion (Nodo): Debe contener titulo (String), artista (String), duracionSegundos (int) y genero (String).
El Problema: El usuario puede agregar canciones "A continuación" (insertar después de la actual) o "Al final de la cola".
Reto: Implementa un método que sume la duración de todas las canciones y muestre el tiempo total de la lista en formato MM:SS. */

package Ejercicio5;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int opcion;

        ListaReproduccion lista = new ListaReproduccion();

        do {
            System.out.println("\n==============================================");
            System.out.println("   SPOTIFY LITE - Menu Principal");
            System.out.println("==============================================");
            System.out.println("1. Agregar cancion al final");
            System.out.println("2. Agregar cancion a continuacion");
            System.out.println("3. Mostrar duracion total");
            System.out.println("4. Mostrar canciones");
            System.out.println();
            System.out.println("0. Salir");
            System.out.println("==============================================");
            System.out.print("Elige una opcion: ");

            opcion = sc.nextInt();

            System.out.println();

            switch (opcion) {

                case 1:
                    System.out.print("Titulo: ");
                    sc.nextLine();
                    String titulo1 = sc.nextLine();

                    System.out.print("Artista: ");
                    String artista1 = sc.nextLine();

                    System.out.print("Duracion (segundos): ");
                    int duracion1 = sc.nextInt();

                    sc.nextLine();
                    System.out.print("Genero: ");
                    String genero1 = sc.nextLine();
                    Cancion nueva1 = new Cancion(titulo1, artista1, duracion1, genero1);
                    lista.agregarAlFinal(nueva1);
                    break;

                case 2:
                    System.out.print("Titulo: ");
                    sc.nextLine();
                    String titulo = sc.nextLine();

                    System.out.print("Artista: ");
                    String artista = sc.nextLine();

                    System.out.print("Duracion (segundos): ");
                    int duracion = sc.nextInt();

                    sc.nextLine();
                    System.out.print("Genero: ");
                    String genero = sc.nextLine();

                    Cancion nueva = new Cancion(titulo, artista, duracion, genero);

                    lista.agregarSiguiente(nueva);

                case 3:
                    lista.mostrarDuracionTotal();
                    break;

                case 4:
                    lista.mostrarCanciones();
                    break;

                case 0:
                    System.out.println("¡Saliendo del reproductor!");
                    break;

                default:
                    System.out.println("Opcion no valida.");
            }

        } while (opcion != 0);

        sc.close();
    }
}