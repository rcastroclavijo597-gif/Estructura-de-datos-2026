package Corte2.Listas_Circulares_Dobles.src.Estudio;
/* 6. Reproductor de Podcasts (Lista Circular Doble)

Diseña un sistema que gestione una lista de episodios de podcast.

La Clase Episodio (Nodo): Debe contener titulo (String), duracionMin (int) y autor (String).

El Problema:
Los episodios se organizan en una lista circular doble.
El usuario puede:
- Ir al siguiente episodio
- Ir al anterior episodio
- Eliminar el episodio actual
- Ver el episodio actual

Reto:
Implementar:
1. siguiente()
2. anterior()
3. eliminarActual()
4. mostrarActual()
5. mostrarLista()
*/

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int opcion;

        ListaCircularDoble lista = new ListaCircularDoble();

        do {
            System.out.println("\n==============================================");
            System.out.println("   REPRODUCTOR DE PODCASTS");
            System.out.println("==============================================");
            System.out.println("1. Agregar episodio");
            System.out.println("2. Siguiente episodio");
            System.out.println("3. Episodio anterior");
            System.out.println("4. Mostrar actual");
            System.out.println("5. Eliminar actual");
            System.out.println("6. Mostrar lista");
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

                    System.out.print("Autor: ");
                    String autor = sc.nextLine();

                    lista.agregar(new Episodio(titulo, duracion, autor));
                    break;

                case 2:
                    lista.siguiente();
                    break;

                case 3:
                    lista.anterior();
                    break;

                case 4:
                    lista.mostrarActual();
                    break;

                case 5:
                    lista.eliminarActual();
                    break;

                case 6:
                    lista.mostrarLista();
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