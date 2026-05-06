package Corte2.Listas_Circulares.src.Estudio;

/* 6. Sistema de Turnos en Barbería (Atención Circular)

Diseña un sistema para gestionar los turnos de clientes en una barbería.

La Clase Cliente (Nodo): Debe contener nombre (String), tipoServicio (String) y tiempoMin (int).

El Problema:
Los clientes se agregan al final formando una lista circular.
La barbería atiende clientes en orden. Cuando termina con uno, pasa al siguiente.
El sistema nunca se detiene (es circular).

Reto:
Implementar el método atenderCliente() que:
1. Atienda al cliente en la cabeza
2. Lo elimine de la lista
3. Pase al siguiente cliente
4. Muestre el estado actual de la lista
*/

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int opcion;

        ListaCircular lista = new ListaCircular();

        do {
            System.out.println("\n==============================================");
            System.out.println("   SISTEMA DE TURNOS - BARBERÍA");
            System.out.println("==============================================");
            System.out.println("1. Agregar cliente");
            System.out.println("2. Atender cliente");
            System.out.println("3. Mostrar lista");
            System.out.println();
            System.out.println("0. Salir");
            System.out.println("==============================================");
            System.out.print("Elige una opción: ");

            opcion = sc.nextInt();
            System.out.println();

            switch (opcion) {

                case 1:
                    sc.nextLine();
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();

                    System.out.print("Tipo de servicio: ");
                    String servicio = sc.nextLine();

                    System.out.print("Tiempo estimado (min): ");
                    int tiempo = sc.nextInt();

                    lista.agregarCliente(new Cliente(nombre, servicio, tiempo));
                    break;

                case 2:
                    lista.atenderCliente();
                    break;

                case 3:
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
