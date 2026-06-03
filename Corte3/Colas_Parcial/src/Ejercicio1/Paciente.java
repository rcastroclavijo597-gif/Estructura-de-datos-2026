package Ejercicio1;

public class Paciente {
    int idPaciente;
    String nombre;
    String especialidad;
    int edadAnios;
    Paciente siguiente;

    public Paciente(int idPaciente, String nombre, String especialidad, int edadAnios) {
        this.idPaciente = idPaciente;
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.edadAnios = edadAnios;
        this.siguiente = null;
    }
}