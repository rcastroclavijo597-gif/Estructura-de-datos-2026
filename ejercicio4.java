import java.util.Scanner;

//Ficha de un estudiante//
//

public class ejercicio4 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String placa;
        int anio;
        int cilindraje;
        double precio;
        char color;
        boolean soat;

        System.out.print("Ingrese la placa del vehiculo: ");
        placa = sc.nextLine();

        System.out.print("Ingrese el año de fabricacion: ");
        anio = sc.nextInt();

        System.out.print("Ingrese el cilindraje (cc): ");
        cilindraje = sc.nextInt();

        System.out.print("Ingrese el precio de compra: ");
        precio = sc.nextDouble();

        System.out.print("Ingrese la inicial del color: ");
        color = sc.next().charAt(0);

        System.out.print("Tiene SOAT vigente? (true/false): ");
        soat = sc.nextBoolean();

        for (int i = 0; i < 20; i++) {
            System.out.println();
        }

        System.out.println("----- DATOS DEL VEHICULO -----");
        System.out.println("Placa: " + placa);
        System.out.println("Año de fabricacion: " + anio);
        System.out.println("Cilindraje: " + cilindraje + " cc");
        System.out.println("Precio de compra: " + precio);
        System.out.println("Color (inicial): " + color);
        System.out.println("SOAT vigente: " + soat);

        sc.close();
    }
}