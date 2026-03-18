public class ej5 {
    public static void main(String[] args) {
        String[] Pasajeros = new String[6];
        Pasajeros[0] = "pedro";
        Pasajeros[1] = "juan";
        Pasajeros[2] = "Maria";
        Pasajeros[3] = "rony";
        Pasajeros[4] = "alex";
        Pasajeros[5] = "Marco";

        for (int i = 0; i < Pasajeros.length; i++) {
            System.out.println("Pasajero" + (i + 1) + Pasajeros[i]);

        }
    }

}
