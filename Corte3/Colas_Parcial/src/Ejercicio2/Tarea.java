package Ejercicio2;

public class Tarea {
    int idTarea;
    String titulo;
    String prioridad; // "ALTA", "MEDIA", "BAJA"
    String asignadoA;
    Tarea siguiente;

    public Tarea(int idTarea, String titulo, String prioridad, String asignadoA) {
        this.idTarea = idTarea;
        this.titulo = titulo;
        this.prioridad = prioridad;
        this.asignadoA = asignadoA;
        this.siguiente = null;
    }
}