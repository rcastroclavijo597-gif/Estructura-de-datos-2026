import java.util.Scanner;

public class ejercicios {
    public static void main(String[] args) {
        System.out.println("Ejercicio 1");

        System.out.print(" Ingresa tu nombre completo ");
        Scanner sc = new Scanner(System.in);
        String nombre = sc.nextLine();
        System.out.println("Ingresa tu I.D");
        String cedula = sc.nextLine();
        System.out.println("Ingresa tu semestre actual");
        String semestre = sc.nextLine();
        System.out.println("Ingresa tu promedio acumulado");
        String promedio = sc.nextLine();
        System.out.println("Estas matriculado?diga si o no");
        String matriculado = sc.nextLine();

        System.out.println();

        System.out.println(" hola " + nombre);
        System.out.println("ID:" + cedula);
        System.out.println("Semestre:" + semestre);
        System.out.println("Promedio:" + promedio);
        System.out.println("Matriculado:" + matriculado);

    }
}