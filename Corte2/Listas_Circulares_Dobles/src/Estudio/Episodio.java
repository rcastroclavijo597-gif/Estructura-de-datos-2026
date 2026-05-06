package Corte2.Listas_Circulares_Dobles.src.Estudio;

public class Episodio {

    String titulo;
    int duracionMin;
    String autor;

    Episodio siguiente; // apunta al siguiente nodo
    Episodio anterior; // apunta al nodo anterior

    public Episodio(String titulo, int duracionMin, String autor) {
        this.titulo = titulo;
        this.duracionMin = duracionMin;
        this.autor = autor;
        this.siguiente = null;
        this.anterior = null;
    }
}
