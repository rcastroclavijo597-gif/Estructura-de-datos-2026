package Ejercicio4;

public class ListaLecturas {

    Lectura cabeza;

    public ListaLecturas() {
        this.cabeza = null;
    }

    public void agregarLectura(Lectura nuevaLectura) {

        nuevaLectura.siguiente = cabeza;
        cabeza = nuevaLectura;
    }

    public void mostrarTemperaturaMaxima() {

        if (cabeza == null) {
            System.out.println("No hay lecturas.");
            return;
        }

        Lectura actual = cabeza;
        Lectura max = cabeza;

        while (actual != null) {

            if (actual.temperatura > max.temperatura) {
                max = actual;
            }

            actual = actual.siguiente;
        }

        System.out.println("Lectura con mayor temperatura:");
        System.out.println("Sensor: " + max.idSensor +
                " | Temperatura: " + max.temperatura +
                " | Presion: " + max.presion +
                " | Hora: " + max.hora);
    }

    public void mostrarLecturas() {
        Lectura actual = cabeza;

        while (actual != null) {
            System.out.println("Sensor: " + actual.idSensor +
                    " | Temp: " + actual.temperatura +
                    " | Presion: " + actual.presion +
                    " | Hora: " + actual.hora);
            actual = actual.siguiente;
        }
    }
}