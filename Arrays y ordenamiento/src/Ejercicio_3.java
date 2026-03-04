 /* Sensor de Temperatura (Control de Calidad)
Una máquina industrial registra la temperatura cada 10 minutos y guarda los datos en un arreglo.
El Problema: Al final del día, el supervisor quiere saber cuál fue la temperatura más alta registrada 
para asegurarse de que la máquina no se recalentó.
Algoritmo a usar: Búsqueda Lineal de Máximo. Debes recorrer todo el arreglo comparando cada valor para encontrar el mayor de todos. */

public class Ejercicio_3 {

    public static void main(String[] args) {

        double[] temperaturas = {45.5, 47.2, 50.1, 49.8, 51.3, 48.6, 52.4, 46.9};


        double mayor = temperaturas[0];

 
        for (int i = 1; i < temperaturas.length; i++) {

            if (temperaturas[i] > mayor) {
                mayor = temperaturas[i];
            }
        }

        System.out.println("La temperatura más alta fue: " + mayor + " grados.");
    }
}