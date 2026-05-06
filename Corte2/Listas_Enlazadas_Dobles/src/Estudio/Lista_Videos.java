package Corte2.Listas_Enlazadas_Dobles.src.Estudio;

public class Lista_Videos {

    Video cabeza; // primer nodo
    Video cola; // último nodo
    Video actual; // nodo donde está el usuario (IMPORTANTE)

    public Lista_Videos() {
        cabeza = null;
        cola = null;
        actual = null;
    }

    // ✅ Agregar al final
    public void agregarVideo(Video nuevo) {

        // Si la lista está vacía
        if (cabeza == null) {
            cabeza = nuevo;
            cola = nuevo;
            actual = nuevo; // el usuario queda en el primero
        } else {
            cola.siguiente = nuevo; // el último apunta al nuevo
            nuevo.anterior = cola; // el nuevo apunta al anterior
            cola = nuevo; // actualizamos la cola
        }
    }

    // ✅ Avanzar al siguiente video
    public void avanzar() {

        // Verifica que haya un siguiente
        if (actual != null && actual.siguiente != null) {
            actual = actual.siguiente;
            System.out.println("Avanzaste al siguiente video.");
        } else {
            System.out.println("No hay siguiente video.");
        }
    }

    // ✅ Retroceder al video anterior
    public void retroceder() {

        // Verifica que haya un anterior
        if (actual != null && actual.anterior != null) {
            actual = actual.anterior;
            System.out.println("Retrocediste al video anterior.");
        } else {
            System.out.println("No hay video anterior.");
        }
    }

    // ✅ Mostrar el video actual
    public void mostrarActual() {

        if (actual != null) {
            System.out.println("Video actual:");
            System.out.println("Título: " + actual.titulo);
            System.out.println("Duración: " + actual.duracionMin + " min");
            System.out.println("Categoría: " + actual.categoria);
        } else {
            System.out.println("No hay videos.");
        }
    }
}
