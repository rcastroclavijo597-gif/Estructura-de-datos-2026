package Ejercicio1;

public class Llamada {
    int IdLlamada;
    String nombreCliente;
    String motivoConsulta;
    String duracionEstimadaMinutos;

    Llamada siguiente;

    public Llamada(int idLlamada, String nombreCliente, String motivoConsulta, String duracionEstimadaMinutos) {
        this.IdLlamada = idLlamada;
        this.nombreCliente = nombreCliente;
        this.motivoConsulta = motivoConsulta;
        this.duracionEstimadaMinutos = duracionEstimadaMinutos;
        this.siguiente = null;
    }

}
