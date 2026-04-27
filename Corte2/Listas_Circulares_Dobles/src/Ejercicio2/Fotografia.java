package Corte2.Listas_Circulares_Dobles.src.Ejercicio2;

public class Fotografia {
    String nombre_Archivo;
    double tamaño_MB;
    String Resolucion;
    Foto anterior;
    Foto siguiente;

    public Fotografia(String nombre_archivo, double tamaño_mb, String resolucion) {
        this.nombre_Archivo = nombre_archivo;
        this.tamaño_MB = tamaño_mb;
        this.Resolucion = resolucion;
        this.siguiente = null;
        this.anterior = null;
    }

}
