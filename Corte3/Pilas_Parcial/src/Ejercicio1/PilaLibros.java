package Ejercicio1;

public class PilaLibros {
    private Libro tope;
    private int tamanio;

    public PilaLibros() {
        this.tope = null;
        this.tamanio = 0;
    }

    public boolean estaVacia() {
        return tope == null;
    }

    public int getTamanio() {
        return tamanio;
    }

    public void push(Libro nuevo) {
        nuevo.siguiente = tope;
        tope = nuevo;
        tamanio++;
    }

    public Libro pop() {
        if (estaVacia())
            return null;
        Libro aux = tope;
        tope = tope.siguiente;
        tamanio--;
        aux.siguiente = null;
        return aux;
    }

    public Libro peek() {
        return tope;
    }

    public void imprimir() {
        if (estaVacia()) {
            System.out.println("Pila vacía.");
            return;
        }
        Libro actual = tope;
        System.out.println("=== ESTANTE (De Tope a Base) ===");
        while (actual != null) {
            if (actual == tope)
                System.out.print("  TOPE -> ");
            else
                System.out.print("          ");
            System.out.println(actual);
            actual = actual.siguiente;
        }
        System.out.println("================================");
    }

    // MÉTODO RETO: contar libros de un autor sin modificar la pila
    public int contarPorAutor(String autor) {
        int contador = 0;
        Libro actual = tope;
        while (actual != null) {
            if (actual.autor.equalsIgnoreCase(autor))
                contador++;
            actual = actual.siguiente;
        }
        return contador;
    }

    // EXTRA PARCIAL: verificar si un ISBN ya existe
    public boolean existeIsbn(String isbn) {
        Libro actual = tope;
        while (actual != null) {
            if (actual.isbn.equalsIgnoreCase(isbn))
                return true;
            actual = actual.siguiente;
        }
        return false;
    }
}
