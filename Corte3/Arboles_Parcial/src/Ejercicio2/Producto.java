package Ejercicio2;

public class Producto {
    int codigoBarras;
    String nombre;
    double precio;
    int stock;
    Producto izquierdo;
    Producto derecho;

    public Producto(int codigoBarras, String nombre, double precio, int stock) {
        this.codigoBarras = codigoBarras;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.izquierdo = null;
        this.derecho = null;
    }

    @Override
    public String toString() {
        return "[" + codigoBarras + " | " + nombre + " | $" + precio + " | Stock: " + stock + "]";
    }
}