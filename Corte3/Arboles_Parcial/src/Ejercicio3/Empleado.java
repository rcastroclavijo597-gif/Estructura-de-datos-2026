package Ejercicio3;

public class Empleado {
    int cedula;
    String nombre;
    String departamento;
    double salario;
    Empleado izquierdo;
    Empleado derecho;

    public Empleado(int cedula, String nombre, String departamento, double salario) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.departamento = departamento;
        this.salario = salario;
        this.izquierdo = null;
        this.derecho = null;
    }

    @Override
    public String toString() {
        return "[" + cedula + " | " + nombre + " | " + departamento + " | $" + salario + "]";
    }
}