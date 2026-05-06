package Corte2.Listas_Circulares.src.Estudio;

public class Cliente {

    String nombre;
    String tipoServicio;
    int tiempoMin;

    Cliente siguiente; // apunta al siguiente nodo (circular)

    public Cliente(String nombre, String tipoServicio, int tiempoMin) {
        this.nombre = nombre;
        this.tipoServicio = tipoServicio;
        this.tiempoMin = tiempoMin;
        this.siguiente = null;
    }
}
