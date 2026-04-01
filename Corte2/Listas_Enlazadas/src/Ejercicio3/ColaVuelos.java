package Ejercicio3;

public class ColaVuelos {

    Vuelo cabeza;

    public ColaVuelos() {
        this.cabeza = null;
    }

    public void agregarVuelo(Vuelo nuevoVuelo) {

        if (cabeza == null) {
            cabeza = nuevoVuelo;
        } else {

            if (nuevoVuelo.combustibleRestante < 10) {
                nuevoVuelo.siguiente = cabeza;
                cabeza = nuevoVuelo;
            } else {
                Vuelo actual = cabeza;
                while (actual.siguiente != null) {
                    actual = actual.siguiente;
                }
                actual.siguiente = nuevoVuelo;
            }
        }
    }

    public void reportarEmergencia(String numeroVuelo) {

        if (cabeza == null || cabeza.numeroVuelo.equals(numeroVuelo)) {
            return;
        }

        Vuelo anterior = cabeza;
        Vuelo actual = cabeza.siguiente;

        while (actual != null) {

            if (actual.numeroVuelo.equals(numeroVuelo)) {

                anterior.siguiente = actual.siguiente;

                actual.siguiente = cabeza;
                cabeza = actual;

                System.out.println("Vuelo en emergencia movido al inicio.");
                return;
            }

            anterior = actual;
            actual = actual.siguiente;
        }

        System.out.println("Vuelo no encontrado.");
    }

    public void mostrarVuelos() {
        Vuelo actual = cabeza;

        while (actual != null) {
            System.out.println("Vuelo: " + actual.numeroVuelo + " | Aerolinea: " + actual.aerolinea + " | Combustible: "
                    + actual.combustibleRestante + " | Pasajeros: " + actual.pasajeros);
            actual = actual.siguiente;
        }
    }
}
