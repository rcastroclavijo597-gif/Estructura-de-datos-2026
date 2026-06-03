package Ejercicio3;

public class ColaVuelos {
    private Vuelo entrada;
    private Vuelo salida;
    private int tamanio;

    public ColaVuelos() {
        this.entrada = null;
        this.salida = null;
        this.tamanio = 0;
    }

    public boolean isEmpty() {
        return salida == null;
    }

    public int size() {
        return tamanio;
    }

    public Vuelo peek() {
        if (isEmpty()) {
            System.out.println("La cola está vacía");
            return null;
        }
        return salida;
    }

    public void enqueue(Vuelo v) {
        if (isEmpty()) {
            salida = v;
            entrada = v;
        } else {
            entrada.siguiente = v;
            entrada = v;
        }
        tamanio++;
    }

    public Vuelo dequeue() {
        if (isEmpty()) {
            System.out.println("La cola está vacía");
            return null;
        }
        Vuelo v = salida;
        salida = salida.siguiente;
        if (salida == null)
            entrada = null;
        tamanio--;
        return v;
    }

    public void imprimir() {
        if (isEmpty()) {
            System.out.println("[ Cola vacía ]");
            return;
        }
        System.out.print("Salida < ");
        Vuelo actual = salida;
        while (actual != null) {
            System.out.print("[" + actual.codigoVuelo + ": " + actual.destino
                    + " - " + actual.aerolinea + " - " + actual.pasajeros + " pax]");
            if (actual.siguiente != null)
                System.out.print(" < ");
            actual = actual.siguiente;
        }
        System.out.println(" < Entrada");
    }

    // MÉTODO RETO: calcular total de pasajeros en pista
    public int totalPasajeros() {
        int total = 0;
        Vuelo actual = salida;
        while (actual != null) {
            total += actual.pasajeros;
            actual = actual.siguiente;
        }
        return total;
    }

    // EXTRA PARCIAL: contar vuelos de una aerolínea específica
    public int contarPorAerolinea(String aerolinea) {
        int contador = 0;
        Vuelo actual = salida;
        while (actual != null) {
            if (actual.aerolinea.equalsIgnoreCase(aerolinea))
                contador++;
            actual = actual.siguiente;
        }
        return contador;
    }
}