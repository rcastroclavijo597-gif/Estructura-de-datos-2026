/* Una aplicación de cocina necesita convertir unidades:

Declara una variable tazas (double) con la cantidad de tazas de un ingrediente.
Convierte a mililitros (1 taza = 236.588 ml) y guarda el resultado en otra variable.
Convierte también a litros.
Muestra las tres medidas por consola. */

package ejerciciosclase.src;

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