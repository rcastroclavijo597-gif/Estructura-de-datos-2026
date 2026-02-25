package ejerciciosclase.src;

public class ejercicio12 {
    public static void main(String[] args) {

        double[] ventas = { 12000, 35000, 8000, 15000, 22000, 5000, 18000 };

        double ventaMayor = ventas[0];
        double ventaMenor = ventas[0];
        double total = 0;

        for (int i = 0; i < ventas.length; i++) {

            total = total + ventas[i];

            if (ventas[i] > ventaMayor) {
                ventaMayor = ventas[i];
            }

            if (ventas[i] < ventaMenor) {
                ventaMenor = ventas[i];
            }
        }

        System.out.println("venta mas alta: " + ventaMayor);
        System.out.println("venta mas baja: " + ventaMenor);
        System.out.println("total del dia: " + total);
    }
}