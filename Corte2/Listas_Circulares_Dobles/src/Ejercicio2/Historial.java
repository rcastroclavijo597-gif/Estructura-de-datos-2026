package Corte2.Listas_Circulares_Dobles.src.Ejercicio2;

public class Historial {
    Comando cabeza;
    Comando cola;
    Comando cursor;

    public Historial() {
        cabeza = null;
        cola = null;
        cursor = null;
    }

    public boolean estaVacio() {
        return cabeza == null;
    }

    public void agregarComando(String texto, boolean exitoso, String directorio) {
        Comando nuevo = new Comando(texto, exitoso, directorio);

        if (cabeza == null) {
            nuevo.siguiente = nuevo;
            nuevo.anterior = nuevo;
            cabeza = nuevo;
            cola = nuevo;
            cursor = nuevo;
        } else {
            cola.siguiente = nuevo;
            nuevo.anterior = cola;
            nuevo.siguiente = cabeza;
            cabeza.anterior = nuevo;
            cola = nuevo;
        }
    }

    public void arriba() {
        if (cursor != null) {
            cursor = cursor.anterior;
        }
    }

    public void abajo() {
        if (cursor != null) {
            cursor = cursor.siguiente;
        }
    }

    public void mostrarCursor() {
        if (cursor == null) {
            System.out.println("No hay comandos.");
            return;
        }

        System.out.println("Texto: " + cursor.texto);
        System.out.println("Directorio: " + cursor.directorio);
        System.out.println("Estado: " + (cursor.exitoso ? "OK" : "ERROR"));
    }

    public void eliminarActual() {
        if (cursor == null)
            return;

        if (cursor == cabeza && cursor == cola) {
            cabeza = null;
            cola = null;
            cursor = null;
            return;
        }

        cursor.anterior.siguiente = cursor.siguiente;
        cursor.siguiente.anterior = cursor.anterior;

        if (cursor == cabeza)
            cabeza = cursor.siguiente;
        if (cursor == cola)
            cola = cursor.anterior;

        cursor = cursor.siguiente;
    }

    public void mostrarHistorial() {
        if (estaVacio()) {
            System.out.println("Historial vacío.");
            return;
        }

        Comando actual = cabeza;
        int i = 1;

        do {
            String marca = (actual == cursor) ? " <-- cursor" : "";

            System.out.println(i + ". " + actual.texto +
                    " [" + (actual.exitoso ? "OK" : "ERROR") + "]" +
                    " (" + actual.directorio + ")" +
                    marca);

            actual = actual.siguiente;
            i++;
        } while (actual != cabeza);
    }
}