/* El Podio de la Competencia
Algoritmo obligatorio: Ordenamiento por Selección (Selection Sort)

Contexto: Se ha realizado una carrera de 100 metros planos y el comité olímpico necesita determinar quiénes ganaron las medallas.
Detalle del ejercicio: El programa debe solicitar primero cuántos corredores participaron (ej. 5 a 10). Luego, debe pedir el tiempo 
en segundos (con decimales) de cada corredor.
Lógica de Selección: El algoritmo debe buscar el tiempo más bajo (el más rápido) en cada iteración y colocarlo al inicio.
Resultado esperado: El programa debe imprimir el arreglo totalmente ordenado y, adicionalmente, mostrar un mensaje claro
 indicando quién obtuvo el Oro (1er lugar), Plata (2do lugar) y Bronce (3er lugar). */

import java.util.Scanner;
public class ejercicio1 {
    public static void main(String[] args) {

        Scanner Sc = new Scanner(System.in);

        System.out.println("Ingrese cuantos corredores participaron");

        int Cantidad = Sc.nextInt();

        double[] participantes = new double[Cantidad];

        for (int i = 0; i < Cantidad; i++) {
            System.out.println("Ingrese el valor de su tiempo " + (i + 1) + ":");
            participantes[i] = Sc.nextDouble();
        }

        int n = participantes.length;

        
        for (int i = 0; i < n - 1; i++) {

            int minIdx = i;

            for (int j = i + 1; j < n; j++) {
                if (participantes[j] < participantes[minIdx]) {
                    minIdx = j;
                }
            }

            double temp = participantes[i];
            participantes[i] = participantes[minIdx];
            participantes[minIdx] = temp;
        }

        System.out.println("\nTiempos ordenados:");
        for (int i = 0; i < n; i++) {
            System.out.println(participantes[i]);
        }

        System.out.println("\n--- PODIO ---");
        System.out.println("Oro: " + participantes[0]);
        System.out.println("Plata: " + participantes[1]);
        System.out.println("Bronce: " + participantes[2]);

        Sc.close();
    }
}




