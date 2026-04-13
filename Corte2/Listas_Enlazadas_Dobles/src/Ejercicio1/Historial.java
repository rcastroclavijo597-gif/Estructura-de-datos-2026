package Corte2.Listas_Enlazadas_Dobles.src.Ejercicio1;

public class Historial {
    Cambio cabeza;
    Cambio cola;

    public Historial() {
        this.cabeza = null;
        this.cola = null;
    }

    public void agregarCambio(Cambio cambio) {
        if (cabeza == null) {
            cabeza = cambio;
            cola = cambio;
        } else {
            cola.siguiente = cambio;
            cambio.anterior = cola;
            cola = cambio;
        }
    }

    public Cambio deshacer(Cambio cambioActual) {
        if (cambioActual.anterior == null) {
            System.out.println("No hay cambios para deshacer.");
            return cambioActual;
        }
        return cambioActual.anterior;
    }

    public Cambio rehacer(Cambio cambioActual) {
        if (cambioActual.siguiente == null) {
            System.out.println("No hay cambios para rehacer.");
            return cambioActual;
        }
        return cambioActual.siguiente;
    }

}