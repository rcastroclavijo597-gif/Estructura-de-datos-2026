public class ejercicio9 {
    public static void main(String[] args) {

        double[] notasProfesor = { 3.5, 2.5, 4.0, 3.0 };

        double[] notasCoordinador = notasProfesor;

        System.out.println("notas antes de la correccion:");
        System.out.println("estudiante 2 (profesor): " + notasProfesor[1]);
        System.out.println("estudiante 2 (coordinador): " + notasCoordinador[1]);

        notasCoordinador[1] = 3.0;

        System.out.println("notas despues de la correccion:");
        System.out.println("estudiante 2 (profesor): " + notasProfesor[1]);
        System.out.println("estudiante 2 (coordinador): " + notasCoordinador[1]);

        /*
         * esto ocurre porque los arreglos en java se manejan por referencia.
         * cuando hacemos notasCoordinador = notasProfesor, no se copia el arreglo,
         * solo se copia la direccion de memoria.
         * entonces ambas variables apuntan al mismo arreglo y si se cambia uno,
         * el otro tambien cambia.
         */
    }
}