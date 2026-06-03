package Ejercicio2;

public class Producto {
    String codigo;
    String nombre;
    String categoria;
    double precio;
    int cantidad;
    Producto siguiente;

    public Producto(String codigo, String nombre, String categoria, double precio, int cantidad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.cantidad = cantidad;
        this.siguiente = null;
    }

    @Override
    public String toString() {
        return "[" + codigo + " | " + nombre + " | " + categoria + " | $" + precio + " | Cant: " + cantidad + "]";
    }
}