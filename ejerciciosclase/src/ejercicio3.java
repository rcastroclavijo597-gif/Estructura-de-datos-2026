package ejerciciosclase.src;

import java.util.Scanner;

public class ejercicio3 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double temperatura;
        String nombreSensor;
        int numeroLectura;
        boolean enAlarma = false;

        System.out.print("Ingrese el nombre del sensor: ");
        nombreSensor = sc.nextLine();

        System.out.print("Ingrese la temperatura actual (Celsius): ");
        temperatura = sc.nextDouble();

        System.out.print("Ingrese el numero de lectura: ");
        numeroLectura = sc.nextInt();

        if (temperatura > 80) {
            enAlarma = true;
        }

        for (int i = 0; i < 20; i++) {
            System.out.println();
        }

        System.out.println("----- DATOS DEL SENSOR -----");
        System.out.println("Nombre del sensor: " + nombreSensor);
        System.out.println("Temperatura: " + temperatura + " C");
        System.out.println("Numero de lectura: " + numeroLectura);
        System.out.println("En alarma: " + enAlarma);

        sc.close();
    }
}
