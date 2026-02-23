public class ejercicio5 {
    public static void main(String[] args) {

        double tazas = 2;
        double mililitros;
        double litros;

        mililitros = tazas * 236.588;

        litros = mililitros / 1000;

        System.out.println("cantidad en tazas: " + tazas);
        System.out.println("cantidad en mililitros: " + mililitros);
        System.out.println("cantidad en litros: " + litros);
    }
}