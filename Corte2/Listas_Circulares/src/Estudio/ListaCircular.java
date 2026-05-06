package Corte2.Listas_Circulares.src.Estudio;

public class ListaCircular {

    Cliente cabeza;
    Cliente cola;

    public ListaCircular() {
        cabeza = null;
        cola = null;
    }

    // ✅ Agregar cliente al final
    public void agregarCliente(Cliente nuevo) {

        // Si la lista está vacía
        if (cabeza == null) {
            cabeza = nuevo;
            cola = nuevo;
            nuevo.siguiente = cabeza; // se apunta a sí mismo (circular)
        } else {
            cola.siguiente = nuevo; // el último apunta al nuevo
            nuevo.siguiente = cabeza; // el nuevo apunta a la cabeza
            cola = nuevo; // actualizamos la cola
        }
    }

    // ✅ Atender cliente (elimina la cabeza)
    public void atenderCliente() {

        // Si la lista está vacía
        if (cabeza == null) {
            System.out.println("No hay clientes.");
            return;
        }

        // Mostrar cliente atendido
        System.out.println("Atendiendo a: " + cabeza.nombre);

        // Caso: solo hay un cliente
        if (cabeza == cola) {
            cabeza = null;
            cola = null;
        } else {
            cabeza = cabeza.siguiente; // avanzamos la cabeza
            cola.siguiente = cabeza; // mantenemos el ciclo
        }

        // Mostrar lista actual
        mostrarLista();
    }

    // ✅ Mostrar lista completa (circular)
    public void mostrarLista() {

        if (cabeza == null) {
            System.out.println("Lista vacía.");
            return;
        }

        Cliente actual = cabeza;

        System.out.println("Clientes en espera:");

        // usamos do-while porque es circular
        do {
            System.out.println("- " + actual.nombre + " (" + actual.tipoServicio + ")");
            actual = actual.siguiente;
        } while (actual != cabeza);
    }
}
