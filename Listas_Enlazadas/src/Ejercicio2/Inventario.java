package Ejercicio2;

public class Inventario {

    Producto cabeza;

    public Inventario() {
        this.cabeza = null;
    }

    public void agregarProducto(Producto nuevoProducto) {

        if (nuevoProducto.diasParaVencer < 3) {
            nuevoProducto.siguiente = cabeza;
            cabeza = nuevoProducto;
        } else {
            if (cabeza == null) {
                cabeza = nuevoProducto;
            } else {
                Producto actual = cabeza;
                while (actual.siguiente != null) {
                    actual = actual.siguiente;
                }
                actual.siguiente = nuevoProducto;
            }
        }
    }

    public void mostrarProductosMenos5Dias() {
        Producto actual = cabeza;

        while (actual != null) {
            if (actual.diasParaVencer < 5) {
                System.out.println("Nombre: " + actual.nombre + " | Cantidad: " + actual.cantidad + " | Dias: "
                        + actual.diasParaVencer);
            }
            actual = actual.siguiente;
        }
    }
}