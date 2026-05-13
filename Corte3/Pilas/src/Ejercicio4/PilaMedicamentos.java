package Ejercicio4;

public class PilaMedicamentos {

    private Medicamento tope;
    private int tamanio;

    public PilaMedicamentos() {

        this.tope = null;
        this.tamanio = 0;
    }

    public boolean estaVacia() {

        return tope == null;
    }

    public int getTamanio() {

        return tamanio;
    }

    public void push(Medicamento nuevo) {

        nuevo.siguiente = tope;
        tope = nuevo;
        tamanio++;
    }

    public Medicamento pop() {

        if (estaVacia()) {
            return null;
        }

        Medicamento aux = tope;

        tope = tope.siguiente;

        tamanio--;

        aux.siguiente = null;

        return aux;
    }

    public Medicamento peek() {

        return tope;
    }

    public void imprimir() {

        if (estaVacia()) {

            System.out.println("Pila vacía.");
            return;
        }

        Medicamento actual = tope;

        System.out.println("=== MEDICAMENTOS EN EL DISPENSADOR ===");

        while (actual != null) {

            if (actual == tope) {
                System.out.print(" TOPE -> ");
            } else {
                System.out.print("          ");
            }

            System.out.println(actual.toString());

            actual = actual.siguiente;
        }

        System.out.println("=====================================");
    }

    // Método del reto
    public void validarDespacho() {

        if (estaVacia()) {
            System.out.println("No hay medicamentos en el dispensador.");
            return;
        }

        while (tope != null && tope.diasParaVencer < 10) {

            System.out.println("\nMedicamento retirado automáticamente por vencimiento próximo:");
            System.out.println(pop());
        }

        if (tope != null) {

            System.out.println("\nMedicamento seguro para despachar:");
            System.out.println(tope);

        } else {

            System.out.println("\nNo quedan medicamentos seguros en el dispensador.");
        }
    }
}
