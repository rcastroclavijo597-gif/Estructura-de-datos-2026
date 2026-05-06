package Corte2.Listas_Enlazadas_Dobles.src.Estudio;

public class Video {

    String titulo;
    int duracionMin;
    String categoria;

    Video siguiente; // apunta al siguiente nodo
    Video anterior; // apunta al nodo anterior

    public Video(String titulo, int duracionMin, String categoria) {
        this.titulo = titulo;
        this.duracionMin = duracionMin;
        this.categoria = categoria;
        this.siguiente = null;
        this.anterior = null;
    }
}
