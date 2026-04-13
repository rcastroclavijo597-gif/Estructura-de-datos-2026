package Corte2.Listas_Enlazadas_Dobles.src.Ejercicio4;

public class Paciente {
    String nombre;
    int edad;
    int nivelUrgencia;

    Paciente siguiente;
    Paciente anterior;

    public Paciente(String nombre, int edad, int nivelUrgencia) {
        this.nombre = nombre;
        this.edad = edad;
        this.nivelUrgencia = nivelUrgencia;
        this.siguiente = null;
        this.anterior = null;
    }
}
