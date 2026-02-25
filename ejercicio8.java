public class ejercicio8 {
    public static void main(String[] args) {

        String ultimoMensaje = "Hola";
        String copiaTexto = ultimoMensaje;

        System.out.println("ultimo mensaje: " + ultimoMensaje);
        System.out.println("copia texto: " + copiaTexto);

        copiaTexto = "¿Cómo estás?";

        System.out.println("despues de cambiar copiaTexto");
        System.out.println("ultimo mensaje: " + ultimoMensaje);
        System.out.println("copia texto: " + copiaTexto);

        /*
         * esto ocurre porque los string en java son inmutables.
         * cuando cambiamos copiaTexto, no se modifica el texto original,
         * sino que se crea un nuevo string en memoria.
         * por eso ultimoMensaje no cambia.
         */
    }
}
