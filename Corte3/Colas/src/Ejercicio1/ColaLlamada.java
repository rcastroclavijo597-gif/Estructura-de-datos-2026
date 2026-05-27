package Ejercicio1;

public class ColaLlamada {
    private Llamada entrada;
    private Llamada salida;
    private int tamanio;

    public ColaLlamada() {
        this.entrada = null;
        this.salida = null;
        this.tamanio = 0;
    }

    // Verifica si la cola está vacía
    public boolean isEmpty() {
        return salida == null;
    }

    // Retorna el número de elementos
    public int size() {
        return tamanio;
    }

    // Consulta la salida sin extraerlo
    public Llamada peek() {
        if (isEmpty()) {
            System.out.println("La cola está vacía");
            return null;
        }
        return salida;
    }

    // Inserta un elemento por la entrada: O(1)
    public void enqueue(Llamada llamada) {
        if (isEmpty()) {
            salida = llamada; // primer elemento: salida y entrada apuntan al mismo nodo
            entrada = llamada;
        } else {
            entrada.siguiente = llamada; // el antiguo entrada enlaza al nuevo
            entrada = llamada; // entrada avanza al nuevo nodo
        }
        tamanio++;
    }

    // Extrae y retorna el elemento de la salida: O(1)
    public Llamada dequeue() {
        if (isEmpty()) {
            System.out.println("La cola está vacía");
            return null;
        }
        Llamada llamada = salida;
        salida = salida.siguiente; // salida avanza al siguiente nodo
        if (salida == null) {
            entrada = null; // la cola quedó vacía: también limpiar entrada
        }
        tamanio--;
        return llamada;
    }

    // Imprime la cola desde la salida hasta la entrada
    public void imprimir() {
        if (isEmpty()) {
            System.out.println("[ Cola vacía ]");
            return;
        }
        System.out.print("Salida < ");
        Llamada actual = salida;
        while (actual != null) {
            System.out.print("[" + actual.IdLlamada + ": " + actual.nombreCliente + " - " + actual.motivoConsulta
                    + " - " + actual.duracionEstimadaMinutos + " min]");
            if (actual.siguiente != null)
                System.out.println(" < ");
            actual = actual.siguiente;
        }
        System.out.println(" < Entrada");
    }

    public int contarPorMotivo(String motivo) {
        int contador = 0;
        Llamada actual = salida;
        while (actual != null) {
            if (actual.motivoConsulta.equalsIgnoreCase(motivo)) {
                contador++;
            }
            actual = actual.siguiente;
        }
        return contador;
    }

}
