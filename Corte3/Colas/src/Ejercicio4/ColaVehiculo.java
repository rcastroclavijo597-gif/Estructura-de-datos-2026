package Ejercicio4;

public class ColaVehiculo {
    private Vehiculo entrada;
    private Vehiculo salida;
    private int tamanio;

    public ColaVehiculo() {
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

    public Vehiculo peek() {
        if (isEmpty()) {
            System.out.println("La cola está vacía");
            return null;
        }
        return salida;
    }

    public void enqueue(Vehiculo vehiculo) {
        if (isEmpty()) {
            salida = vehiculo;
            entrada = vehiculo;
        } else {
            entrada.siguiente = vehiculo;
            entrada = vehiculo;
        }
        tamanio++;
    }

    public Vehiculo dequeue() {
        if (isEmpty()) {
            System.out.println("La cola está vacía");
            return null;
        }
        Vehiculo vehiculo = salida;
        salida = salida.siguiente;
        if (salida == null) {
            entrada = null;
        }
        tamanio--;
        return vehiculo;
    }

    public void imprimir() {
        if (isEmpty()) {
            System.out.println("[ Cola vacía ]");
            return;
        }
        System.out.print("Salida < ");
        Vehiculo actual = salida;
        while (actual != null) {
            System.out.print("[" + actual.placa + ": " + actual.tipoVehiculo + " - $" + actual.tarifa + " - "
                    + (actual.esExento ? "Exento" : "Paga") + "]");
            if (actual.siguiente != null)
                System.out.println(" < ");
            actual = actual.siguiente;
        }
        System.out.println(" < Entrada");
    }

    public void cerrarTurno() {
        if (isEmpty()) {
            System.out.println("No hay vehículos en cola.");
            return;
        }
        double totalRecaudado = 0;
        int totalVehiculos = 0;
        int totalExentos = 0;
        System.out.println("\n--- CIERRE DE TURNO ---");
        while (!isEmpty()) {
            Vehiculo v = dequeue();
            totalVehiculos++;
            if (!v.esExento) {
                totalRecaudado += v.tarifa;
                System.out.println("Cobrado : " + v.placa + " (" + v.tipoVehiculo + ") - $" + v.tarifa);
            } else {
                totalExentos++;
                System.out.println("Exento  : " + v.placa + " (" + v.tipoVehiculo + ") - Sin cobro");
            }
        }
        System.out.println("----------------------------------");
        System.out.println("Total de vehículos procesados : " + totalVehiculos);
        System.out.println("Vehículos exentos             : " + totalExentos);
        System.out.println("Total recaudado en el turno   : $" + String.format("%.2f", totalRecaudado));
    }
}
