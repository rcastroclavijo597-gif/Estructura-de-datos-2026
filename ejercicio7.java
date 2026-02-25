public class ejercicio7 {
    public static void main(String[] args) {

        // crear arreglo con stock inicial
        int[] stockAlmacen = {10, 20, 15, 8, 5};

        // asignar el mismo arreglo a otra variable
        int[] stockReportes = stockAlmacen;

        // mostrar stock antes de la venta
        System.out.println("stock antes de la venta:");
        System.out.println("producto 1: " + stockAlmacen[0]);

        // simular una venta (reducir stock del producto 1)
        stockReportes[0] = stockReportes[0] - 3;

        // mostrar stock despues de la venta
        System.out.println("stock despues de la venta:");
        System.out.println("producto 1 en almacen: " + stockAlmacen[0]);
        System.out.println("producto 1 en reportes: " + stockReportes[0]);

        /*
         * esto ocurre porque los arreglos en java son objetos.
         * cuando hacemos stockReportes = stockAlmacen, no se copia el arreglo,
         * solo se copia la referencia. entonces ambas variables apuntan al mismo
         * arreglo en memoria, por eso si cambia uno, cambia el otro.
         */
    }
}