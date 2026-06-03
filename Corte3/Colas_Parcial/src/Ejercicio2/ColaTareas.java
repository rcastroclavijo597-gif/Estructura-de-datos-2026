package Ejercicio2;

public class ColaTareas {
    private Tarea entrada;
    private Tarea salida;
    private int tamanio;

    public ColaTareas() {
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

    public Tarea peek() {
        if (isEmpty()) {
            System.out.println("La cola está vacía");
            return null;
        }
        return salida;
    }

    public void enqueue(Tarea t) {
        if (isEmpty()) {
            salida = t;
            entrada = t;
        } else {
            entrada.siguiente = t;
            entrada = t;
        }
        tamanio++;
    }

    public Tarea dequeue() {
        if (isEmpty()) {
            System.out.println("La cola está vacía");
            return null;
        }
        Tarea t = salida;
        salida = salida.siguiente;
        if (salida == null)
            entrada = null;
        tamanio--;
        return t;
    }

    public void imprimir() {
        if (isEmpty()) {
            System.out.println("[ Cola vacía ]");
            return;
        }
        System.out.print("Salida < ");
        Tarea actual = salida;
        while (actual != null) {
            System.out.print("[" + actual.idTarea + ": " + actual.titulo
                    + " - " + actual.prioridad + " - " + actual.asignadoA + "]");
            if (actual.siguiente != null)
                System.out.print(" < ");
            actual = actual.siguiente;
        }
        System.out.println(" < Entrada");
    }

    // MÉTODO RETO: contar tareas por prioridad sin modificar la cola
    public int contarPorPrioridad(String prioridad) {
        int contador = 0;
        Tarea actual = salida;
        while (actual != null) {
            if (actual.prioridad.equalsIgnoreCase(prioridad))
                contador++;
            actual = actual.siguiente;
        }
        return contador;
    }

    // EXTRA PARCIAL: verificar si una persona tiene tareas pendientes
    public boolean tieneAreasTareas(String persona) {
        Tarea actual = salida;
        while (actual != null) {
            if (actual.asignadoA.equalsIgnoreCase(persona))
                return true;
            actual = actual.siguiente;
        }
        return false;
    }
}