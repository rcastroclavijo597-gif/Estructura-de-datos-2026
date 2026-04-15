package Corte2.Listas_Enlazadas_Dobles.src.Ejercicio2;

/* 2. Carrusel de Imágenes (Galería Interactiva)
Simula el comportamiento de una galería de fotos en una aplicación móvil.

La Clase Fotografia (Nodo): Debe contener nombreArchivo (String), tamanoMB (double) y resolucion (String).
El Problema: El usuario puede avanzar a la "Siguiente Foto" o retroceder a la "Foto Anterior". Si llega al final, 
no puede avanzar más (a menos que sea circular, pero por ahora manténlo lineal).
Reto: Crea un método reproducirGaleria() que recorra toda la lista hacia adelante y luego toda la lista hacia 
atrás para mostrar todas las fotos. */

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int opcion;

        Galeria galeria = new Galeria();
        Fotografia fotoActual = null;

        do {
            System.out.println("\n==============================================");
            System.out.println("        Carrusel de Imágenes");
            System.out.println("==============================================");
            System.out.println("  [1] Agregar Foto");
            System.out.println("  [2] Foto Anterior");
            System.out.println("  [3] Siguiente Foto");
            System.out.println("  [4] Reproducir Galería");
            System.out.println();
            System.out.println("  [0] Salir");
            System.out.println("==============================================");
            System.out.print("Elige una opción: ");

            opcion = sc.nextInt();
            System.out.println();

            switch (opcion) {

                case 1:

                    sc.nextLine();

                    System.out.print("Ingrese nombre del archivo: ");
                    String nombre = sc.nextLine();

                    System.out.print("Ingrese tamaño en MB: ");
                    double tamaño = sc.nextDouble();

                    sc.nextLine();

                    System.out.print("Ingrese resolución: ");
                    String resolucion = sc.nextLine();

                    Fotografia nuevaFoto = new Fotografia(nombre, tamaño, resolucion);

                    galeria.agregarFoto(nuevaFoto);

                    fotoActual = nuevaFoto;

                    System.out.println("Foto agregada correctamente.");
                    break;

                case 2:

                    if (fotoActual != null) {
                        System.out.println("Foto actual: " + fotoActual.nombre);
                        fotoActual = galeria.fotoAnterior(fotoActual);
                        System.out.println("Ahora estás en: " + fotoActual.nombre);
                    } else {
                        System.out.println("No hay fotos.");
                    }

                    break;

                case 3:

                    if (fotoActual != null) {
                        System.out.println("Foto actual: " + fotoActual.nombre);
                        fotoActual = galeria.siguienteFoto(fotoActual);
                        System.out.println("Ahora estás en: " + fotoActual.nombre);
                    } else {
                        System.out.println("No hay fotos.");
                    }

                    break;

                case 4:

                    galeria.reproducirGaleria();

                    break;

                case 0:

                    System.out.println("Saliendo del Carrusel...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 0);

        sc.close();
    }
}
