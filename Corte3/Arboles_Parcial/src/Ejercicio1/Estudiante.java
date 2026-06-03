package Ejercicio1;

public class Estudiante {
    double promedio;
    String nombre;
    String codigo;
    String carrera;
    Estudiante izquierdo;
    Estudiante derecho;

    public Estudiante(double promedio, String nombre, String codigo, String carrera) {
        this.promedio = promedio;
        this.nombre = nombre;
        this.codigo = codigo;
        this.carrera = carrera;
        this.izquierdo = null;
        this.derecho = null;
    }

    @Override
    public String toString() {
        return "[" + promedio + " | " + nombre + " | " + codigo + " | " + carrera + "]";
    }
}