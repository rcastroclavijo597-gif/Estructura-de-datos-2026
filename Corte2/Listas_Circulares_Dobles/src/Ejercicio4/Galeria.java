package Corte2.Listas_Circulares_Dobles.src.Ejercicio4;

public class Galeria {
    Foto cabeza;
    Foto cola;
    Foto actual;

    public Galeria() {
        cabeza = null;
        cola = null;
        actual = null;
    }

    public boolean estaVacia() {
        return cabeza == null;
    }

    public void agregarFoto(String titulo, String fecha) {
        Foto nueva = new Foto(titulo, fecha, false);

        if (cabeza == null) {
            nueva.siguiente = nueva;
            nueva.anterior = nueva;
            cabeza = nueva;
            cola = nueva;
            actual = nueva;
        } else {
            cola.siguiente = nueva;
            nueva.anterior = cola;
            nueva.siguiente = cabeza;
            cabeza.anterior = nueva;
            cola = nueva;
        }
    }

    public void siguiente() {
        if (actual != null) {
            actual = actual.siguiente;
        }
    }

    public void anterior() {
        if (actual != null) {
            actual = actual.anterior;
        }
    }

    public void toggleFavorita() {
        if (actual != null) {
            actual.esFavorita = !actual.esFavorita;
        }
    }

    public void eliminarActual() {
        if (actual == null)
            return;

        if (actual == cabeza && actual == cola) {
            cabeza = null;
            cola = null;
            actual = null;
            return;
        }

        actual.anterior.siguiente = actual.siguiente;
        actual.siguiente.anterior = actual.anterior;

        if (actual == cabeza)
            cabeza = actual.siguiente;
        if (actual == cola)
            cola = actual.anterior;

        actual = actual.siguiente;
    }

    public void mostrarGaleria() {
        if (estaVacia()) {
            System.out.println("Galería vacía.");
            return;
        }

        Foto temp = cabeza;
        int i = 1;

        do {
            String marcaActual = (temp == actual) ? "[▶] " : "    ";
            String marcaFav = temp.esFavorita ? "[★] " : "";

            System.out.println(i + ". " + marcaActual + marcaFav +
                    temp.titulo + " (" + temp.fecha + ")");

            temp = temp.siguiente;
            i++;
        } while (temp != cabeza);
    }
}
