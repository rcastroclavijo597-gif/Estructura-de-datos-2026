package Ejercicio1;

public class Libro {
    String isbn;
    String titulo;
    String autor;
    int anio;
    Libro siguiente;

    public Libro(String isbn, String titulo, String autor, int anio) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.anio = anio;
        this.siguiente = null;
    }

    @Override
    public String toString() {
        return "[" + isbn + " | " + titulo + " | " + autor + " | " + anio + "]";
    }
}