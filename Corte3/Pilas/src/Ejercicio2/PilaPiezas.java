package Ejercicio2;

public class PilaPiezas {
    private Pieza tope;
    private int tamanio;

    public PilaPiezas() {
        this.tope = null;
        this.tamanio = 0;
    }

    public boolean estaVacia() {
        return tope == null;
    }

    public int getTamanio() {
        return tamanio;
    }

    public void push(Pieza nueva) {
        nueva.siguiente = tope;
        tope = nueva;
        tamanio++;
    }

    public Pieza pop() {
        if (estaVacia()) {
            return null;
        }

        Pieza aux = tope;
        tope = tope.siguiente;
        tamanio--;

        aux.siguiente = null;
        return aux;
    }

    public Pieza peek() {
        return tope;
    }

    public void imprimir() {
        if (estaVacia()) {
            System.out.println("Pila vacía.");
            return;
        }

        Pieza actual = tope;

        System.out.println("=== PILA DE PIEZAS (De Tope a Base) ===");

        while (actual != null) {

            if (actual == tope) {
                System.out.print(" TOPE -> ");
            } else {
                System.out.print("          ");
            }

            System.out.println(actual.toString());

            actual = actual.siguiente;
        }

        System.out.println("=======================================");
    }

    // Método del reto
    public void limpiarHastaDefecto() {

        if (estaVacia()) {
            System.out.println("La pila está vacía.");
            return;
        }

        System.out.println("\nRetirando piezas buenas...");

        while (tope != null && !tope.esDefectuosa) {

            Pieza retirada = pop();

            System.out.println("Pieza descartada: "
                    + retirada.nombrePieza);
        }

        if (tope != null && tope.esDefectuosa) {

            System.out.println("\n¡PIEZA DEFECTUOSA ENCONTRADA!");
            System.out.println("La línea de producción se detiene.");

            System.out.println("Pieza defectuosa:");
            System.out.println(tope);
        } else {
            System.out.println("No se encontró ninguna pieza defectuosa.");
        }
    }
}
