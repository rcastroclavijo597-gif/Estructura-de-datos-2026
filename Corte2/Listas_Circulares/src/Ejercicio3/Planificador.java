package Corte2.Listas_Circulares.src.Ejercicio3;

import java.util.ArrayList;

public class Planificador {
    Proceso cabeza;
    Proceso cola;
    ArrayList<String> ordenFinalizados;

    public Planificador() {
        cabeza = null;
        cola = null;
        ordenFinalizados = new ArrayList<>();
    }

    public void agregarProceso(Proceso proceso) {
        if (cabeza == null) {
            cabeza = proceso;
            cola = proceso;
            proceso.siguiente = cabeza;
        } else {
            cola.siguiente = proceso;
            proceso.siguiente = cabeza;
            cola = proceso;
        }
    }

    public void mostrarProcesos() {
        if (cabeza == null) {
            System.out.println("No hay procesos registrados.");
            return;
        }
        Proceso actual = cabeza;
        do {
            System.out.println("Nombre: " + actual.nombre + ", PID: " + actual.pid + ", Tiempo Restante: "
                    + actual.tiempoRestante + ", Prioridad: " + actual.prioridad);
            actual = actual.siguiente;
        } while (actual != cabeza);
    }

    public void ejecutar(int quantum) {
        if (cabeza == null) {
            System.out.println("No hay procesos para ejecutar.");
            return;
        }
        Proceso actual = cabeza;
        while (cabeza != null) {
            actual.tiempoRestante -= quantum;
            if (actual.tiempoRestante > 0) {
                System.out.println("Ejecutando: " + actual.nombre + " PID: " + actual.pid + " Tiempo restante: "
                        + actual.tiempoRestante);
                actual = actual.siguiente;
            } else {
                System.out.println("Proceso terminado: " + actual.nombre + " PID: " + actual.pid);
                ordenFinalizados.add(actual.nombre);
                eliminarProceso(actual);
                if (cabeza == null)
                    break;
                actual = actual.siguiente;
            }
        }
        mostrarOrdenFinalizados();
    }

    private void eliminarProceso(Proceso proceso) {
        if (cabeza == null || proceso == null)
            return;
        if (cabeza == proceso && cabeza == cola) {
            cabeza = null;
            cola = null;
        } else if (cabeza == proceso) {
            cabeza = cabeza.siguiente;
            cola.siguiente = cabeza;
        } else {
            Proceso actual = cabeza;
            while (actual.siguiente != proceso) {
                actual = actual.siguiente;
            }
            actual.siguiente = proceso.siguiente;
            if (cola == proceso) {
                cola = actual;
            }
        }
    }

    private void mostrarOrdenFinalizados() {
        System.out.println("Orden de finalización de procesos:");
        for (String nombre : ordenFinalizados) {
            System.out.println(nombre);
        }
    }
}
