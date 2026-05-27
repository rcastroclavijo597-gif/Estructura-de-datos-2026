package Ejercicio3;

/* 3. Impresora Compartida (Red de Oficina)
En una oficina de arquitectura, varias computadoras comparten una única impresora de gran formato. Cada vez que alguien 
envía un documento, este se agrega al final de la cola de impresión. La impresora procesa los trabajos en el orden exacto en que 
fueron recibidos.

La Clase Documento (Nodo): Debe contener nombreArchivo (String), usuario (String), numeroPaginas (int) y esColor (boolean).
El Problema: Antes de imprimir, el jefe de oficina quiere saber cuántas páginas en total tiene la cola de impresión pendiente.
Reto: Implementa un método calcularPaginasTotales() que recorra la cola y retorne la suma de numeroPaginas de todos los documentos
 en espera, sin alterar la cola. */

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        ColaDocumento colaDocumentos = new ColaDocumento();
        Scanner scanner = new Scanner(System.in);

        colaDocumentos.enqueue(new Documento("Plano_Fachada.pdf", "Arq. Ramírez", 12, true));
        colaDocumentos.enqueue(new Documento("Corte_Transversal.dwg", "Arq. Peña", 5, false));
        colaDocumentos.enqueue(new Documento("Render_Interior.png", "Diseñador López", 3, true));
        colaDocumentos.enqueue(new Documento("Memoria_Descriptiva.docx", "Arq. Castro", 20, false));
        colaDocumentos.enqueue(new Documento("Presupuesto_Obra.xlsx", "Admin. Torres", 8, false));

        int opcion;
        do {
            System.out.println("\n--- SISTEMA DE GESTIÓN DE IMPRESIÓN (RED DE OFICINA) ---");
            System.out.println("1. Ver documentos en cola");
            System.out.println("2. Enviar nuevo documento");
            System.out.println("3. Imprimir siguiente documento");
            System.out.println("4. Calcular páginas totales en espera");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("\nEstado actual de la cola:");
                    colaDocumentos.imprimir();
                    break;
                case 2:
                    System.out.print("Nombre del archivo: ");
                    String archivo = scanner.nextLine();
                    System.out.print("Usuario: ");
                    String usuario = scanner.nextLine();
                    System.out.print("Número de páginas: ");
                    int paginas = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("¿Es a color? (true/false): ");
                    boolean color = scanner.nextBoolean();
                    scanner.nextLine();
                    colaDocumentos.enqueue(new Documento(archivo, usuario, paginas, color));
                    System.out.println("Documento enviado a la cola correctamente.");
                    break;
                case 3:
                    Documento impreso = colaDocumentos.dequeue();
                    if (impreso != null) {
                        System.out.println("Imprimiendo: " + impreso.nombreArchivo + " de " + impreso.usuario + " ("
                                + impreso.numeroPaginas + " págs - " + (impreso.esColor ? "Color" : "B/N") + ")");
                    } else {
                        System.out.println("No hay documentos en cola.");
                    }
                    break;
                case 4:
                    int totalPaginas = colaDocumentos.calcularPaginasTotales();
                    System.out.println("Total de páginas pendientes en cola: " + totalPaginas);
                    break;
                case 5:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 5);

        scanner.close();
    }
}
