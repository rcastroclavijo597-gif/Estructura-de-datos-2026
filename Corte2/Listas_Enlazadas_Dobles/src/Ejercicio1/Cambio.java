package Corte2.Listas_Enlazadas_Dobles.src.Ejercicio1;

public class Cambio {
    String texto;
    String tipoOperacion;

    Cambio siguiente; // Referencia al siguiente cambio en la lista
    Cambio anterior; // Referencia al cambio anterior en la lista

    public Cambio(String texto, String tipoOperacion) {
        this.texto = texto;
        this.tipoOperacion = tipoOperacion;
        this.siguiente = null;
        this.anterior = null;
    }
}