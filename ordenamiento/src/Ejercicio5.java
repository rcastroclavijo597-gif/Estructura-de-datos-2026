/* El Inspector de Eficiencia (Duelo de Métodos)
Algoritmos obligatorios: Selección vs Inserción

Contexto: Un analista de sistemas quiere saber cuál algoritmo es más "pesado" en términos de operaciones para un caso específico.
Detalle del ejercicio: El usuario debe ingresar 6 números enteros desordenados. El programa aplicará AMBOS métodos al mismo conjunto 
de datos (puedes usar una copia del arreglo original).
Lógica de Conteo:
En Selección: Cuenta cada vez que ocurre un swap (intercambio físico de posiciones).
En Inserción: Cuenta cada vez que un elemento se "mueve" hacia la izquierda dentro del bucle interno.
Resultado esperado: El programa debe imprimir cuántos intercambios hizo Selección y cuántos movimientos hizo Inserción. 
El estudiante debe concluir cuál fue más eficiente para esos datos ingresados por el teclado. */

import java.util.Scanner;
public class Ejercicio5 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] datos = new int[6];

        
        System.out.println("Ingrese 6 numeros enteros:");
        for (int i = 0; i < 6; i++) {
            System.out.print("Numero " + (i + 1) + ": ");
            datos[i] = sc.nextInt();
        }

        
        int[] seleccion = datos.clone();
        int[] insercion = datos.clone();

        
        int swapsSeleccion = 0;
        int movimientosInsercion = 0;

        
        for (int i = 0; i < seleccion.length - 1; i++) {

            int min = i;

            for (int j = i + 1; j < seleccion.length; j++) {
                if (seleccion[j] < seleccion[min]) {
                    min = j;
                }
            }

            if (min != i) {
                int temp = seleccion[i];
                seleccion[i] = seleccion[min];
                seleccion[min] = temp;

                swapsSeleccion++; 
            }
        }

        for (int i = 1; i < insercion.length; i++) {

            int clave = insercion[i];
            int j = i - 1;

            while (j >= 0 && insercion[j] > clave) {
                insercion[j + 1] = insercion[j];
                j--;
                movimientosInsercion++; 
            }

            insercion[j + 1] = clave;
        }

        
        System.out.println("\nResultados del analisis:");
        System.out.println("Intercambios en Seleccion: " + swapsSeleccion);
        System.out.println("Movimientos en Insercion: " + movimientosInsercion);

        if (swapsSeleccion < movimientosInsercion) {
            System.out.println("Seleccion fue mas eficiente para estos datos.");
        } else if (movimientosInsercion < swapsSeleccion) {
            System.out.println("Insercion fue mas eficiente para estos datos.");
        } else {
            System.out.println("Ambos metodos tuvieron la misma cantidad de operaciones.");
        }

        sc.close();
    }
}


