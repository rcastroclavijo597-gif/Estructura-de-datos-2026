import java.util.Scanner;

public class Ej1 {
    public static void main(String[] args) {

        double[] PrecioBoletos = new double[5];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < PrecioBoletos.length; i++) {
            System.out.println(" Ingrese el precio del boleto " + (i + 1));
            PrecioBoletos[i] = sc.nextDouble();

        }

        double[] SelectionShort = PrecioBoletos;

        for (int i = 0; i < SelectionShort.length - 1; i++) {
            int max = i;

            for (int j = i + 1; j < SelectionShort.length; j++) {
                if (SelectionShort[j] > SelectionShort[max]) {
                    max = j;
                }
            }

            if (max != i) {
                double temp = SelectionShort[i];
                SelectionShort[i] = SelectionShort[max];
                SelectionShort[max] = temp;
            }
        }

        System.out.println("Precios ordenados de mayor a menor:");
        for (double precio : SelectionShort) {
            System.out.println(precio);
        }

        double suma = 0;
        for (double precio : PrecioBoletos) {
            suma += precio;
        }
        double promedio = suma / PrecioBoletos.length;
        System.out.println("\nPromedio de precios: " + promedio);

        System.out.println("BÚSQUEDA LINEAL");
        System.out.println("Ingrese el precio a buscar:");
        double precioBuscar = sc.nextDouble();

        int posicion = -1;
        for (int i = 0; i < SelectionShort.length; i++) {
            if (SelectionShort[i] == precioBuscar) {
                posicion = i;
                break;
            }
        }

        if (posicion != -1) {
            System.out.println("Precio encontrado en la posición: " + posicion);
        } else {
            System.out.println("Precio no encontrado");
        }

        sc.close();

    }

}
