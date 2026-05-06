package Corte2.Listas_Circulares_Dobles.src.Estudio;

public class ListaCircularDoble {

    Episodio cabeza;
    Episodio cola;
    Episodio actual; // puntero donde está el usuario

    public ListaCircularDoble() {
        cabeza = null;
        cola = null;
        actual = null;
    }

    // ✅ Agregar al final
    public void agregar(Episodio nuevo) {

        // Si la lista está vacía
        if (cabeza == null) {
            cabeza = nuevo;
            cola = nuevo;

            // Se conecta consigo mismo (circular doble)
            nuevo.siguiente = nuevo;
            nuevo.anterior = nuevo;

            actual = nuevo;
        } else {
            cola.siguiente = nuevo;
            nuevo.anterior = cola;

            nuevo.siguiente = cabeza;
            cabeza.anterior = nuevo;

            cola = nuevo;
        }
    }

    // ✅ Ir al siguiente episodio
    public void siguiente() {
        if (actual != null) {
            actual = actual.siguiente;
            System.out.println("Pasaste al siguiente episodio.");
        }
    }

    // ✅ Ir al episodio anterior
    public void anterior() {
        if (actual != null) {
            actual = actual.anterior;
            System.out.println("Regresaste al episodio anterior.");
        }
    }

    // ✅ Mostrar episodio actual
    public void mostrarActual() {
        if (actual != null) {
            System.out.println("Episodio actual:");
            System.out.println("Título: " + actual.titulo);
            System.out.println("Duración: " + actual.duracionMin);
            System.out.println("Autor: " + actual.autor);
        } else {
            System.out.println("No hay episodios.");
        }
    }

    // ✅ Eliminar episodio actual
    public void eliminarActual() {

        // Lista vacía
        if (actual == null) {
            System.out.println("No hay episodios para eliminar.");
            return;
        }

        System.out.println("Eliminando: " + actual.titulo);

        // Caso: solo un nodo
        if (cabeza == cola) {
            cabeza = null;
            cola = null;
            actual = null;
        } else {
            Episodio temp = actual;

            // reconectar nodos
            temp.anterior.siguiente = temp.siguiente;
            temp.siguiente.anterior = temp.anterior;

            // actualizar cabeza
            if (temp == cabeza) {
                cabeza = temp.siguiente;
            }

            // actualizar cola
            if (temp == cola) {
                cola = temp.anterior;
            }

            // mover actual al siguiente
            actual = temp.siguiente;
        }
    }

    // ✅ Mostrar toda la lista
    public void mostrarLista() {

        if (cabeza == null) {
            System.out.println("Lista vacía.");
            return;
        }

        Episodio aux = cabeza;

        System.out.println("Lista de episodios:");

        do {
            if (aux == actual) {
                System.out.println("[▶] " + aux.titulo);
            } else {
                System.out.println(" - " + aux.titulo);
            }

            aux = aux.siguiente;
        } while (aux != cabeza);
    }
}
