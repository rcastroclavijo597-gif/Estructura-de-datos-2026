package Corte2.Listas_Enlazadas_Dobles.src.Ejercicio2;

public class Fotografia {
    String nombre;
    double tamaño;
    String Resolucion;
    Fotografia siguiente;
    Fotografia anterior;

    public Fotografia(String nombre, double tamaño, String Resolucion) {
        this.nombre = nombre;
        this.tamaño = tamaño;
        this.Resolucion = Resolucion;
        this.siguiente = null;
        this.anterior = null;
    }
}
