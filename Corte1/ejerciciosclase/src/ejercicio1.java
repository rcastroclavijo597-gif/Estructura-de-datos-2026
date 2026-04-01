// Un sistema universitario necesita registrar la información básica de un estudiante: 
//nombre completo, código (número entero), semestre actual, promedio acumulado y si está matriculado o no
// Declara las variables con los tipos de datos apropiados.
// Asigna valores de ejemplo.
// Imprime un reporte por consola con el siguiente formato:
// === Ficha del Estudiante ===
// Nombre: Ana Torres
// Código: 20241001
// Semestre: 3
// Promedio: 3.85
// Matriculado: true

package ejerciciosclase.src;

import java.util.Scanner;

public class ejercicio1 {
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