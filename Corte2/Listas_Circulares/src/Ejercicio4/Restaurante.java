package Corte2.Listas_Circulares.src.Ejercicio4;

public class Restaurante {
    Grupo cabeza;
    Grupo cola;

    public Restaurante() {
        cabeza = null;
        cola = null;
    }

    public void agregarGrupo(Grupo grupo) {
        if (cabeza == null) {
            cabeza = grupo;
            cola = grupo;
            grupo.siguiente = cabeza;
        } else {
            cola.siguiente = grupo;
            grupo.siguiente = cabeza;
            cola = grupo;
        }
    }

    public void mostrarGrupos() {
        if (cabeza == null) {
            System.out.println("No hay grupos en espera.");
            return;
        }
        Grupo actual = cabeza;
        do {
            System.out.println("Reserva: " + actual.nombreReserva + ", Personas: " + actual.numeroDPersonas + ", VIP: "
                    + actual.esVip + ", Minutos esperando: " + actual.minutosEsperando);
            actual = actual.siguiente;
        } while (actual != cabeza);
    }

    public void atenderSiguiente() {
        if (cabeza == null) {
            System.out.println("No hay grupos para atender.");
            return;
        }
        Grupo actual = cabeza;
        System.out.println("Atendiendo grupo: " + actual.nombreReserva + " (" + actual.numeroDPersonas
                + " personas, VIP: " + actual.esVip + ")");
        if (actual.esVip) {
            cabeza = cabeza.siguiente;
            cola.siguiente = actual;
            cola = actual;
        } else {
            eliminarGrupo(actual);
        }
        mostrarGrupos();
    }

    private void eliminarGrupo(Grupo grupo) {
        if (cabeza == null || grupo == null)
            return;
        if (cabeza == grupo && cabeza == cola) {
            cabeza = null;
            cola = null;
        } else if (cabeza == grupo) {
            cabeza = cabeza.siguiente;
            cola.siguiente = cabeza;
        } else {
            Grupo actual = cabeza;
            while (actual.siguiente != grupo) {
                actual = actual.siguiente;
            }
            actual.siguiente = grupo.siguiente;
            if (cola == grupo) {
                cola = actual;
            }
        }
    }
}
