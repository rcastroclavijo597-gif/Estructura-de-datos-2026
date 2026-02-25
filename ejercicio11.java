public class ejercicio11 {
    public static void main(String[] args) {

        String[] pasajeros = new String[6];

        pasajeros[0] = "juan";
        pasajeros[1] = "maria";
        pasajeros[2] = "carlos";
        pasajeros[3] = "ana";
        pasajeros[4] = "luis";
        pasajeros[5] = "sofia";

        System.out.println("lista de pasajeros:");
        for (int i = 0; i < pasajeros.length; i++) {
            System.out.println("asiento " + (i + 1) + ": " + pasajeros[i]);
        }

        int ocupados = 0;
        for (int i = 0; i < pasajeros.length; i++) {
            if (pasajeros[i] != null) {
                ocupados++;
            }
        }

        System.out.println("asientos ocupados: " + ocupados);
    }
}
