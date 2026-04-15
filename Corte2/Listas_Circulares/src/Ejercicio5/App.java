/* 5. Torneo de Fútbol (Fixture Round Robin)
En un torneo de fútbol por todos contra todos, cada equipo debe enfrentarse exactamente una vez contra cada uno de 
los demás equipos. El algoritmo Round Robin fija los partidos rotando los equipos en un ciclo.

La Clase Equipo (Nodo): Debe contener nombre (String), ciudad (String), puntos (int) y golesFavor (int).
El Problema: El fixture se genera rotando la lista: en cada jornada, se enfrentan los equipos opuestos del ciclo 
(el primero con el último, el segundo con el penúltimo, etc.). Un equipo queda fijo (la cabeza) y el resto rota una 
posición hacia adelante en cada jornada.
Reto: Implementa el método generarFixture() que imprima todos los partidos de una jornada completa para 6 equipos 
(3 partidos por jornada). Luego, rota los equipos una posición y repite hasta que todos se hayan enfrentado. Al final, 
imprime la tabla de posiciones ordenando los equipos de mayor a menor puntaje 
(puedes asignar puntos aleatorios o fijos para la simulación). */

package Corte2.Listas_Circulares.src.Ejercicio5;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Torneo torneo = new Torneo();
        int opcion;

        do {
            System.out.println("\n==============================================");
            System.out.println("   Torneo de Fútbol — Round Robin");
            System.out.println("==============================================");
            System.out.println("1. Agregar equipo");
            System.out.println("2. Mostrar equipos");
            System.out.println("3. Generar fixture");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del equipo: ");
                    String nombre = sc.next();
                    System.out.print("Ingrese la ciudad: ");
                    String ciudad = sc.next();
                    Equipo nuevo = new Equipo(nombre, ciudad);
                    torneo.agregarEquipo(nuevo);
                    break;

                case 2:
                    torneo.mostrarEquipos();
                    break;

                case 3:
                    torneo.generarFixture();
                    break;

                case 0:
                    System.out.println("Saliendo del torneo...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);

        sc.close();
    }
}
