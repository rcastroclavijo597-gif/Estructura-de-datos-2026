package Ejercicio3;

public class PilaTransacciones {
    private Transaccion tope;
    private int tamanio;

    public PilaTransacciones() {
        this.tope = null;
        this.tamanio = 0;
    }

    public boolean estaVacia() {
        return tope == null;
    }

    public int getTamanio() {
        return tamanio;
    }

    public void push(Transaccion nueva) {
        nueva.siguiente = tope;
        tope = nueva;
        tamanio++;
    }

    public Transaccion pop() {
        if (estaVacia())
            return null;
        Transaccion aux = tope;
        tope = tope.siguiente;
        tamanio--;
        aux.siguiente = null;
        return aux;
    }

    public Transaccion peek() {
        return tope;
    }

    public void imprimir() {
        if (estaVacia()) {
            System.out.println("Pila vacía.");
            return;
        }
        Transaccion actual = tope;
        System.out.println("=== HISTORIAL (Más reciente primero) ===");
        while (actual != null) {
            if (actual == tope)
                System.out.print("  TOPE -> ");
            else
                System.out.print("          ");
            System.out.println(actual);
            actual = actual.siguiente;
        }
        System.out.println("========================================");
    }

    // MÉTODO RETO: calcular saldo neto (suma créditos - suma débitos)
    public double calcularSaldoNeto() {
        double saldo = 0;
        Transaccion actual = tope;
        while (actual != null) {
            if (actual.tipo.equalsIgnoreCase("CREDITO"))
                saldo += actual.monto;
            else if (actual.tipo.equalsIgnoreCase("DEBITO"))
                saldo -= actual.monto;
            actual = actual.siguiente;
        }
        return saldo;
    }

    // EXTRA PARCIAL: contar transacciones por tipo
    public int contarPorTipo(String tipo) {
        int contador = 0;
        Transaccion actual = tope;
        while (actual != null) {
            if (actual.tipo.equalsIgnoreCase(tipo))
                contador++;
            actual = actual.siguiente;
        }
        return contador;
    }
}
