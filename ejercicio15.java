public class ejercicio15 {

    public static void main(String[] args) {

        double[] temperaturas = { 30.5, 32.0, 28.7, 31.2, 33.8, 29.9, 34.1 };

        String[] dias = { "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo" };

        double suma = 0;
        double promedio;

        for (int i = 0; i < temperaturas.length; i++) {
            suma = suma + temperaturas[i];
        }

        promedio = suma / temperaturas.length;

        System.out.println("Promedio semanal: " + promedio);

        System.out.println("Dias con temperatura mayor al promedio:");

        for (int i = 0; i < temperaturas.length; i++) {
            if (temperaturas[i] > promedio) {
                System.out.println(dias[i] + " -> " + temperaturas[i] + " grados");
            }
        }
    }
}
