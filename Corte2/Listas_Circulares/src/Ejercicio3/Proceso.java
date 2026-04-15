package Corte2.Listas_Circulares.src.Ejercicio3;

public class Proceso {
    String nombre;
    int pid;
    int tiempoRestante;
    int prioridad;
    Proceso siguiente;

    public Proceso(String nombre, int pid, int tiempoRestante, int prioridad) {
        this.nombre = nombre;
        this.pid = pid;
        this.tiempoRestante = tiempoRestante;
        this.prioridad = prioridad;
    }
}
