package Corte2.Listas_Enlazadas_Simples.src.Estudio;

public class Paciente {

    String nombre;
    int edad;
    double costoConsulta;

    Paciente siguiente;

    public Paciente(String nombre, int edad, double costoConsulta) {
        this.nombre = nombre;
        this.edad = edad;
        this.costoConsulta = costoConsulta;
        this.siguiente = null;
    }
}
