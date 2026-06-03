package Ejercicio1;

public class ColaPacientes {
    private Paciente entrada;
    private Paciente salida;
    private int tamanio;

    public ColaPacientes() {
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

    public Paciente peek() {
        if (isEmpty()) {
            System.out.println("La cola está vacía");
            return null;
        }
        return salida;
    }

    public void enqueue(Paciente p) {
        if (isEmpty()) {
            salida = p;
            entrada = p;
        } else {
            entrada.siguiente = p;
            entrada = p;
        }
        tamanio++;
    }

    public Paciente dequeue() {
        if (isEmpty()) {
            System.out.println("La cola está vacía");
            return null;
        }
        Paciente p = salida;
        salida = salida.siguiente;
        if (salida == null)
            entrada = null;
        tamanio--;
        return p;
    }

    public void imprimir() {
        if (isEmpty()) {
            System.out.println("[ Cola vacía ]");
            return;
        }
        System.out.print("Salida < ");
        Paciente actual = salida;
        while (actual != null) {
            System.out.print("[" + actual.idPaciente + ": " + actual.nombre
                    + " - " + actual.especialidad + " - " + actual.edadAnios + " años]");
            if (actual.siguiente != null)
                System.out.print(" < ");
            actual = actual.siguiente;
        }
        System.out.println(" < Entrada");
    }

    // MÉTODO RETO: contar pacientes por especialidad sin modificar la cola
    public int contarPorEspecialidad(String especialidad) {
        int contador = 0;
        Paciente actual = salida;
        while (actual != null) {
            if (actual.especialidad.equalsIgnoreCase(especialidad))
                contador++;
            actual = actual.siguiente;
        }
        return contador;
    }

    // EXTRA PARCIAL: calcular promedio de edad de los pacientes en espera
    public double promedioEdad() {
        if (isEmpty())
            return 0;
        int suma = 0, cantidad = 0;
        Paciente actual = salida;
        while (actual != null) {
            suma += actual.edadAnios;
            cantidad++;
            actual = actual.siguiente;
        }
        return (double) suma / cantidad;
    }
}