package Corte2.Listas_Circulares.src.Ejercicio2;

public class Carrusel {
    Anuncio cabeza;
    Anuncio cola;
    int tiempoTotal;

    public Carrusel() {
        cabeza = null;
        cola = null;
        tiempoTotal = 0;
    }

    public void agregarAnuncio(Anuncio anuncio) {
        if (cabeza == null) {
            cabeza = anuncio;
            cola = anuncio;
            anuncio.siguiente = cabeza;
        } else {
            cola.siguiente = anuncio;
            anuncio.siguiente = cabeza;
            cola = anuncio;
        }
    }

    public void mostrarAnuncios() {
        if (cabeza == null) {
            System.out.println("No hay anuncios registrados.");
            return;
        }
        Anuncio actual = cabeza;
        do {
            System.out.println("Título: " + actual.titulo + ", Duración: " + actual.duracionSegundos
                    + "s, Veces Repetido: " + actual.vecesRepetido + ", Categoría: " + actual.categoria);
            actual = actual.siguiente;
        } while (actual != cabeza);
    }

    public void reproducir(int ciclos) {
        if (cabeza == null) {
            System.out.println("No hay anuncios para reproducir.");
            return;
        }
        Anuncio actual = cabeza;
        for (int i = 0; i < ciclos; i++) {
            do {
                actual.vecesRepetido++;
                tiempoTotal += actual.duracionSegundos;
                System.out.println("Reproduciendo: " + actual.titulo + " (" + actual.categoria + ")");
                actual = actual.siguiente;
            } while (actual != cabeza);
        }
        mostrarResultados();
    }

    private void mostrarResultados() {
        if (cabeza == null)
            return;
        Anuncio actual = cabeza;
        Anuncio masRepetido = cabeza;
        do {
            if (actual.vecesRepetido > masRepetido.vecesRepetido) {
                masRepetido = actual;
            }
            actual = actual.siguiente;
        } while (actual != cabeza);
        System.out.println(
                "Anuncio más repetido: " + masRepetido.titulo + " con " + masRepetido.vecesRepetido + " repeticiones.");
        System.out.println("Tiempo total acumulado: " + tiempoTotal + " segundos.");
    }
}
