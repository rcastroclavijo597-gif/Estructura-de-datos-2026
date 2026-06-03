package Ejercicio2;

public class PilaProductos {
    private Producto tope;
    private int tamanio;

    public PilaProductos() {
        this.tope = null;
        this.tamanio = 0;
    }

    public boolean estaVacia() {
        return tope == null;
    }

    public int getTamanio() {
        return tamanio;
    }

    public void push(Producto nuevo) {
        nuevo.siguiente = tope;
        tope = nuevo;
        tamanio++;
    }

    public Producto pop() {
        if (estaVacia())
            return null;
        Producto aux = tope;
        tope = tope.siguiente;
        tamanio--;
        aux.siguiente = null;
        return aux;
    }

    public Producto peek() {
        return tope;
    }

    public void imprimir() {
        if (estaVacia()) {
            System.out.println("Pila vacía.");
            return;
        }
        Producto actual = tope;
        System.out.println("=== ALMACÉN (De Tope a Base) ===");
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

    // MÉTODO RETO: calcular el valor total del inventario (precio * cantidad)
    public double calcularValorTotal() {
        double total = 0;
        Producto actual = tope;
        while (actual != null) {
            total += actual.precio * actual.cantidad;
            actual = actual.siguiente;
        }
        return total;
    }

    // EXTRA PARCIAL: contar productos de una categoría específica
    public int contarPorCategoria(String categoria) {
        int contador = 0;
        Producto actual = tope;
        while (actual != null) {
            if (actual.categoria.equalsIgnoreCase(categoria))
                contador++;
            actual = actual.siguiente;
        }
        return contador;
    }
}
