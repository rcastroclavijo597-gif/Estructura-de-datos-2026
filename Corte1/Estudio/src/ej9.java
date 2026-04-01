import java.util.Scanner;

public class ej9 {

    public static void insertionSort(double[] arr) {
        for (int i = 1; i < arr.length; i++) {
            double elemento = arr[i];
            int posicion = i - 1;

            while (posicion >= 0 && arr[posicion] > elemento) {
                arr[posicion + 1] = arr[posicion];
                posicion = posicion - 1;
            }

            arr[posicion + 1] = elemento;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] edades = { 25, 19, 22, 18, 30, 21 };
        insertionSort(edades);

        System.out.print("Edades ordenadas: ");
        for (double edad : edades) {
            System.out.print((int) edad + " ");
        }
        System.out.println();

        System.out.print("¿Cuántos miembros tiene el equipo? ");
        int cantidad = scanner.nextInt();

        double[] estaturas = new double[cantidad];
        for (int i = 0; i < cantidad; i++) {
            System.out.print("Estatura " + (i + 1) + " (m): ");
            estaturas[i] = scanner.nextDouble();
        }

        insertionSort(estaturas);

        System.out.print("Estaturas ordenadas: ");
        for (double estatura : estaturas) {
            System.out.printf("%.2f ", estatura);
        }
        System.out.println();

        scanner.close();
    }
}
