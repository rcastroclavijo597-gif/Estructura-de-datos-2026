package Ejercicio5;

public class ListaReproduccion {

    Cancion cabeza;
    Cancion actual; // canción actual

    public ListaReproduccion() {
        this.cabeza = null;
        this.actual = null;
    }

    public void agregarAlFinal(Cancion nueva) {

        if (cabeza == null) {
            cabeza = nueva;
            actual = nueva;
        } else {
            Cancion temp = cabeza;
            while (temp.siguiente != null) {
                temp = temp.siguiente;
            }
            temp.siguiente = nueva;
        }
    }

    public void agregarSiguiente(Cancion nueva) {

        if (actual == null) {
            cabeza = nueva;
            actual = nueva;
        } else {
            nueva.siguiente = actual.siguiente;
            actual.siguiente = nueva;
        }
    }

    public void mostrarDuracionTotal() {

        int totalSegundos = 0;
        Cancion temp = cabeza;

        while (temp != null) {
            totalSegundos += temp.duracionSegundos;
            temp = temp.siguiente;
        }

        int minutos = totalSegundos / 60;
        int segundos = totalSegundos % 60;

        System.out.println("Duracion total: " + minutos + ":" + (segundos < 10 ? "0" + segundos : segundos));
    }

    // (opcional)
    public void mostrarCanciones() {
        Cancion temp = cabeza;

        while (temp != null) {
            System.out.println("Titulo: " + temp.titulo +
                    " | Artista: " + temp.artista +
                    " | Duracion: " + temp.duracionSegundos + " seg");
            temp = temp.siguiente;
        }
    }
}
