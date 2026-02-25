public class ejercicio10 {
    public static void main(String[] args) {

        // arreglo original de configuracion
        int[] configuracion = {1920, 1080, 60};

        // crear una copia real del arreglo
        int[] copiaConfiguracion = new int[configuracion.length];

        // copiar elemento por elemento
        for (int i = 0; i < configuracion.length; i++) {
            copiaConfiguracion[i] = configuracion[i];
        }

        // mostrar valores antes del cambio
        System.out.println("antes del cambio:");
        System.out.println("original fps: " + configuracion[2]);
        System.out.println("copia fps: " + copiaConfiguracion[2]);

        // modificar la copia
        copiaConfiguracion[2] = 120;

        // mostrar valores despues del cambio
        System.out.println("despues del cambio:");
        System.out.println("original fps: " + configuracion[2]);
        System.out.println("copia fps: " + copiaConfiguracion[2]);

        /*
         * aqui se creo un nuevo arreglo y se copiaron los valores uno por uno,
         * por eso configuracion y copiaConfiguracion son arreglos diferentes en memoria.
         * si hubieramos hecho copiaConfiguracion = configuracion, solo se copiaria la referencia
         * y cualquier cambio en uno afectaria al otro.
         */
    }
}
