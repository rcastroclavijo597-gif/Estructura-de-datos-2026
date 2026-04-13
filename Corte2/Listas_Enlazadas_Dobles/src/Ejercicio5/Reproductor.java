package Corte2.Listas_Enlazadas_Dobles.src.Ejercicio5;

public class Reproductor {
    Cancion cabeza;
    Cancion cola;

    public Reproductor() {
        cabeza = null;
        cola = null;
    }

    public void agregarCancion(Cancion nueva) {
        if (cabeza == null) {
            cabeza = nueva;
            cola = nueva;
        } else {
            cola.siguiente = nueva;
            nueva.anterior = cola;
            cola = nueva;
        }
    }

    public Cancion saltarAdelante(Cancion actual) {
        if (actual == null) {
            System.out.println("No hay canción actual.");
            return null;
        }
        if (actual.siguiente == null) {
            System.out.println("No hay más canciones hacia adelante.");
            return actual;
        }
        return actual.siguiente;
    }

    public Cancion saltarAtras(Cancion actual) {
        if (actual == null) {
            System.out.println("No hay canción actual.");
            return null;
        }
        if (actual.anterior == null) {
            System.out.println("No se puede retroceder, ya estás en la primera canción.");
            return actual;
        }
        return actual.anterior;
    }

    public void mostrarLista() {
        if (cabeza == null) {
            System.out.println("La lista de reproducción está vacía.");
            return;
        }
        Cancion temp = cabeza;
        System.out.println("\n--- Lista de Reproducción ---");
        while (temp != null) {
            System.out.println(
                    "Título: " + temp.titulo + " | Artista: " + temp.artista + " | Duración: " + temp.duracion + "s");
            temp = temp.siguiente;
        }
    }
}