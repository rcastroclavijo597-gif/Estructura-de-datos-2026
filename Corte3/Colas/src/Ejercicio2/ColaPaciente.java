package Ejercicio2;

public class ColaPaciente {
    private Paciente entrada;
    private Paciente salida;
    private int tamanio;

    public ColaPaciente() {
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

    public void enqueue(Paciente paciente) {
        if (isEmpty()) {
            salida = paciente;
            entrada = paciente;
        } else {
            entrada.siguiente = paciente;
            entrada = paciente;
        }
        tamanio++;
    }

    public Paciente dequeue() {
        if (isEmpty()) {
            System.out.println("La cola está vacía");
            return null;
        }
        Paciente paciente = salida;
        salida = salida.siguiente;
        if (salida == null) {
            entrada = null;
        }
        tamanio--;
        return paciente;
    }

    public void imprimir() {
        if (isEmpty()) {
            System.out.println("[ Cola vacía ]");
            return;
        }
        System.out.print("Salida < ");
        Paciente actual = salida;
        while (actual != null) {
            System.out.print("[" + actual.cedula + ": " + actual.nombreCompleto + " - " + actual.edad + " años - "
                    + actual.sintomaPrincipal + "]");
            if (actual.siguiente != null)
                System.out.println(" < ");
            actual = actual.siguiente;
        }
        System.out.println(" < Entrada");
    }

    public void atenderTodos() {
        if (isEmpty()) {
            System.out.println("No hay pacientes en espera.");
            return;
        }
        int total = 0;
        System.out.println("\n--- INICIO DE ATENCIÓN DE TURNO ---");
        while (!isEmpty()) {
            Paciente p = dequeue();
            total++;
            System.out.println("Atendiendo paciente #" + total + ":");
            System.out.println("  Cédula         : " + p.cedula);
            System.out.println("  Nombre         : " + p.nombreCompleto);
            System.out.println("  Edad           : " + p.edad + " años");
            System.out.println("  Síntoma        : " + p.sintomaPrincipal);
            System.out.println("----------------------------------");
        }
        System.out.println("Total de pacientes atendidos en este turno: " + total);
    }
}
