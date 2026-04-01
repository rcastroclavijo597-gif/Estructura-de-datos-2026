/* Buscador de Cédulas (Base de Datos Bancaria)
Un banco tiene una lista de 1.000 clientes organizados de forma estricta y ascendente por su número de cédula o ID.
El Problema: Un cliente llega a la ventanilla y da su número. El sistema debe encontrar sus datos de la manera más rápida posible 
(en pocos pasos).
Algoritmo a usar: Búsqueda Binaria. Como los datos ya están ordenados, este algoritmo permitirá encontrar 
al cliente dividiendo la lista a la mitad en cada paso. */

import java.util.Scanner;

public class Ejercicio_2 {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        int[] cedulas = new int[1000];

        for (int i = 0; i < 1000; i++) {
            cedulas[i] = 1000 + i;  
        }

        System.out.print("Ingrese la cédula a buscar: ");
        int numero = teclado.nextInt();

        int inicio = 0;
        int fin = cedulas.length - 1;
        int encontrado = -1;

        while (inicio <= fin) {

            int medio = (inicio + fin) / 2;

            if (cedulas[medio] == numero) {
                encontrado = medio;
                break;
            }

            if (numero < cedulas[medio]) {
                fin = medio - 1;
            } else {
                inicio = medio + 1;
            }
        }

        if (encontrado != -1) {
            System.out.println("Cliente encontrado en la posición: " + encontrado);
        } else {
            System.out.println("Cliente no encontrado.");
        }

        teclado.close();
    }
}


