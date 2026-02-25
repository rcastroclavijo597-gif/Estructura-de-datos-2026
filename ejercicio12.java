public class ejercicio12 {
    public static void main(String[] args) {

        // arreglo con 7 ventas de ejemplo
        double[] ventas = {12000, 35000, 8000, 15000, 22000, 5000, 18000};

        // variables para calcular
        double ventaMayor = ventas[0];
        double ventaMenor = ventas[0];
        double total = 0;

        // recorrer el arreglo
        for (int i = 0; i < ventas.length; i++) {

            // sumar total
            total = total + ventas[i];

            // buscar venta mayor
            if (ventas[i] > ventaMayor) {
                ventaMayor = ventas[i];
            }

            // buscar venta menor
            if (ventas[i] < ventaMenor) {
                ventaMenor = ventas[i];
            }
        }

        // mostrar resultados
        System.out.println("venta mas alta: " + ventaMayor);
        System.out.println("venta mas baja: " + ventaMenor);
        System.out.println("total del dia: " + total);
    }
}