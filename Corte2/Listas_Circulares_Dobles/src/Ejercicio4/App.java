/* 4. Galería de Fotos
Una app de galería muestra las fotos de un álbum de una en una. El usuario puede pasar a 
la foto siguiente, volver a la anterior, y marcar cualquier foto como favorita. Al eliminar una foto, 
la galería continúa desde la siguiente sin interrupciones.

La Clase Foto (Nodo): Debe contener titulo (String), fecha (String) y esFavorita (boolean).
El Problema: La galería mantiene un puntero actual a la foto que se está viendo. Navegar con 
"siguiente" o "anterior" mueve ese puntero. Marcar como favorita simplemente alterna el campo 
esFavorita de la foto actual. Eliminar la foto actual desconecta el nodo en O(1) y mueve actual a la siguiente.
Reto: Implementa los métodos siguiente(), anterior(), toggleFavorita(), eliminarActual() y mostrarGaleria(). 
mostrarGaleria() recorre todas las fotos marcando con [★] las favoritas y con [▶] la foto actual. Simula: 
carga 5 fotos, avanza dos veces, marca la actual como favorita, retrocede una, elimina esa foto y muestra 
el estado final de la galería. */

package Corte2.Listas_Circulares_Dobles.src.Ejercicio4;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Galeria galeria = new Galeria();
        int opcion;

        do {
            System.out.println("\n==============================================");
            System.out.println("   Galería de Fotos — Menú Principal");
            System.out.println("==============================================");
            System.out.println("1. Agregar foto");
            System.out.println("2. Mostrar galería");
            System.out.println("3. Siguiente foto");
            System.out.println("4. Foto anterior");
            System.out.println("5. Marcar/Desmarcar favorita");
            System.out.println("6. Eliminar foto actual");
            System.out.println("7. Cargar ejemplo");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();
            System.out.println();

            switch (opcion) {
                case 1:
                    System.out.print("Título: ");
                    String titulo = sc.nextLine();
                    System.out.print("Fecha: ");
                    String fecha = sc.nextLine();
                    galeria.agregarFoto(titulo, fecha);
                    System.out.println("Foto agregada.");
                    break;

                case 2:
                    galeria.mostrarGaleria();
                    break;

                case 3:
                    galeria.siguiente();
                    galeria.mostrarGaleria();
                    break;

                case 4:
                    galeria.anterior();
                    galeria.mostrarGaleria();
                    break;

                case 5:
                    galeria.toggleFavorita();
                    System.out.println("Estado de favorita cambiado.");
                    break;

                case 6:
                    galeria.eliminarActual();
                    System.out.println("Foto eliminada.");
                    break;

                case 7:
                    galeria = new Galeria();
                    galeria.agregarFoto("Foto 1", "2024-01-01");
                    galeria.agregarFoto("Foto 2", "2024-01-02");
                    galeria.agregarFoto("Foto 3", "2024-01-03");
                    galeria.agregarFoto("Foto 4", "2024-01-04");
                    galeria.agregarFoto("Foto 5", "2024-01-05");

                    galeria.siguiente();
                    galeria.siguiente();
                    galeria.toggleFavorita();
                    galeria.anterior();
                    galeria.eliminarActual();

                    System.out.println("Estado final:");
                    galeria.mostrarGaleria();
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
