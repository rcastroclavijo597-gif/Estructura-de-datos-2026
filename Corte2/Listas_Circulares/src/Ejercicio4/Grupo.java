package Corte2.Listas_Circulares.src.Ejercicio4;

public class Grupo {
    String nombreReserva;
    int numeroDPersonas;
    boolean esVip;
    int minutosEsperando;
    Grupo siguiente;

    public Grupo(String nombreReserva, int numeroDPersonas, boolean esVip, int minutosEsperando) {
        this.nombreReserva = nombreReserva;
        this.numeroDPersonas = numeroDPersonas;
        this.esVip = esVip;
        this.minutosEsperando = minutosEsperando;
    }
}
