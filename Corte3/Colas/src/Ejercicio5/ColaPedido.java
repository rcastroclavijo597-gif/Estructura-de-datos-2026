package Ejercicio5;

public class ColaPedido {
    private Pedido entrada;
    private Pedido salida;
    private int tamanio;

    public ColaPedido() {
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

    public Pedido peek() {
        if (isEmpty()) {
            System.out.println("La cola está vacía");
            return null;
        }
        return salida;
    }

    public void enqueue(Pedido pedido) {
        if (isEmpty()) {
            salida = pedido;
            entrada = pedido;
        } else {
            entrada.siguiente = pedido;
            entrada = pedido;
        }
        tamanio++;
    }

    public Pedido dequeue() {
        if (isEmpty()) {
            System.out.println("La cola está vacía");
            return null;
        }
        Pedido pedido = salida;
        salida = salida.siguiente;
        if (salida == null) {
            entrada = null;
        }
        tamanio--;
        return pedido;
    }

    public void imprimir() {
        if (isEmpty()) {
            System.out.println("[ Cola vacía ]");
            return;
        }
        System.out.print("Salida < ");
        Pedido actual = salida;
        while (actual != null) {
            System.out.print("[" + actual.numeroPedido + ": " + actual.cliente + " - $"
                    + String.format("%.2f", actual.totalPagar) + " - " + (actual.cancelado ? "Cancelado" : "Vigente")
                    + "]");
            if (actual.siguiente != null)
                System.out.println(" < ");
            actual = actual.siguiente;
        }
        System.out.println(" < Entrada");
    }

    public void procesarPedidos() {
        if (isEmpty()) {
            System.out.println("No hay pedidos en cola.");
            return;
        }
        int totalDespachados = 0;
        int totalCancelados = 0;
        System.out.println("\n--- PROCESAMIENTO DE BODEGA ---");
        while (!isEmpty()) {
            Pedido p = dequeue();
            if (p.cancelado) {
                totalCancelados++;
                System.out.println(
                        "Descartado : [" + p.numeroPedido + "] " + p.cliente + " - Pedido cancelado por el cliente");
            } else {
                totalDespachados++;
                System.out.println("Despachado : [" + p.numeroPedido + "] " + p.cliente + " - $"
                        + String.format("%.2f", p.totalPagar));
            }
        }
        System.out.println("----------------------------------");
        System.out.println("Total pedidos despachados : " + totalDespachados);
        System.out.println("Total pedidos cancelados  : " + totalCancelados);
    }
}
