
/* Un almacén tiene un arreglo con el stock de 5 productos. El sistema de ventas y el sistema de reportes apuntan al mismo arreglo.

Crea el arreglo stockAlmacen con valores iniciales.
Asigna stockReportes = stockAlmacen.
Simula una venta reduciendo el stock de un producto desde stockReportes.
Muestra que stockAlmacen también cambió y explica en comentarios por qué. */

package ejerciciosclase.src;

public class ejercicio7 {
    public static void main(String[] args) {

        int[] stockAlmacen = { 10, 20, 15, 8, 5 };

        int[] stockReportes = stockAlmacen;

        System.out.println("stock antes de la venta:");
        System.out.println("producto 1: " + stockAlmacen[0]);

        stockReportes[0] = stockReportes[0] - 3;

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