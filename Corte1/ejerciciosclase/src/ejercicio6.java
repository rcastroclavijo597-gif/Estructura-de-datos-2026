/* Un cajero de banco trabaja con el número del turno actual. Se crea una variable turnoActual y se asigna a turnoEnPantalla.

Demuestra con código que cambiar turnoEnPantalla no afecta a turnoActual (comportamiento por valor).
Explica en un comentario por qué ocurre esto. */

package ejerciciosclase.src;

public class ejercicio6 {
    public static void main(String[] args) {

        int turnoActual = 10;
        int turnoEnPantalla = turnoActual;

        System.out.println("turno actual: " + turnoActual);
        System.out.println("turno en pantalla: " + turnoEnPantalla);

        turnoEnPantalla = 20;

        System.out.println("despues de cambiar turnoEnPantalla");
        System.out.println("turno actual: " + turnoActual);
        System.out.println("turno en pantalla: " + turnoEnPantalla);

        /*
         * esto ocurre porque en java los tipos primitivos (int, double, char, boolean)
         * se pasan por valor. eso significa que turnoEnPantalla recibe una copia del
         * valor de turnoActual, no la misma variable.
         */
    }
}
