public class ej6 {
    public static void main(String[] args) {
        double[] Ventas = new double[6];

        Ventas[0] = 20000;
        Ventas[1] = 500000;
        Ventas[2] = 200001;
        Ventas[3] = 5000002;
        Ventas[4] = 5000003;
        Ventas[5] = 200004;

        double VentasMayor = Ventas[0];
        double Ventasmenor = Ventas[0];
        double Total = 0;

        for (int i = 0; i < Ventas.length; i++) {
            Total += Ventas[i];
            if (Ventas[i] > VentasMayor) {
                VentasMayor = Ventas[i];
            }

            if (Ventas[i] < Ventasmenor) {
                Ventasmenor = Ventas[i];

            }

        }
        System.out.println(VentasMayor);
        System.out.println(Ventasmenor);
        System.out.println(Total);

    }

}
