public class ejercicio10 {
    public static void main(String[] args) {

        int[] configuracion = { 1920, 1080, 60 };

        int[] copiaConfiguracion = new int[configuracion.length];

        for (int i = 0; i < configuracion.length; i++) {
            copiaConfiguracion[i] = configuracion[i];
        }

        System.out.println("antes del cambio:");
        System.out.println("original fps: " + configuracion[2]);
        System.out.println("copia fps: " + copiaConfiguracion[2]);

        copiaConfiguracion[2] = 120;

        System.out.println("despues del cambio:");
        System.out.println("original fps: " + configuracion[2]);
        System.out.println("copia fps: " + copiaConfiguracion[2]);

        /*
         * aqui se creo un nuevo arreglo y se copiaron los valores uno por uno,
         * por eso configuracion y copiaConfiguracion son arreglos diferentes en
         * memoria.
         * si hubieramos hecho copiaConfiguracion = configuracion, solo se copiaria la
         * referencia
         * y cualquier cambio en uno afectaria al otro.
         */
    }
}
